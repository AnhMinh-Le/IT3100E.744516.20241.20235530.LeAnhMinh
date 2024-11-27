import java.util.Scanner;

public class equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Type of equation?");
            System.out.println("1. The first-degree equation (linear equation) with one variable");
            System.out.println("2. The system of first-degree equations (linear system) with two variables");
            System.out.println("3. The second-degree equation with one variable");
            System.out.println("4. Exit");
            System.out.print("Enter the corresponding number to choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    solveFirstDegreeEquation(scanner);
                    break;
                case 2:
                    solveLinearSystem(scanner);
                    break;
                case 3:
                    solveSecondDegreeEquation(scanner);
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void solveFirstDegreeEquation(Scanner scanner) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Solving first-degree equation: ax + b = 0");
        System.out.print("Enter coefficient a: ");
        double a = scanner1.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner1.nextDouble();
        
        if (a == 0) {
            if (b == 0) System.out.println("Infinity solution.");
            else System.out.println("No solution.");
        } 
        else {
            double root = -b / a;
            System.out.println("The solution is: x = " + root);
        }
    }

    private static void solveLinearSystem(Scanner scanner) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Solving system of first-degree equations (a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2)");

        System.out.print("Enter coefficient a11: ");
        double a11 = scanner2.nextDouble();
        System.out.print("Enter coefficient a12: ");
        double a12 = scanner2.nextDouble();
        System.out.print("Enter constant b1: ");
        double b1 = scanner2.nextDouble();
        System.out.print("Enter coefficient a21: ");
        double a21 = scanner2.nextDouble();
        System.out.print("Enter coefficient a22: ");
        double a22 = scanner2.nextDouble();
        System.out.print("Enter constant b2: ");
        double b2 = scanner2.nextDouble();
        
        double D = a11 * a22 - a21 * a12; 
        double D1 = b1 * a22 - b2 * a12;   
        double D2 = a11 * b2 - a21 * b1;   

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D; 
            double x2 = D2 / D; 
            System.out.println("The solution for the system of equations is:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
    }
}

    private static void solveSecondDegreeEquation(Scanner scanner) {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Solving second-degree equation ax^2 + bx + c = 0");
        System.out.print("Enter coefficient a: ");
        double a = scanner3.nextDouble();
        
        if (a == 0) {
            System.out.println("This is not a second-degree equation.");
            return;
        }
        
        System.out.print("Enter coefficient b: ");
        double b = scanner3.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner3.nextDouble();
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are: x1 = " + root1 + ", x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The double root is: x = " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("The roots are complex:");
            System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }
}