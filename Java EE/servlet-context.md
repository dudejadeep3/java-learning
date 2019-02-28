## **Servlet Context**

Servlet Context is a configuration Object which is created when web application is started. It contains different initialization parameter that can be configured in web.xml

The servlet context is an interface which helps to communicate with other servlets. It contains information about the Web application and container. It is kind of application environment. **Using the context, a servlet can obtain URL references to the resources, and store attributes that other servlets in the context can use.**

### **Example of ServletContext with scenario**

You are developing a web application where you want to access the mail of administrator in whole application. You want to set this email id @ one location and each Servlet and Jsp can access that email. In that case you will take the help of ServletContext. You can add this email in servletcontext via init parameter in web.xml. Now this value (Email id of administrator) will be available to every JSP and Servlet in the web application.

### **Life Cycle of Servlet Context**

- **Step 1:** Servlet container reads the Deployment Descriptor (web.xml) and creates the name/value pair for each **\<context-param\>** when web application is getting started.
- **Step 2:** Container creates the new instance of Servlet Context. **(Note: ServletContext is an interface)**
- **Step 3:** Servlet container gives the ServletContext a reference to each name/value pair of the context init parameter.
- **Step 4:** Every servlet and JSP in the same web application will now have access to this ServletContext.

### **Difference from ServletConfig**

- ServletConfig is one per servlet while ServletContext is one per application.
- ServletContext is available to all servlet & Jsps in web application while ServletConfig will be available only for specific servlet.

### **What is ServletContextListener**

Now you know that you can set init parameter in ServletContext & this ServletContext will be initialized when application starts. After initialization this servletcontext will be available to all servlet and jsp. But what if you want to perform some kind of action when context initialization/desctruction process happen. This is the situation when you will take the help of servletcontextlistener.
