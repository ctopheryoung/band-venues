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
}
