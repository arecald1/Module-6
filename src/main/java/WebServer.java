import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class WebServer {
    public static void main(String[] args) {

        staticFiles.location("/public");
        get("/", (req, res) -> {
            return new ModelAndView(null, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/search", (req, res) -> {
            return new ModelAndView(null, "search.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
