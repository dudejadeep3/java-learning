### PreProcessor

As the name suggest PreProcessor are program that processes our source code before compilation. There are number of steps involved between writing a program and executing a program in C/C++.

Following are some sample preprocessor directives (_meaning_: an official or authorative instruction. synonym: instruction, direction) of C language.

- **Macros:** Macros are pieces of code in a program which is given some name. Whenever this name is encountered by the pre-processor, it replaces the name with actual piece of code.

```C++
#include <iostream>

// macro with parameter
#define AREA(l, b) (l * b)
int main()
{
    int l1 = 10, l2 = 5, area;

    area = AREA(l1, l2);

    std::cout << "Area of rectangle is: " << area;

    return 0;
}
```

- **File Inclusion:** This type of preprocessor include a file in the source code program. It could be some file of library or custom files.
