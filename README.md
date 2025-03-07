Employee CRUD Operation Web Application

Features
✅ Add, Update, Delete, and View Employees
✅ Spring Boot + Spring MVC + Thymeleaf
✅ MySQL Database Integration + Spring Data JPA
✅ JSP(Java Server Page), HTML5, CSS, BootStrap, Java Script (Front-End)
✅ Email Verification for Employee Registration
✅ Maven Dependencies / Spring Boot Starters

Technologies Used
-->Backend: Java, Spring Boot
-->Frontend: Thymeleaf, HTML, CSS, Bootstrap, Java Script
-->Database: MySQL and Spring Data Jpa
-->Maven Dependencies / Spring Boot Starters : Spring Boot Dev Tools, Spring Web, Lombok, Validation, Thymleaf, MySQL, Spring Data Jpa
-->Email Service: JavaMailSender


Application Properties
----------- ----------
spring.application.name=emp_crud

#Server Properties
server.port=80

#Database Properties
spring.datasource.url=jdbc:mysql://localhost:3306/emp_crud?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#Email Properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=darshanl1254@gmail.com
spring.mail.password=gcst ssvi thoz xalv
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

The Employee CRUD Operation Web Application efficiently manages employee records with secure authentication and email verification. It demonstrates essential full-stack development skills and can be further enhanced with advanced features like pagination and role-based access control. 🚀

