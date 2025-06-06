/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class NumberConverter {

    // Function to convert decimal to binary and return as a string
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, (decimal & 1));
            decimal >>= 1;
        }
        return binary.toString();
    }

    // Function to convert binary to decimal and return as an integer
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    // Function to convert decimal to octal and return as a string
    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    // Function to convert octal to decimal and return as an integer
    public static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    // Function to convert hexadecimal to binary and return as a string
    public static String hexadecimalToBinary(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        return decimalToBinary(decimal);
    }

    // Function to convert binary to hexadecimal and return as a string
    public static String binaryToHexadecimal(String binary) {
        int length = binary.length();
        int padding = (4 - (length % 4)) % 4;

        StringBuilder paddedBinary = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            paddedBinary.append('0');
        }
        paddedBinary.append(binary);
        String paddedBinaryStr = paddedBinary.toString();

        StringBuilder hexadecimal = new StringBuilder();
        for (int i = 0; i < paddedBinaryStr.length(); i += 4) {
            String group = paddedBinaryStr.substring(i, i + 4);
            int decimalValue = Integer.parseInt(group, 2);
            hexadecimal.append(Integer.toHexString(decimalValue).toUpperCase());
        }
        return hexadecimal.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("LNCT UNIVERSITY, BHOPAL");
        System.out.println("==============================");
        System.out.println("NUMBER SYSTEM CONVERTER");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Decimal to Binary");
            System.out.println("2. Binary to Decimal");
            System.out.println("3. Decimal to Octal");
            System.out.println("4. Octal to Decimal");
            System.out.println("5. Hexadecimal to Binary");
            System.out.println("6. Binary to Hexadecimal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            }

            String input;
            switch (choice) {
                case 1:
                    System.out.print("Enter a decimal number: ");
                    int decimalInput = scanner.nextInt();
                    System.out.println("Decimal to Binary: " + decimalToBinary(decimalInput));
                    break;
                case 2:
                    System.out.print("Enter a binary number: ");
                    input = scanner.nextLine();
                    System.out.println("Binary to Decimal: " + binaryToDecimal(input));
                    break;
                case 3:
                    System.out.print("Enter a decimal number: ");
                    decimalInput = scanner.nextInt();
                    System.out.println("Decimal to Octal: " + decimalToOctal(decimalInput));
                    break;
                case 4:
                    System.out.print("Enter an octal number: ");
                    input = scanner.nextLine();
                    System.out.println("Octal to Decimal: " + octalToDecimal(input));
                    break;
                case 5:
                    System.out.print("Enter a hexadecimal number: ");
                    input = scanner.nextLine();
                    System.out.println("Hexadecimal to Binary: " + hexadecimalToBinary(input));
                    break;
                case 6:
                    System.out.print("Enter a binary number: ");
                    input = scanner.nextLine();
                    System.out.println("Binary to Hexadecimal: " + binaryToHexadecimal(input));
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
