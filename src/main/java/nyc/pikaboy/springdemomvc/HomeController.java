package nyc.pikaboy.springdemomvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Step 1: Define @Controller annotation
@Controller
public class HomeController {
    //Step 3: Create the request mapping
    @RequestMapping("/")
    //Step 2: Create a controller method
    public String showPage(){
        //Step 4: Return view name
        return "main-menu";
    }
}
