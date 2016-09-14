import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class JobOpeningTest{
  @Test
  public void JobOpening_instantiatesCorrectly_true() {
    JobOpening myJobOpening = new JobOpening("title", "contactinfo", "description");
    assertEquals(true, myJobOpening instanceof JobOpening);
  }

  @Test
  public void JobOpening_instantiatesWithTitle_string() {
    JobOpening myJobOpening = new JobOpening("title", "contactinfo", "description");
    assertEquals("title", myJobOpening.getTitle());
  }

  @Test
  public void JobOpening_instantiatesWithContactInfo_string() {
    JobOpening myJobOpening = new JobOpening("title", "contactinfo", "description");
    assertEquals("contactinfo", myJobOpening.getContactInfo());
  }

  @Test
  public void JobOpening_instantiatesWithDescription_string() {
    JobOpening myJobOpening = new JobOpening("title", "contactinfo", "description");
    assertEquals("description", myJobOpening.getDescription());
  }
}
