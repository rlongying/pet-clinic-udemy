package learn.spring.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @GetMapping({"/oups", "/error"})
    public String error(Model model) {
        model.addAttribute("message", "Something was wrong ...");
        return "error";
    }
}
