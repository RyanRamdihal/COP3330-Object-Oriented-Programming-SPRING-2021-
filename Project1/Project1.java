import java.util.*;

/*
- Project 1
- Ryan Ramdihal
*/
public class Project1 {
    public static final Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        int exit = 0;
        String input = "null";
        int studSelect;
        int case1check = 0;
        int caseTwo = 0;
        int check2 = 0;
        int check5 = 0;
        int staffCheck = 0;
        String confirm = "null";
        final double PER_CREDIT_HOUR = 236.45;
        final int ADMIN_FEE = 52;
        final double DISCOUNT_MULTIPLIER = 0.85;

        String studentName = "null";
        String studentID = "null";
        double studentGPA = 0;
        int studentHours = 0;

        String studentNameTwo = "null";
        String studentIDTwo = "null";
        double studentGPATwo = 0;
        int studentHoursTwo = 0;

        String facultyName = "null";
        String facultyID = "null";
        String facultyDept = "null";
        String facultyRank = "null";

        String staffName = "null";
        String staffID = "null";
        String staffDept = "null";
        String staffStatus = "null";

        System.out.println("\t\t\t\t\tWelcome to my Personal Management Program");

        while (exit == 0) {
            System.out.println("Choose one of the options:");
            System.out.println("1- Enter the information of the faculty");
            System.out.println("2- Enter the information of the two students");
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
                    facultyName = getName();
                    System.out.print("ID: ");
                    facultyID = getID();
                    System.out.println();
                    facultyRank = getRank();
                    System.out.println();
                    facultyDept = getDept();
                    System.out.println();
                    System.out.println("Faculty successfully added!");
                    case1check++;
                    System.out.println();
                    break;

                case "2":
                    if (caseTwo > 0) {
                        System.out.println("You already have two students filled in. Do you want to update their information?");
                        while (check2 == 0) {
                            System.out.print("Yes or No: ");
                            confirm = scnr.nextLine();
                            confirm = confirm.toLowerCase();
                            if ((confirm.compareTo("yes") == 0) || (confirm.compareTo("no") == 0)) {
                                if (confirm.compareTo("yes") == 0) {
                                    check2++;
                                } else if (confirm.compareTo("no") == 0) {
                                    break;
                                } else {
                                    System.out.print("Invalid entry- please try again");
                                    // make sure it breaks case and loop
                                }
                            }
                        }
                    }
                    caseTwo++;
                    System.out.println("Enter student 1 info: ");
                    // tab this
                    System.out.print("\t\tName of Student: ");
                    studentName = getName();
                    System.out.print("\t\tID: ");
                    studentID = getID();
                    System.out.print("\t\tGpa: ");
                    studentGPA = getGpa();
                    System.out.print("\t\tCredit hours: ");
                    studentHours = getHours();
                    System.out.println("Thanks!");
                    System.out.println();
                    System.out.println("Enter student 2 info: ");
                    System.out.print("\t\tName of Student: ");
                    studentNameTwo = getName();
                    System.out.print("\t\tID: ");
                    studentIDTwo = getID();
                    System.out.print("\t\tGpa: ");
                    studentGPATwo = getGpa();
                    System.out.print("\t\tCredit hours: ");
                    studentHoursTwo = getHours();
                    System.out.println("Thanks!");
                    System.out.println();
                    scnr.nextLine();
                    break;

                case "3":
                    if (caseTwo == 0) {
                        System.out.println("You have no students.");
                        break;
                    }
                    System.out.print("Which student? Enter 1 for " + studentName + " or Enter 2 for " + studentNameTwo + " ? ");
                    studSelect = scnr.nextInt();
                    if (studSelect == 1) {
                        System.out.println("---------------------------------------");
                        System.out.print(studentName);
                        System.out.println("\t\t" + studentID);
                        System.out.println("Credit hours:" + studentHours + " ($236.45/credit hour)");
                        System.out.println("Fees: $52");
                        System.out.println();
                        if (studentGPA >= 3.85) {
                            System.out.printf("Total payment (after discount): $%,.2f\t\t($%.2f discount applied)",
                                    calculateTuition(studentHours, PER_CREDIT_HOUR, ADMIN_FEE, studentGPA, DISCOUNT_MULTIPLIER),
                                    ((calculateTuition(studentHours, PER_CREDIT_HOUR, ADMIN_FEE, studentGPA, DISCOUNT_MULTIPLIER) / 0.85)
                                            - (calculateTuition(studentHours, PER_CREDIT_HOUR, ADMIN_FEE, studentGPA, DISCOUNT_MULTIPLIER))));
                        } else {
                            System.out.printf("Total payment (after discount): $%,.2f\t\t($0 discount applied)",
                                    calculateTuition(studentHours, PER_CREDIT_HOUR, ADMIN_FEE, studentGPA, DISCOUNT_MULTIPLIER));
                        }
                        System.out.println();
                        System.out.println("---------------------------------------");
                        System.out.println();
                    } else if (studSelect == 2) {
                        System.out.println("---------------------------------------");
                        System.out.print(studentNameTwo);
                        System.out.println("\t\t" + studentIDTwo);
                        System.out.println("Credit hours:" + studentHoursTwo + " ($236.45/credit hour)");
                        System.out.println("Fees: $52");
                        System.out.println();
                        if (studentGPATwo >= 3.85) {
                            System.out.printf("Total payment (after discount): $%,.2f\t\t($%.2f discount applied)",
                                    calculateTuition(studentHoursTwo, PER_CREDIT_HOUR, ADMIN_FEE, studentGPATwo, DISCOUNT_MULTIPLIER),
                                    ((calculateTuition(studentHoursTwo, PER_CREDIT_HOUR, ADMIN_FEE, studentGPATwo, DISCOUNT_MULTIPLIER) / 0.85)
                                            - (calculateTuition(studentHoursTwo, PER_CREDIT_HOUR, ADMIN_FEE, studentGPATwo, DISCOUNT_MULTIPLIER))));
                        } else {
                            System.out.printf("Total payment (after discount): $%,.2f\t\t($0 discount applied)",
                                    calculateTuition(studentHoursTwo, PER_CREDIT_HOUR, ADMIN_FEE, studentGPATwo, DISCOUNT_MULTIPLIER));
                        }
                        System.out.println();
                        System.out.println("---------------------------------------");
                        System.out.println();
                    }
                    scnr.nextLine();
                    break;

                case "4":
                    if (case1check == 0) {
                        System.out.println("Sorry! no Faculty member entered yet");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("---------------------------------------");
                    }
                    System.out.print(facultyName);
                    System.out.println("\t\t" + facultyID);
                    System.out.print(facultyDept + " Department, ");
                    System.out.print(facultyRank);
                    System.out.println();
                    System.out.println("---------------------------------------");
                    System.out.println();
                    break;

                case "5":
                    if (staffCheck > 0) {
                        System.out.println("You already have a staff member filled in. Do you want to update their information?");
                        while (check5 == 0) {
                            System.out.print("Yes or No: ");
                            confirm = scnr.nextLine();
                            confirm = confirm.toLowerCase();
                            if ((confirm.compareTo("yes") == 0) || (confirm.compareTo("no") == 0)) {
                                if (confirm.compareTo("yes") == 0) {
                                    check5++;
                                } else if (confirm.compareTo("no") == 0) {
                                    break;
                                }
                            } else {
                                System.out.print("Invalid entry- please try again");
                            }
                        }
                    }
                    staffCheck++;
                    System.out.println();
                    System.out.print("Name of the staff member: ");
                    staffName = getName();
                    System.out.print("Enter the id: ");
                    staffID = getID();
                    staffDept = getDept();
                    System.out.println();
                    System.out.print("Status, Enter P for Part Time or Enter F for Full Time: ");
                    staffStatus = getStatus();
                    System.out.println();
                    System.out.println("Staff member added!");
                    System.out.println();
                    break;

                case "6":
                    if (staffCheck < 1) {
                        System.out.println();
                        System.out.println("Sorry! No Staff member entered yet");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("---------------------------------------");
                    }
                    System.out.print(staffName);
                    System.out.println("\t\t" + staffID);
                    System.out.print(staffDept + " Department, ");
                    System.out.print(staffStatus);
                    System.out.println();
                    System.out.println("---------------------------------------");
                    System.out.println();
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
            if ((dept.compareTo("mathematics") == 0) || (dept.compareTo("engineering") == 0) || (dept.compareTo("english") == 0)) {
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
            if ((status.compareTo("f") == 0) || (status.compareTo("p") == 0)) {
                if ((status.compareTo("f") == 0)) {
                    sValid++;
                    status = "Full Time";
                } else if ((status.compareTo("p") == 0)) {
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
            if ((rank.compareTo("professor") == 0) || (rank.compareTo("adjunct") == 0)) {
                rValid++;
                rank = rank.substring(0, 1).toUpperCase() + rank.substring(1);
            } else {
                System.out.println("\"" + temprank + "\" is invalid");
            }
        }
        return rank;
    }

    public static double calculateTuition(int hrs, double perHour, int fee, double geePeeAy, double disc) {
        double tuition = 0;
        tuition = hrs * perHour;
        tuition = tuition + fee;
        if (geePeeAy >= 3.85) {
            tuition = tuition * disc;
        }
        return tuition;
    }
}
