package com.assetcontrol.datatranslator.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.assetcontrol.datatranslator.model.Employee;

/**
 * The mapper class to map the file to POJO.
 */
public class EmployeeResultSetMapper implements FieldSetMapper<Employee> {
  /**
   * method which maps the file records to POJO.
   * @param fieldSet
   * @return Employee
   * @throws BindException
   */
  @Override
  public Employee mapFieldSet(final FieldSet fieldSet) throws BindException {
    Employee employee = new Employee();
    employee.setId(fieldSet.readLong(0));
    employee.setFirstName((fieldSet.readString(1)));
    employee.setLastName(fieldSet.readString(2));
    employee.setAddress(fieldSet.readString(3));
    employee.setCity(fieldSet.readString(4));
    employee.setPhoneNumber(fieldSet.readLong(5));
    employee.setEmail(fieldSet.readString(6));
    employee.setDepartment(fieldSet.readString(7));
    return employee;
  }
}
