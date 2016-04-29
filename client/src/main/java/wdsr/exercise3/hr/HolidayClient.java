package wdsr.exercise3.hr;

import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.soap.SOAPFaultException;

// TODO Complete this class to book holidays by issuing a request to Human Resource web service.
// In order to see definition of the Human Resource web service:
// 1. Run HolidayServerApp.
// 2. Go to http://localhost:8090/holidayService/?wsdl
public class HolidayClient {
	/**
	 * Creates this object
	 * @param wsdlLocation URL of the Human Resource web service WSDL
	 */
	
	private HumanResourceService service; 
	private HumanResource hr;
	
	public HolidayClient(URL wsdlLocation) {
		service = new HumanResourceService(wsdlLocation);
		hr = service.getHumanResourcePort();
	}
	
	/**
	 * Sends a holiday request to the HumanResourceService.
	 * @param employeeId Employee ID
	 * @param firstName First name of employee
	 * @param lastName Last name of employee
	 * @param startDate First day of the requested holiday
	 * @param endDate Last day of the requested holiday
	 * @return Identifier of the request, if accepted.
	 * @throws ProcessingException if request processing fails.
	 */
	public int bookHoliday(int employeeId, String firstName, String lastName, Date startDate, Date endDate) throws ProcessingException {
		EmployeeType employee = new EmployeeType();
		HolidayType holiday = new HolidayType();
		employee.setNumber(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(startDate);
			holiday.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
			c.setTime(endDate);
			holiday.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		HolidayRequest request = new HolidayRequest();
		request.setEmployee(employee);
		request.setHoliday(holiday);
		try{
			return hr.holiday(request).getRequestId();
		}catch(SOAPFaultException e){
			throw new ProcessingException();
		}
	}
}
