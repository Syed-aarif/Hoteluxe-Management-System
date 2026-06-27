# 🏨 Hoteluxe Management System

A Spring Boot REST API for managing hotel operations including customers, rooms, and bookings.

## 🚀 Features

* Customer Management (CRUD)
* Room Management (CRUD)
* Booking Management (CRUD)
* Input Validation
* Global Exception Handling
* RESTful APIs
* MySQL Database Integration
* Tested using Postman

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Gradle
* Postman
* Git & GitHub

---

## 📂 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── exception
 └── resources
```

---

## REST APIs

### Customer

* POST /customers/add
* GET /customers/all
* GET /customers/{id}
* PUT /customers/update/{id}
* DELETE /customers/delete/{id}

### Room

* POST /rooms/add
* GET /rooms/all
* GET /rooms/{id}
* PUT /rooms/update/{id}
* DELETE /rooms/delete/{id}

### Booking

* POST /bookings/add
* GET /bookings/all
* GET /bookings/{id}
* PUT /bookings/update/{id}
* DELETE /bookings/delete/{id}

---

## Validation

* Customer name cannot be empty
* Email must be valid
* Phone number must contain exactly 10 digits

---

## Author

**Syed Aarif**
