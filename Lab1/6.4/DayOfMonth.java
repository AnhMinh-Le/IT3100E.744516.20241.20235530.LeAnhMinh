import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] monthFullNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthShortNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthAbbrNames = {"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        String[] monthNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        
        int month = getValidMonth(scanner, monthFullNames, monthShortNames, monthAbbrNames, monthNumbers);
        int year = getValidYear(scanner);
        int days = getDaysInMonth(month, year);
        System.out.println("Number of days in " + monthFullNames[month - 1] + " " + year + ": " + days);
        
        scanner.close();
    }
    
    public static int getValidMonth(Scanner scanner, String[] monthFullNames, String[] monthShortNames, String[] monthAbbrNames, String[] monthNumbers) {
        while (true) {
            System.out.print("Enter the month: ");
            String inputMonth = scanner.nextLine().trim().toLowerCase();
            
            int month = findMonthIndex(inputMonth, monthFullNames, monthShortNames, monthAbbrNames, monthNumbers);
            if (month != -1) {
                return month + 1; 
            }
            System.out.println("Invalid month. Please enter again.");
        }
    }

    public static int getValidYear(Scanner scanner) {
        while (true) {
            System.out.print("Enter the year: ");
            String inputYear = scanner.nextLine().trim();
            
            if (isValidYear(inputYear)) {
                return Integer.parseInt(inputYear);
            }
            System.out.println("Invalid year. Please enter again.");
        }
    }
    
    public static int findMonthIndex(String inputMonth, String[] fullNames, String[] shortNames, String[] abbrNames, String[] monthNumbers) {
        if (contains(inputMonth, fullNames) || contains(inputMonth, shortNames) || contains(inputMonth, abbrNames) || contains(inputMonth, monthNumbers)) {
            return findIndex(inputMonth, fullNames, shortNames, abbrNames, monthNumbers);
        }
        return -1;
    }

    public static boolean isValidYear(String inputYear) {
        try {
            int year = Integer.parseInt(inputYear);
            return year >= 0 && inputYear.length() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }


    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean contains(String value, String[]... arrays) {
        for (String[] array : arrays) {
            for (String element : array) {
                if (element.equalsIgnoreCase(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findIndex(String value, String[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (String[] array : arrays) {
                if (array[i].equalsIgnoreCase(value)) {
                    return i;
                }
            }
        }
        return -1;
    }
}