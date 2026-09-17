# Restaurant Management API

Spring Boot REST backend for managing a restaurant's menu, dining tables, and orders.

## Development server

Requirements: Java 17+ and Maven 3.9+.

```bash
# Run with the default development configuration
mvn spring-boot:run

# Run on another port when needed
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=5000"
```

The development server listens on **http://localhost:5000**.

## Production server

Build the executable JAR without running tests:

```bash
mvn clean package -DskipTests
```

Start the production server:

```bash
java -jar target/restaurant-management-0.0.1-SNAPSHOT.jar
```

For a production port override:

```bash
java -jar target/restaurant-management-0.0.1-SNAPSHOT.jar --server.port=5000
```

For PowerShell, the equivalent environment-variable configuration is:

```powershell
$env:SERVER_PORT = "5000"
java -jar .\target\restaurant-management-0.0.1-SNAPSHOT.jar
```

For a full production build that runs tests, omit `-DskipTests`:

```bash
mvn clean package
```

## Endpoints

- `GET|POST /api/menu-items`
- `GET|PUT|DELETE /api/menu-items/{id}`
- `GET|POST /api/tables`
- `GET|PUT|DELETE /api/tables/{id}`
- `GET|POST /api/orders`
- `GET|DELETE /api/orders/{id}`
- `PATCH /api/orders/{id}/status?status=PREPARING`

The application uses MongoDB database `restaurant_management` at `mongodb://localhost:27017` by default.
Start MongoDB from the sibling `db` directory before starting the backend:

```bash
cd ../db
docker compose up -d
cd ../server
mvn spring-boot:run
```

To connect to another MongoDB instance, set the `MONGODB_URI` environment variable.
