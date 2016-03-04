import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void band_instantiatesCorrectly_true() {
    Band testBand = new Band("Fruition");
    assertEquals(true, testBand instanceof Band);
    assertEquals("Fruition", testBand.getName());
    assertEquals(Band.all().size(), testBand.getId());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Band.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    Band firstBand = new Band("Fruition");
    Band secondBand = new Band("Fruition");
    assertTrue(firstBand.equals(secondBand));
  }

  // @Test
  // public void equals_returnsTrueIfSavedBandsAretheSame() {
  //   Band testBand = new Band("Fruition");
  //   testBand.save();
  //   assertTrue(Band.all().get(0).equals(testBand));
  // }

  // @Test
  // public void save_assignsIdToObject() {
  //   Band testBand = new Band("Fruition");
  //   testBand.save();
  //   Band savedBand = Band.all().get(0);
  //   assertEquals(testBand.getId(), savedBand.getId());
  // }
  //
  // @Test
  // public void save_savesIntoDatabase_true() {
  //   Band testBand = new Band("Fruition");
  //   testBand.save();
  //   assertEquals(Band.all().get(0).getName(), "Fruition");
  // }
  //
  // @Test
  // public void find_findsBandInDatabase_true() {
  //   Band testBand = new Band("Fruition");
  //   testBand.save();
  //   Band savedBand = Band.find(testBand.getId());
  //   assertEquals(savedBand.getName(), "Fruition");
  // }
  //
  // @Test
  // public void all_returnsAllInstancesOfBand_true() {
  //   Band firstBand = new Band("Fruition");
  //   Band secondBand = new Band("Chili Powder");
  //   firstBand.save();
  //   secondBand.save();
  //   assertTrue(Band.all().contains(firstBand));
  //   assertTrue(Band.all().contains(secondBand));
  // }
  //
  // @Test
  // public void find_returnsBandWithSameId_secondBand() {
  //   Band firstBand = new Band("Fruition");
  //   Band secondBand = new Band("Chili Powder");
  //   firstBand.save();
  //   secondBand.save();
  //   assertEquals(Band.find(secondBand.getId()), secondBand);
  // }
  //
  // @Test
  // public void find_returnsNullWhenNoBandFound_null() {
  //   assertTrue(Band.find(999) == null);
  // }
  //
  // @Test
  // public void delete_deleteDeletesBand() {
  //   Band myBand = new Band("Fruition");
  //   myBand.save();
  //   myBand.delete();
  //   assertEquals(Band.all().size(), 0);
  // }
  //TESTS TO BE USED AFTER RECIPE CLASS IS SET UP
  // @Test
  // public void addRecipe_addsRecipeForIngredient() {
  //   Recipe myRecipe = new Recipe(????);
  //   myRecipe.save();
  //
  //   Ingredient myIngredient = new Ingredient("Fruition");
  //   myIngredient.save();
  //
  //   myIngredient.addRecipe(myRecipe);

  //   Recipe savedRecipe = myIngredient.getRecipes().get(0);
  //   assertTrue(myRecipe.equals(savedRecipe));
  // }
  //
  // @Test
  // public void getRecipes_returnsRecipesThatUseIngredient_List() {
  //   Recipe myRecipe = new Recipe(????);
  //   myRecipe.save();
  //
  //   Ingredient myIngredient = new Ingredient("Fruition");
  //   myIngredient.save();
  //
  //   myIngredient.addRecipe(myRecipe);

  //   List<Recipe> savedRecipes = myIngredient.getRecipes();
  //   assertEquals(savedRecipe.size(), 1);
  // }
}
