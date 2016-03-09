import org.fluentlenium.adapter.FluentTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Database of Venues and Bands");
  }

  @Test
  public void bandIsDisplayedTest() {
    Band testBand = new Band("Fruition");
    testBand.save();
    goTo("http://localhost:4567/bands");
    assertThat(pageSource()).contains("Fruition");
  }

  @Test
    public void venueIsDisplayedTest() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();
    goTo("http://localhost:4567/venues");
    assertThat(pageSource()).contains("Revolution Hall");
  }

  @Test
  public void allBandsDisplayAllBandNamesOnVenuePage() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();

    Band firstBand = new Band("Fruition");
    firstBand.save();

    firstBand.addVenue(testVenue);

    String categoryPath = String.format("http://localhost:4567/venues/%d", testVenue.getId());
    goTo(categoryPath);
    assertThat(pageSource()).contains("Revolution Hall");
    assertThat(pageSource()).contains("Fruition");
  }

  @Test
  public void allVenuesAreDisplayedOnBandPage() {
    Venue testVenue = new Venue("Revolution Hall");
    testVenue.save();

    Band firstBand = new Band("Fruition");
    firstBand.save();

    testVenue.addBand(firstBand);

    String categoryPath = String.format("http://localhost:4567/bands/%d", firstBand.getId());
    goTo(categoryPath);
    assertThat(pageSource()).contains("Revolution Hall");
    assertThat(pageSource()).contains("Fruition");
  }
}
