import org.junit.*;
import static org.junit.Assert.*;

public class CityTest{

  @Test
  public void City_instantiatesCorrectly_true() {
    City myCity = new City("cityName");
    assertEquals(true, myCity instanceof City);
  }

  @Test
  public void City_instantiatesWithCityName_string() {
    City myCity = new City("cityName");
    assertEquals("cityName", myCity.getCityName());
  }

  @Test
  public void all_returnsAllInstancesOfCity_true() {
    City firstCity = new City("Portland");
    City secondCity = new City("Seattle");
    assertEquals(true, City.all().contains(firstCity));
    assertEquals(true, City.all().contains(secondCity));
  }

  @Test
  public void clear_emptiesAllCitiesFromlist_0() {
    City testCity = new City("Portland");
    City.clear();
    assertEquals(City.all().size(), 0);
  }

  @Test
  public void getId_citiesInstantiateWithAnId_1() {
    City testCity = new City("Portland");
    assertEquals(1, testCity.getId());
  }

  @Test
  public void find_returnsCityWithSameId_secondCity(){
    City.clear();
    City firstCity = new City("Portland");
    City secondCity = new City("Seattle");
    assertEquals(City.find(secondCity.getId()), secondCity);
  }

  @Test
  public void find_returnsNullWhenNoTaskFound_null() {
    assertTrue(City.find(999) == null);
  }

  @Test
  public void getJobOpenings_intiallyReturnsEmptyList_0() {
    City.clear();
    City testCity = new City("Portland");
    assertEquals(0, testCity.getJobOpenings().size());
  }

  @Test
  public void addJobOpening_addsJobOpeningToList_true() {
    City.clear();
    City testCity = new City("Portland");
    JobOpening testJobOpening = new JobOpening("title", "contactinfo", "description");
    testCity.addJobOpening(testJobOpening);
    assertTrue(testCity.getJobOpenings().contains(testJobOpening));
  }

}
