

public class JobOpening {
  private String mTitle;
  private String mContactInfo;
  private String mDescription;


  public JobOpening (String title, String contactInfo, String description) {
    mTitle = title;
    mContactInfo = contactInfo;
    mDescription = description;
  }

  public String getTitle(){
    return mTitle;
  }

  public String getContactInfo(){
    return mContactInfo;
  }

  public String getDescription(){
    return mDescription;
  }

}
