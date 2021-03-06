import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import java.util.List;


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

  @Test
  public void save_assignsIdToObject() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    Venue savedVenue = Venue.all().get(0);
    assertEquals(testVenue.getId(), savedVenue.getId());
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    assertEquals(Venue.all().get(0).getName(), "Revolution Hall");
  }

  @Test
  public void find_findsVenueInDatabase_true() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    Venue savedVenue = Venue.find(testVenue.getId());
    assertEquals(savedVenue.getName(), "Revolution Hall");
  }


  @Test
  public void all_returnsAllInstancesOfVenue_true() {
    Venue firstVenue = new Venue("Revolution Hall");
    Venue secondVenue = new Venue("Crystal Ballroom");
    firstVenue.save();
    secondVenue.save();
    assertTrue(Venue.all().contains(firstVenue));
    assertTrue(Venue.all().contains(secondVenue));
  }

  @Test
  public void find_returnsVenueWithSameId_secondVenue() {
    Venue firstVenue = new Venue("Revolution Hall");
    Venue secondVenue = new Venue("Crystal Ballroom");
    firstVenue.save();
    secondVenue.save();
    assertEquals(Venue.find(secondVenue.getId()), secondVenue);
  }

  @Test
  public void find_returnsNullWhenNoVenueFound_null() {
    assertTrue(Venue.find(999) == null);
  }

  @Test
  public void delete_deleteDeletesVenue() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    testVenue.delete();
    assertEquals(Venue.all().size(), 0);
  }

  @Test
  public void update_updatesVenueNameInDatabase() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    testVenue.update("Washington High");
    Venue savedVenue = Venue.find(testVenue.getId());
    assertEquals(savedVenue.getName(), "Washington High");
  }

  @Test
  public void getBands_returnsAllBands_List() {
    Band myBand = new Band("Fruition");
    myBand.save();
    Venue myVenue = new Venue("Revolution Hall");
    myVenue.save();
    myVenue.addBand(myBand);
    List<Band> savedBand = myVenue.getBands();
    assertEquals(savedBand.size(), 1);
  }
}
