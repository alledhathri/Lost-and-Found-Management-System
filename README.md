# 🔍 Lost & Found Management System

A simple console-based Lost & Found Management System developed using Java, JDBC, and MySQL.

This project helps users manage lost and found items using basic CRUD operations.

---

## 🚀 Features

- Add lost items
- Add found items
- View items
- Search items
- Update items
- Delete items
- User management
- MySQL database connectivity

---

## 🛠️ Technologies Used

- Java
- MySQL
- JDBC
- OOP
- PreparedStatement

---

## 📂 Project Structure

```text
Lost&Found
│
├── lib
│   └── mysql-connector-j-*.jar
│
└── src
    ├── DBConnection.java
    ├── FoundItem.java
    ├── Item.java
    ├── ItemDAO.java
    ├── LostFoundCRUD.java
    ├── LostItem.java
    ├── Main.java
    ├── User.java
    └── UserDAO.java
## CRUD Operations
Create – Add items
Read – View/Search items
Update – Update item details
Delete – Delete items
## Database

The project uses MySQL to store lost and found item details.

Java connects to MySQL using JDBC.

Java Application
       ↓
      JDBC
       ↓
     MySQL
