package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UiPatientMenu {
    public static void showPatientMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("::PATIENT");
            System.out.println("Welcome: " + UiMenu.patientLogged.getName());
            System.out.println("""
                    1. Book an appointment.
                    2. My appointment.
                    0. Return.
                    """);

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointment();
                    break;
                case 2:
                    showPatientMyAppointment();
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
         }while(response != 0);
    }

    private static void showBookAppointment(){
        int response = 0;
        do{
            System.out.println("::BOOK AN APPOINTMENT");
            System.out.println(" - Select date");

            //Voy a mostrar todas las consultas disponibles mostrando sus fechas
            //Toda la informacion  la voy a guardar en este map
            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            //Este for es para recorrer las consultas disponibles del doctor...
            for (int i = 0; i < UIDoctorMenu.doctorAvailableAppointments.size(); i++) {
                //y guardarlas en este array para poder usarlas sin problemas
                ArrayList<Doctor.availableAppointment> availableAppointments
                        = UIDoctorMenu.doctorAvailableAppointments.get(i).getAvailableAppointments();

                //En este map es donde se va a guardad el indice y el doctor
                Map<Integer,Doctor> doctorAppointments = new TreeMap<>();
                /*Este for de abajo recorrera el array de arriba el cual estara recorriendo solo las consulta de
                * los doctores que si ingresaron sus consultas disponible con todo y sus fechas
                * */
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorAvailableAppointments.get(i));

                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.parseInt(sc.nextLine());
            Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for(Map.Entry<Integer,Doctor> doc:doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UiMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                showPatientMenu();
            }
        }while(response != 0);
    }
    private static void showPatientMyAppointment(){
        int response = 0;
        do{
            System.out.println("::My Appointment");
            if (UiMenu.patientLogged.getAppointmentDoctors().isEmpty()){
                System.out.println("Don't have appointments");
                break;
            }
            for (int i = 0; i < UiMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "Time: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\nDoctor: " + UiMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        }while(response != 0);
    }
}
