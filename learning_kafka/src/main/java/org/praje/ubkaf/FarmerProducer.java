package org.praje.ubkaf;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class FarmerProducer {
	
	public static void main(String str[]) {
		
		String topicName = "FarmerTopic";
		
		Properties properties = new Properties();
		
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.praje.ubkaf.FarmerSerializer");
		
		Producer<String, Farmer> producer = new KafkaProducer<String, Farmer>(properties);
		
		Farmer farmer1 = new Farmer("1", "123", "Bangalore");
		Farmer farmer2 = new Farmer("2", "124", "mysosre");
		
		producer.send(new ProducerRecord<String, Farmer>(topicName, "FAR1", farmer1));
		producer.send(new ProducerRecord<String, Farmer>(topicName, "FAR2", farmer2));
		
		
		System.out.println("Close the transaction");
		producer.close();
		
		
		
	
		
	}
	
	

}
