package com.dawn.exchangeConsumer.DBUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Controller
public class MongoConnectionUtil {

	//Get connection string from parameter file
	@Value("${mongoDB.connectionString}")
	private String connectionString;
	
	//Get database name from parameter file
	@Value("${mongoDB.databaseName}")
	private String databaseName;
	
	/**
	 * getDataBaseInstance method connect to MongoDB 
	 * @return MongoDB database
	 */
	public MongoDatabase getDataBaseInstance() {

		//Create uri from the connection string
		MongoClientURI uri = new MongoClientURI(connectionString);
		
		//Connect to mongoDB
		MongoClient mongoClient = new MongoClient(uri);
		
		//Get database from mongoDB
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		
		return database;
	}

}
