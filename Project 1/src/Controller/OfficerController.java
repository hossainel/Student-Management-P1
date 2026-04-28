package Controller;

import Models.Officer;
import Models.OfficerModel;

import java.util.Scanner;

public class OfficerController {
    private Officer officer;
    private final Scanner sc = new Scanner(System.in);

    public boolean officerLogin() {
        OfficerModel model = new OfficerModel();
        System.out.print("Enter Officer username: ");
        this.officer = model.getUserData(this.sc.nextLine());
        if (this.officer == null) {
            System.out.println("Invalid Officer username");
        } else {
            System.out.print("Enter Password: ");
            if ( this.officer.checkPassword(sc.nextLine()) ) {
                System.out.println("Officer successfully logged in");
                return true;
            } else  {
                System.out.println("Invalid Password");
            }
        }
        return false;
    }
    public Officer getOfficer() {
        return officer;
    }
    public void welcomeMessage() {
        System.out.println("Welcome back: " +  this.officer.getName());
    }
    public int printMenu() {
        System.out.println("======= Management Dashboard =======");
        System.out.println("1. View All Students");
        System.out.println("2. Search Students");
        System.out.println("3. Add Student");
        System.out.println("4. View All Course");
        System.out.println("5. Search Course");
        System.out.println("6. Add Course");
        System.out.println("7. Advise Course");
        System.out.println("8. Exit/Logout");
        System.out.print("Enter your choice [1-8]: ");
        return sc.nextInt();
    }
}
