package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM employee",(response, rowNumber) ->
                new Employee(response.getLong("id"),
                        response.getString("first_name"),
                        response.getString("last_name"),
                        response.getString("function"),
                        response.getString("mail")
                        ));
        return employeeList;
    }

    public Employee findById(Long id) {
        Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",new Object[]{id},
                (response, rowNumber) ->
                    new Employee(response.getLong(1),
                                response.getString(2),
                                response.getString(3),
                                response.getString(4),
                                response.getString(5)
                                ));
        return employee;
    }

    public void createEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee(id, first_name, last_name, function, mail, id_warehouse) VALUES (?,?,?,?,?,?)",
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getFunction(),
                employee.getMail()
        );
    }

    public void updateEmployee(long id, Employee employee) {
        jdbcTemplate.update("UPDATE employee SET first_name = ? WHERE id = ?;",
                employee.getFirstName(),id);
    }

    public void deleteEmployee(long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?;",id);
    }

    public List<Employee> findEmployeeByWarehouse(long id) {
        List<Employee> employeeList = jdbcTemplate.query("SELECT e.id, e.first_name, e.last_name, e.function,w.id, w.adress, w.nr_employees FROM employee_warehouse INNER JOIN employee e on e.id = employee_warehouse.id_employee\n" +
                "                                    INNER JOIN warehouse w on employee_warehouse.id_warehouse = w.id WHERE w.id = ?", new Object[]{id},
                (response, rowNumber) ->
                new Employee(response.getLong(1),
                        response.getString("first_name"),
                        response.getString("last_name"),
                        response.getString("function"),
                        response.getLong(5),
                        response.getString("adress"),
                        response.getInt("nr_employees")
                ));

        return employeeList;
    }
}
