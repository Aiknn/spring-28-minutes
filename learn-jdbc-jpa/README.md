* Create a Spring Boot project with H2
    * dependencies
        * Spring Web
        * Spring Data
        * JDBC
        * Spring Data JPA
    * to run project - mvn spring-boot:run

* H2 Database
    * add to properties - spring.h2.console.enabled=true
    * add to properties - spring.datasource.url=jdbc:h2:mem:testdb
    * go to web - localhost:8080/h2-console
    * change JDBC URL to - jdbc:h2:mem:testdb - connect 
    * create schema.sql (with sql code) in resources folder
    * run spring and check for new table in h2 console 

* Spring JDBC
    * public class Course - with setter, getters, constructor - without any annotations 
    * schema.sql (table and field creation) - located in resources file
    * CourseJdbcRepository
        * got @Repository
        * @Autowired - private JdbcTemplate springJdbcTemplate
        * private static String INSERT_QUERY, DELETE_QUERY, SELECT_QUERY with sql code
        * public void insert(Course course)
            * springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getA)
        * public void deleteByID(long id)
            * springJdbcTemplate.update(DELETE_QUERY, id);
        * public Course findByID(long id)
            * return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id)
    * CourseJdbcCommandLineRunner implements CommandLineRunner
        * @Component
        * @Autowired - private CourseJdbcRepository repository
        * @Override - public void run(String... args) throws Exception 
            * repository.insert(new Course(1, "Learn AWS now", "in28minutes"))
            * repository.deleteByID(2)
            * repository.findByID(3)

* JPA
    * public class Course - with annotations @Entity, @Id, @Column(name = "name")
    * schema.sql (table and field creation) - located in resources file
    * CourseJpaRepository
        * @Repository, @Transactional
        * @PersistenceContext - private EntityManager entityManager
        * public void insert (Course course) - entityManager.merge(course)
        * public Course findById(long id) - return entityManager.find(Course.class, id)
        * public void deleteById(long id) - Course course = entityManager.find(Course.class, id)
        * entityManager.remove(course)
    * CourseCommandLineRunner implements CommandLineRunner
        * @Component
        * @Autowired - private CourseJpaRepository repository
        * @Override - public void run(String... args) throws Exception 
            * repository.insert(new Course(1, "Learn AWS now", "in28minutes"))
            * repository.deleteByID(2)
            * repository.findByID(3)

* Spring JPA
    * public class Course - with annotations @Entity, @Id, @Column(name = "name")
    * schema.sql (table and field creation) - located in resources file
    * CourseJpaRepositorypublic interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>
    * CourseCommandLineRunner implements CommandLineRunner
        * @Component
        * @Autowired - private CourseJpaRepository repository
        * @Override - public void run(String... args) throws Exception 
            * repository.save(new Course(1, "Learn AWS now", "in28minutes"))
            * repository.deleteByID(2)
            * repository.findByID(3)

* Comparison
    * JDBC - Direct SQL access. You manage connection, statements, ResultSet manually.
    * Spring JDBC - Simplifies SQL execution, resource closing, and error handling
    * JPA - ORM standard. Works with objects instead of SQL. Maps classes to tables
    * Spring JPA - ready-made CRUD repositories. Generates queries from method namess
    * JPA is a specification in Java that defines how to work with databases using objects, instead of writing SQL manually. Hibernate is a implementations of JPA.