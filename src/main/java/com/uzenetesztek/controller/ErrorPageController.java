package com.uzenetesztek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorPageController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Autowired
    public void setErrorAttributes(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERROR_PATH)
    public String error(Model model, HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request); // get the attributes of the request
        Map<String, Object> error = this.errorAttributes.getErrorAttributes(servletWebRequest, true); // get only the attributes concerning the error

        model.addAttribute("error", error.get("error")); // add attributes to the model
        model.addAttribute("message", error.get("message"));
        model.addAttribute("path", error.get("path"));
        model.addAttribute("status", error.get("status"));
        model.addAttribute("timestamp", error.get("timestamp"));

//        if (error.get("status") == "404") {
//            return notFound(model, request);  // this is how to handle specific error codes for different error pages
//        }

        return "error";
    }

//    public String notFound(Model model, HttpServletRequest request) {
//        return "404";  // this redirects to the 404.html page
//    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
