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

  // @Test
  // public void clientPhoneFormIsDisplayed() {
  //   Stylist testStylist = new Stylist("Larry");
  //   testStylist.save();
  //
  //   Client testClient = new Client("Donald Trump", "111-111-1111", testStylist.getId());
  //   testClient.save();
  //
  //   String clientDisplay = String.format("http://localhost:4567/clients/%d", testClient.getId());
  //   goTo(clientDisplay);
  //   assertThat(pageSource()).contains("111-111-1111");
  // }
  //
  // @Test
  // public void clientIsDeletedAndSuccessPageShows() {
  //   Stylist testStylist = new Stylist("Larry");
  //   testStylist.save();
  //
  //   Client testClient = new Client("Donald Trump", "111-111-1111", testStylist.getId());
  //   testClient.save();
  //
  //   String clientPage = String.format("http://localhost:4567/clients/%d", testClient.getId());
  //   goTo(clientPage);
  //   click("button", withText("Delete Client"));
  //   assertThat(pageSource()).contains("Delete Successful!");
  // }
  //
  // @Test
  // public void allClientsDisplayAllClientNamesOnStylistage() {
  //   Stylist testStylist = new Stylist("Larry");
  //   testStylist.save();
  //   Client firstClient = new Client("Donald Trump", "123-456-7890", testStylist.getId());
  //   firstClient.save();
  //   Client secondClient = new Client("Hillary Clinton", "111-111-1111", testStylist.getId());
  //   secondClient.save();
  //   String categoryPath = String.format("http://localhost:4567/stylists/%d", testStylist.getId());
  //   goTo(categoryPath);
  //   assertThat(pageSource()).contains("Donald Trump");
  //   assertThat(pageSource()).contains("Hillary Clinton");
  // }
}
