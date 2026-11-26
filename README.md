# 🎓 Java Student Management System

A robust console-based application built in **Java** designed to efficiently manage student records and academic operations using Object-Oriented Programming (OOP) principles and `HashMap` data structures.

## 🚀 Key Features
* **Student Records Management:** Add, update, view, and remove student profiles with comprehensive validation.
* **Advanced Search & Filtering:** Search students instantly by ID or name, and filter lists by graduation status.
* **Sorting Capabilities:** Sort students dynamically by ID, name, or academic grade.
* **Comprehensive Statistics:** Generate real-time statistics including total students, graduated vs. non-graduated counts, average age, and grade distribution (A-F).
* **Report Exporting:** Export detailed student statistics reports directly to a text file (`ReportStudents.txt`).
* **File Persistence:** Automatic saving and loading of student data using `Students.txt` via `FileWriter` and `BufferedReader`.
* **Robust Input Handling:** Comprehensive exception handling and input validation for console interactions[cite: 10, 11, 12].

---

## 🏗️ Technical Architecture & OOP Principles
* **Data Structures:** Utilizes `HashMap<Integer, Student>` for efficient student record management by ID.
* **Collections & Sorting:** Uses `ArrayList` and `Comparator` for flexible sorting by ID, name, and grade.
* **File I/O:** Implements robust persistent storage using `BufferedReader` and `FileWriter`[cite: 10, 11, 12].

---

## 🛠️ How to Run
1. Open the project in an IDE such as **Eclipse**, **IntelliJ IDEA**, or **VS Code**.
2. Run `Main.java` as the entry point[cite: 10].
3. Follow the interactive CLI menu options ranging from `0` to `11`.
