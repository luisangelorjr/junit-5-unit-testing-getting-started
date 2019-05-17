package patientintake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class ClinicCalendarTest {

	@Test
	public void allowEntryOfAnAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointments("Luis", "Angelo", "avery", "1/06/1992 11:30 am");
		List<PatientAppointment> appointments = calendar.getAppointments();	
		
		assertNotNull(appointments);
		assertEquals(1, appointments.size());
		
		
		
	}
}