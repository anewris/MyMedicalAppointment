package ui;

import model.Doctor;
import model.Patient;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {
    public static final  String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August","September","October", "November", "December"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        System.out.println("\n\nWELCOME TO MEDICAL APPOINTMENT");
        System.out.println("Chose an option");

        int option = 0;

        do{
            System.out.println("""
                    1. DOCTOR
                    2. PATIENT
                    0. OUT
                    """);
            Scanner sc = new Scanner(System.in);
            option = Integer.parseInt(sc.nextLine());

            switch(option){
                case 1 :
                    option = 0;
                    System.out.println("::DOCTOR");
                    authUser(1);
                    break;
                case 2 :
                    option = 0;
                    System.out.println("\n::PATIENT");
                    authUser(2);
                    break;
                case 0 :
                    System.out.println("\nTHANK YOU FOR VISITING");
                    break;
                default:
                    System.out.println("\nINVALID CHOICE");
            }
        }while(option != 0);

    }
    public static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor("Jose", "jose@gmail.com"));
        doctors.add(new Doctor("Lucas", "lucas@gmail.com"));
        doctors.add(new Doctor("Marcos", "marcos@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<Patient>();
        patients.add(new Patient("Kevin", "kevin@gmail.com"));
        patients.add(new Patient("Eduard", "eduard@gmail.com"));
        patients.add(new Patient("Daniel", "daniel@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("ingresar correo. ej: a@a.com");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1){
                for(Doctor doctor : doctors){
                    if (doctor.getEmail().equals(email)){
                        emailCorrect = true;
                        //get logged user
                        doctorLogged = doctor;
                        //show doctor menu
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2){
                for(Patient patient : patients){
                    if (patient.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = patient;
                        UiPatientMenu.showPatientMenu();
                    }
                }
            }

        }while(!emailCorrect);
    }
}
