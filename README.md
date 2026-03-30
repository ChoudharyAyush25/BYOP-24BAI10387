# BYOP-24BAI10387
Java Vityarthi Project

# Personal Task Manager

A simple, console-based Personal Task Manager application built using Core Java. This project demonstrates foundational Object-Oriented Programming (OOP) principles and file I/O operations without relying on any external frameworks or databases. It is designed to be clean, modular, and easy to understand.

## Features

- **Add a Task:** Create new tasks with a title, priority (High/Medium/Low), and a deadline (YYYY-MM-DD).
- **View All Tasks:** Display all tasks in a cleanly formatted table within the console.
- **Update a Task:** Modify the title, priority, or status of an existing task by its ID.
- **Delete a Task:** Remove a task completely using its ID.
- **Mark as Completed:** Quickly update a task's status from 'Pending' to 'Completed'.
- **Search by Title:** Find specific tasks by searching for keywords in their titles (case-insensitive).
- **Sort by Deadline:** Reorder and display the task list chronologically based on the deadline.
- **Data Persistence:** Tasks are automatically saved to and loaded from a local text file (`tasks.txt`), ensuring your data is not lost between sessions.

## Project Structure

The application's logic is cleanly separated into four main Java classes:

1. **`Task.java`**: The model class representing a single task and its core attributes (ID, Title, Priority, Status, Deadline).
2. **`FileHandler.java`**: Handles reading from and writing to the `tasks.txt` file securely.
3. **`TaskManager.java`**: Central controller containing the core logic for managing the list of tasks (adding, removing, filtering, and sorting).
4. **`Main.java`**: The entry point of the program that provides the interactive, menu-driven command-line interface for the user.

## Prerequisites

To compile and run this project, you will need:
- **Java Development Kit (JDK)** installed on your system (Java 8 or higher).
- A basic terminal or command prompt (Command Prompt, PowerShell, Terminal, etc.).

## Setup & Installation

1. Download or place all the Java files into a single directory on your computer (e.g., `Java Vityarthi`).
2. Open your terminal or command prompt.
3. Navigate to the directory where the project files are located.
   ```bash
   cd "C:\path\to\your\folder"
   ```
4. Compile the Java source files by running the following command:
   ```bash
   javac *.java
   ```
   *(Note: If no errors are displayed after running this command, the compilation was successful.)*

## How to Use

Once the code is properly compiled, you can start the application by running the `Main` class:

```bash
java Main
```

The application will present a main menu that looks like this:

```text
=========================================
   Welcome to Personal Task Manager      
=========================================

--- Main Menu ---
1. Add a new Task
2. View all Tasks
3. Update a Task
4. Delete a Task
5. Mark Task as Completed
6. Search Task by Title
7. Sort Tasks by Deadline
8. Exit
Enter your choice (1-8): 
```

Simply type the number corresponding to the action you want to perform and hit **Enter**. Follow the on-screen prompts to manage your tasks!

## Data Storage
The application will automatically create a file named `tasks.txt` in the same directory when you add your first task. This file safely stores your tasks in a lightweight comma-separated format. If you ever want to reset your task list completely, you can simply delete the `tasks.txt` file from the folder, and the application will start fresh!
