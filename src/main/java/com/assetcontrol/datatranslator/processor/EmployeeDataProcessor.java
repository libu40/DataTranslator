package com.assetcontrol.datatranslator.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import com.assetcontrol.datatranslator.common.FileUtility;
import com.assetcontrol.datatranslator.model.Employee;
import com.google.common.io.Resources;

/**
 * The processor which transforms the input by filtering and transforms to respective identifiers
 * in the configuration.
 */
public class EmployeeDataProcessor implements ItemProcessor<Employee, Employee> {

  private Map<String, List<String>> employeeInputDataStore = new HashMap<>();
  private Map<String, String> dataIdentifierStore = dataIdentifierExtractor();

  /**
   * method which process the records and gives to writer.
   * @param employee
   * @return
   * @throws Exception
   */
  @Override
  public Employee process(final Employee employee) throws Exception {
    if (dataIdentifierStore.containsKey(String.valueOf(employee.getId()))) {
      employeeInputDataStore = employeeInputPopulator(employee, employeeInputDataStore);
      employee.setId(Long.parseLong(dataIdentifierStore.get(String.valueOf(employee.getId()))));
      return employee;
    }
    return null;
  }

  private Map<String, List<String>> employeeInputPopulator(final Employee employee, Map<String, List<String>> employeeInput) {

    List<String> employeeInputList = new ArrayList<>();
    employeeInputList.add(employee.getFirstName());
    employeeInputList.add(employee.getLastName());
    employeeInputList.add(employee.getAddress());
    employeeInputList.add(employee.getCity());
    employeeInputList.add(Long.toString(employee.getPhoneNumber()));
    employeeInputList.add(employee.getEmail());
    employeeInputList.add(employee.getDepartment());

    employeeInput.put(Long.toString(employee.getId()), employeeInputList);
    return employeeInput;


  }

  private Map<String, String> dataIdentifierExtractor() {
    FileUtility utility = new FileUtility();
    String dataExtractor = Resources.getResource("DataExtractor.txt").getFile();
    return utility.parseConfigFile(dataExtractor);
  }
}
