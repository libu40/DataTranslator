package com.assetcontrol.datatranslator.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.assetcontrol.datatranslator.model.Employee;


public class EmployeeDataWriter implements ItemWriter<Employee> {

  @Override
  public void write(final List<? extends Employee> list) throws Exception {

  }
}
