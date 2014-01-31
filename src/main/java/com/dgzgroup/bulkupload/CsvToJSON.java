package com.dgzgroup.bulkupload;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class CsvToJSON implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage message = eventContext.getMessage();
		
		System.out.println("payload is : " + message.getPayload());
		
		return message;
	}

}
