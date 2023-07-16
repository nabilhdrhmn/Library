# Library

Short description or overview of the project.

## Prerequisites

Before you begin, ensure you have the following installed:

- OpenJDK 17 for Java 17

## Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/your/repository.git
   ```

2. Create a new PostgreSQL database and import the SQL file located in the `sql` folder.

3. Configure the application:

   - Open the `application.properties` file located in the project's root directory.
   - Update the database connection settings according to your PostgreSQL setup.

4. Run the Spring Boot application:

   ```shell
   mvn spring-boot:run
   ```

## Usage

Once the application is up and running, you can access the Swagger documentation by navigating to:

[http://localhost:8080/swagger-ui/index.html#](http://localhost:8080/swagger-ui/index.html#)

## License

This project is licensed under the [License Name](LICENSE).
