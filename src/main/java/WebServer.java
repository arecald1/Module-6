import model.Course;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebServer {
    public static void main(String[] args) {
        staticFiles.location("/public");

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("EN.500.112","GATEWAY COMPUTING: JAVA"));
        courses.add(new Course("EN.601.220","INTERMEDIATE PROGRAMMING"));
        courses.add(new Course("EN.601.226","DATA STRUCTURES"));
        courses.add(new Course("EN.601.229","COMPUTER SYSTEM FUNDAMENTALS"));
        courses.add(new Course("EN.601.231","AUTOMATA and COMPUTATION THEORY"));

        get("/", (req, res) -> {
            return new ModelAndView(null, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/search", (req, res) -> {
            Map<String, Object> model = Map.of("courses", courses);
            return new ModelAndView(model, "search.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
