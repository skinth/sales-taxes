# Sales taxes problem
This project represents my solution to sales taxes problem, you can find a detailed description 
here https://github.com/xpeppers/sales-taxes-problem.

# Technologies
The program is written in JAVA programming language (you have to install the JDK version 8, at minimum, 
to compile https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and it uses Gradle 
as build automation tool (visit official site for more detailed information and for install instructions 
https://docs.gradle.org/current/userguide/userguide.html).

# Compile and execute
You can import the project in your favorite JAVA IDE to compile and execute it, or you can use the command 
_./gradlew run_ (if you haven't installed gradle yet, the script will download it automatically) under the root folder.

# Execute test
To execute the unit tests, you can use the command _./gradlew build_, in the root folder, and then check the 
result opening the index.html file under the path build/reports/tests/; after you can execute only the tests with the 
command _./gradlew test_.

# Results
The results upon supplied test data are contained in the **AppTest** test class.

# Interactive mode (branch development)
If you run the program, it presents you an interactive prompt where you can write sentences like "2 book at 12.49",
or "1 box of strawberry at 2.99" then you have to choose the type of the product (Food, Medicine, Book, Other; the last 
one will be taxed at 10%); if you specify the word "imported" the product will be taxed at 5%. 
The program doesn't have a complete understanding of the meaning of the words and it doesn't remember, 
so you have to tell it the type of product again if you exit from the program; it is only for example purpose.
