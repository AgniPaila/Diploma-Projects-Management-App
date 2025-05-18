# 🎓 Diploma Projects Management App
A web application designed to simplify the management of diploma thesis projects between students and professors. This app allows 
- students to browse available diploma thesis projects from various professors and apply for the diploma thesis projects that interest them
- professors to assign diploma thesis projects to students, supervise the assigned thesis projects and assess the outcomes
making the academic process more efficient and transparent.

## 📌 Features

### 🔐 General Functionality
- User registration and login with role selection (Student or Professor)
- Secure authentication to access personalized functionalities

### 👨‍💻 Student Features
- Set personal profile information (name, year of study, average grade, remaining courses)
- Browse available diploma thesis subjects offered by professors
- View detailed subject descriptions (title, objectives, supervisor)
- Apply for thesis subjects of interest

### 👨‍🏫 Professor Features
- Set personal profile information (name, specialty)
- Manage thesis subjects: add, edit, or delete
- View student applications for thesis subjects
- Assign thesis subjects to students using one of multiple selection strategies:
  - Random choice
  - Best average grade
  - Fewest remaining courses
  - Custom thresholds (e.g., average > Th1 and remaining courses < Th2)
- Monitor assigned theses
- Evaluate student work by setting grades for:
  - Implementation
  - Report
  - Presentation
- Automatically calculate final grade

## 🛠️ Technologies Used
- **Language**: Java  (compatible at least with Java 8)
- **Framework**: Spring Boot  
- **IDE**: Eclipse  
- **Database**: MySQL 
- **Build Tool**: Maven
- **Tests**: JUnit and Mockito
- For the **Front-end** we used HTML and Bootstrap

## 🚀 How to Run
Clone the repository

Open the project in Eclipse

Build and run the application

Access the app via http://localhost:8080

## 📘 Course Info
Course: Τεχνολογία Λογισμικού (Software Engineering)

Team: This project was developed in collaboration with two fellow students.

