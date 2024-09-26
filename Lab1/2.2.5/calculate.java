import java.util.Scanner;

public class calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        printSum(num1, num2);
        printDiff(num1, num2);
        printMul(num1, num2);
        printDiv(num1, num2);

        scanner.close();
    }

    public static void printSum(double a, double b) {
        double sum = a + b;
        System.out.println("The sum: " + sum);
    }

    public static void printDiff(double a, double b) {
        double diff = a - b;
        System.out.println("The difference: " + diff);
    }

    public static void printMul(double a, double b) {
        double mul = a * b;
        System.out.println("The product: " + mul);
    }

    public static void printDiv(double a, double b) {
        if (b != 0) {
            double div = a / b;
            System.out.println("The quotient: " + div);
        } else {
            System.out.println("Can not division for zero!");
        }
    }
}


