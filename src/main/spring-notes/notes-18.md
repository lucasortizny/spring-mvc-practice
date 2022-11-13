
# Reading Form Data with Spring MVC (Notes #18)

At a high level, we are gonna have a form asking the user for its name, they'll hit 
submit query, it'll go through the spring mvc application, and then we'll show a confirmation page.


So in the browser they'll go to ``/showForm`` and then go to the HelloWorld controller
and then show the jsp form. 

Once they hit submit, this is gonna pass the information to ``/processForm`` request mapping and then
go to the controller and pass back a confirmation page with the collected form values.
One hello world controller with two request mappings.


Let's take a look the source code of the controller. 

File: HelloWorldController.java

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    // need a controller method to show the initial html form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    // need a controller method to process html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
}

```

This can be any method names. All we do is just map the paths to the actual methods
so we can make this work properly. 

## Development Process

Step by step breakdown of the development process!

1) Create controller class
2) Show the html form: create controller method to show HTML form, create view page for HTML form.
3) Process HTML Form: create controller method to process HTML form, develop view page for confirmation

