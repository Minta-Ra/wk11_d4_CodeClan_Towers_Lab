import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;
    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(){
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.bookings = new ArrayList<Booking>();
        this.diningRooms = new HashMap<String, DiningRoom>();
    }

    public void addRoom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public void addRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return this.conferenceRooms;
    }

    public void checkIn(Room room, Guest guest){
        if (this.getVacantBedrooms().contains(room)) {
            room.addGuest(guest);
        }
    }

    public void checkOut(Room room, Guest guest){
        room.removeGuest(guest);
    }

    public Booking bookRoom(Bedroom bedroom, int nightsBooked){
        Booking newBooking = new Booking(nightsBooked, bedroom);
        bookings.add(newBooking);
        return newBooking;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public double getBill(Booking booking){
        return booking.getNightsBooked() * booking.getBedroom().getNightlyRate();
    }

    public void addRoom(DiningRoom diningRoom){
        diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public HashMap<String, DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public ArrayList<Bedroom> getVacantBedrooms(){
        ArrayList<Bedroom> emptyRooms = new ArrayList<Bedroom>();
        for(Bedroom bedroom : bedrooms){
            if(bedroom.getGuests().size() == 0){
                emptyRooms.add(bedroom);
            }
        }
        return emptyRooms;
    }


}
