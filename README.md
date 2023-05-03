# EnocaBackendChallenge

To get started with the project, follow these steps:

Build the project in the current directory by running the following command in your terminal:
- mvn clean install
This will compile the code, run tests, and generate a jar file in the target directory.

Install PostgreSQL DB on your local machine. You can download it from the official website and follow the installation instructions.

Once you have installed PostgreSQL, you need to update the application.properties file with your database information. Open the file and replace {username}, {password}, and {databaseName} fields with your PostgreSQL credentials. The spring.datasource.url field should contain the JDBC URL for your database. It should look something like this:
spring.datasource.url=jdbc:postgresql://localhost:5432/databaseName

Finally, you need to install Lombok on your local machine. Lombok is a Java library that helps to reduce boilerplate code. You can download it from the official website and follow the installation instructions.

Once you have completed these steps, you should be ready to run the project on your local machine.
