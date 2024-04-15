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
            username = JOptionPane.showInputDialog(null, "Enter username (must be at least 5 characters long and contain an underscore):", "Registration", JOptionPane.PLAIN_MESSAGE); //(Fromen,2016)
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
                if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*")) { //(Sharma,2014)
                    
                    JOptionPane.showMessageDialog(null, "Password successfully captured!", "Registration", JOptionPane.INFORMATION_MESSAGE);
                    break;
               
                } else {
                    JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character. ", "Registration", JOptionPane.ERROR_MESSAGE);
                }
            }

        String firstName = "";
                while (true) {//(progyammer,2016)
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
                while (true) {//(progyammer,2016)
                    lastName = JOptionPane.showInputDialog(null, "Enter last name (letters only):", "Registration", JOptionPane.PLAIN_MESSAGE);
                    if (lastName == null) {
                        return;
                    }
                    if (lastName.matches("[a-zA-Z]+")) { //(Sharma,2014)
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Last name must contain only letters. Please try again.", "Registration", JOptionPane.ERROR_MESSAGE);
                    }
                }
                        if (username == null || password == null || firstName == null || lastName == null) { //when user cancels registration
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

    boolean isUsernameFormattedCorrectly(String user_) {// this was automatically generated when i created my unit test 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public static User getUser(String username) {//(Thakur,2020)
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

//Referencing List:
/*
Thakur.2020. Get the Name of a Member Object in Java. [Online].
Available at: https://www.tutorialspoint.com/get-the-name-of-a-member-object-in-java#:~:text=The%20getName()%20method%20is,the%20form%20of%20a%20string.
[accessed 13 April 2024].
*/

/*
Fromen.2016. Efficiently Check Multiple Conditions [closed], Java. [Online].
Available at: https://stackoverflow.com/questions/40860009/efficiently-check-multiple-conditions
[accessed 13 April 2024].
*/

/*
Progyammer.2016. How can I input an if statement inside a while loop?, Java. [Online].
Available at: https://stackoverflow.com/questions/38670004/how-can-i-input-an-if-statement-inside-a-while-loop
[accessed 11 April 2024]
*/

/*
Sharma. 2014. Check if a String contains a special character, Java. [Online].
Available at: https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character#:~:text=You%20can%20use%20the%20following%20code%20to%20detect%20special%20character%20from%20string.&text=If%20it%20matches%20regex%20%5Ba,not%20special%20characters%20in%20it.
[accessed 13 April 2024]
*/
