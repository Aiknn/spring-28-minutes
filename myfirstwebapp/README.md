# Web App with Spring

* Add to Jasper Dependency to the POM
    * groupId = org.apache.tomcat.embed
	* artifactId = tomcat-embed-jasper
* Create structure and add jsp files
    * src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    * jsp file = html structure 
* Add application.properties file
    * spring.mvc.view.prefix=/WEB-INF/jsp/
    * spring.mvc.view.suffix=.jsp
* Create controller file 
    * @Controller - public class SayHelloController 
    * @RequestMapping("say-hello-jsp") - public String sayHelloJsp()
        * return "sayHello"
* Request param
    * add to your controller method
        * public String goToLoginPage(@RequestParam String name, ModelMap model)
            * model.put("name", name)
            * return "login"
    * add to your JSP file
        * Welcome to the login page ${name}
    
# MVC logic
* Front Controller (Dispatcher) receives HTTP Request from browser 
* Delegate request to correct Controller (based on url)
* Controller creates a Model and View name and returns to Front Controller 
* Front Controller send model to correct View template 
* After it takes View and send as a HTTP Response to browser 

# Login Credentials
* if you put GET all information from the form will go to browser link
    * http://localhost:8080/login?name=qwe&password=asd
* if you use POST method in form action, then link is unchaged and in fo in Payload only
* create for one url (login) two methods, one for GET and one for POST method, and they will render different views.
* create @Service class which check credentials and enter it to Controller class 
* if Controller class authorices, then sends model to view. If not, sends model and error 

# Session
* Request scope is active only for one session 
    * for ex, Controller sends model to jsp, and second other jsp will not see the data from model
* use @SessionAttributes("name") for Controllers (both - who accepts and sends)

# ToDoList
* Created Todo POJO with AllArgsConstructor, getter, setters and ToString
* Created TodoService class which got static ToDo List, and it populates data 
* Created TodoController with @Controller on class and  @RequestMapping("list-todos") on method
* created jsp file 
* add POM 
    * groupId - jakarta.servlet.jsp.jstl, artifactId - jakarta.servlet.jsp.jstl-api
    * groupId - org.glassfish.web, artifactId - jakarta.servlet.jsp.jstl
* add in jsp file
    * on top - <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    * in code - <c:forEach items="${todos}" var="todo">, <td>${todo.id}</td>
* add to POM
    * groupId - org.webjars, artifactId - bootstrap, version - 5.1.3
    * groupId - org.webjars, artifactId - jquery, version - 3.6.0
* add to JSP file
    * in head - <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    * in body before closing tag
        * <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        * <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
                    
