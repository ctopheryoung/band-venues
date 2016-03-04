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

  //READ
  public static List<Band> all() {
    String sql = "SELECT id, name FROM bands";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Band.class);
    }
  }
  //UPDATE
  //DELETE
}
