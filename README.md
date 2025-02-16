# FlipkartZ - E-commerce Web Application

FlipkartZ is a full-stack e-commerce web application built using Java and Spring Boot, providing users with the ability to browse products, add them to a cart, and place orders securely. The application follows MVC architecture and integrates Spring Security for authentication and authorization. Docker is used for containerized deployment.

🛠 Tech Stack
Backend:
1.Java (Spring Boot)
2.Spring Security (Authentication & Authorization)
3.Hibernate & JPA (ORM & Database Interaction)
4.MySQL (Database)
Frontend:
1.JSP (Java Server Pages)
2.Bootstrap (Responsive UI)
3.jQuery (Dynamic UI Enhancements)
Deployment:
1.Docker (Containerization)

# Features
-Product Listing – View available products with details and images
-Search Functionality – Search for products easily
-Add to Cart – Users can add items to their shopping cart
-Remove from Cart – Option to delete items from the cart
-User Authentication – Secure login and signup using Spring Security
-Role-Based Access Control – Different permissions for users and admins
-Place Order – Finalize purchase with a Place Order button

# Installation & Setup
1️ Clone the Repository
  -git clone https://github.com/basum/flipkartz.git
  -cd flipkartz
2️ Configure MySQL Database
  CREATE DATABASE flipkartz_db;
  # application.properties
  spring.datasource.url=jdbc:mysql://localhost:3307/Flipkart
  spring.datasource.username=flip_user
  spring.datasource.password=flipuser
  # Running with docker
   docker build -t flipkartz .
 #  Run MySQL Container
   docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=flipkartz_db -d -p 3306:3306 mysql:latest
  # Run the Application Container
docker run -p 8080:8080 --name flipkartz --link mysql-db:mysql flipkartz
# Now, the application will be available at:
http://localhost:8080
