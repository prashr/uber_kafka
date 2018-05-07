package org.praje.ubkaf.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.praje.ubkaf.Farmer;
import org.praje.ubkaf.FarmerDeserialize;

public class FarmerConsumer {

	public static void main(String str[]) {
		String topicName = "FarmerTopic";
		String groupName = "FarmerTopicGroup";
		
		Properties prop = new Properties();
		prop.put("bootstrap.servers", "localhost:9092" );
		prop.put("group.id", groupName);
		prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.put("value.deserializer", "org.praje.ubkaf.FarmerDeserialize");
		
		KafkaConsumer<String, Farmer> consumer = null;
		try {
			consumer = new KafkaConsumer<String, Farmer>(prop);
			consumer.subscribe(Arrays.asList(topicName));
			
			while(true) {
				ConsumerRecords<String, Farmer> records = consumer.poll(100);
				for(ConsumerRecord<String, Farmer> record : records) {
					System.out.println("key " + record.key() + " val : " +  record.value());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			consumer.close();
		}
				
	
		
	}
	
}
