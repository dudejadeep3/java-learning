### Predefined/Standard Annotations

- Four are imported from **java.lang.annotation** : @Retention, @Documented, @Target and @Inherited.
- Three are included in **java.lang**: @Deprecated, @Override and @SupressWarnings.

**@Deprecated Annotation**

- It is a maker annotation. It indicates that a declaration is obsolete and has been replaced by a newer form.
- The Javadoc **@deprecated** tag should be used when an element has been deprecated.
- **@deprecated** tag is for documentation and **@Deprecated** annotation is for runtime reflection.
- **@deprecated** tag has higher priority than **@Deprecated** annotation when both are used together.

```Java
public class DeprecatedTest{
    @Deprecated
    public void display(){
        System.out.println("Deprecated Display()");
    }

    public static void main(String[] args){
        DeprecatedTest t1 = new DeprecatedTest();
        t1.display();
    }
}
```
