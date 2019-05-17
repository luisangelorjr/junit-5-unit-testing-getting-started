package patientintake;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {

	private static ClinicCalendar calendar;

	public static void main(String[] args) throws Throwable {
		calendar = new ClinicCalendar();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Patient Intake Computer System\n\n");

		String lastOption = "";

		while (!lastOption.equalsIgnoreCase("x")) {
			lastOption = displayMenu(sc);
		}
		System.out.println("\nExiting System...\n");
	}

	private static String displayMenu(Scanner sc) throws Throwable {
		System.out.println("Please select an option: ");
		System.out.println("1. Enter a Patient Appoitment");
		System.out.println("2. View All Appoitments");
		System.out.println("X. Exit System.");
		System.out.print("Option: ");

		String option = sc.next();

		switch (option) {
		case "1":
			performPatientEntry(sc);
			return option;
		case "2":
			performAllAppointments();
			return option;
		default:
			System.out.println("Invalid option, please re-enter.");
			return option;
		}
	}

	private static void performAllAppointments() throws Throwable {
		System.out.println("\n\n All Appointments in System: ");

		for (PatientAppointment appointment : calendar.getAppointments()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyy hh:mm a");
			String apptTime = formatter.format(appointment.getAppointmentDateTime());

			System.out.println(String.format("%s: %s, %s \t\tDoctor: %s", apptTime, appointment.getPatientLastName(),
					appointment.getPatientFirstName(), appointment.getDoctor().getName()));
		}

	}

	private static void performPatientEntry(Scanner sc) throws Throwable {
		sc.nextLine();
		System.out.println("\n\nPlease Enter Appointment Info: ");
		System.out.print("   Patient Last Name: ");
		String lastName = sc.nextLine();
		System.out.print("   Patient First Name: ");
		String firstName = sc.nextLine();
		System.out.print("   Appointment Date (M/d/yyyy h:m a): ");
		String when = sc.nextLine();
		System.out.println("   Doctor Last Name: ");
		String doc = sc.nextLine();
		
		try {
			calendar.addAppointments(firstName, lastName, doc, when);
		 } catch (Throwable t){
			 System.out.println("Error! " + t.getMessage());
			 return;
	 	}	
	}
}
