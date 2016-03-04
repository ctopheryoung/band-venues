import java.util.List;
import org.sql2o.*;

public class Band {
  private int id;
  private String name;

  //CONSTRUCTOR
  public Band(String name) {
    this.name = name;
  }

  //OVERRIDE FOR EQUALS METHOD
  @Override
  public boolean equals(Object otherBand){
    if (!(otherBand instanceof Band)) {
      return false;
    } else {
      Band newBand = (Band) otherBand;
      return this.getName().equals(newBand.getName());
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
    String sql = "INSERT INTO bands(name) VALUES (:name)";
    try(Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql,true)
      .addParameter("name", name)
      .executeUpdate()
      .getKey();
    }
  }

  public void addVenue(Venue venue) {
    String sql = "INSERT INTO band_venues (band_id, venue_id) VALUES (:band_id, :venue_id)";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
      .addParameter("band_id", id)
      .addParameter("venue_id", venue.getId())
      .executeUpdate();
    }
  }
  
  //READ
  public static List<Band> all() {
    String sql = "SELECT id, name FROM bands";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Band.class);
    }
  }

  public static Band find(int id) {
    String sql = "SELECT * FROM bands where id=:id;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Band.class);
    }
  }

  public List<Venue> getVenues() {
    String sql = "SELECT venues.* FROM bands JOIN band_venues ON (bands.id = band_venues.band_id) JOIN venues ON (band_venues.venue_id = venues.id) WHERE bands.id = :band_id";
    try(Connection con = DB.sql2o.open()) {
        return con.createQuery(sql)
          .addParameter("band_id", id)
          .executeAndFetch(Venue.class);
    }
  }
  //UPDATE
  public void update(String name) {
    String sql = "UPDATE bands SET name = :name WHERE id = :id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }


  //DELETE
  public void removeVenue(Venue venue) {
    String sql = "DELETE FROM band_venues (band_id, venue_id) VALUES (:band_id, :venue_id)";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql)
        .addParameter("band_id", id)
        .addParameter("venue_id", venue.getId())
        .executeUpdate();
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM bands WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();

      String enrollmentsQuery = "DELETE FROM band_venues WHERE band_id = :bandId";
      con.createQuery(enrollmentsQuery)
        .addParameter("bandId", id)
        .executeUpdate();
    }
  }
}
