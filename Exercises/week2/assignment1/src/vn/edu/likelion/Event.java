package vn.edu.likelion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {

    // Define variables
    private int id;
    private String name;
    private Date date;
    private int guestLimit;
    private List<Guest> guests;

    // Constructor
    public Event(int id, String name, Date date, int guestLimit) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.guestLimit = guestLimit;
        this.guests = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGuestLimit() {
        return guestLimit;
    }

    public void setGuestLimit(int guestLimit) {
        this.guestLimit = guestLimit;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    // Add a guest to the event
    public void addGuest(Guest guest) {
        if ((!guests.contains(guest)) && (!guests.contains(null)) && (guests.size() <= guestLimit)) {
            guests.add(guest);
            System.out.println("Guest added: " + guest.getName());
        } else if (guests.contains(guest)) {
            System.out.println("Guest already exists");
        } else if (guests.size() > guestLimit) {
            System.out.println("Guest limit exceeded");
        } else {
            System.out.println("No guest exists");
        }
    }

    // Remove a guest from the event
    public void removeGuest(int guestId) {
        guests.removeIf(guest -> guest.getId() == guestId);
    }

    // Convert to a string
    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", date=" + date + ", guestLimit=" + guestLimit + ", guests=" + guests + "]";
    }
}