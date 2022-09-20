# Creating a Spring Home Controller and View (Notes #17)

What we are going to do is set up a request mapping for a given path and then have 
a home controller that's gonna handle the request and forward it over to a view template (main-menu.jsp).

### Development Process Step-by-Step

1) Create controller class
2) Define Controller method
3) Add request mappings to the Controller mapping
4) Return view name
5) Develop view page

### Step 1: Create controller class

- Annotate class with ``@Controller``.
- ``@Controller`` inherits from ``@Component``... supports scanning

```java
import org.springframework.stereotype.Controller;

@Controller
public class HomeController{
    //...
}
```
### Step 2: Define Controller Method

```java
import org.springframework.stereotype.Controller;

@Controller
public class HomeController{
    public String showMyPage(){
        //...
    }
}
```
Here we have a method that is quite simple. The method name is flexible. We can call it whatever. This is going to return
a string and will simply just return a view name. You can pass in any number of parameters and return different variations.
This will be kept simple for now but there's so many complications possible!

### Step 3: Map Web Request

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showMyPage() {

    }
}
```
We use the ``@RequestMapping`` tag and give the actual path of the webpages we can use for mapping all types of requests.

### Step 4: Return view name

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showMyPage() {
        return "main-menu";
    }
}
```
You actually return the name of the view when it comes to the controller. Remember there is some
magic happening in the background and will find the view page based on the configuration file. It will look for
the file in the prefix part and then append jsp in the view. This is any regular HTML page/Markup/etc.

### Step 5: Develop View Pages
File: /WEB-INF/view/main-menu.jsp
```html
<html>
<body>
<h2>Spring MVC Demo - Home Page</h2>
</body>
</html>

```

# Lucas' Notes

Setting up Tomcat for the cheap version of the IntelliJ system.

1) Set up Tomcat via Brew Install
2) Grab the directory with the jar files ``/usr/loca/Cellar?/Tomcat@9/9.0/libexec/lib`` and make sure
you take the ``/conf`` directory located in the `/etc/` folder so the IDE doesn't give errors. 
3) After doing it, set up the Smart Tomcat plugin via Plugins and go to the ``lib`` folder where the catalina.jar files are.

Make sure all package names are valid in ``web.xml``. Make sure all ``jsp`` files are properly populated.