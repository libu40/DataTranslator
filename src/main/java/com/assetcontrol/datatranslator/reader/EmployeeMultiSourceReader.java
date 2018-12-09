package com.assetcontrol.datatranslator.reader;

import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamReader;

/**
 * This is the reader class which is used to read the file.
 */
public class EmployeeMultiSourceReader implements ItemReader, ItemStream {

  private List<ItemStreamReader> delegates;
  private int currentSource = 0;

  /**
   * This method is used to read the data from the input file and send to processor
   * @return employee
   * @throws Exception
   */
  @Override
  public Object read() throws Exception {
    while (currentSource < delegates.size()) {
      ItemStreamReader itemStreamReader = delegates.get(currentSource);
      Object employee = itemStreamReader.read();
      if (employee == null) {
        delegates.get(currentSource).close();
        currentSource++;
      } else {
        return employee;
      }
    }
    return null;
  }

  @Override
  public void open(final ExecutionContext executionContext) {
    for (ItemStreamReader reader : delegates) {
      reader.open(executionContext);
    }
  }

  @Override
  public void update(final ExecutionContext executionContext) {

  }

  @Override
  public void close() {

  }

  public void setDelegates(final List<ItemStreamReader> delegates) {
    this.delegates = delegates;
  }
}
