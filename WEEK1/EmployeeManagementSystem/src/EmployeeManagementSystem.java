public class EmployeeManagementSystem {

    // Employee class to represent employee details
    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and setters
        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId='" + employeeId + '\'' +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    // Employee management class using array
    public static class EmployeeManager {
        private Employee[] employees;
        private int size;

        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        // Method to add an employee
        public boolean addEmployee(Employee employee) {
            if (size >= employees.length) {
                System.out.println("Array is full. Cannot add more employees.");
                return false;
            }
            employees[size++] = employee;
            return true;
        }

        // Method to search for an employee by ID
        public Employee searchEmployeeById(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    return employees[i];
                }
            }
            return null;
        }

        // Method to delete an employee by ID
        public boolean deleteEmployeeById(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    // Shift elements to the left
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[size - 1] = null;
                    size--;
                    return true;
                }
            }
            return false;
        }

        // Method to traverse and display all employees
        public void displayEmployees() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void main(String[] args) {
        // Create an EmployeeManager with a capacity of 5
        EmployeeManager manager = new EmployeeManager(5);

        // Add some employees
        manager.addEmployee(new Employee("E1", "Alice", "Manager", 75000));
        manager.addEmployee(new Employee("E2", "Bob", "Developer", 60000));
        manager.addEmployee(new Employee("E3", "Charlie", "Analyst", 55000));

        // Display all employees
        System.out.println("All Employees:");
        manager.displayEmployees();

        // Search for an employee
        System.out.println("\nSearching for Employee with ID E2:");
        Employee emp = manager.searchEmployeeById("E2");
        System.out.println(emp != null ? emp : "Employee not found.");

        // Delete an employee
        System.out.println("\nDeleting Employee with ID E2:");
        boolean deleted = manager.deleteEmployeeById("E2");
        System.out.println(deleted ? "Employee deleted successfully." : "Employee not found.");

        // Display all employees after deletion
        System.out.println("\nEmployees after deletion:");
        manager.displayEmployees();
    }
}
