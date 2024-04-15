/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerlogin;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Main {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);

 while (true) {
 System.out.println("1. Register\n2. Login\n3. Exit");
 System.out.print("Enter your choice: ");
 int choice = scanner.nextInt();

 switch (choice) {
 case 1:
 registerUser(scanner);
 break;
 case 2:
 loginUser(scanner);
 break;
 case 3:
 System.out.println("Goodbye!");
 return;
 default:
 System.out.println("Invalid choice. Please try again.");
 }
 }
 }

 private static void registerUser(Scanner scanner) {
 System.out.print("Enter email: ");
 String email = scanner.nextLine();

 System.out.print("Enter password: ");
 //String password = scanner.nextLine();

 // Validate the email and password here
 }

 private static void loginUser(Scanner scanner) {
 System.out.print("Enter email: ");
 String email = scanner.nextLine();

 System.out.print("Enter password: ");
 //String password = scanner.nextLine();
 }
}
