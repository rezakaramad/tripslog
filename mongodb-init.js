const databaseName = process.env.MONGO_INITDB_DATABASE;
const username = process.env.MONGO_APP_USERNAME;
const password = process.env.MONGO_APP_PASSWORD;

if (!databaseName || !username || !password) {
  throw new Error("Missing MongoDB init environment variables");
}

const database = db.getSiblingDB(databaseName);

database.createUser({
  user: username,
  pwd: password,
  roles: [
    {
      role: "readWrite",
      db: databaseName
    }
  ]
});

print(`Created MongoDB user '${username}' on database '${databaseName}'`);
