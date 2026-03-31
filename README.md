# JDBC User Input CRUD Application

## 📘 Overview
This project is a **Java console application** that demonstrates how to perform **CRUD operations** (Create, Read, Update, Delete) on a MySQL database using **JDBC**.  
It provides a simple **menu-driven interface** where users can insert, update, delete, and view student records interactively.

---

## 📌 Problem Statement
Managing student records often requires repetitive SQL queries, which can be error-prone and inconvenient for beginners.  
The goal of this project is to design a **menu-driven Java application** that allows users to perform CRUD operations on a MySQL database interactively.  
This eliminates the need for direct SQL commands and provides a user-friendly interface for database management.

---

## ⚙️ Features
- ✅ Connects to MySQL database using JDBC.
- ✅ Insert new student records.
- ✅ Update existing student records by ID.
- ✅ Delete student records by ID.
- ✅ View all student records.
- ✅ Menu-driven interface with user input.
- ✅ Uses **PreparedStatement** for secure query execution.

---

## 🏗️ Requirements
- Java JDK 8 or above
- MySQL Database
- MySQL JDBC Driver (`mysql-connector-java`)
- IDE or terminal to run Java programs

---

## 🔧 Setup Instructions
1. **Create Database & Table**
   ```sql
   CREATE DATABASE testdb;
   USE testdb;

   CREATE TABLE student (
       id INT PRIMARY KEY,
       name VARCHAR(50)
   );
