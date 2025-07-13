package ui;

import model.Doctor;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class UIDoctorMenu {
   static Scanner scanner = new Scanner(System.in);
   static ArrayList<Doctor> doctorAvailableAppointments = new ArrayList<>();
    public static void showDoctorMenu(){
        int option = 0;
        do{
            System.out.println("\n\n:: DOCTOR MENU");
            System.out.println("Welcome Dr. " + UiMenu.doctorLogged.getName());
            System.out.println("""
                    1. Add available appointment.
                    2. My Scheduled appointment.
                    0. Logout.
                    """);

            option = Integer.valueOf(scanner.nextLine());

            switch (option){
                case 1:
                    option = 0;
                    showAddAvailableAppointment();
                    break;
                case 2:
                    option = 0;
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
                default:
            }
        }while(option != 0);
    }
    private static void showAddAvailableAppointment(){
        int option = 0;
        do {
            System.out.println("::Add available appointment");
            System.out.println("Chose a month");

            ArrayList<Month> months = new ArrayList<>(Arrays.asList(Month.values()));

            for (int i = 0; i < 3 ; i++) {
                int j = i + 1;
                System.out.println(j + ". " + months.get(i));
            }
            System.out.println("0. Return");

            option = Integer.valueOf(scanner.nextLine());

            if(option > 0 && option < 4){
                //1,2,3
                int monthSelected = option;
                System.out.println(monthSelected + ". " + months.get(monthSelected-1));

                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = scanner.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(scanner.nextLine());
                if(responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = scanner.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(scanner.nextLine());
                }while (responseTime == 2);
                UiMenu.doctorLogged.addAppointment(date, time);
                checkDotorAvailableAppointment(UiMenu.doctorLogged);

            } else if (option == 0) {
                showDoctorMenu();
            }

        }while(option != 0);
    }

    public static void checkDotorAvailableAppointment(Doctor doctor){
        if(!doctor.getAvailableAppointments().isEmpty() && !doctorAvailableAppointments.contains(doctor)){
            doctorAvailableAppointments.add(doctor);
        }
    }
}
