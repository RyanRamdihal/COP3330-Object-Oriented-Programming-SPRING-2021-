# Project 2 — University Personnel Management Program

A console-based Java application that manages personnel records for a university, including students, faculty, and staff. Built to demonstrate object-oriented programming principles: inheritance, abstract classes, abstract methods, and method overriding.

## Overview

The program lets a user enter, store, and retrieve information about three kinds of people on campus:

- **Students** — tracked with name, ID, GPA, and credit hours currently taken. The program can generate a tuition invoice for any student on demand.
- **Faculty** — tracked with name, ID, department, and rank.
- **Staff** — tracked with name, ID, department, and employment status (full time or part time).

All records are stored in a single `Person[]` array of size 100. Lookups are performed by ID.

## Class Hierarchy

The program is organized around the following inheritance structure:

```
            Person  (abstract)
           /      \
      Student      Employee  (abstract)
                  /        \
              Faculty       Staff
```

- `Person` — abstract base class containing the fields common to everyone (`name`, `id`) and the abstract method `public abstract void print();` that each concrete subclass overrides.
- `Employee` — abstract class extending `Person`, adds the shared `department` field for faculty and staff.
- `Student` — extends `Person`; adds `gpa` and `creditHours`; implements `calculateTuition()` and a `print()` method that produces a formatted tuition invoice.
- `Faculty` — extends `Employee`; adds `rank`.
- `Staff` — extends `Employee`; adds `status` (full time / part time).

Each class includes at least two constructors (a no-arg default and a parameterized constructor) along with getters and setters for all data members.

## Tuition Calculation

Tuition for a student is calculated as follows:

- $236.45 per credit hour
- Plus a flat $52 administrative fee
- A 25% discount is applied to the total when the student's GPA is 3.85 or higher

The invoice is produced by `Student.print()` and shows the name, ID, credit hours, fees, and the final amount due (with any discount noted on the same line).

## Valid Input Values

The program validates the following fields and re-prompts on invalid entries:

- **Department** (faculty and staff): `Mathematics`, `Engineering`, or `Sciences` — input is case-insensitive and normalized to title case on display.
- **Rank** (faculty): `Professor` or `Adjunct`.
- **Status** (staff): `F` for Full Time or `P` for Part Time.
- **ID** has no required format; any string is accepted.

## Menu Options

When run, the program displays a menu repeatedly until the user chooses to exit:

```
1- Enter the information of the faculty
2- Enter the information of the student
3- Print the tuition invoice
4- Print faculty information
5- Enter the information of the staff member
6- Print the information of the staff member
7- Exit Program
```

Options 3, 4, and 6 prompt for an ID and then print the matching record. If no record with that ID exists, the program reports it and returns to the menu.

## How to Compile and Run

The project is a single source file: `Project2.java`.

```bash
javac Project2.java
java Project2
```

Requires a Java compiler and runtime (JDK 8 or newer is sufficient).

## Sample Session

```
Welcome to my Personal Management Program
Choose one of the options:
1- Enter the information of the faculty
2- Enter the information of the student
...
    Enter your selection: 2
Enter student info:
        Name of Student: Julia Alvarez
        ID: ju1254
        Gpa: 3.26
        Credit hours: 7
Student Added!

    Enter your selection: 3
Enter the Student's ID: ju1254

Here is the tuition invoice for Julia Alvarez :
---------------------------------------
Julia Alvarez           ju1254
Credit hours:7 ($236.45/credit hour)
Fees: $52

Total payment (after discount): $1,707.15           ($0 discount applied)
---------------------------------------
```

## File Structure

```
Project2.java     // Contains Project2 (entry point), Person, Employee,
                  // Student, Faculty, and Staff classes
```

## Concepts Demonstrated

- Abstract classes and abstract methods (`Person`, `Employee`, `print()`)
- Inheritance across multiple levels (`Person` → `Employee` → `Faculty`/`Staff`)
- Method overriding (`print()`, `getID()` are overridden in each concrete subclass)
- Polymorphism via a single `Person[]` array holding mixed subclass instances
- Encapsulation through private fields with public getters and setters
- Input validation with re-prompt loops for constrained fields
