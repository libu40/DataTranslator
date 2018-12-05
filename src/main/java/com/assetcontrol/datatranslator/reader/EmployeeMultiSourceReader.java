package com.assetcontrol.datatranslator.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.ItemStreamReader;

import java.util.List;

public class EmployeeMultiSourceReader implements ItemReader, ItemStream {

  private List<ItemStreamReader> delegates;
  private int currentSource = 0;

  @Override
  public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    while (currentSource < delegates.size()) {
      ItemStreamReader itemStreamReader = delegates.get(currentSource);
      Object obj = itemStreamReader.read();
      if (obj == null) {
        delegates.get(currentSource).close();
        currentSource++;
      } else {
        return obj;
      }
    }
    return null;
  }

  @Override
  public void open(final ExecutionContext executionContext) throws ItemStreamException {
    for (ItemStreamReader reader : delegates) {
      reader.open(executionContext);
    }
  }

  @Override
  public void update(final ExecutionContext executionContext) throws ItemStreamException {

  }

  @Override
  public void close() throws ItemStreamException {

  }

  public void setDelegates(final List<ItemStreamReader> delegates) {
    this.delegates = delegates;
  }
}
