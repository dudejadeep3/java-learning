# Understanding Bean Scopes

In Spring Framework, we can create beans in 6 inbuilt spring bean scopes and **you can also define your own scopes as well.** Out of these six scopes, four are available only if you use a web-aware **Application Context.** **Singleton** and **Prototype** scopes are available in any type of IOC containers.

In Spring, scope can be defined using spring bean `@Scope` annotation.

| Scope              | Description                                                                                      |
| ------------------ | ------------------------------------------------------------------------------------------------ |
| singleton(default) | Single bean object instance per IOC Container                                                    |
| prototype          | Opposite to singleton, it produces a new instance each and every time a bean is requested        |
| request\*          | A single instance will be created and available during complete lifecycle of an HTTP request     |
| session\*          | A single instance will be created and available during complete life cycle of an HTTP session    |
| application\*      | A single instance will be created and available during complete lifecycle of **ServletContext**. |
| websocket\*        | A single instance will be created and available during complete lifecycle of **WebSocket**       |

\* Only valid in web-aware Spring **ApplicationContext**. (Means only valid for web applications and not for desktop applications running on standarad JVM)

### Singleton Scope

It is the default bean scope in spring container. It tells the container to create and manage only one instance of bean class, per container. This single instance is stored in a cache of such singleton beans, and all subsequent requests and references for that named bean return the cached instance.

Example of singleton scope bean using Java config -

```Java
@Component
@Scope("singleton") //This statement is redundant since it is the default scope
public class Beanclass {}
```

Example of singleton scope bean using XML config -

```xml
<bean id="beandId" class="com.test.Beanclass" scope="singleton"> </bean>
```

### Prototype scope

It results in creation of a new bean instance every time a request for the bean is made by application code.

You should know that the **destruction bean lifecycle methods** are not called for prototype bean, only initialization callback methods are called. So as a developer, we are responsible to clean up prototype-scoped bean instances and any resource that it hold.

Java config example for prototype bean scope-

```Java
@component
@Scope("prototype")
public class BeanClass {}
```

XML config example of prototype bean scope-

```XML
<bean id="beanId" class="com.test.BeanClass" scope="prototype"> </bean>
```

**As a rule, you should prefer to use _prototype_ scope for all stateful beans and the _singleton_ scope for stateless beans.**

### Request Scope

In request scope, container creates a new instance for each and every HTTP requests. So, if server is currently handling 50 request, then container can have at most 50 individual instances of bean class. Any state change to one instance, will not be visible to othere instances. These instances are destructed as soon as the request is completed.

Java Config example of request bean scope -

```Java
@component
@Scope("request")
public class BeanClass{}
//or

@Component
@RequestScope
public class BeanClass{}
```

XML config example of request bean scope -

```XML
<bean id="beanId" class="com.test.BeanClass" scope="request"></bean>
```

### Session Scope

In session scope, container creates a new instance for each and every HTTP session. SO if server has 20 active sessions, then container can have at most 20 individual instances of bean class. All HTTP request within single session lifetime will have access to same single bean instance in that scope.

Any state change to one instance, will not be visible to other instances. These instances are destructed as soon as the session is destroyed/end on server.

Java config example of session bean scope -

```Java
@component
@Scope("session")
public class BeanClass{}

//or

@component
@SessionScope
public class Beanclass{}
```

XML config example of session bean scope -

```XML
<bean id="beanId" class="com.test.BeanClass" scope="session"></bean>
```

### Application Scope

In application scope, container creates one instance per web application runtime. It is almost similar to **singleton** scope, with only two differences i.e.

- application scoped bean is singleton per servletcontext, whereas singleton scoped bean is singleton per ApplicationContext. Please note that there can be multiple application contexts for single application.

- application scoped bean is visible as a ServletContext attribute.

Java Config example of application scope bean -

```Java
@component
@Scope("application")
public class BeanClass{}

//or

@component
@ApplicationScope
public class BeanClass{}
```

XML config example of application bean scope -

```XML
<bean id="beanId" class="com.test.BeanClass" scope="application"></bean>
```

### WebSocket scope

The **WebSocket Protocol** enables two-way communication between a client and a remote host that has opted-in to communication with client. WebSocket protocol provices a single TCP connection in both direction. This is especially useful for multi-user application with simultaneous editing and multi-user games.

In this type of web applications, HTTP is used only for the initial handshake with Http Status 101(switching protocol) if it agrees- to handshake request. If the handshake succeeds, the TCP socket remains open and both client & server can use it to send message to each other.

Java Config example of websocket bean scope -

```Java
@component
@Scope("websocket")
public class BeanClass{}
```

XML config example of websocket bean scope -

```XML
<bean id="beanId" class="com.test.BeanClass" scope="websocket"></bean>
```

### Custom Thread Scope

Spring also provide a non-default thread scope using class **SimpleThreadScope**. To use this scope, you must register it to container using **CustomScopeConfigurer** class.

```XML
<bean class="org.springframework.beans.factory.config.CustomScopeConfigurer">
    <property name="scopes">
        <map>
            <entry key="thread">
                <bean class="org.springframework.context.support.SimpleThreadScope"/>
            </entry>
        </map>
    </property>
</bean>
```

Every request for bean will return the same instance within the same thread.

Java config example of thread bean scope -

```Java
@component
@Scope("thread")
public class BeanClass{}
```

XML config example of thread bean scope -

```XML
<bean id="beanId" class="com.test.BeanClass" scope="thread"></bean>
```
