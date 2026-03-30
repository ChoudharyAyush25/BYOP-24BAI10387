public class Task {
    private int id;
    private String title;
    private String priority;
    private String status;
    private String deadline;

    // Parameterized constructor to initialize a Task
    public Task(int id, String title, String priority, String status, String deadline) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getPriority() { return priority; }
    public String getStatus() { return status; }
    public String getDeadline() { return deadline; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setStatus(String status) { this.status = status; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    // Helper method to convert a task to a comma-separated string for file storage
    public String toFileString() {
        return id + "," + title + "," + priority + "," + status + "," + deadline;
    }
    
    // Helper method to parse a comma-separated string back into a Task object
    public static Task fromFileString(String line) {
        String[] parts = line.split(",");
        // Ensure there are exactly 5 parts to avoid array out of bounds
        if (parts.length == 5) {
            int parsedId = Integer.parseInt(parts[0]);
            return new Task(parsedId, parts[1], parts[2], parts[3], parts[4]);
        }
        return null; // Return null if the line is not formatted correctly
    }
}
