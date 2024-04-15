/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerlogin;

import javax.swing.JOptionPane;

public class RegisterLogin {
    public static void main(String[] args) {
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Register\nLogin\nExit",
                    "Choose an option",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Register", "Login", "Exit"},
                    null);

            switch (choice) {
                case 0:
                    registerUser();
                    break;
                case 1:
                    loginUser();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser() {
        
        String username = "";
        while (true) {
            username = JOptionPane.showInputDialog(null, "Enter username (must be at least 5 characters long and contain an underscore):", "Registration", JOptionPane.PLAIN_MESSAGE);
            if (username == null) {
                return;
            }
            if (username.length() >= 5 && username.contains("_")) {//this meathod checks both the length of userName and checks for underscore at the same (I avoiding hard coding)
                
                JOptionPane.showMessageDialog(null, "Username successfully captured!", "Registration", JOptionPane.INFORMATION_MESSAGE);
                break;
        
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", "Registration", JOptionPane.ERROR_MESSAGE);
            }
        }

                
       String password = "";
            while (true) {
                password = JOptionPane.showInputDialog(null, "Enter password (must be 8 characters long, contain a capital letter, a number, and a special character):", "Registration", JOptionPane.PLAIN_MESSAGE);
                if (password == null) {
                    return;
                }
                if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*")) {
                    
                    JOptionPane.showMessageDialog(null, "Password successfully captured!", "Registration", JOptionPane.INFORMATION_MESSAGE);
                    break;
               
                } else {
                    JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character. ", "Registration", JOptionPane.ERROR_MESSAGE);
                }
            }

        String firstName = "";
                while (true) {
                    firstName = JOptionPane.showInputDialog(null, "Enter first name (letters only):", "Registration", JOptionPane.PLAIN_MESSAGE);
                    if (firstName == null) {
                        return;
                    }
                    if (firstName.matches("[a-zA-Z]+")) {//checks that only letters are used
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "First name must contain only letters. Please try again.", "Registration", JOptionPane.ERROR_MESSAGE);
                    }
                }

                    
        String lastName = "";
                while (true) {
                    lastName = JOptionPane.showInputDialog(null, "Enter last name (letters only):", "Registration", JOptionPane.PLAIN_MESSAGE);
                    if (lastName == null) {
                        return;
                    }
                    if (lastName.matches("[a-zA-Z]+")) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Last name must contain only letters. Please try again.", "Registration", JOptionPane.ERROR_MESSAGE);
                    }
                }
                        if (username == null || password == null || firstName == null || lastName == null) {
                            return;
                        }

        User user = new User(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, "Username, Password, firstName, LastName successfully captured");
    }
    
    
//stage for logging in 
    
    private static void loginUser() {
        String username = JOptionPane.showInputDialog(null, "Enter username:", "Login", JOptionPane.PLAIN_MESSAGE);

        if (username == null) {
            return;
        }

        String password = JOptionPane.showInputDialog(null, "Enter password:", "Login", JOptionPane.PLAIN_MESSAGE);

        if (password == null) {
            return;
        }

        User user = User.getUser(username);

        if (user == null || !user.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again", "Login", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Welcome " + user.getFirstName() + ", " + user.getLastName() + " it is great to see you again.", "Login", JOptionPane.INFORMATION_MESSAGE);

    }
}

class User {
    private static User[] users = new User[10];
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = this;
                break;
            }
        }
    }

    public static User getUser(String username) {
        for (User user : users) {
            if (user != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
