# Library

Short description or overview of the project.

## Prerequisites

Before you begin, ensure you have the following installed:

- OpenJDK 17 for Java 17

## Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/nabilhdrhmn/Library.git
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

Once the application is up and running, you can use this api by reference:

### Get All Books

To retrieve all books, send a GET request to:

```
http://localhost:8080/books
```

To filter books by status, append the `status` parameter to the URL:

```
http://localhost:8080/books?status={yourStatus}
```

Replace `{yourStatus}` with the desired status value (0 or 1).

### Insert New Book

To add a new book, send a POST request to:

```
http://localhost:8080/books/insert
```

Include the following JSON body:

```json
{
    "judul": "Harry Potter",
    "pengarang": "J.K. Rowling",
    "penerbit": "Elex Media",
    "tanggalTerbit": "2020-07-29",
    "tebalBuku": 100
}
```

### Update Book

To update a book, send a PUT request to:

```
http://localhost:8080/books/update
```

Include the following JSON body with the updated book details:

```json
{
    "id": "A0002",
    "judul": "Harry Potter",
    "pengarang": "J.K. Rowling",
    "penerbit": "PT Terbit",
    "tanggalTerbit": "2020-07-29",
    "tebalBuku": 100
}
```

### Borrow Book / Update Book Status

To borrow a book or update its status, send a PUT request to:

```
http://localhost:8080/books/status/update
```

Include the following JSON body:

```json
{
    "id": "A0002",
    "peminjam": "Andi",
    "tanggalPinjam": "2020-08-01",
    "tanggalKembali": "2021-08-01"
}
```

### Delete Book

To delete a book, send a DELETE request to:

```
http://localhost:8080/books/delete/{id}
```

Replace `{id}` with the ID of the book you wish to delete.

## Swagger

Or you can access the Swagger documentation when running this application by navigating to:

```
http://localhost:8080/swagger-ui/index.html#
```

## License

This project is licensed under the [License Name](LICENSE).
