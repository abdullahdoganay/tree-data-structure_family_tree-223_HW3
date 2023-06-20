//-----------------------------------------------------
// Title: main class
// Author: Abdullah Doğanay
// ID: 10549887192
// Section: 2
// Assignment: 3
// Description: This class is the main/tester class.
// -----------------------------------------------------

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String operation = "0";
        String fileName;
        System.out.println("Enter filename:");
        fileName = scan.nextLine();
        tree tree = new tree(fileName);

        while (!operation.equals("6")){
            System.out.println("Enter operation code:");
            operation = scan.next();
            switch(operation) {
                case "1":
                    System.out.println("Enter ID:");
                    String id = scan.next();
                    tree.printAllDescendants(Integer.parseInt(id));
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Enter IDs:");
                    int a2;
                    int b2;
                    a2 = scan.nextInt();
                    b2 = scan.nextInt();
                    System.out.println(tree.checkAncestor(a2, b2));
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Enter IDs:");
                    int a3;
                    int b3;
                    a3 = scan.nextInt();
                    b3 = scan.nextInt();
                    System.out.println(tree.checkDescendant(a3, b3));
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Enter IDs:");
                    int a4;
                    int b4;
                    a4 = scan.nextInt();
                    b4 = scan.nextInt();
                    System.out.println(tree.checkSiblings(a4, b4));
                    System.out.println();
                    break;
                case "5":
                    System.out.println("Enter IDs:");
                    int a5;
                    int b5;
                    a5 = scan.nextInt();
                    b5 = scan.nextInt();
                    System.out.println(tree.findFirstOldestCommon(a5, b5));
                    System.out.println();
                    break;
                case "6":
                    System.out.println("Stopped!");
                    System.out.println();
                    break;

                default:
                    System.out.println("Please enter valid operation!");
            }
        }
        }

}