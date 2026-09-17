# MongoDB database code

[mongodb-init.js](./mongodb-init.js) creates the `restaurant_management` database structure used by the Spring Boot server.
It creates collections, schema validation rules, indexes, and no external infrastructure.

Run it with the MongoDB Shell:

```powershell
mongosh "mongodb://localhost:27017/restaurant_management" .\mongodb-init.js
```

The server connects using:

```text
mongodb://localhost:27017/restaurant_management
```

To use another MongoDB instance:

```powershell
$env:MONGODB_URI = "mongodb://username:password@host:27017/restaurant_management?authSource=admin"
mongosh $env:MONGODB_URI .\mongodb-init.js
```
