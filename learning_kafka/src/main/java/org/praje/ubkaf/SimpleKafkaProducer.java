package org.praje.ubkaf;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleKafkaProducer {

	public static void main(String[] args) {
		String topicName = "test";
		String key ="key1";
		String value = "value11 for now today";
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, value);
		producer.send(record);
		producer.close();
		System.out.println("finish");
		
		
	}

}
