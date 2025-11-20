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
    