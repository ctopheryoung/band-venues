import java.util.List;
import org.sql2o.*;

public class Venue {
  private int id;
  private String name;

  //CONSTRUCTOR
  public Venue(String name) {
    this.name = name;
  }

  //OVERRIDE FOR EQUALS METHOD
  @Override
  public boolean equals(Object otherVenue){
    if (!(otherVenue instanceof Venue)) {
      return false;
    } else {
      Venue newVenue = (Venue) otherVenue;
      return this.getName().equals(newVenue.getName());
    }
  }

  //GETTER METHODS
  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
  //CREATE
  public void save() {
    String sql = "INSERT INTO venues(name) VALUES (:name)";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql,true)
      .addParameter("name", name)
      .executeUpdate()
      .getKey();
    }
  }

  //READ
  public static List<Venue> all() {
    String sql = "SELECT id, name FROM venues";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Venue.class);
    }
  }

  public static Venue find(int id) {
    String sql = "SELECT * FROM venues where id=:id;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Venue.class);
    }
  }

  public List<Band> getBands() {
    String sql = "SELECT bands.* FROM venues JOIN band_venues ON (venues.id = band_venues.venue_id) JOIN bands ON (band_venues.band_id = bands.id) WHERE venues.id = :venue_id";
    try(Connection con = DB.sql2o.open()) {
        return con.createQuery(sql)
          .addParameter("venue_id", id)
          .executeAndFetch(Band.class);
    }
  }

  //UPDATE
  public void update(String name) {
    String sql = "UPDATE venues SET name = :name WHERE id = :id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void addBand(Band band) {
    String sql = "INSERT INTO band_venues (band_id, venue_id) VALUES (:band_id, :venue_id)";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
        .addParameter("band_id", band.getId())
        .addParameter("venue_id", id)
        .executeUpdate();
    }
  }
  //DELETE
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM venues WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();

      String enrollmentsQuery = "DELETE FROM band_venues WHERE venue_id = :venueId";
      con.createQuery(enrollmentsQuery)
        .addParameter("venueId", id)
        .executeUpdate();
    }
  }
}
