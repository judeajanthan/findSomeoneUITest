## 🤝 Contributing Guidelines

Welcome contributions! To maintain a clean and organized codebase, please follow these branch naming and development standards.

### 1. Branch Naming Convention

Please prefix your branch names according to the type of work being done:

| Prefix | Purpose | Example |
| :--- | :--- | :--- |
| `feature/` | New functionality | `feature/user-login` |
| `bugfix/` | Fix a normal bug | `bugfix/cart-total-calculation` |
| `hotfix/` | Urgent production fix | `hotfix/payment-api-crash` |
| `refactor/` | Code quality improvement | `refactor/grn-service-cleanup` |
| `chore/` | Maintenance tasks | `chore/update-dependencies` |
| `docs/` | Documentation updates | `docs/api-readme-update` |
| `test/` | Adding or fixing tests | `test/add-user-service-tests` |
| `perf/` | Performance improvements | `perf/optimize-database-query` |
| `style/` | Formatting only (linting, spacing) | `style/apply-prettier-format` |

### 2. Workflow
1. **Create a branch** from `dev` using the prefixes above.
2. **Commit changes** with clear, descriptive messages.
3. **Run local tests** to ensure no regressions are introduced.
4. **Push to GitHub** and open a Pull Request (PR) for review.

### 3. Tasks can be done for now

Create test scenarios and test cases creating packages -> classes -> methods under test/java/ac/ucsc/uitest/tests

* Your testing scope -> package
* Test Scenario -> class
* Test Case -> method

### 4. Before you push

Do not push anything to the master branch. Create feature branch for all your commits and create pull requests to the dev branch (Not for the master branch). 
Before you push anything, always pull from the dev branch.

#### Example steps

* git checkout master
* git pull origin master
* git checkout -b refactor/replace-data-provider
* git add .
* git commit -m "refactor: DataProvider classes moved to the respective tests/packages"
* git push origin refactor/replace-data-provider
