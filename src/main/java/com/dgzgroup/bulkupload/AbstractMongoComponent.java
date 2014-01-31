package com.dgzgroup.bulkupload;

import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Component
public class AbstractMongoComponent {

	
	protected MongoClient db;
	private String dbName;
	private String collectionName;
	
	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public AbstractMongoComponent() {

	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	
	
	public MongoClient getDb() {
		return db;
	}

	public void setDb(MongoClient db) {
		this.db = db;
	}
	
	
}
