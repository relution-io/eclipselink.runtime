/*******************************************************************************
 * Copyright (c) 2011, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *    Denise Smith - February 20, 2013
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.xmlschematype;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XSDSchemaTypesTestCases extends JAXBWithJSONTestCases{
	
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlschematype/xsdtypes.xml";
    private final static String XML_WRITE_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlschematype/xsdtypeswrite.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlschematype/xsdtypes.json";
    private final static String JSON_WRITE_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlschematype/xsdtypeswrite.json";

	public XSDSchemaTypesTestCases(String name) throws Exception {
	    super(name);
	    setControlDocument(XML_RESOURCE);  
	    setControlJSON(JSON_RESOURCE);
	    setControlJSON(JSON_WRITE_RESOURCE);
	    setWriteControlDocument(XML_WRITE_RESOURCE);
	    Class[] classes = new Class[1];
	    classes[0] = XSDTypesHolder.class;
	    setClasses(classes);
	}

	@Override
	protected Object getControlObject() {	
		try { 
    		DatatypeFactory factory = DatatypeFactory.newInstance();
		
		    XSDTypesHolder holder = new XSDTypesHolder();
		    holder.things = new ArrayList();
		    holder.things.add(new BigInteger("10"));
		    holder.things.add(new BigInteger("10"));
		    holder.things.add(new BigInteger("-10"));
		    holder.things.add(new BigInteger("10"));		    
     		
		    XMLGregorianCalendar cal = factory.newXMLGregorianCalendar();
	    	cal.setMonth(10);
		    holder.things.add(cal);
		    
		    cal = factory.newXMLGregorianCalendar();
		    cal.setDay(10);
		    holder.things.add(cal);
		    
		    cal = factory.newXMLGregorianCalendar();
		    cal.setMonth(10);
		    cal.setDay(10);
		    holder.things.add(cal);
		    
		    cal = factory.newXMLGregorianCalendar();
		    cal.setYear(2013);		    
		    holder.things.add(cal);
		    
		    cal = factory.newXMLGregorianCalendar();
		    cal.setMonth(10);
		    cal.setYear(2013);
		    holder.things.add(cal);
		    
		    Duration dur =  factory.newDuration("PT130S");
		    holder.things.add(dur);
		    
		    String s = "this is a test";
		    holder.things.add(s);
		    
		    holder.things.add("abc".getBytes());
		    
		    return holder;
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		return null;
		
	}
}