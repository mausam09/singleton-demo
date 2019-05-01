package org.mausam.demo.singletondemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mausam.demo.singletondemo.vo.Event;
import org.mausam.demo.singletondemo.vo.EventType;

public class EventUpdatesTest {
	
	private EventUpdates eventUpdates;

	@Before
	public void setUp() throws Exception {
		this.eventUpdates = EventUpdates.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertTrue(eventUpdates == EventUpdates.getInstance());
	}

	@Test
	public void testAddEventToList() {
		assertTrue(eventUpdates.addEventToList(getTestEvent()));
	}

	@Test
	public void testGetLatestEvent() {
		Event latestEvent = getTestEvent();
		this.eventUpdates.addEventToList(latestEvent);
		
		assertEquals(latestEvent, 
				eventUpdates.getAllEvents().get(
						eventUpdates.getAllEvents().size() - 1));
	}

	@Test
	public void testGetAllEvents() {
		assertFalse(eventUpdates.getAllEvents().isEmpty());
	}

	@Test
	public void testResetListOfEvents() {
		eventUpdates.resetListOfEvents();
		
		assertTrue(eventUpdates.getAllEvents().isEmpty());
	}
	
	private Event getTestEvent() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return new Event(EventType.ADD, 
				"Test Event String", df.format(new Date()));
		
	}

}
