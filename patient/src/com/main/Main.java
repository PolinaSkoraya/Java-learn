package com.main;

import patient.Diagnoses;
import patient.Patient;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Patient patient1 = new Patient ("Skoraya", "Polina", "Nikolaevna", "adress", "232323");
        System.out.println (patient1);

        Patient [] patients = new Patient[5];
        for (int i = 0; i < 5; i++) {
            patients[i] = new Patient ();
        }

        System.out.println ("Array of patients: ");
        for (Patient patient : patients) {
            System.out.println (patient);
        }

        ArrayList<Patient> selectedPatients = Patient.getPatientsByCardNumber (patients, 100, 500);
        System.out.println ("--------------------------------------------------------");
        System.out.println ("patients with medical card number between 100 and 500:");
        System.out.println (selectedPatients);

        ArrayList<Patient> selectedPatients1 = Patient.getPatientsByDiagnosis (patients, Diagnoses.BRONCHITIS);
        System.out.println ("--------------------------------------------------------");
        System.out.println ("patients with bronchitis:");
        System.out.println (selectedPatients1);
    }
}
