package ac.ucsc.uitest.dbconn;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aerok
 * @code @created 01/04/2026
 */
public class DBConnectionManager {
    // Maps each DBType to its own Hikari Connection Pool
    private final Map<DBType, HikariDataSource> dataSources;

    // Private constructor prevents instantiation from other classes
    private DBConnectionManager() {
        dataSources = new ConcurrentHashMap<>();
    }

    // --- Bill Pugh Singleton Implementation ---
    private static class SingletonHelper {
        private static final DBConnectionManager INSTANCE = new DBConnectionManager();
    }

    public static DBConnectionManager getInstance() {
        return SingletonHelper.INSTANCE;
    }
    // ------------------------------------------

    /**
     * Gets a connection from the Hikari pool for the specified database.
     */
    public Connection getConnection(DBType dbType) throws SQLException {
        // computeIfAbsent safely initializes the pool if it doesn't exist yet
        HikariDataSource dataSource = dataSources.computeIfAbsent(dbType, this::createDataSource);

        // Return an active connection from the Hikari pool
        return dataSource.getConnection();
    }

    /**
     * Factory method to configure and instantiate a new Hikari Pool.
     */
    private HikariDataSource createDataSource(DBType dbType) {
        HikariConfig config = new HikariConfig();

        switch (dbType) {
            case MYSQL:
                String dbUrl = System.getenv("FIND_SOMEONE_DB_URL");
                String dbUsername = System.getenv("FIND_SOMEONE_DB_USERNAME");
                String dbPassword = System.getenv("FIND_SOMEONE_DB_PASSWORD");

                if (dbUrl == null || dbUsername == null || dbPassword == null) {
                    throw new IllegalStateException(
                            "Database environment variables are not configured. " +
                                    "Please set FIND_SOMEONE_DB_URL, FIND_SOMEONE_DB_USERNAME, " +
                                    "and FIND_SOMEONE_DB_PASSWORD."
                    );
                }

                config.setJdbcUrl(dbUrl);
                config.setUsername(dbUsername);
                config.setPassword(dbPassword);
                config.setDriverClassName("com.mysql.cj.jdbc.Driver");
                break;
            case ORACLE:
                config.setJdbcUrl(System.getenv("FIND_SOMEONE_ORACLE_DB_URL"));
                config.setUsername(System.getenv("FIND_SOMEONE_ORACLE_DB_USERNAME"));
                config.setPassword(System.getenv("FIND_SOMEONE_ORACLE_DB_PASSWORD"));
                config.setDriverClassName("oracle.jdbc.OracleDriver");
                break;

            case POSTGRESQL:
                config.setJdbcUrl(System.getenv("FIND_SOMEONE_POSTGRES_DB_URL"));
                config.setUsername(System.getenv("FIND_SOMEONE_POSTGRES_DB_USERNAME"));
                config.setPassword(System.getenv("FIND_SOMEONE_POSTGRES_DB_PASSWORD"));
                config.setDriverClassName("org.postgresql.Driver");
                break;
            default:
                throw new IllegalArgumentException("Unsupported Database Type: " + dbType);
        }

        // --- Standard Pool Settings ---
        config.setMaximumPoolSize(10);           // Max connections in the pool
        config.setMinimumIdle(2);                // Keep at least 2 connections ready
        config.setIdleTimeout(30000);            // Drop connections if idle for 30 seconds
        config.setMaxLifetime(1800000);          // Max life of a connection (30 minutes)
        config.setConnectionTimeout(10000);      // How long to wait for an available connection (10 sec)

        return new HikariDataSource(config);
    }

    /**
     * Call this gracefully shut down all connection pools.
     * can be used in @AfterSuite
     */
    public void closeAllPools() {
        dataSources.values().forEach(HikariDataSource::close);
        dataSources.clear();
    }
}