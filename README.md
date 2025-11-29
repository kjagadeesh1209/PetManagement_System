# 🐾 Pet Management System (Java Servlets + MySQL + Tomcat)

A complete web application to manage pet details such as **add, view, update, and delete** using  
**Java Servlets, JDBC, MySQL, HTML, CSS & Tomcat 10.1**.

---

## 🚀 Features

| Feature                       | Status |
|------------------------------|--------|
| Add Pet                      | ✔️     |
| View All Pets                | ✔️     |
| Delete Pet                   | ✔️     |
| Update/Edit Pet              | ✔️     |
| MySQL Database Integration   | ✔️     |
| Simple & Clean Frontend UI   | ✔️     |
| Fully Working CRUD Operations| ✔️     |

---

## 🛠️ Tech Stack

| Technology               | Used For         |
|--------------------------|------------------|
| **Java Servlet (Jakarta)** | Backend Logic    |
| **HTML, CSS**            | Frontend UI      |
| **JDBC**                 | DB Connectivity  |
| **MySQL**                | Data Storage     |
| **Tomcat 10.1**          | Server Deployment|
| **Git / GitHub**         | Version Control  |

---

## 📂 Project Structure

```bash
PetManagementSystem/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── petmanagement/
│   │   │           ├── model/
│   │   │           │   └── Pet.java
│   │   │           ├── dao/
│   │   │           │   └── PetDAO.java
│   │   │           ├── util/
│   │   │           │   └── DBUtil.java
│   │   │           └── servlet/
│   │   │               ├── AddPetServlet.java
│   │   │               ├── ListPetsServlet.java
│   │   │               ├── EditPetServlet.java
│   │   │               └── DeletePetServlet.java
│   │   └── webapp/
│   │       ├── index.jsp
│   │       ├── add-pet.jsp
│   │       ├── edit-pet.jsp
│   │       ├── list-pets.jsp
│   │       └── assets/
│   │           ├── css/
│   │           │   └── style.css
│   │           └── images/
│   └── test/ (optional)
└── target/ (generated after build)
