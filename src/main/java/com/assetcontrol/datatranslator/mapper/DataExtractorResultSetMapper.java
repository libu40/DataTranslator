package com.assetcontrol.datatranslator.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.assetcontrol.datatranslator.model.DataExtractor;

public class DataExtractorResultSetMapper implements FieldSetMapper<DataExtractor> {
  @Override
  public DataExtractor mapFieldSet(final FieldSet fieldSet) throws BindException {

    DataExtractor dataExtractor = new DataExtractor();
    dataExtractor.setOriginalId(fieldSet.readLong(0));
    dataExtractor.setRenamedId(fieldSet.readLong(1));
    return dataExtractor;
  }
}
