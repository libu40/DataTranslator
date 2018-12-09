package com.assetcontrol.datatranslator.listener;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * The listener class which depicts the status and execution time of job.
 */
public class EmployeeJobListener implements JobExecutionListener {

  private static final Logger logger = LoggerFactory.getLogger(EmployeeJobListener.class);

  private DateTime startTime;
  private DateTime stopTime;

  @Override
  public void beforeJob(final JobExecution jobExecution) {
    startTime = new DateTime();
  }

  @Override
  public void afterJob(final JobExecution jobExecution) {
    stopTime = new DateTime();

    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
    } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
      List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
      for (Throwable th : exceptionList) {
        logger.warn("The exception thrown after completing the job is",th.getMessage());
      }
    }
  }

  private long getTimeInMillis(DateTime start, DateTime stop) {
    return stop.getMillis() - start.getMillis();
  }
}
