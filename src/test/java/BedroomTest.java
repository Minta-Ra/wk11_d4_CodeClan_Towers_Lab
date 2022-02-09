import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom;
    private Guest guest;

    @Before
    public void before(){
        this.bedroom = new Bedroom(1, RoomType.DOUBLE, 12);
        this.guest = new Guest("Sacha");
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        this.bedroom.addGuest(guest);
        assertEquals(1, bedroom.getGuests().size());
    }

    @Test
    public void hasNightlyRates(){
        assertEquals(12, bedroom.getNightlyRate());
    }


}
