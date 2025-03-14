import java.util.*;

class Patient {
    String id, name;
    int age;
    Patient(String id, String name, int age) {
        this.id = id; this.name = name; this.age = age;
    }
    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

class Appointment {
    String id, doctor;
    Patient patient;
    Date date;
    Appointment(String id, Patient patient, String doctor, Date date) {
        this.id = id; this.patient = patient; this.doctor = doctor; this.date = date;
    }
    @Override
    public String toString() {
        return "Appointment ID: " + id + ", Patient: " + patient.name + ", Doctor: " + doctor + ", Date: " + date;
    }
}

class EHR {
    String id, diagnosis, treatment;
    Patient patient;
    EHR(String id, Patient patient, String diagnosis, String treatment) {
        this.id = id; this.patient = patient; this.diagnosis = diagnosis; this.treatment = treatment;
    }
    @Override
    public String toString() {
        return "EHR ID: " + id + ", Patient: " + patient.name + ", Diagnosis: " + diagnosis + ", Treatment: " + treatment;
    }
}

class Billing {
    String id;
    Patient patient;
    double amount;
    Billing(String id, Patient patient, double amount) {
        this.id = id; this.patient = patient; this.amount = amount;
    }
    @Override
    public String toString() {
        return "Billing ID: " + id + ", Patient: " + patient.name + ", Amount: $" + amount;
    }
}

class MedicalSupply {
    String id, name;
    int quantity;
    MedicalSupply(String id, String name, int quantity) {
        this.id = id; this.name = name; this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Supply ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class Staff {
    String id, name, role;
    Staff(String id, String name, String role) {
        this.id = id; this.name = name; this.role = role;
    }
    @Override
    public String toString() {
        return "Staff ID: " + id + ", Name: " + name + ", Role: " + role;
    }
}

public class HospitalManagementSystem {
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<EHR> ehrs = new ArrayList<>();
    static List<Billing> bills = new ArrayList<>();
    static List<MedicalSupply> supplies = new ArrayList<>();
    static List<Staff> staffs = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Add EHR");
            System.out.println("4. Add Billing");
            System.out.println("5. Add Medical Supply");
            System.out.println("6. Add Staff");
            System.out.println("7. View All Data");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    addEHR();
                    break;
                case 4:
                    addBilling();
                    break;
                case 5:
                    addMedicalSupply();
                    break;
                case 6:
                    addStaff();
                    break;
                case 7:
                    viewAllData();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        patients.add(new Patient(id, name, age));
        System.out.println("Patient added successfully!");
    }

    static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        Date date = new Date(); // Current date
        appointments.add(new Appointment(id, patient, doctor, date));
        System.out.println("Appointment scheduled successfully!");
    }

    static void addEHR() {
        System.out.print("Enter EHR ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();
        ehrs.add(new EHR(id, patient, diagnosis, treatment));
        System.out.println("EHR added successfully!");
    }

    static void addBilling() {
        System.out.print("Enter Billing ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        bills.add(new Billing(id, patient, amount));
        System.out.println("Billing added successfully!");
    }

    static void addMedicalSupply() {
        System.out.print("Enter Supply ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Supply Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        supplies.add(new MedicalSupply(id, name, quantity));
        System.out.println("Medical Supply added successfully!");
    }

    static void addStaff() {
        System.out.print("Enter Staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Staff Role: ");
        String role = scanner.nextLine();
        staffs.add(new Staff(id, name, role));
        System.out.println("Staff added successfully!");
    }

    static void viewAllData() {
        System.out.println("\n===== Patients =====");
        patients.forEach(System.out::println);

        System.out.println("\n===== Appointments =====");
        appointments.forEach(System.out::println);

        System.out.println("\n===== EHRs =====");
        ehrs.forEach(System.out::println);

        System.out.println("\n===== Billings =====");
        bills.forEach(System.out::println);

        System.out.println("\n===== Medical Supplies =====");
        supplies.forEach(System.out::println);

        System.out.println("\n===== Staff =====");
        staffs.forEach(System.out::println);
    }

    static Patient findPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.id.equals(id)) {
                return patient;
            }
        }
        return null;
    }
}