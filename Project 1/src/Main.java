import Controller.OfficerController;
import Controller.CourseController;
import Controller.StudentController;

public class Main {
    private static final OfficerController officerController =  new OfficerController();
    private static final CourseController courseController =  new CourseController();
    private static final StudentController studentController =  new StudentController();

    private static boolean notLogin = true;
    public static void main(String[] args) {
        System.out.println("Welcome to Student Management System");
        System.out.println("------Login to Enter------");
        while (notLogin) {
            if (officerController.officerLogin()) {
                notLogin = false;
                officerController.welcomeMessage();
            } else {
                System.out.println();
            }
        }
        int choice;
        while (!notLogin) {
            choice = officerController.printMenu();
            switch (choice) {
                case 1:
                    studentController.viewAllStudent();
                    break;
                case 2:
                    studentController.searchStudent();
                    break;
                case 3:
                    studentController.addStudent();
                    break;
                case 4:
                    courseController.viewAllCourse();
                    break;
                case 5:
                    courseController.searchCourse();
                    break;
                case 6:
                    courseController.addCourse();
                    break;
                case 7:
                    studentController.advisedCourse();
                    break;
                case 8:
                    System.out.println("Thank you for using the system.");
                    notLogin = true;
                    break;
                default:
                    System.out.println("Wrong choice. Enter 1-8");

            }
        }
    }
}