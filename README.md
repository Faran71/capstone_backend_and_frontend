# E-commerce
## Description
This is a full stack website made using Spring Boot and PostgreSQL for the backend and REACT for the frontend.

## Setup instructions for Backend

To set up the project you will need to:
1. Install IntelliJ IDEA or another IDE that is suitable for JDK 17.
2. Install postgreSQL.
3. Clone the project repository from GitHub.
4. Import the project into your IDE.
5. Make a postgreSQL database on your system with the following command `createdb rainforest_retail`. See the `application.properties` file for the path that the application requires to access the database 
6. Run the project.

## Setup instructions for Frontend

Open Frontend folder and follow instructions
   
## The RESTful route endpoints:

The default port the project will be run on is port 8080 but any can be used. You can access the API endpoints with the following URL **`https://localhost:{port}/{endpoint}`**. See the table below for all available endpoints.

|Controller | Mapping |Path | Description |
|----------|-----------|------|-------------|
| Customer | GET	| `localhost:8080/customers` | Get all customers details
| | POST	| `localhost:8080/customers`	| Register a new customer to the system
| | POST	| `localhost:8080/customers/autheticate`	| Check whether log-in details are correct
| Orders | POST | `localhost:8080/orders/createOrder/{customerId}`	| Add an order for a customer using the customerId
| Product | GET	| `localhost:8080/products`	| Get all products
| | GET	| `localhost:8080/products/category={category}`	| Filter products for a specific category
| | GET	| `localhost:8080/products/rating={rating}`	| Filter products for a specific rating
| | GET	| `localhost:8080/products/price/{priceLow}/{priceHigh}`	| Filter products within a specific price range
| | GET	| `localhost:8080/products/search`	| Get products related to the search word
| ProductsOrders | GET	| `localhost:8080/productsOrders`	| Get all products and orders together
| | PUT	| `localhost:8080/productsOrders/{productId}/{orderId}/{quantitySold}`	| Create an order using productId, orderId and quantitySold
| Review | POST	| `localhost:8080/reviews`	| Post a review for a product


## Tech Stack

The technologies used for this project are:

- Intelliji IDEA, running JDK 17
- Spring Boot
- H2 Server
- Postman
- Postico
- REACT

## Dependencies

The dependencies required for the project to run are:
- SpringBoot Web
- SpringBoot DevTools
- PostgreSQL
- SpringBoot Starter Data JPA
