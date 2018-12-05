package com.assetcontrol.datatranslator.processor;

import org.springframework.batch.item.ItemProcessor;

import com.assetcontrol.datatranslator.model.Employee;

public class EmployeeDataProcessor implements ItemProcessor<Employee,Employee> {

  @Override
  public Employee process(final Employee employee) throws Exception {
    return null;
  }
}
