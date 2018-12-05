package com.assetcontrol.datatranslator.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.assetcontrol.datatranslator.model.ColumnExtractor;

public class ColumnExtractResultSetMapper implements FieldSetMapper<ColumnExtractor> {

  @Override
  public ColumnExtractor mapFieldSet(final FieldSet fieldSet) throws BindException {
    ColumnExtractor columnExtractor = new ColumnExtractor();
    columnExtractor.setOriginalLabel(fieldSet.readString(0));
    columnExtractor.setRenamedLabel(fieldSet.readString(1));
    return columnExtractor;
  }
}
