# Spring vs SpringBoot

The Spring Framework is one of the most popular application development framework for Java. One of the best features in Spring is that it has the **Dependency Injection** or **Inversion of Control** which allow us to develop loosely coupled application. **_And, loosely coupled applications can be easily unit-tested._**

### Example without Dependecy Injection

Conside the example below - `MyController` depends upone `MyService` to perform a certain task. So to get the instance of `MyService`, we will use:

```Java
MyService myService = new MyService();
```

Now that we have created the instance of `MyService`, and we see both are tightely coupled. If i create a mock for `MyService` in a unit test for controller, how do I make `MyController` use the mock? It's bit difficult -- isn't it?

```Java
public class MyController {
    private MyService service = new MyService();

    @RequestMapping("/welcome")
    public String welcome(){
        return service.retrieveWelcomeMessage();
    }
}
```

### Example with Dependency Injection

With the help of only two annotations, we can get the instance of `MyService` easily, which is not tightly coupled. The Spring Framework does all the hard work to make things simpler.

- `@component` is simply used in the Spring Framework as a bean that you need to manage within your own **BeanFactory** _(an implementation of the Factory Pattern)_.

* `@Autowired` is simply used in the spring to find the correct match for this specific type and autowire it.

So, Spring Framework will crate a bean for `MyService` and autowire it into `MyController`.

In a Unit Test, I can ask the Spring Framework to auto-wire the mock of `MyService` into `MyController`.

```Java
@Component
public class MyService{
    public String retrieveWelcomeMessage(){
        return "Welcome to Innovation";
    }
}

@RestController
public class MyController{

    @Autowired
    private MyService service;

    @RequestMapping("/welcome")
    public String welcome(){
        return service.retriveWelcomeMessage();
    }
}
```

The Spring Framework has many other features, which are divided into twenty modules to solve many common problems. Here are some popular modules:

- Spring JDBC
- Spring MVC
- Spring AOP
- Spring JMS
- Spring Test
- Spring Expression Language (SpEL)

Aspect Oriented Programming (AOP) is another strong side of the Spring Framework. The key unit in object-oriented programming is the `class` ,whereas in **AOP**, the key unit is the **aspect**. For example, if you want to add the security in your project, logging etc. you can just use the AOP and keep these as a cross-cutting concern away from your main business logic. You can perform any action after a method call, before a method call, after a method returns, or after the exception arises.

The Spring Framework doesn't have its own ORM, but it provides good integration with ORM like Hibernate, Apache iBATIS etc.

In short we can say that the Spring Framework provides a decoupled way of developing web applications. Web application development becomes easy with the help of these concepts in Spring like Dispatcher Servlet, ModelAndView, and View Resolver.

### If Spring can solve so many problems, Why do we need Spring Boot?

Now if you have already worked on Spring, think about the problems that you faced while developing a full-fledged Spring application with all the functionalities. There was lot of difficulty to setup Hibernate Datasource, Entity Manager, Session Factory and transaction Management. It takes a lot of time for a developer to setup a basic project using Spring MVC with minimum functionality.

```xml
<bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix">
            <value>/WEB-INF/views/</value>
        </property>
        <property name="suffix">
            <value>.jsp</value>
        </property>
  </bean>
  <mvc:resources mapping="/webjars/**" location="/webjars/"/>
<servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/my-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

When we use Hibernate, we have to configure these things like datasource, Entity Manager etc.

```xml
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
        destroy-method="close">
        <property name="driverClass" value="${db.driver}" />
        <property name="jdbcUrl" value="${db.url}" />
        <property name="user" value="${db.username}" />
        <property name="password" value="${db.password}" />
    </bean>
    <jdbc:initialize-database data-source="dataSource">
        <jdbc:script location="classpath:config/schema.sql" />
        <jdbc:script location="classpath:config/data.sql" />
    </jdbc:initialize-database>
    <bean
        class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"
        id="entityManagerFactory">
        <property name="persistenceUnitName" value="hsql_pu" />
        <property name="dataSource" ref="dataSource" />
    </bean>
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory" />
        <property name="dataSource" ref="dataSource" />
    </bean>
    <tx:annotation-driven transaction-manager="transactionManager"/>
```

### How does Spring Boot solve this problem ?

- Spring Boot does all those using `AutoConfiguration` and will take care of all the internal dependencies that your application needs - all you need to do is run your application. Spring Boot will auto configure the `Dispatcher Servlet` if Spring `jar` is in the class path. It will also auto-configure datasource if Hibernate jar is available on the class path. Spring Boot gives us a pre-configured set of Starter Projects to be added as a dependency in our project.

- During web-application development, we would need the jars that we want to use, and which version we want to use and how to connect them together. All web applications has similar needs, for example, Spring MVC, jackson Databind, Hibernate core, and Log4j (for logging). So we had to choose the compatible versions of all these jars. In order to decrease the complexity, Spring Boot has introduced what we call **Spring Boot Starters**.

```xml
<dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-webmvc</artifactId>
   <version>4.2.2.RELEASE</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.5.3</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.0.2.Final</version>
</dependency>
```

Starters are a set of convenient dependencies that you can include in your Spring Boot application. For using Spring and Hibernate, we just have to include the spring-boot-starter-data-jpa dependency in the project.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### Spring Boot Starter Project Options

1. spring-boot-starter-web-services: SOAP WebService
2. spring-boot-starter-web: Web and Restful applications
3. spring-boot-starter-test: Unit Testing and Integration Testing
4. spring-boot-starter-jdbc: Traditional JDBC
5. spring-boot-starter-hateoas: Add HATEOAS features to your services
6. spring-boot-starter-security: Authentication and Authorization using Spring security
7. spring-boot-starter-data-jpa: Spring Data JPA with Hibernate
8. spring-boot-starter-cache: Enabling Spring Framework's caching support
9. spring-boot-starter-data-rest: Expose Simple Rest Services using Spring Data REST
