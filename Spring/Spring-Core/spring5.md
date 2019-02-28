# What's new in Spring 5 ?

Spring 5 is the first major release, almost four years after Spring Framework 5.0. During this time, most of the enhancements were done in **Spring Boot** Project. In Spring 5, these are the exciting features worth mentioning:

- **Baseline Upgrades** - Spring 5 now support minimum JDK 8 and JAVA EE 7. There are few more libraries for which the minimum supported versions have been increase. For example- Servlet 3.1, JMS 2.0, JPA 2.1, JAX-RS 2.0, Bean Validation 1.1, Hibernate 5, Jackson 2.6, EhCache 2.10, JUnit 5 and Tiles 3.
- **JDK 9 rutime compatiblity** - Spring 5 supports Java 9, including Java modules. -**Usage of JDK 8 features** - Spring 5 has baseline version 8, so it uses many new features of Java 8 and Java 9 as well. In fact, it has pretty extensive use of lambda functions. -**Reactive programming support** - Spring Framework 5 embrace Reactive Streams (language-neutral attempt to define reactive APIs) and Reactors (java implementation of Reactive Streams provided by the Spring Pivotal team) for its own reactive use as well as in many of its core APIs. -**A functional framework** - Spring 5 also provides a functional web framework. It provides features to define endpoints using functional programming style. -**Kotlin Support** - Spring Framework 5.0 has good support for Kotlin.

### Minimum Supported versions of various servers

- Tomcat 8.5+
- Jetty 9.4+
- WildFly 10+
- Netty 4.1+
- Undertow 1.4+

## Usage of JDK 8 features

Until Spring 4.3, JDK baseline version was 6. So Spring 4 had to support Java 6, 7 and 8. To maintain backward compatibility, Spring framework didn't adapt many new features which Java8 brought with itself. e.g Lambda Expressions

Spring 5 has a baseline version 8, so it uses many features of Java 8 as well as 9. e.g.

- Java 8 default methods in core Spring interfaces
- Internal code improvements based on Java 8 reflection enhancements.
- Use of functional programming in the framework codes- lambda and streams.

## Reactive programming suport (Need to learn)

Reactive Programming is one of the most important features of Spring Framework 5.0. Reactive programming provides an alternate style of programming focused on building applications that reacts to events. Spring Framework 5.0 embraces Reactive Streams (language-neutral attempt to define reactive APIs) and Reactor (java implementation of Reactive Stream provided by the Spring pivotal team) for its own reactive use as well as in many of its core APIs.

Spring Web Reactive lives in the new **spring-web-reactive** module next to the existing **Spring Web MVC** that lives in the **spring-webmvc** module. Please note that in Spring 5, traditional Spring MVC keeps running on any Servlet 3.1 stack, including Java EE 7 servers.

### A functional web framework

Building on top of the reactive features, Spring 5 also provides a functional web framework. It provides features to define endpoints using functional programming style. This framework introduces two fundamental concepts: **Handler Function** and **Router Function**.

The **Handler Function** represent function that handles incoming request and generates responses. **Router Function** serves as an alternative to the `@RequestMapping` annotation. It's used for routing incoming request to handler functions. e.g.

```Java
RouterFunction<String> route =
    route(GET("/hello-world"),
    request -> Response.ok().body(fromObject("Hello World")));
```

### Dropped Features

Along with the increase in baseline version for JAVA, JAVA EE and a few other frameworks, Spring Framework 5 removed support for a few frameworks e.g.

- Portlet
- Velocity
- JasperReports
- XMLBeans
- JDO
- Guava (caching)
