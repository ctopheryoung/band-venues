import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class VenueTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void venue_instantiatesCorrectly_true() {
    Venue testVenue = new Venue("Revolution Hall");
    assertEquals(true, testVenue instanceof Venue);
    assertEquals("Revolution Hall", testVenue.getName());
    assertEquals(Venue.all().size(), testVenue.getId());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Venue.all().size(), 0);
  }

}
