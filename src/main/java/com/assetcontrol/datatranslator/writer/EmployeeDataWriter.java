package com.assetcontrol.datatranslator.writer;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;

import com.assetcontrol.datatranslator.common.FileUtility;
import com.assetcontrol.datatranslator.model.Employee;
import com.google.common.io.Resources;

/**
 * The writer class which dumps the data to file.
 */
public class EmployeeDataWriter implements ItemWriter<Employee> {

  private Map<String, String> columnIdentifierStore = columnIdentifierExtractor();

  /**
   * method which process and writes to file.
   * @param list
   * @throws Exception
   */
  @Override
  public void write(final List<? extends Employee> list) throws Exception {
    try (FileWriter writer = new FileWriter("EmployeeOutput.txt")) {
      for (Map.Entry<String, String> column : columnIdentifierStore.entrySet()) {
        writer.write(columnIdentifierStore.get(column.getKey()) + "\t");
      }
      writer.flush();

      String appender = "";
      for (Employee employee : list) {
        writer.write("\n");
        for (String column : columnIdentifierStore.keySet()) {
          if (column.equalsIgnoreCase("Id")) {
            writer.write(appender + employee.getId() + "\t");
          } else if (column.equalsIgnoreCase("FirstName")) {
            writer.write(appender + employee.getFirstName() + "\t");
          } else if (column.equalsIgnoreCase("LastName")) {
            writer.write(appender + employee.getLastName() + "\t");
          } else if (column.equalsIgnoreCase("Address")) {
            writer.write(appender + employee.getAddress() + "\t");
          } else if (column.equalsIgnoreCase("City")) {
            writer.write(appender + employee.getCity() + "\t");
          } else if (column.equalsIgnoreCase("PhoneNumber")) {
            writer.write(appender + employee.getPhoneNumber() + "\t");
          } else if (column.equalsIgnoreCase("Email")) {
            writer.write(appender + employee.getEmail() + "\t");
          } else if (column.equalsIgnoreCase("Department")) {
            writer.write(appender + employee.getDepartment() + "\t");
          }
        }
        writer.flush();
      }
    }
  }

  private Map<String, String> columnIdentifierExtractor() {
    FileUtility utility = new FileUtility();
    String columnExtractor = Resources.getResource("ColumnExtractor.txt").getFile();
    return utility.parseConfigFile(columnExtractor);
  }
}
