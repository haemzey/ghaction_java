/*
 * Restaurant Management MongoDB database setup.
 *
 * Run with:
 *   mongosh "mongodb://localhost:27017/restaurant_management" db/mongodb-init.js
 */

const database = db.getSiblingDB("restaurant_management");

const createCollectionIfMissing = (name, options) => {
  if (!database.getCollectionNames().includes(name)) {
    database.createCollection(name, options);
  }
};

createCollectionIfMissing("menu_items", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "price", "category", "available"],
      properties: {
        name: { bsonType: "string", minLength: 1 },
        description: { bsonType: "string" },
        price: { bsonType: ["decimal", "double", "int", "long"], minimum: 0 },
        category: { bsonType: "string", minLength: 1 },
        available: { bsonType: "bool" },
        preparationTimeMinutes: { bsonType: ["int", "long"], minimum: 0 }
      }
    }
  },
  validationLevel: "strict",
  validationAction: "error"
});

createCollectionIfMissing("dining_tables", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["tableNumber", "capacity", "occupied"],
      properties: {
        tableNumber: { bsonType: "string", minLength: 1 },
        capacity: { bsonType: ["int", "long"], minimum: 1 },
        occupied: { bsonType: "bool" }
      }
    }
  },
  validationLevel: "strict",
  validationAction: "error"
});

createCollectionIfMissing("restaurant_orders", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["customerName", "status", "createdAt"],
      properties: {
        customerName: { bsonType: "string", minLength: 1 },
        tableId: { bsonType: "string" },
        items: { bsonType: "string" },
        status: {
          enum: ["RECEIVED", "PREPARING", "READY", "SERVED", "PAID", "CANCELLED"]
        },
        createdAt: { bsonType: "date" }
      }
    }
  },
  validationLevel: "strict",
  validationAction: "error"
});

database.menu_items.createIndex({ category: 1 });
database.menu_items.createIndex({ available: 1 });
database.dining_tables.createIndex({ tableNumber: 1 }, { unique: true });
database.dining_tables.createIndex({ occupied: 1 });
database.restaurant_orders.createIndex({ status: 1 });
database.restaurant_orders.createIndex({ createdAt: -1 });
database.restaurant_orders.createIndex({ tableId: 1 });

print("restaurant_management database initialized");
