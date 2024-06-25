package vn.edu.likelion;

import java.util.Date;

public class Guest {

    // Define variables
    private int id;
    private String name;
    private int age;
    private Date registrationDate;
    private Event event;

    // Constructor
    public Guest(int id, String name, int age, Date registrationDate, Event event) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
        this.event = event;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // Convert to a string
    @Override
    public String toString() {
        return "Guest [id=" + id + ", name=" + name + ", age=" + age + ", registrationDate=" + registrationDate + ", event=" + event.getName() + "]";
    }
}

