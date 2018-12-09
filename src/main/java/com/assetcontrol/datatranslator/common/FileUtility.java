package com.assetcontrol.datatranslator.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The utility class for reading the column and data identifiers.
 */
public class FileUtility {

  private static final Logger logger = LoggerFactory.getLogger(FileUtility.class);

  /**
   * Method which reads the input file.
   *
   * @param fileName
   * @return map of key and value
   */
  public Map<String, String> parseConfigFile(String fileName) {
    Map<String, String> map;
    map = new LinkedHashMap<>();
    String lineJustFetched = null;

    try (BufferedReader buf = new BufferedReader(new FileReader(fileName))) {
      while (true) {
        lineJustFetched = buf.readLine();
        if (lineJustFetched == null) {
          break;
        } else {
          String[] columnIdentifiers = lineJustFetched.split("\t");
          map.put(columnIdentifiers[0], columnIdentifiers[1]);
        }
      }
    } catch ( IOException e) {
      logger.warn(e.getMessage());
    }
    return map;
  }

}
