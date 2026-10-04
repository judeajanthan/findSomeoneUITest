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
                config.setJdbcUrl("jdbc:mysql://144.91.97.34:3307/ineedtofindsomeonefor");
                config.setUsername("automation_rw_3");
                config.setPassword("8f2d9b3b6fdf4d90a0f7d29d34d87659");
                config.setDriverClassName("com.mysql.cj.jdbc.Driver");
                break;
            case ORACLE:
//                config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
//                config.setUsername("admin");
//                config.setPassword("password");
//                config.setDriverClassName("oracle.jdbc.OracleDriver");
                break;
            case POSTGRESQL:
//                config.setJdbcUrl("jdbc:postgresql://localhost:5432/my_schema");
//                config.setUsername("postgres");
//                config.setPassword("password");
//                config.setDriverClassName("org.postgresql.Driver");
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