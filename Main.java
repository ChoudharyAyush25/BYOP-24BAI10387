import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int choice = -1;

        System.out.println("=========================================");
        System.out.println("   Welcome to Personal Task Manager      ");
        System.out.println("=========================================");

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new Task");
            System.out.println("2. View all Tasks");
            System.out.println("3. Update a Task");
            System.out.println("4. Delete a Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Search Task by Title");
            System.out.println("7. Sort Tasks by Deadline");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            
            // Read user input and handle invalid inputs
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character left by nextInt
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the bad input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    
                    System.out.print("Enter Deadline (YYYY-MM-DD): ");
                    String deadline = scanner.nextLine();
                    
                    taskManager.addTask(title, priority, deadline);
                    break;

                case 2:
                    taskManager.viewAllTasks();
                    break;

                case 3:
                    System.out.print("Enter the ID of the task to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Enter new Title (or press Enter to keep current): ");
                    String newTitle = scanner.nextLine();
                    
                    System.out.print("Enter new Priority (or press Enter to keep current): ");
                    String newPriority = scanner.nextLine();
                    
                    System.out.print("Enter new Status (Pending/Completed, or press Enter to keep current): ");
                    String newStatus = scanner.nextLine();
                    
                    taskManager.updateTask(updateId, newTitle, newPriority, newStatus);
                    break;

                case 4:
                    System.out.print("Enter the ID of the task to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    taskManager.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.print("Enter the ID of the task to mark as completed: ");
                    int completeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    taskManager.markTaskCompleted(completeId);
                    break;

                case 6:
                    System.out.print("Enter keyword to search in title: ");
                    String keyword = scanner.nextLine();
                    taskManager.searchTaskByTitle(keyword);
                    break;

                case 7:
                    taskManager.sortTasksByDeadline();
                    break;

                case 8:
                    System.out.println("\nThank you for using Personal Task Manager. Goodbye!");
                    break;

                default:
                    System.out.println("\n[Error] Invalid choice. Please select a number between 1 and 8.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
