package wdsr.exercise3.hr;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hr.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hr.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HolidayRequest }
     * 
     */
    public HolidayRequest createHolidayRequest() {
        return new HolidayRequest();
    }

    /**
     * Create an instance of {@link HolidayType }
     * 
     */
    public HolidayType createHolidayType() {
        return new HolidayType();
    }

    /**
     * Create an instance of {@link EmployeeType }
     * 
     */
    public EmployeeType createEmployeeType() {
        return new EmployeeType();
    }

    /**
     * Create an instance of {@link HolidayResponse }
     * 
     */
    public HolidayResponse createHolidayResponse() {
        return new HolidayResponse();
    }

}