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
* logic behind todo list and add todo
    * client clicks web - localhost:8080/list-todos
    * controller takes from service all todos and through model.addAttribute sends to listTodos.jsp
    * this page also got link - add-todo
    * controller got 2 classes for this link (GET - default, POST - if client clicks)
    * GET method renderes form for todo 
    * After you enter data and click subbmit method (POST) it takes data:
        * through @RequestParam takes description 
        * through @SessionAttributes and ModelMap takes name
    * througth service adds new todo and redirect:list-todos
        * when you use POST method its recommended to use redirect - which rerenders redirected link with get method
* Validation
    * front-end validation is just add required="required" (not recomended)
    * back-end validation 
        * add dependency POM: 
            * groupId - org.springframework.boot
            * artifactId - spring-boot-starter-validation
    * add to entity's field - @Size(min = 10, message = "Enter atleast 10 characters")
    * make 2-way binding in a controller between GET and POST
        * GET method creates todo - and sends through ModelMap
            * takes username through session
            * populates other fields with dummy data, but description = empty
        * POST method
            * takes as parameter - ModelMap map, @Valid Todo todo, BindingResult result
            * if result.hasErrors - returns todo page
            * if no error creates todo and passes to jsp through model
    * in todo.jsp: 
        * add tag - <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        * form:input type="text" path="description" required="required" 
        * form:errors path="description" cssClass="text-warning" 
        * form:input type="hidden" path="id" 
        * form:input type="hidden" path="done" 
* Delete todo logic
    * add to jsp file delete button with id
        * a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete
    * add to service layer - deleteById (int id) method with Predicater 
    * add to controller level - deleteTodo(@RequestParam int id), which:
        * calls deleteById from service layer
        * redirects to list-todos again  
* Update todo logic
    * add to jsp file update button with id
        * a href="update-todo?id=${todo.id}" class="btn btn-success">Update
    * add to controller level method - String showUpdateTodoPage (GET), which
        * finds todo by id from service level
        * returns "todo" jsp fil and trough model puts found todo
    * add to controller level method - String updateTodo (POST), which
        * changes todo to new updated one through services
        * returns "redirect:list-todos" 
    * add to properties - spring.mvc.format.date=yyyy-MM-dd
    * pom
        * groupId - org.webjars
    	* artifactId - bootstrap-datepicker
        * version - 1.10.0
    * change jsp file and add vidjets 