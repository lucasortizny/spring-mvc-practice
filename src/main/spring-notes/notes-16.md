# Spring MVC Configuration (Notes 16)

### Spring MVC Configuration Process - Part I

Make modifications to file: ``WEB-INF/web.xml``

1) Configure Spring MVC Dispatcher Servlet
2) Set up URL Mappings to this Dispatcher Servlet

### Spring MVC Configuration Process - Part II

Add the configurations to file: ``WEB-INF/spring-mvc-demo-servlet.xml``

3) Add support for Spring component scanning
4) Add support for conversion, formatting and validation
5) Configure the Spring MVC View Resolver

### Step 1: Configure the Spring MVC Dispatcher Servlet

File: web.xml

```xml
    <servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
    </servlet>
```

We need to make a servlet reference. The dispatcher servlet is offered by spring-core. Then
put the parameters and reference where it is so Spring knows where to find it.

### Step 2: Set up URL Mappings to this DispatcherServlet

File: web.xml

```xml
    <servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
    </servlet-mapping>

```
Tell the system: for any URL pattern coming in, pass it off to the dispatcher servlet. If 
you want to have another patten, you can do something like `/foobar/*`. One thing that is important
to note is that the servlet name must match the one named earlier in the file.

### Step 3: Add support for Spring component scanning

File: spring-mvc-demo-servlet.xml
```xml
<!-- Step 3: Add support for component scanning -->
<context:component-scan base-package="com.luv2code.springdemo" />
```
Add support for component scanning. We just add context:component-scan just like 
we have done before. It will scan this package and find any potential spring beans in order
to make it happen.

### Step 4: Add support for conversion, formatting, and validation

File: spring-mvc-demo-servlet.xml
```xml
<!-- Step 4: Add support for conversion, formatting and validation support -->
	<mvc:annotation-driven/>
```
So when making use of Spring MVC, it can do conversion of form data, formatting it, and 
validating data within the form.

### Step 5: Configure the Spring MVC View Resolver
File: spring-mvc-demo-servlet.xml
```xml
<!-- Step 5: Define Spring MVC view resolver -->
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/view/" />
		<property name="suffix" value=".jsp" />
	</bean>
```
Really a fancy way to say "How do we display the pages? How do we load the webpages?"

When your app provides a viewname, it will prepend the prefix and append the suffix and RENDER 
the view for your application.

Say we returned a view name of ``show-student-list``. Spring will automatically prepend the prefix
and append the suffix so it becomes ``/WEB-INF/view/show-student-list.jsp``.