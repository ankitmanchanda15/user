# Application Flows

## User Registration Flow
1. Client sends a POST request to `/users/register` with user details.
2. Controller receives the request and passes the details to the service layer.
3. Service layer validates the details and stores the user in the database.
4. Service responds with a confirmation to the controller.
5. Controller sends a response back to the client with the registration status.