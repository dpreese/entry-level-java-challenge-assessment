package com.challenge.api.model;
import java.time.Instant;
import java.util.UUID;
import com.challenge.api.model.Employee;

public class EmployeeModel implements Employee {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate;

    public EmployeeModel(UUID uuid, String firstName, String lastName) {
        // Basic constructor with hardcoded values for simplicity assuming all fields are required.
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = 0;
        this.age = 0;
        this.jobTitle = "Test Job";
        this.email = "Test Email";
        this.contractHireDate = Instant.now();
        this.contractTerminationDate = null;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String name) {
        this.firstName = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String name) {
        this.lastName = name;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setFullName(String name) {
        // fullName is derived from firstName and lastName, so we don't store it directly.
        // This method is not used in the current implementation.
    }
    

    @Override
    public Integer getSalary() {
        return salary;
    }
    @Override
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Instant getContractHireDate() {
        return contractHireDate;
    }

    @Override
    public void setContractHireDate(Instant date) {
        this.contractHireDate = date;
    }

    @Override
    public Instant getContractTerminationDate() {
        return contractTerminationDate;
    }

    @Override
    public void setContractTerminationDate(Instant date) {
        this.contractTerminationDate = date;
    }
}
