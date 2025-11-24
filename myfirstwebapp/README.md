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

# ToDoList
* Created Todo POJO with AllArgsConstructor, getter, setters and ToString
* Created TodoService class which got static ToDo List, and it populates data 
* Created TodoController with @Controller on class and  @RequestMapping("list-todos") on method
* created jsp file 
