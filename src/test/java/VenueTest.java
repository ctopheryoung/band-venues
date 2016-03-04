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

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    Venue firstVenue = new Venue("Revolution Hall");
    Venue secondVenue = new Venue("Revolution Hall");
    assertTrue(firstVenue.equals(secondVenue));
  }

  @Test
  public void equals_returnsTrueIfSavedVenuesAretheSame() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    assertTrue(Venue.all().get(0).equals(testVenue));
  }
}
