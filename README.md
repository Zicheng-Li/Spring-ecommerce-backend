# EL's Online Shop - Backend

This repository contains the backend code for EL's Online Shop, developed using SpringBoot 3.

## Frontend Repository: [Spring-ecommerce-frontend](https://github.com/Zicheng-Li/Angular-ecommerce-frontend)

## Features: [Link to Demo Video](https://youtu.be/q0_N9ydf67c)

- **API Endpoints:** Provides endpoints for product listings, user management, order processing, and more.
  
- **Secure Authentication:** Uses Okta's Auth0 for user authentication and registration.
  
- **Payment Processing:** Integrated with Stripe for secure payment transactions.
  
- **Data Management:** Uses a MySQL database for storing product listings, user data, and transaction records.

## Prerequisites

- Java JDK
- Maven
- MySQL

## Installation

1. Clone this repository.
2. Navigate to the project directory.
3. Update the `application.properties` file with your database credentials.
4. Run `mvn clean install` to build the project.
5. Run `mvn spring-boot:run` to start the server.
6. The server will start on `http://localhost:8080/`.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
