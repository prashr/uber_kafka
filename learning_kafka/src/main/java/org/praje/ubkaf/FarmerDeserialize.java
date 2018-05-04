package org.praje.ubkaf;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

public class FarmerDeserialize implements Deserializer<Farmer> {
	private String str = "UTF8";
	
	public void close() {
		// TODO Auto-generated method stub
		
	}

	
	public Farmer deserialize(String topic, byte[] data) {
		
		try {
			
			if(data == null) {
				System.out.println("data is null");
				return null;
			}
			
			ByteBuffer buffer = ByteBuffer.wrap(data);
			
			int idSize = buffer.getInt();
			byte[] id = new byte[idSize];
			buffer.get(id);
			String deFarmerId = new String(id,str);
			
			int adharSize = buffer.getInt();
			byte[] adhar = new byte[adharSize];
			buffer.get(adhar);
			String deAdhar = new String(adhar,str);
			
			int villegeSize = buffer.getInt();
			byte[] village = new byte[villegeSize];
			buffer.get(village);
			String deVillage = new String(village,str);
			
			return new Farmer(deFarmerId, deAdhar, deVillage);
			
		}catch(Exception ex) {
			System.out.println("exception received");
		}
		
		return null;
	}

	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

}
