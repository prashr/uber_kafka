package org.praje.ubkaf;

public class Farmer {
	
	private String farmerId;
	private String aadharNum;
	private String villageName;
	
	
	
	public Farmer(String farmerId, String aadharNum, String villageName) {
		super();
		this.farmerId = farmerId;
		this.aadharNum = aadharNum;
		this.villageName = villageName;
	}
	
	
	public String getFarmerId() {
		return farmerId;
	}
	public String getAadharNum() {
		return aadharNum;
	}
	public String getVillageName() {
		return villageName;
	}


	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", aadharNum=" + aadharNum + ", villageName=" + villageName + "]";
	}
	
	
	

}
