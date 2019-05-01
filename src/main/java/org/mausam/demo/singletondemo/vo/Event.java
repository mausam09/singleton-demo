package org.mausam.demo.singletondemo.vo;

/**
 * @author mausam
 * 
 * Value object to hold event data
 *
 */
public class Event {
	
	private EventType eventType;
	private String eventString;
	private String eventTimestamp;
	
	public Event(final EventType eventType, 
			final String eventString, final String eventTimestamp) {
		this.eventType = eventType;
		this.eventString = eventString;
		this.eventTimestamp = eventTimestamp;
	}
	
	public EventType getEventType() {
		return eventType;
	}
	
	public void setEventType(final EventType eventType) {
		this.eventType = eventType;
	}
	
	public String getEventString() {
		return eventString;
	}
	
	public void setEventString(final String eventString) {
		this.eventString = eventString;
	}
	
	public String getEventTimestamp() {
		return eventTimestamp;
	}
	
	public void setEventTimestamp(final String eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}
	
	

}
