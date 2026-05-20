# Architecture Overview

The application is built using a layered architecture, consisting of the following layers:

1. **Controller Layer**: Handles incoming requests and returns responses. 
2. **Service Layer**: Contains business logic and interacts with the repository layer.
3. **Repository Layer**: Interacts with the database for data persistence.

## Technologies Used
- Spring Boot for the web layer
- Spring Data JPA for data access
- H2 for the in-memory database