package com.assetcontrol.datatranslator.model;

public class DataExtractor {

  private long originalId;
  private long renamedId;

  public long getOriginalId() {
    return originalId;
  }

  public void setOriginalId(final long originalId) {
    this.originalId = originalId;
  }

  public long getRenamedId() {
    return renamedId;
  }

  public void setRenamedId(final long renamedId) {
    this.renamedId = renamedId;
  }
}
