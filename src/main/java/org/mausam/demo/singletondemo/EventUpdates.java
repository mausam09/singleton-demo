package org.mausam.demo.singletondemo;

import java.util.ArrayList;
import java.util.List;

import org.mausam.demo.singletondemo.vo.Event;

/**
 * @author mausam
 * 
 * The singleton object of this class acts as a central 
 * repository of all events arriving from multiple sources. 
 * In turn, the list of events can potentially be read by 
 * something like one or more orchestration agent(s).
 *
 */
public class EventUpdates {
	
	private List<Event> events;
	private static EventUpdates instance;
	
	private EventUpdates() {
		events = new ArrayList<Event>();
	}
	
	/**
	 * Static method to always return the same instance
	 * 
	 * @return the singleton instance of this class
	 */
	public static EventUpdates getInstance() {
		if (instance == null) {
			instance = new EventUpdates();
		}
		
		return instance;
	}
	
	/**
	 * @param event object to append to the list of events
	 * @return true if the event was appended successfully 
	 * to the list; false otherwise
	 */
	public synchronized boolean addEventToList(final Event event) {
		return this.events.add(event);
	}
	
	/**
	 * @return the last event object added
	 */
	public Event getLatestEvent() {
		return events.get(events.size() - 1);
	}
	
	/**
	 * @return the List of all events added since the last flush of the list
	 */
	public List<Event> getAllEvents() {
		return this.events;
	}
	
	/**
	 * Flushes all events from the list
	 */
	public void resetListOfEvents() {
		if (this.events != null) {
			this.events.clear();
		}
	}

}
