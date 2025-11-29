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

PetManagementSystem
│
├── frontend
│   ├── addPet.html
│   ├── index.html
│   ├── script.js
│   ├── style.css
│   └── viewPets.html
│
├── src
│   └── com
│       └── pet
│           └── controller
│               ├── PetServlet.java          # Add pet
│               ├── ViewPetsServlet.java     # View all pets
│               ├── UpdatePetServlet.java    # Update pet
│               ├── EditPetServlet.java      # Load data for editing
│               └── DeletePetServlet.java    # Delete pet
│
├── WEB-INF
│   ├── classes
│   │   └── com
│   │       └── pet
│   │           └── controller
│   │               ├── PetServlet.class
│   │               ├── ViewPetsServlet.class
│   │               ├── UpdatePetServlet.class
│   │               ├── EditPetServlet.class
│   │               └── DeletePetServlet.class
│   ├── lib/                # MySQL JDBC driver (if added manually)
│   └── web.xml             # Servlet mappings
│
└── PetManagementSystem.war  # Deployment WAR file


