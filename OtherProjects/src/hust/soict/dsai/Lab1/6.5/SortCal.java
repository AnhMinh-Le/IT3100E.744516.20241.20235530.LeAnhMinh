import java.util.Scanner;

public class SortCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an array? (y/n): ");
        char choice = scanner.next().charAt(0);

        int[] numbers;
        if (Character.toLowerCase(choice) == 'y') {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            numbers = new int[n];
            System.out.println("Please input " + n + " elements:");
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }
        } else {
            numbers = new int[]{1789, 2035, 1899, 1456, 2013}; //Constant
        }
        insertionSort(numbers);
        System.out.println("Sorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        System.out.println("\nSum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
        
        scanner.close();
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
