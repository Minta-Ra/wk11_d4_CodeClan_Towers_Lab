import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Bedroom bedroom;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private ConferenceRoom conferenceRoom;
    private Guest guest;
    private Guest guest2;
    private Booking booking;
    private DiningRoom diningRoom;

    @Before
    public void before(){
        hotel = new Hotel();
        bedroom = new Bedroom(12, RoomType.DOUBLE, 50);
        bedroom2 = new Bedroom(11, RoomType.SINGLE, 14);
        bedroom3 = new Bedroom(10, RoomType.SINGLE, 18);
        conferenceRoom = new ConferenceRoom(2, "Red room");
        guest = new Guest("Anna");
        guest2 = new Guest("Peter");
        diningRoom = new DiningRoom("Dining", 20);
    }

    @Test
    public void bedroomArrayStartsEmpty(){
        assertEquals(0, hotel.getBedrooms().size());
    }

    @Test
    public void confRoomArrayStartsEmpty(){
        assertEquals(0, hotel.getConferenceRooms().size());
    }

    @Test
    public void canAddBedroomToArray(){
        hotel.addRoom(bedroom);
        hotel.addRoom(bedroom2);
        assertEquals(2, hotel.getBedrooms().size());
    }

    @Test
    public void canAddConfRoomToArray(){
        hotel.addRoom(conferenceRoom);
        assertEquals(1, hotel.getConferenceRooms().size());
    }

    @Test
    public void guestCanCheckIn(){
        hotel.addRoom(bedroom);
        hotel.checkIn(bedroom, guest);
        assertEquals(1, bedroom.getGuests().size());
    }

    @Test
    public void guestCanCheckOut(){
        hotel.checkIn(conferenceRoom, guest);
        // System.out.println(conferenceRoom.getGuests().size());
        hotel.checkOut(conferenceRoom, guest);
        assertEquals(0, conferenceRoom.getGuests().size());
    }

    @Test
    public void guestCanBookRoom(){
        hotel.bookRoom(bedroom, 4);
        assertEquals(1, hotel.getBookings().size());
    }

    @Test
    public void canCalculateBill(){
        Booking newBooking = hotel.bookRoom(bedroom, 4);
        assertEquals(200.00, hotel.getBill(newBooking), 0.0);
    }

    @Test
    public void canAddDiningRoomToArray(){
        hotel.addRoom(diningRoom);
        assertEquals(1, hotel.getDiningRooms().size());
    }

    @Test
    public void canGetEmptyRooms(){
        hotel.addRoom(bedroom);
        hotel.addRoom(bedroom2);
        hotel.addRoom(bedroom3);
        hotel.checkIn(bedroom, guest);
        assertEquals(2, hotel.getVacantBedrooms().size());
    }

    @Test
    public void cannotCheckInGuest(){
        hotel.addRoom(bedroom2);
        hotel.checkIn(bedroom2, guest);
        hotel.checkIn(bedroom2, guest2);
        assertEquals(1, bedroom2.getGuests().size());
    }

}
