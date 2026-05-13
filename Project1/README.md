# Project 1 — Personal Management Program

A simple Java console application that manages university personnel information, including faculty, students, and staff. The program presents a menu-driven interface that allows the user to enter records, generate tuition invoices, and display information for each type of person.

## Author
- Ryan Ramdihal

## Description

This program stores and displays information for three types of university personnel. Each type has its own set of fields:

- **Student:** full name, ID, GPA, and number of credit hours currently taken
- **Faculty:** full name, ID, department (Mathematics, Engineering, or English), and rank (Professor or Adjunct)
- **Staff:** full name, ID, department (Mathematics, Engineering, or English), and status (Part Time or Full Time)

The program supports up to one faculty member, two students, and one staff member at a time. It also generates a tuition invoice for either of the two students based on the credit hours and GPA they entered.

## Tuition Calculation

Tuition is calculated using the following constants:

- Per-credit-hour cost: **$236.45**
- Administrative fee: **$52.00**
- GPA discount: **15% off** the total payment if the student's GPA is **≥ 3.85**

Formula:

```
tuition = (credit_hours × 236.45) + 52
if GPA ≥ 3.85:
    tuition = tuition × 0.85
```

## Menu Options

When the program starts, the user is presented with the following menu:

```
1- Enter the information of the faculty
2- Enter the information of the two students
3- Print the tuition invoice
4- Print faculty information
5- Enter the information of the staff member
6- Print the information of the staff member
7- Exit Program
```

The menu loops until the user selects option 7. Invalid menu entries display an error message and re-prompt the user.

## Requirements

- Java JDK 8 or later
- A terminal or command prompt

## How to Compile and Run

1. Open a terminal in the project directory.
2. Compile the source file:

   ```
   javac Project1.java
   ```

3. Run the compiled program:

   ```
   java Project1
   ```

## Sample Run

```
Welcome to my Personal Management Program
Choose one of the options:
1- Enter the information of the faculty
2- Enter the information of the two students
3- Print the tuition invoice
4- Print faculty information
5- Enter the information of the staff member
6- Print the information of the staff member
7- Exit Program
    Enter your selection: 2
Enter student 1 info:
        Name of Student: Julia Alvarez
        ID: ju1254
        Gpa: 3.26
        Credit hours: 7
Thanks!

Enter student 2 info:
        Name of Student: Matt Jones
        ID: ma0258
        Gpa: 2.78
        Credit hours: 0
Thanks!
```

## Methods

The program is organized around several static helper methods to keep the main loop clean:

- `getName()` — reads a name from the user
- `getID()` — reads an ID string from the user
- `getGpa()` — reads a GPA value as a double
- `getHours()` — reads credit hours as an integer
- `getDept()` — prompts for a department and validates the entry (Mathematics, Engineering, or English)
- `getRank()` — prompts for a faculty rank and validates it (Professor or Adjunct)
- `getStatus()` — prompts for staff status and validates the entry (P for Part Time or F for Full Time)
- `calculateTuition(hrs, perHour, fee, gpa, disc)` — computes the total tuition, applying the GPA-based discount when applicable

## Input Validation

The program validates the following inputs:

- **Department:** must be Mathematics, Engineering, or English (case insensitive)
- **Faculty rank:** must be Professor or Adjunct (case insensitive)
- **Staff status:** must be P (Part Time) or F (Full Time) (case insensitive)
- **Menu selection:** must be a digit from 1 through 7
- **Update confirmation:** must be "yes" or "no" when overwriting existing student or staff information

## Files

- `Project1.java` — main source file containing the `Project1` class and all helper methods

## Notes

- This project was developed as a class assignment to demonstrate the use of static methods, control flow, input validation, and basic console I/O in Java.
- Entering information for students or the staff member a second time will prompt for confirmation before overwriting existing records.
