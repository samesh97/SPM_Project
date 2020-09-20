package enums;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Location {
	private SimpleStringProperty locationId;
	private SimpleStringProperty buildingId;
	private SimpleStringProperty blockId;
	private SimpleStringProperty roomId;
	private SimpleStringProperty roomType;
	private Button btnUpdate;
	private Button btnDelete;
	
	public Location() {
		
	}
	
	public Location(String buildingId, String blockId, String roomId, String roomType) {
		super();		
		this.buildingId = new SimpleStringProperty(buildingId);
		this.blockId = new SimpleStringProperty(blockId);
		this.roomId = new SimpleStringProperty(roomId);
		this.roomType = new SimpleStringProperty(roomType);
		this.btnUpdate= new Button("UPDATE");
		this.btnDelete= new Button("DELETE");
	}

	public String getLocationId() {
		return locationId.get();
	}

	public void setLocationId(String locationId) {
		this.locationId = new SimpleStringProperty(locationId);
	}
	
	public String getBuildingId() {
		return buildingId.get();
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = new SimpleStringProperty(buildingId);
	}

	public String getBlockId() {
		return blockId.get();
	}

	public void setBlockId(String blockId) {
		this.blockId = new SimpleStringProperty(blockId);
	}

	public String getRoomId() {
		return roomId.get();
	}

	public void setRoomId(String roomId) {
		this.roomId = new SimpleStringProperty(roomId);
	}

	public String getRoomType() {
		return roomType.get();
	}

	public void setRoomType(String roomType) {
		this.roomType = new SimpleStringProperty(roomType);
	}
	
	

}
