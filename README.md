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

1. Clone this repository, please use IntelliJ for best experience.
2. Navigate to the project directory.
3. Update the `application.properties` file with your database credentials.
4. Add secret key for stripe and change server port to 8443 in the `application.properties` file.

    ```bash
    server.port=8443
    stripe.key.secret=YOUR_SECRET_KEY
    ```
5. Run `mvn clean install` to build the project.
6. Click on the start button to start the server.
7. The server will start on `http://localhost:8443/`.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
