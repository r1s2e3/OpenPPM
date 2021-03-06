package es.sm2.openppm.core.model.enums;

public enum StatusNotificationEnum {

	ENABLED("ENABLED"),
    DISABLED("DISABLED");
	
	private String status;
	
	private StatusNotificationEnum(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
