public class TaskManagementSystem {

    // Task class to represent a task
    public static class Task {
        private String taskId;
        private String taskName;
        private String status;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        // Getters and setters
        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId='" + taskId + '\'' +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    // Node class for the linked list
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Singly Linked List class
    public static class TaskManager {
        private Node head;

        public TaskManager() {
            this.head = null;
        }

        // Method to add a task
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // Method to search for a task by ID
        public Task searchTaskById(String taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId().equals(taskId)) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        // Method to delete a task by ID
        public boolean deleteTaskById(String taskId) {
            if (head == null) return false;

            if (head.task.getTaskId().equals(taskId)) {
                head = head.next;
                return true;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.getTaskId().equals(taskId)) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Method to traverse and display all tasks
        public void displayTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of TaskManager
        TaskManager manager = new TaskManager();

        // Add some tasks
        manager.addTask(new Task("1", "Design Database", "Pending"));
        manager.addTask(new Task("2", "Develop API", "In Progress"));
        manager.addTask(new Task("3", "Test Application", "Not Started"));

        // Display all tasks
        System.out.println("All Tasks:");
        manager.displayTasks();

        // Search for a task
        System.out.println("\nSearching for Task with ID 2:");
        Task task = manager.searchTaskById("2");
        System.out.println(task != null ? task : "Task not found.");

        // Delete a task
        System.out.println("\nDeleting Task with ID 2:");
        boolean deleted = manager.deleteTaskById("2");
        System.out.println(deleted ? "Task deleted successfully." : "Task not found.");

        // Display all tasks after deletion
        System.out.println("\nTasks after deletion:");
        manager.displayTasks();
    }
}

