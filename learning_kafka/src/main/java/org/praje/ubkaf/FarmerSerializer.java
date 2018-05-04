package org.praje.ubkaf;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

public class FarmerSerializer implements Serializer<Farmer> {

	private String encode ="UTF8";
	
	public void close() {
		// Do Nothing
		
	}

	public void configure(Map<String, ?> arg0, boolean arg1) {
		// Do Nothing
		
	}

	public byte[] serialize(String string, Farmer farmer) {
		
		
		byte[] serializedFarmerId, serializedAadhar,serializedVillage;
		int farmerIdSize, aadharSize, villageSize;
		
		try {
			if(farmer == null) return null;
			serializedFarmerId = farmer.getFarmerId().getBytes(encode);
			farmerIdSize = serializedFarmerId.length;
			serializedAadhar = farmer.getAadharNum().getBytes(encode);
			aadharSize = serializedAadhar.length;
			serializedVillage = farmer.getVillageName().getBytes(encode);
			villageSize = serializedVillage.length;
			ByteBuffer buffer = ByteBuffer.allocate(4+4+4+4+farmerIdSize+aadharSize+villageSize);
			buffer.putInt(farmerIdSize);
			buffer.put(serializedFarmerId);
			buffer.putInt(aadharSize);
			buffer.put(serializedAadhar);
			buffer.putInt(villageSize);
			buffer.put(serializedVillage);
			return buffer.array();
			
		}catch(Exception exc)
		{
			System.out.println("Serilazition failed");
		}		
		return null;
	}

}
