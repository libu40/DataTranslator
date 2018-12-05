package com.assetcontrol.datatranslator.listener;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class EmployeeJobListener implements JobExecutionListener {

  private DateTime startTime, stopTime;

  @Override
  public void beforeJob(final JobExecution jobExecution) {
    startTime = new DateTime();
  }

  @Override
  public void afterJob(final JobExecution jobExecution) {
    stopTime = new DateTime();

    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      //Here you can perform some other business logic like cleanup
    } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
      List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
      for (Throwable th : exceptionList) {
      }
    }
  }

  private long getTimeInMillis(DateTime start, DateTime stop) {
    return stop.getMillis() - start.getMillis();
  }
}
