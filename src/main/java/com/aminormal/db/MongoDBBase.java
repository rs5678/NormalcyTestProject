package com.aminormal.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public abstract class MongoDBBase {

    // SETUP THESE PARAMETERS FOR YOUR INSTANCE
    // If hostname is not  good you would get network error
    // If user/password are bad you would get "'bad auth : Authentication failed."
    final public static String MONGODB_HOST="cluster0.xk5cc.mongodb.net";

    final public static String MONGODB_USER="questionUser";
    final public static String MONGODB_PASSWORD="Dog12345";

    // Ensure the database name is good
    final public static String DATABASE_NAME="myFirstDatabase";

    // Connection string for MongoDB
    final public static String MONGODB_CLUSTER_URL="mongodb+srv://"+MONGODB_USER+":"+MONGODB_PASSWORD+"@"+MONGODB_HOST+"/"+DATABASE_NAME;

    /**
     * Inserts in the collection
     * @param jsonDocument
     */
    public void executeInsert(String collection, String jsonDocument){
        // This is to suppress the MongoDB log messages
//        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "ERROR");

        MongoClient mongoClient = new MongoClient(new MongoClientURI(MONGODB_CLUSTER_URL));

        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        MongoCollection mongoCollection = database.getCollection(collection);

        Document document = Document.parse(jsonDocument);

        mongoCollection.insertOne(document);

        mongoClient.close();

    }

    public FindIterable find(String collection, Bson filter){
        // This is to suppress the MongoDB log messages
//        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "ERROR");

        MongoClient mongoClient = new MongoClient(new MongoClientURI(MONGODB_CLUSTER_URL));

        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        MongoCollection mongoCollection = database.getCollection(collection);

        FindIterable iterable = mongoCollection.find(filter);

        return iterable;
    }

    /**
     * Executes the check for existence
     * https://docs.mongodb.com/manual/reference/method/db.collection.countDocuments/
     */
    public long getDocumentCount(String collection, Bson filter){
//        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "ERROR");

        MongoClient mongoClient = new MongoClient(new MongoClientURI(MONGODB_CLUSTER_URL));

        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

        MongoCollection mongoCollection = database.getCollection(collection);

        long count = mongoCollection.countDocuments(filter);

        mongoClient.close();

//        System.out.println("MongoDBBase count="+count);

        return count;
    }


}




