package com.assetcontrol.datatranslator.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The application main class for the execution.
 */
public class DataTranslatorApp {

  private static final Logger logger = LoggerFactory.getLogger(DataTranslatorApp.class);

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("employee-datatranslator-context.xml");
    JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
    Job job = (Job) context.getBean("employeeDataTranslatorJob");
    try {
      JobExecution execution = jobLauncher.run(job, new JobParameters());
      logger.info("The Job has been executed with the status"+execution.getStatus());
    } catch (JobExecutionException e) {
      logger.warn(e.getMessage());
    }
  }
}


