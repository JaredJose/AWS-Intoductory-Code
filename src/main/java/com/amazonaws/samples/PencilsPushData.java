package com.amazonaws.samples;

import java.sql.SQLException;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class PencilsPushData {
	public static void main(String[] args) throws InterruptedException, SQLException {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
		DynamoDB dynamoDB = new DynamoDB(client);
		
		Table table = dynamoDB.getTable("Pencils");
		
		Item item = new Item()
				.withPrimaryKey("ID", 3)
				.withNumber("coolFactor", 0)
				.withNumber("cost", 15)
				.withString("name", "Staedtler Pencil");
		
		PutItemOutcome outcome = table.putItem(item);
	}
}
