import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest;

    @Before
    public void before(){
        this.conferenceRoom = new ConferenceRoom(5, "Main");
        this.guest = new Guest("Anna");
    }

    @Test
    public void hasName(){
        assertEquals("Main", conferenceRoom.getName());
    }

    @Test
    public void guestsStartsEmpty(){
        assertEquals(0, conferenceRoom.getGuests().size());
    }

    @Test
    public void hasCapacity(){
        assertEquals(5, conferenceRoom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        this.conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.getGuests().size());
    }

}
