package com.dgzgroup.bulkupload;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CsvToJSONTransformer extends AbstractMessageTransformer {
	
	private List<BulkItem> itemsList;
	
	private static final String[] FIELD_MAPPING = new String[] { 
        "policyNum",                   // simple field mapping (like CsvBeanReader)
        "policyName",          // as above
        "primaryEmail", // indexed (first element) + deep mapping
        "secondaryEmail",
        "accountNum"
        };

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		this.itemsList = new ArrayList<BulkItem>();
		
		final CellProcessor[] processors = new CellProcessor[] { 
                new NotNull(), // policyNum
                new NotNull(), // policyName
                new NotNull(), // primaryEmail
                new Optional(), //secondaryEmail
                new Optional()	//accountNum
               
        };
		
		System.out.println("payload is : " + message.getPayload());
		
		ICsvDozerBeanReader beanReader = null;
		
		try {
			
			beanReader = new CsvDozerBeanReader(new StringReader(message.getPayloadAsString()), CsvPreference.STANDARD_PREFERENCE);
			beanReader.getHeader(true); // ignore the header
	        beanReader.configureBeanMapping(BulkItem.class, FIELD_MAPPING);
	        
	        BulkItem bulkItem;
            while( (bulkItem = beanReader.read(BulkItem.class, processors)) != null ) {
            	
                    System.out.println(String.format("lineNo=%s, rowNo=%s, surveyResponse=%s", beanReader.getLineNumber(),
                            beanReader.getRowNumber(), bulkItem));
                    
                    this.itemsList.add(bulkItem);
                    
            }
            
            message.setPayload(this.itemsList);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return message;
		
	}

}
