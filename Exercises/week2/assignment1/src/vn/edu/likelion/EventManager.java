package vn.edu.likelion;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    // Add an event to the manager
    public void addEvent(Event event) {
        if (events.size() < 5) {
            events.add(event);
        } else {
            System.out.println("Cannot add more than 5 events.");
        }
    }

    // Remove an event from the manager
    public void removeEvent(int eventId) {
        events.removeIf(event -> event.getId() == eventId);
    }

    // List all events
    public List<Event> listEvents() {
        return events;
    }

    // Add a guest to an event
    public void addGuestToEvent(int eventId, Guest guest) {
        Event event = findEventById(eventId);
        if (event != null) {
            if (guest.getAge() >= 18) {
                event.addGuest(guest);
            } else {
                System.out.println("Guests must be at least 18 years old.");
            }
        } else {
            System.out.println("Event not found.");
        }
    }

    // List all guests in an event
    public List<Guest> listGuestsInEvent(int eventId) {
        Event event = findEventById(eventId);
        if (event != null) {
            return event.getGuests();
        } else {
            System.out.println("Event not found.");
            return new ArrayList<>();
        }
    }

    // Remove a guest from an event
    public void removeGuestFromEvent(int eventId, int guestId) {
        Event event = findEventById(eventId);
        if (event != null) {
            event.removeGuest(guestId);
        } else {
            System.out.println("Event not found.");
        }
    }

    // Find an event by ID
    public Event findEventById(int eventId) {
        for (Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    // Find a guest by ID
    public Guest findGuestById(int eventId, int guestId) {
        Event event = findEventById(eventId);
        if (event != null) {
            for (Guest guest : event.getGuests()) {
                if (guest.getId() == guestId) {
                    return guest;
                }
            }
        }
        return null;
    }

    // Check whether edit event or not
    public boolean canEditEvent(int eventId) {
        Event event = findEventById(eventId);
        if (event != null) {
            long currentTime = new Date().getTime();
            long eventTime = event.getDate().getTime();
            long diffInHours = (eventTime - currentTime) / (1000 * 60 * 60);
            return diffInHours >= 24;
        }
        return false;
    }
}
