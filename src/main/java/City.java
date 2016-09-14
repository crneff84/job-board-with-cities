import java.util.List;
import java.util.ArrayList;

public class City {
  private String mCityName;
  private static List<City> instances = new ArrayList<City>();
  private int mId;
  private List<JobOpening> mJobOpenings;

  public City(String cityName) {
    mCityName = cityName;
    instances.add(this);
    mId = instances.size();
    mJobOpenings = new ArrayList<JobOpening>();
  }

  public String getCityName() {
    return mCityName;
  }

  public static List<City> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static City find(int id) {
    try{
      return instances.get(id - 1);
    } catch(IndexOutOfBoundsException exception){
      return null;
    }
  }

  public List<JobOpening> getJobOpenings() {
    return mJobOpenings;
  }

  public void addJobOpening(JobOpening jobOpening) {
    mJobOpenings.add(jobOpening);
  }
}
