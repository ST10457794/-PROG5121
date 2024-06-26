/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerlogin;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class RegisterLogin {
    private static ArrayList<Task> taskList = new ArrayList<>(); //(How to use array list ? [Oop], n.d.)
    private static ArrayList<User> users = new ArrayList<>();
    private static int taskCounter = 0;

     // Arrays to store task details
    private static ArrayList<String> developerArray = new ArrayList<>(); 
    private static ArrayList<String> taskNameArray = new ArrayList<>(); 
    private static ArrayList<String> taskIdArray = new ArrayList<>(); 
    private static ArrayList<Integer> taskDurationArray = new ArrayList<>(); 
    private static ArrayList<String> taskStatusArray = new ArrayList<>(); 

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
            if (username.length() >= 5 && username.contains("_")) {
                JOptionPane.showMessageDialog(null, "Username successfully captured!", "Registration", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is at least 5 characters in length.", "Registration", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", "Registration", JOptionPane.ERROR_MESSAGE);
            }
        }//(Methods as sources, n.d.)&(Regexp Java for password validation, n.d.)

        String firstName = "";
        while (true) {
            firstName = JOptionPane.showInputDialog(null, "Enter first name (letters only):", "Registration", JOptionPane.PLAIN_MESSAGE);
            if (firstName == null) {
                return;
            }
            if (firstName.matches("[a-zA-Z]+")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "First name must contain only letters. Please try again.", "Registration", JOptionPane.ERROR_MESSAGE);
            }
        }//(Methods as sources, n.d.)

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
        }//(Methods as sources, n.d.)

        User user = new User(username, password, firstName, lastName);
        users.add(user);
        JOptionPane.showMessageDialog(null, "User successfully registered!");
    }

    private static void loginUser() {
        String username = JOptionPane.showInputDialog(null, "Enter username:", "Login", JOptionPane.PLAIN_MESSAGE);
        if (username == null) {
            return;
        }

        String password = JOptionPane.showInputDialog(null, "Enter password:", "Login", JOptionPane.PLAIN_MESSAGE);
        if (password == null) {
            return;
        }

        User user = getUser(username);
        if (user == null || !user.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again", "Login", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Welcome " + user.getFirstName() + ", " + user.getLastName() + " it is great to see you again.", "Login", JOptionPane.INFORMATION_MESSAGE);
        
        // To show task menu
        showTaskMenu(user);
    }

    private static User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    private static void showTaskMenu(User user) {
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Add Task\nView Tasks\nSearch Task\nDelete Task\nReport\nLogout", 
                    "Choose an option",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Add Task", "View Tasks", "Search Task", "Delete Task", "Report", "Logout"}, 
                    null);

                    switch (choice) {
                        case 0:
                            addTask(user);
                            break;
                        case 1:
                            viewTasks();
                            break;
                        case 2:
                            searchTask(); 
                            break;
                        case 3:
                            deleteTask(); 
                            break;
                        case 4:
                            displayReport(); 
                            break;
                        case 5:
                            return;  // Logout
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                    }
                }
            }
        
            private static void addTask(User user) {
                String taskName = JOptionPane.showInputDialog(null, "Enter task name:", "Add Task", JOptionPane.PLAIN_MESSAGE);
                if (taskName == null) {
                    return;
                }
        
                int taskNumber = taskCounter++;
        
                String taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 characters):", "Add Task", JOptionPane.PLAIN_MESSAGE);
                if (taskDescription == null || taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters", "Add Task", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Task successfully captured", "Add Task", JOptionPane.INFORMATION_MESSAGE);
                }
        
                String developerDetails = JOptionPane.showInputDialog(null, "Enter developer details:", "Add Task", JOptionPane.PLAIN_MESSAGE);
                if (developerDetails == null) {
                    return;
                }
        
                int taskDuration;
                while (true) {
                    try {
                        taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter task duration (in hours):", "Add Task", JOptionPane.PLAIN_MESSAGE));
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid task duration. Please enter a valid number.", "Add Task", JOptionPane.ERROR_MESSAGE);
                    }
                }
        
                String[] statuses = {"To Do", "Doing", "Done"};
                int statusChoice = JOptionPane.showOptionDialog(null, "Select task status:", "Add Task", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);
                if (statusChoice == -1) {
                    return;
                }
                String taskStatus = statuses[statusChoice];
        
                Task task = new Task(taskName, taskNumber, taskDescription, developerDetails, taskDuration, taskStatus);
                taskList.add(task);
        
                // Add to arrays
                developerArray.add(developerDetails); 
                taskNameArray.add(taskName); 
                taskIdArray.add(task.getTaskID()); 
                taskDurationArray.add(taskDuration); 
                taskStatusArray.add(taskStatus); 
        
                JOptionPane.showMessageDialog(null, "Task successfully added!");
            }
        
            private static void viewTasks() {
                StringBuilder tasks = new StringBuilder("Task List:\n");
                for (Task task : taskList) {
                    tasks.append(task.printTaskDetails()).append("\n\n");
                }
                JOptionPane.showMessageDialog(null, tasks.toString(), "View Tasks", JOptionPane.INFORMATION_MESSAGE);
            }
        
            // Method to search for a task by name
            private static void searchTask() {
                String taskName = JOptionPane.showInputDialog(null, "Enter task name to search:", "Search Task", JOptionPane.PLAIN_MESSAGE); 
                if (taskName == null) {
                    return;
                }
        
                for (Task task : taskList) {
                    if (task.getTaskName().equalsIgnoreCase(taskName)) {
                        JOptionPane.showMessageDialog(null, task.printTaskDetails(), "Search Task", JOptionPane.INFORMATION_MESSAGE); 
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Task not found.", "Search Task", JOptionPane.ERROR_MESSAGE); 
            } //(How to search for elements in an ArrayList? - Java, n.d.)
        
            // Method to delete a task by name
            private static void deleteTask() {
                String taskName = JOptionPane.showInputDialog(null, "Enter task name to delete:", "Delete Task", JOptionPane.PLAIN_MESSAGE); 
                if (taskName == null) {
                    return;
                }
        
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                        taskList.remove(i);
        
                        // Remove from arrays
                        developerArray.remove(i); 
                        taskNameArray.remove(i); 
                        taskIdArray.remove(i); 
                        taskDurationArray.remove(i); 
                        taskStatusArray.remove(i); 
        
                        JOptionPane.showMessageDialog(null, "Task successfully deleted.", "Delete Task", JOptionPane.INFORMATION_MESSAGE); 
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Task not found.", "Delete Task", JOptionPane.ERROR_MESSAGE); 
            } //(How to search for elements in an ArrayList? - Java, n.d.)
        
            // Method to display a report of tasks
            private static void displayReport() {
                StringBuilder report = new StringBuilder("Task Report:\n");
                for (int i = 0; i < taskList.size(); i++) {
                    report.append("Developer: ").append(developerArray.get(i))
                          .append("\nTask Name: ").append(taskNameArray.get(i))
                          .append("\nTask ID: ").append(taskIdArray.get(i))
                          .append("\nTask Duration: ").append(taskDurationArray.get(i))
                          .append("\nTask Status: ").append(taskStatusArray.get(i))
                          .append("\n\n");
                }
                JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
            }//(StringBuilder class in java with examples, 2018)
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

/*
Stack Overflow. 2013. How to create a multi-line JOptionPane.showMessageDialog?. [Online].
Available at: https://stackoverflow.com/questions/6578205/how-to-create-a-multi-line-joptionpane-showmessagedialog
[accessed 15 May 2024].
*/

/*
How to search for elements in an ArrayList? - Java (2023) Stack Overflow. 
Available at: https://stackoverflow.com/questions/62650051/how-to-search-for-elements-in-an-arraylist-java 
(Accessed: June 24, 2024).

How to use array list ? [Oop] (2012) Stack Overflow. 
Available at: https://stackoverflow.com/questions/12493548/how-to-use-array-list-oop 
(Accessed: June 23, 2024).

Methods as sources Hyperskill. 
Available at: https://hyperskill.org/learn/step/19388 
(Accessed: June 25, 2024).

Regexp Java for password validation (2014) Stack Overflow. 
Available at: https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation 
(Accessed: June 24, 2024).

StringBuilder class in java with examples (2018) GeeksforGeeks. 
Available at: https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/ 
(Accessed: June 24, 2024).
 */
