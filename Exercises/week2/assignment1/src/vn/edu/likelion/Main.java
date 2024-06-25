package vn.edu.likelion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        while (true) {
            showMainMenu(); // Show the main menu list
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    EventDetails(eventManager, input, dateFormat); // Option to modify anything related to event
                    break;
                case "2":
                    GuestDetails(eventManager, input, dateFormat); // Option to modify anything related to guest
                    break;
                case "3":
                    System.out.println("Exiting program."); // Exiting program
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    private static void EventDetails(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        while (true) {
            showEventMenu(); // Show the event menu list
            String choiceEvent = input.nextLine();

            switch (choiceEvent) {
                case "1":
                    addEvent(eventManager, input, dateFormat); // Add an event
                    break;
                case "2":
                    editEvent(eventManager, input, dateFormat); // Edit an event
                    break;
                case "3":
                    removeEvent(eventManager, input, dateFormat); // Remove an event
                    break;
                case "4":
                    listEvent(eventManager, input, dateFormat); // List out all events
                    break;
                case "5":
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    private static void GuestDetails(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        while (true) {
            showGuestMenu();
            String choiceGuest = input.nextLine();

            switch (choiceGuest) {
                case "1":
                    addGuest(eventManager, input, dateFormat); // Add a guest
                    break;
                case "2":
                    editGuest(eventManager, input, dateFormat); // Edit a guest
                    break;
                case "3":
                    removeGuest(eventManager, input, dateFormat); // Remove a guest
                    break;
                case "4":
                    listGuest(eventManager, input, dateFormat); // List out all guests of an event
                    break;
                case "5":
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    private static void showMainMenu() {
        // Show the main menu list
        System.out.println("\nEvent Management");
        System.out.println("1. Event details.");
        System.out.println("2. Guest details.");
        System.out.println("3. Exit program.");
        System.out.print("Choose 1, 2, or 3: ");
    }

    private static void showEventMenu() {
        // Show the event menu list
        System.out.println("\nEvent Details");
        System.out.println("1. Add event.");
        System.out.println("2. Edit event.");
        System.out.println("3. Remove event.");
        System.out.println("4. List events.");
        System.out.println("5. Exit to main menu.");
        System.out.print("Choose 1, 2, 3, 4 or 5: ");
    }

    private static void addEvent(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // Add an event method
        try {
            System.out.print("Enter ID of the event: ");
            int eventId = Integer.parseInt(input.nextLine());

            if (eventManager.findEventById(eventId) == null) {
                System.out.print("Enter event name: ");
                String eventName = input.nextLine();

                System.out.print("Enter event date (dd/MM/yyyy HH:mm): ");
                String eventDateString = input.nextLine();
                Date eventDate = dateFormat.parse(eventDateString);

                System.out.print("Enter guest limit: ");
                int eventLimit = Integer.parseInt(input.nextLine());

                Event event = new Event(eventId, eventName, eventDate, eventLimit);

                eventManager.addEvent(event);
                System.out.println("Event added successfully.");
            } else {
                System.out.println("Event already exists.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editEvent(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // Edit an event method
        try {
            System.out.print("Enter ID of the event to edit: ");
            int eventId = Integer.parseInt(input.nextLine());
            if (!eventManager.canEditEvent(eventId)) {
                System.out.println("Event cannot be edited within 24 hours of the start time.");
                return;
            }
            Event event = eventManager.findEventById(eventId);

            if (event != null) {
                showEditEventMenu();
                String choiceEventEdit = input.nextLine();
                switch (choiceEventEdit) {
                    case "1":
                        editEventName(eventManager, input, dateFormat, event);
                        break;
                    case "2":
                        editEventDate(eventManager, input, dateFormat, event);
                        break;
                    case "3":
                        editEventGuestLimit(eventManager, input, dateFormat, event);
                        break;
                    case "4":
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void showEditEventMenu() {
        // Show the edit event menu list
        System.out.println("1. Edit event name.");
        System.out.println("2. Edit event date.");
        System.out.println("3. Edit event guest limit.");
        System.out.println("4. Exit to main menu.");
    }

    private static void editEventName(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event) {
        // Edit an event name method
        try {
            System.out.print("Enter event name to edit: ");
            String newEventName = input.nextLine();
            event.setName(newEventName);
            System.out.println("Event name updated successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editEventDate(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event) {
        // Edit an event date method
        try {
            System.out.print("Enter event date (dd/MM/yyyy) to edit: ");
            String newEventDate = input.nextLine();
            Date newEventDateString = dateFormat.parse(newEventDate);
            event.setDate(newEventDateString);
            System.out.println("Event date updated successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editEventGuestLimit(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event) {
        // Edit an event guest limit method
        try {
            System.out.print("Enter event guest limit to edit: ");
            int newEventLimit = Integer.parseInt(input.nextLine());
            event.setGuestLimit(newEventLimit);
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void removeEvent(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // Remove an event method
        try {
            System.out.print("Enter ID of the event to remove: ");
            int eventId = Integer.parseInt(input.nextLine());

            eventManager.removeEvent(eventId);
            System.out.println("Event removed successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void listEvent(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // List out all events method
        System.out.println("Events:");
        for (Event event : eventManager.listEvents()) {
            System.out.println(event);
        }
    }

    private static void showGuestMenu() {
        // Show the guest menu list
        System.out.println("\nGuest Details");
        System.out.println("1. Add guest.");
        System.out.println("2. Edit guest.");
        System.out.println("3. Remove guest.");
        System.out.println("4. List guests by event.");
        System.out.println("5. Exit to main menu.");
        System.out.print("Choose 1, 2, 3, or 4: ");
    }

    private static void addGuest(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // Add a guest to an event method
        try {
            System.out.print("Enter Guest ID: ");
            int guestId = Integer.parseInt(input.nextLine());

            System.out.print("Enter guest name: ");
            String guestName = input.nextLine();

            System.out.print("Enter guest age: ");
            int guestAge = Integer.parseInt(input.nextLine());

            System.out.print("Enter registration date (dd/MM/yyyy HH:mm): ");
            Date registrationDate = dateFormat.parse(input.nextLine());

            System.out.print("Enter event ID for the guest: ");
            int eventId = Integer.parseInt(input.nextLine());

            Event event = eventManager.findEventById(eventId);
            Guest guestEx = eventManager.findGuestById(eventId, guestId);
            if (event!=null && guestEx==null) {
                Guest guest = new Guest(guestId, guestName, guestAge, registrationDate, event);
                eventManager.addGuestToEvent(eventId, guest);
                System.out.println("Guest added successfully.");
            } else if (event != null) {
                System.out.println("Guest already exist.");
            } else {
                System.out.println("Event not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void removeGuest(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // Remove a guest from an event method
        try {
            System.out.print("Enter event ID: ");
            int eventId = Integer.parseInt(input.nextLine());

            System.out.print("Enter guest ID: ");
            int guestId = Integer.parseInt(input.nextLine());

            eventManager.removeGuestFromEvent(eventId, guestId);
            System.out.println("Guest removed successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void listGuest(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // List out all guests from an event method
        try {
            System.out.print("Enter event ID: ");
            int eventId = Integer.parseInt(input.nextLine());

            System.out.println("Guests in Event ID " + eventId + ":");
            for (Guest guest : eventManager.listGuestsInEvent(eventId)) {
                System.out.println(guest);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editGuest(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat) {
        // Edit a guest in an event method
        try {
            System.out.print("Enter ID of the event to find guest: ");
            int eventId = Integer.parseInt(input.nextLine());
            System.out.print("Enter guest ID: ");
            int guestId = Integer.parseInt(input.nextLine());

            Guest guest = eventManager.findGuestById(guestId, eventId);
            Event event = eventManager.findEventById(eventId);

            if (guest != null) {
                showEditGuestMenu();
                String choiceGuestName = input.nextLine();

                switch (choiceGuestName) {
                    case "1":
                        editGuestName(eventManager, input, dateFormat, event, guest);
                        break;
                    case "2":
                        editGuestAge(eventManager, input, dateFormat, event, guest);
                        break;
                    case "3":
                        editEventNameFromGuest(eventManager, input, dateFormat, event, guest);
                        break;
                    case "4":
                        editRegistrationDate(eventManager, input, dateFormat, event, guest);
                        break;
                    case "5":
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void showEditGuestMenu() {
        // Show the edit menu list
        System.out.println("1. Edit guest name.");
        System.out.println("2. Edit guest age.");
        System.out.println("3. Edit event name of the guest.");
        System.out.println("4. Edit registration date (dd/MM/yyyy).");
        System.out.println("5. Exit to main menu.");
    }

    private static void editGuestName(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event, Guest guest) {
        // Edit a guest name method
        try {
            System.out.println("Enter guest name: ");
            String newGuestName = input.nextLine();
            guest.setName(newGuestName);
            System.out.println("Guest name updated successfully");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editGuestAge(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event, Guest guest) {
        // Edit a guest age method
        try {
            System.out.println("Enter guest age: ");
            int newGuestAge = Integer.parseInt(input.nextLine());
            guest.setAge(newGuestAge);
            System.out.println("Guest age updated successfully");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editEventNameFromGuest(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event, Guest guest) {
        // Edit an event name from a guest
        try {
            System.out.print("Enter event name to edit: ");
            String newEventName = input.nextLine();
            event.setName(newEventName);
            System.out.println("Event name updated successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editRegistrationDate(EventManager eventManager, Scanner input, SimpleDateFormat dateFormat, Event event, Guest guest) {
        // Edit registration date of a guest
        try {
            System.out.print("Enter registration date (dd/MM/yyyy) to edit: ");
            String newRegistrationtDateString = input.nextLine();
            Date newRegistrationDate = dateFormat.parse(newRegistrationtDateString);
            event.setDate(newRegistrationDate);
            System.out.println("Registration date updated successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}

