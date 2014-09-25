package myWall.controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result rootOptions() {
        return noContent();
    }

    public static Result options(String url) {
        return noContent();
    }

}