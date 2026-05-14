import java.util.*;

/*
 * Project 2
   Ryan Ramdihal
 */

abstract class Person {
    protected String name;
    protected String id;

    public abstract void print();

    public abstract String getID();
}

abstract class Employee extends Person {
    protected String department;
}

class Student extends Person {

    private double gpa;
    private int creditHours;

    public Student() {
        name = "null";
        id = "null";
        gpa = 0;
        creditHours = 0;
    }

    public Student(String nameIn, String idIn, double gpaIn, int creditHoursIn) {
        name = nameIn;
        id = idIn;
        gpa = gpaIn;
        creditHours = creditHoursIn;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    public double getGPA() {
        return gpa;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public void setID(String idIn) {
        id = idIn;
    }

    public void setGPA(double gpaIn) {
        gpa = gpaIn;
    }

    public double calculateTuition() {
        double tuition = 0;

        tuition = creditHours * 236.45;
        tuition = tuition + 52;

        return tuition;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println("Here is the tuition invoice for " + name + " :");
        System.out.println("---------------------------------------");

        System.out.print(name);
        System.out.println("\t\t" + id);

        System.out.println("Credit hours:" + creditHours + " ($236.45/credit hour)");
        System.out.println("Fees: $52");
        System.out.println();

        if (gpa >= 3.85) {
            System.out.printf(
                "Total payment (after discount): $%,.2f\t\t($%.2f discount applied)",
                (calculateTuition() * 0.75),
                ((calculateTuition() - (calculateTuition() * 0.75)))
            );
        } else {
            System.out.printf(
                "Total payment (after discount): $%,.2f\t\t($0 discount applied)",
                calculateTuition()
            );
        }

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }
}

class Staff extends Employee {

    private String status;

    public Staff() {
        name = "null";
        id = "null";
        department = "null";
        status = "null";
    }

    public Staff(String nameIn, String idIn, String departmentIn, String statusIn) {
        name = nameIn;
        id = idIn;
        department = departmentIn;
        status = statusIn;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public void setID(String idIn) {
        id = idIn;
    }

    public void setDepartment(String departmentIn) {
        department = departmentIn;
    }

    public void setStatus(String statusIn) {
        status = statusIn;
    }

    @Override
    public void print() {
        System.out.println("---------------------------------------");

        System.out.print(name);
        System.out.println("\t\t" + id);

        System.out.print(department + " Department, ");
        System.out.print(status);

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }
}

class Faculty extends Employee {

    private String rank;

    public Faculty() {
        name = "null";
        id = "null";
        department = "null";
        rank = "null";
    }

    public Faculty(String nameIn, String idIn, String rankIn, String departmentIn) {
        name = nameIn;
        id = idIn;
        department = departmentIn;
        rank = rankIn;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getRank() {
        return rank;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public void setId(String idIn) {
        id = idIn;
    }

    public void setDepartment(String departmentIn) {
        department = departmentIn;
    }

    public void setRank(String rankIn) {
        rank = rankIn;
    }

    @Override
    public void print() {
        System.out.println("---------------------------------------");

        System.out.print(name);
        System.out.println("\t\t" + id);

        System.out.print(department + " Department, ");
        System.out.print(rank);

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }
}

public class Project2 {

    public static final Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {

        Person[] PersonArray = new Person[100];

        for (int i = 0; i < 100; i++) {
            PersonArray[i] = new Student();
        }

        int exit = 0;
        String input = "null";

        int caseTwo = 0;
        int caseOne = 0;

        String tempName = "null";
        String tempID = "null";
        double tempGPA = 0;
        int tempHours = 0;
        String tempDept = "null";
        String tempRank = "null";
        String tempStatus = "null";
        String compareId = "null";

        int objCounter = 0;

        System.out.println("\t\t\t\t\tWelcome to my Personal Management Program");

        while (exit == 0) {

            System.out.println("Choose one of the options:");
            System.out.println("1- Enter the information of the faculty");
            System.out.println("2- Enter the information of the student");
            System.out.println("3- Print the tuition invoice");
            System.out.println("4- Print faculty information");
            System.out.println("5- Enter the information of the staff member");
            System.out.println("6- Print the information of the staff member");
            System.out.println("7- Exit Program");

            System.out.print("\tEnter your selection: ");

            input = scnr.nextLine();

            switch (input) {

                case "1":

                    System.out.print("Name of the faculty: ");
                    tempName = getName();

                    System.out.print("ID: ");
                    tempID = getID();

                    System.out.println();

                    tempRank = getRank();

                    System.out.println();

                    tempDept = getDept();

                    System.out.println();

                    PersonArray[objCounter] =
                        new Faculty(tempName, tempID, tempRank, tempDept);

                    objCounter++;

                    System.out.println("Faculty added!");
                    System.out.println();

                    caseOne++;

                    break;

                case "2":

                    System.out.println("Enter student info: ");

                    System.out.print("\t\tName of Student: ");
                    tempName = getName();

                    System.out.print("\t\tID: ");
                    tempID = getID();

                    System.out.print("\t\tGpa: ");
                    tempGPA = getGpa();

                    System.out.print("\t\tCredit hours: ");
                    tempHours = getHours();

                    PersonArray[objCounter] =
                        new Student(tempName, tempID, tempGPA, tempHours);

                    objCounter++;

                    caseTwo++;

                    System.out.println("Student Added!");
                    System.out.println();

                    scnr.nextLine();

                    break;

                case "3":

                    if (caseTwo == 0) {
                        System.out.println("You have no students.");
                        break;
                    }

                    System.out.print("Enter the Student's ID: ");

                    compareId = scnr.nextLine();

                    printForId(PersonArray, compareId, "Student");

                    break;

                case "4":

                    if (caseOne == 0) {
                        System.out.println("Sorry! No faculty member entered yet.");
                        System.out.println();
                        break;
                    }

                    System.out.print("Enter the Faculty's ID: ");

                    compareId = scnr.nextLine();

                    printForId(PersonArray, compareId, "Faculty");

                    break;

                case "5":

                    System.out.print("Name of the staff member: ");
                    tempName = getName();

                    System.out.print("Enter the id: ");
                    tempID = getID();

                    tempDept = getDept();

                    System.out.println();

                    System.out.print(
                        "Status, Enter P for Part Time or Enter F for Full Time: "
                    );

                    tempStatus = getStatus();

                    System.out.println();

                    PersonArray[objCounter] =
                        new Staff(tempName, tempID, tempDept, tempStatus);

                    objCounter++;

                    System.out.println("Staff member added!");
                    System.out.println();

                    break;

                case "6":

                    System.out.print("Enter the Staff's member's ID: ");

                    compareId = scnr.nextLine();

                    printForId(PersonArray, compareId, "Staff");

                    break;

                case "7":

                    System.out.println("Goodbye!");

                    exit++;

                    break;

                default:

                    System.out.println();
                    System.out.println("Invalid entry- please try again\n");

                    break;
            }
        }
    }

    public static String getName() {
        String name = scnr.nextLine();
        return name;
    }

    public static String getID() {
        String id = scnr.nextLine();
        return id;
    }

    public static double getGpa() {
        double gpa = scnr.nextDouble();
        return gpa;
    }

    public static int getHours() {
        int hours = scnr.nextInt();
        return hours;
    }

    public static String getDept() {

        int dValid = 0;
        String dept = "null";

        while (dValid == 0) {

            System.out.print("Department: ");

            dept = scnr.nextLine();
            dept = dept.toLowerCase();

            if (
                (dept.compareTo("mathematics") == 0) ||
                (dept.compareTo("engineering") == 0) ||
                (dept.compareTo("sciences") == 0)
            ) {

                dValid++;

                dept = dept.substring(0, 1).toUpperCase() + dept.substring(1);

            } else {

                System.out.println("\"" + dept + "\" is invalid");
            }
        }

        return dept;
    }

    public static String getStatus() {

        int sValid = 0;
        String status = "null";

        while (sValid == 0) {

            status = scnr.nextLine();
            status = status.toLowerCase();

            if (
                (status.compareTo("f") == 0) ||
                (status.compareTo("p") == 0)
            ) {

                if (status.compareTo("f") == 0) {

                    sValid++;
                    status = "Full Time";

                } else if (status.compareTo("p") == 0) {

                    sValid++;
                    status = "Part Time";
                }

            } else {

                System.out.print("\"" + status + "\" is invalid");
            }
        }

        return status;
    }

    public static String getRank() {

        int rValid = 0;
        String rank = "null";

        while (rValid == 0) {

            System.out.print("Rank: ");

            rank = scnr.nextLine();

            String temprank = rank;

            rank = rank.toLowerCase();

            if (
                (rank.compareTo("professor") == 0) ||
                (rank.compareTo("adjunct") == 0)
            ) {

                rValid++;

                rank = rank.substring(0, 1).toUpperCase() + rank.substring(1);

            } else {

                System.out.println("\"" + temprank + "\" is invalid");
            }
        }

        return rank;
    }

    public static void printForId(Person[] arr, String compId, String type) {

        boolean success = false;

        for (Person person : arr) {

            if (person.getID().equals(compId)) {

                person.print();
                success = true;
            }
        }

        if (success == false) {

            System.out.println("No " + type + " with this ID found.");
            System.out.println();
        }
    }
}
