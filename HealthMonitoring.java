import java.util.*;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private List<String> medicalHistory;
    private List<String> appointments;
    
    public Patient(String name, int age, String gender, String contactNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.medicalHistory = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContactNumber() { return contactNumber; }
    
    public void addMedicalHistory(String report) {
        medicalHistory.add(report);
    }
    
    public List<String> getMedicalHistory() {
        return medicalHistory;
    }
    
    public void addAppointment(String appointment) {
        appointments.add(appointment);
    }
    
    public List<String> getAppointments() {
        return appointments;
    }
    
    public void displayPatientInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Number: " + contactNumber);
    }
    
    public void displayMedicalHistory() {
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical history available.");
        } else {
            for (String report : medicalHistory) {
                System.out.println("- " + report);
            }
        }
    }
    
    public void displayLatestReportSummary() {
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical reports available.");
        } else {
            System.out.println("Latest Report Summary: " + medicalHistory.get(medicalHistory.size() - 1));
        }
    }
}

class HealthMonitoringSystem {
    private Map<String, Patient> patients;
    
    public HealthMonitoringSystem() {
        patients = new HashMap<>();
    }
    
    public void addPatient(Patient patient) {
        patients.put(patient.getContactNumber(), patient);
    }
    
    public Patient getPatient(String contactNumber) {
        return patients.get(contactNumber);
    }
    
    public void generateReport(String contactNumber, String report) {
        Patient patient = patients.get(contactNumber);
        if (patient != null) {
            patient.addMedicalHistory(report);
            System.out.println("Report added successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }
    
    public void displayPatientRecords(String contactNumber) {
        Patient patient = patients.get(contactNumber);
        if (patient != null) {
            patient.displayPatientInfo();
            System.out.println("Medical History:");
            patient.displayMedicalHistory();
        } else {
            System.out.println("Patient not found!");
        }
    }
    
    public void notifyScheduledCheckups() {
        System.out.println("Sending notifications for scheduled checkups...");
        for (Patient patient : patients.values()) {
            System.out.println("Notification sent to " + patient.getName() + " at " + patient.getContactNumber());
        }
    }
    
    public void scheduleAppointment(String contactNumber, String appointmentDetails) {
        Patient patient = patients.get(contactNumber);
        if (patient != null) {
            patient.addAppointment(appointmentDetails);
            System.out.println("Appointment scheduled successfully for " + patient.getName());
        } else {
            System.out.println("Patient not found!");
        }
    }
    
    public void sendEmergencyAlert(String contactNumber, String alertMessage) {
        Patient patient = patients.get(contactNumber);
        if (patient != null) {
            System.out.println("EMERGENCY ALERT: " + alertMessage + " sent to " + patient.getName() + " at " + patient.getContactNumber());
        } else {
            System.out.println("Patient not found!");
        }
    }
    
    public void provideHealthTips(String contactNumber) {
        Patient patient = patients.get(contactNumber);
        if (patient != null) {
            System.out.println("Health Tips for " + patient.getName() + ":");
            if (patient.getAge() > 50) {
                System.out.println("- Maintain a balanced diet with calcium and Vitamin D.");
                System.out.println("- Engage in moderate exercise like walking.");
            } else {
                System.out.println("- Stay active with regular physical activity.");
                System.out.println("- Ensure adequate hydration and a balanced diet.");
            }
            if (patient.getGender().equalsIgnoreCase("Female")) {
                System.out.println("- Regular health checkups, especially for bone density and cardiovascular health.");
            }
        } else {
            System.out.println("Patient not found!");
        }
    }
    public void displayLatestReportSummary(String contactNumber) {
        Patient patient = patients.get(contactNumber);
        if (patient != null) {
            patient.displayLatestReportSummary();
        } else {
            System.out.println("Patient not found!");
        }
    }
}

public class HealthMonitoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HealthMonitoringSystem system = new HealthMonitoringSystem();
        
        while (true) {
            System.out.println("\n--- Automatic Health Monitoring System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Generate Report");
            System.out.println("3. Display Patient Records");
            System.out.println("4. Notify Scheduled Checkups");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. Send Emergency Alert");
            System.out.println("7. Provide Health Tips");
            System.out.println("8. Display Latest Report Summary");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    Patient newPatient = new Patient(name, age, gender, contactNumber);
                    system.addPatient(newPatient);
                    System.out.println("Patient added successfully!");
                    break;
                
                case 2:
                    System.out.print("Enter patient's contact number: ");
                    String patientNumber = scanner.nextLine();
                    System.out.print("Enter diagnosis report: ");
                    String report = scanner.nextLine();
                    system.generateReport(patientNumber, report);
                    break;
                
                case 3:
                    System.out.print("Enter patient's contact number: ");
                    String searchNumber = scanner.nextLine();
                    system.displayPatientRecords(searchNumber);
                    break;
                
                case 4:
                    system.notifyScheduledCheckups();
                    break;
                
                case 5:
                    System.out.print("Enter patient's contact number: ");
                    String appointmentNumber = scanner.nextLine();
                    System.out.print("Enter appointment details: ");
                    String appointmentDetails = scanner.nextLine();
                    system.scheduleAppointment(appointmentNumber, appointmentDetails);
                    break;
                
                case 6:
                    System.out.print("Enter patient's contact number: ");
                    String alertNumber = scanner.nextLine();
                    System.out.print("Enter emergency alert message: ");
                    String alertMessage = scanner.nextLine();
                    system.sendEmergencyAlert(alertNumber, alertMessage);
                    break;
                
                case 7:
                    System.out.print("Enter patient's contact number: ");
                    String tipsNumber = scanner.nextLine();
                    system.provideHealthTips(tipsNumber);
                    break;
                
                case 8:
                    System.out.print("Enter patient's contact number: ");
                    String summaryNumber = scanner.nextLine();
                    system.displayLatestReportSummary(summaryNumber);
                    break;
                
                case 9:
                    System.out.println("Exiting the system.");
                    return;
                
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
