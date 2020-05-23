package patient;

import java.util.ArrayList;
import java.util.Random;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phone;
    private int medicalCardNumber;
    private Diagnoses diagnosis;

    public Patient() {
        this.id = getRandom ();
        this.medicalCardNumber = getRandom (100, 900);
        this.diagnosis = Diagnoses.getRandomDiagnosis ();
        this.phone = "+375 29 " + getRandom (10000000, 90000000);
    }

    public Patient (String surname, String name, String patronymic, String address, String phone, Diagnoses diagnosis) {
        this.id = getRandom ();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = getRandom (100, 900);
        this.diagnosis = diagnosis;
    }

    public Patient(String surname, String name, String patronymic, String address, String phone) {
        this.id = getRandom ();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = getRandom (100, 900);
    }

    private int getRandom () {
        Random random = new Random ();
        return (1000000 + random.nextInt(1000000));
    }

    public static int getRandom (int from, int to) {
        Random random = new Random ();
        return (from + random.nextInt(to - from));
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(int medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public Diagnoses getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnoses diagnosis) {
        this.diagnosis = diagnosis;
    }

    public static ArrayList<Patient> getPatientsByCardNumber (Patient[] patients, int from, int to) {
        ArrayList<Patient> selectedPatients = new ArrayList<> ();
        for (Patient patient : patients) {
            if (patient.medicalCardNumber > from && patient.medicalCardNumber < to) {
                selectedPatients.add (patient);
            }
        }
        return selectedPatients;
    }

    public static ArrayList<Patient> getPatientsByDiagnosis (Patient[] patients, Diagnoses diagnosis) {
        ArrayList<Patient> selectedPatients = new ArrayList<> ();
        for (Patient patient : patients) {
            if (patient.diagnosis == diagnosis) {
                selectedPatients.add (patient);
            }
        }
        return selectedPatients;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", Surname='" + surname + '\'' +
                ", Name='" + name + '\'' +
                ", Patronymic='" + patronymic + '\'' +
                ", Address='" + address + '\'' +
                ", Phone='" + phone + '\'' +
                ", MedicalCardNumber=" + medicalCardNumber +
                ", Diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
