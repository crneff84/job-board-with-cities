import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobOpenings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      City city = City.find(Integer.parseInt(request.queryParams("cityId")));

      String title = request.queryParams("title");
      String contactInfo = request.queryParams("contactInfo");
      String description = request.queryParams("description");
      JobOpening newJobOpening = new JobOpening(title, contactInfo, description);
      city.addJobOpening(newJobOpening);
      model.put("city", city);
      model.put("template", "templates/city-jobOpenings-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/city-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities/search", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.queryParams("cityId")));
      String searchTerm = request.queryParams("search").trim().toLowerCase();
      List<JobOpening> result = city.getJobOpenings().stream()
      .filter(jobOpening -> (jobOpening.getDescription().toLowerCase().contains(searchTerm) || jobOpening.getTitle().toLowerCase().contains(searchTerm)))
      .collect(Collectors.toList());
      model.put("city", city);
      model.put("results", result);
      model.put("template", "templates/search.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      City newCity = new City(name);
      model.put("template", "templates/city-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cities/:id/jobOpenings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city-jobOpenings-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
