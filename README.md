<img width="435" height="541" alt="image" src="https://github.com/user-attachments/assets/27553305-a06a-456a-b943-e2d7bd504344" /># 📚 Library Management System

## 📌 Project Description

The **Library Management System** is a console-based Java application designed using layered architecture.
The system performs core library operations completely **in memory** without using any database or file system.

This project follows proper package structure and OOP principles including:

* Encapsulation
* Layered Architecture (Bean → DAO → Service → Main)
* Menu-driven console interaction

---

## 📁 Package Structure

```
com.kce.bean
com.kce.dao
com.kce.service
com.kce.main
```

### 🔹 com.kce.bean

Contains all entity (Java Bean) classes with private variables and public getters & setters.

* Book
* Member
* BorrowRecord

### 🔹 com.kce.dao

Handles in-memory data storage using HashMap.

* LibraryDAO

### 🔹 com.kce.service

Contains business logic methods.

* LibraryService

### 🔹 com.kce.main

Contains the main class for console execution.

* LibraryApp

---

## ⚙️ Features Implemented

### 1️⃣ Add Book

* Each book has:

  * Unique Book ID
  * Title
  * Author
  * Total Copies
  * Available Copies

### 2️⃣ Register Member

* Each member has:

  * Unique Member ID
  * Name
* Maximum 3 books allowed at a time.

### 3️⃣ Borrow Book

* Member can borrow only if:

  * Book exists
  * Copies are available
  * Member has borrowed less than 3 books
  * Same book is not borrowed twice simultaneously
* Borrow date is recorded automatically.

### 4️⃣ Return Book

* Due period: 14 days
* Fine: Rs.2 per overdue day
* Copies increase automatically on return.

---

## 🧠 Business Rules

* All operations run completely in memory.
* No database or file handling is used.
* Book IDs and Member IDs must be unique.
* A member cannot borrow the same book twice at the same time.
* Maximum 3 books per member.
* Fine calculation is automatic.

---

## 🛠 Technologies Used

* Java
* OOP Concepts
* Collections (HashMap, ArrayList)
* Java Time API (LocalDate)

---

## ▶️ How to Run

1. Open project in any IDE (Eclipse / IntelliJ / VS Code).
2. Ensure package structure is correctly created:

   ```
   com.kce.bean
   com.kce.dao
   com.kce.service
   com.kce.main
   ```
3. Run:

   ```
   LibraryApp.java
   ```
4. Use menu options in console.

---

## 📌 Sample Menu

```
==== LIBRARY MENU ====
1. Add Book
2. Register Member
3. Borrow Book
4. Return Book
5. Exit
```

---

## 🎯 Learning Outcomes

* Understanding layered architecture
* Applying encapsulation properly
* Using Java Collections framework
* Implementing business logic separation
* Console-based menu driven program

---

## 👩‍💻 Developed By

Devi M
B.E / B.Tech – Computer Science

---

## OUTPUT :
<img width="397" height="490" alt="image" src="https://github.com/user-attachments/assets/fa39eeaf-f55c-44ab-8716-dae5f2d1b553" />
<img width="397" height="490" alt="image" src="https://github.com/user-attachments/assets/e0d0995f-d850-4e6c-bf72-0c38d64d354d" />




This project is developed for academic purposes.
