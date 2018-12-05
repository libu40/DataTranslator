package com.assetcontrol.datatranslator.model;

import java.io.Serializable;

public class ColumnExtractor implements Serializable {

  private String originalLabel;

  private String renamedLabel;

  public String getOriginalLabel() {
    return originalLabel;
  }

  public void setOriginalLabel(final String originalLabel) {
    this.originalLabel = originalLabel;
  }

  public String getRenamedLabel() {
    return renamedLabel;
  }

  public void setRenamedLabel(final String renamedLabel) {
    this.renamedLabel = renamedLabel;
  }
}
