import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = FileHandler.loadTasks();
        this.nextId = 1;
        
        // Find the maximum ID used so far to assign to the next task
        for (Task task : tasks) {
            if (task.getId() >= nextId) {
                nextId = task.getId() + 1;
            }
        }
    }

    // Private helper method to save changes to the file
    private void save() {
        FileHandler.saveTasks(tasks);
    }

    // 1. Add a new task
    public void addTask(String title, String priority, String deadline) {
        Task newTask = new Task(nextId, title, priority, "Pending", deadline);
        tasks.add(newTask);
        nextId++;
        save();
        System.out.println("\n[Success] Task added successfully!");
    }

    // Helper to format and print a table of tasks
    public void viewTasks(List<Task> listToView) {
        if (listToView == null || listToView.isEmpty()) {
            System.out.println("\nNo tasks available to display.");
            return;
        }
        
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-25s | %-10s | %-12s | %-12s |\n", "ID", "Title", "Priority", "Status", "Deadline");
        System.out.println("---------------------------------------------------------------------------------");
        
        for (Task task : listToView) {
            System.out.printf("| %-4d | %-25s | %-10s | %-12s | %-12s |\n", 
                task.getId(), task.getTitle(), task.getPriority(), task.getStatus(), task.getDeadline());
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    // 2. View all tasks
    public void viewAllTasks() {
        viewTasks(tasks);
    }

    // 3. Update an existing task
    public void updateTask(int id, String newTitle, String newPriority, String newStatus) {
        Task task = findTaskById(id);
        if (task != null) {
            // Only update fields if the user provided new values (not empty)
            if (newTitle != null && !newTitle.trim().isEmpty()) {
                task.setTitle(newTitle);
            }
            if (newPriority != null && !newPriority.trim().isEmpty()) {
                task.setPriority(newPriority);
            }
            if (newStatus != null && !newStatus.trim().isEmpty()) {
                task.setStatus(newStatus);
            }
            save(); // Save after updates
            System.out.println("\n[Success] Task modified successfully!");
        } else {
            System.out.println("\n[Error] Task with ID " + id + " not found.");
        }
    }

    // 4. Delete a task
    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            save();
            System.out.println("\n[Success] Task deleted successfully!");
        } else {
            System.out.println("\n[Error] Task with ID " + id + " not found.");
        }
    }

    // 5. Mark task as completed
    public void markTaskCompleted(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus("Completed");
            save();
            System.out.println("\n[Success] Task marked as Completed!");
        } else {
            System.out.println("\n[Error] Task with ID " + id + " not found.");
        }
    }

    // 6. Search task by title
    public void searchTaskByTitle(String keyword) {
        List<Task> results = new ArrayList<>();
        // Search regardless of capitalization
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(task);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("\nNo tasks found matching keyword: \"" + keyword + "\"");
        } else {
            System.out.println("\n--- Search Results ---");
            viewTasks(results);
        }
    }

    // 7. Sort tasks by deadline
    public void sortTasksByDeadline() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks to sort.");
            return;
        }

        // Create a copy so we don't accidentally mess up the original order permanently (optional)
        List<Task> sortedTasks = new ArrayList<>(tasks);
        
        // Sorting using an anonymous Comparator class (Standard Core Java)
        // YYYY-MM-DD format allows for straightforward String comparison
        Collections.sort(sortedTasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getDeadline().compareTo(t2.getDeadline());
            }
        });
        
        System.out.println("\n--- Tasks Sorted by Deadline ---");
        viewTasks(sortedTasks);
    }

    // Helper method to look up a task by its ID
    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
