package org.praje.ubkaf;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
/**
 * Asynchronous Producer 
 */
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class AsynchronousKafkaProducer {

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
		producer.send(record, new MyProducerCallback());
		producer.close();
		System.out.println("finish");
		
		
	}

}

class MyProducerCallback implements Callback{

	public void onCompletion(RecordMetadata data, Exception e) {
		
		if(e != null) {
			System.out.println("exception thrown " + e.getMessage());
		}else {
			System.out.println("the message sending is successful : " +  data.topic() + " to the partition : " + data.partition() + " Offset: " + data.offset());
		}
		
	}
	
}
