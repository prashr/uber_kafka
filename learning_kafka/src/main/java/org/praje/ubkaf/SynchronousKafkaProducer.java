package org.praje.ubkaf;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Synchronous Producer 
 */
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class SynchronousKafkaProducer {

	public static void main(String[] args) {
		String topicName = "test";
		String key ="key1";
		String value = "value11 Asynchronous value";
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, value);
		Future<RecordMetadata> rec = producer.send(record);
		try {
			RecordMetadata metadata = rec.get();
			System.out.println("Record insterted to : "+metadata.topic());
		}catch (Exception e) {
			System.err.println("exception Caught " + e.getStackTrace());
		}
		producer.close();
		System.out.println("finish");
		
		
	}

}

