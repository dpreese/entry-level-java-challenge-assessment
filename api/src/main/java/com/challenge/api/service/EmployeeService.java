package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final List<Employee> employees;
    private final ObjectMapper objectMapper =
            new ObjectMapper(); // Simple object mapper usage. In a real app, would validate input more thoroughly or
    // initialize it in a constructor.

    public EmployeeService() {
        this.employees = new java.util.ArrayList<>();
        UUID sampleUuid1 = UUID.randomUUID();
        UUID sampleUuid2 = UUID.randomUUID();
        UUID sampleUuid3 = UUID.randomUUID();
        employees.add(new EmployeeModel(sampleUuid1, "John", "Doe"));
        employees.add(new EmployeeModel(sampleUuid2, "Jane", "Smith"));
        employees.add(new EmployeeModel(sampleUuid3, "Alice", "Johnson"));
    }
    // Return a list of all employees
    public List<Employee> getAllEmployees() {
        /*
        Some Pseudo Code for if this was a real app with a DB:
         - Inject a DAO
            - private final EmployeeRepoDAO repoDAO;
         - return repoDAO.findAll();
        */
        return employees;
    }
    // Return an employee by UUID
    public Employee getEmployeeByUuid(UUID uuid) {
        /*
        Some Pseudo Code for if this was a real app with a DB:
         - Inject a DAO
            - private final EmployeeRepoDAO repoDAO;
         - return repoDAO.findById(uuid).orElseThrow(() -> new NotFoundException("Employee not found"));
        */
        for (Employee employee : employees) {
            if (employee.getUuid().equals(uuid)) {
                return employee;
            }
        }
        return null;
    }
    // Create a new employee
    public Employee createEmployee(Object requestBody) {
        EmployeeModel request = objectMapper.convertValue(requestBody, EmployeeModel.class);
        request.setUuid(UUID.randomUUID()); // Set employeeUuid to random UUID value
        if (request.getFirstName() == null || request.getLastName() == null) {
            throw new IllegalArgumentException("First name and last name must not be null");
        }
        employees.add(request);
        return request;
    }
}
