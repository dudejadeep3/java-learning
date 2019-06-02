## Annotations

Annotations are used to provide supplement information to the program.

- Annotations start with '@'.
- Annotations help to associate metadata (information) to the program elements i.e. instance variables, constructors, methods, classes etc.
- Annotations are not pure comments as they can change the way a program is treated by compiler. See below code for example.

```Java
class Base {
    public void display(){
        System.out.println("Base display()");
    }
}
class Derived extends Base {
    @Override
    public void display(int x){
        System.out.println("Derived display(int)");
    }

    public static void main(String[] args){
        Derived obj = new Derived();
        obj.display();
    }
}

output:
10: error: method doesn't override or implement a method from a supertype.
```

If we remove parameter(int x) or we remove @override annotation, the program compile fine.

There are 3 types of annotations.

- Marker Annotations:
  The only purpose is to mark a declaration. These annotations contains no members and do not consist any data. Thus, its presence as an annotation is sufficient. Since, marker interface contains no members, simply determining whether it is present or absent is sufficient. **@Override** is an example of marker annotation.

```Java
Example: @TestAnnotation()
```

- Single value annotations:
  These annotations contains only one member and allow a shorthand form of specifying the value of the member. We only need to specify the value for that member when the annotation is applied and don't need to specify the name of the member. **However in order to use this shorthand, the name of the member must be value**.

```Java
Example:- @TestAnnotation("Testing")
```

- Full Annotations:
  These annotations consist of multiple data members/name , value, pairs.

```Java
Example:- @TestAnnotation(owner="Rahul",value="Class Geeky")
```
