package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality;
    private ArrayList<availableAppointment>availableAppointments = new ArrayList<>();
    public  Doctor(String name, String email, String speciality){
        super(name, email);
        System.out.println("\n ::DOCTOR");
        System.out.println("The assigned doctor's name is " + name);
        this.speciality = speciality;
    }
    public  Doctor(String name, String email){
        super(name, email);
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public static class availableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public availableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
          return date;
      }
        public String getDate() {
            return format.format(date);
        }

      public void setDate(Date date) {
          this.date = date;
      }

      public String getTime() {
          return time;
      }

      public void setTime(String time) {
          this.time = time;
      }

        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime: " + time;
        }
  }
  public void addAppointment(String date, String time){
      getAvailableAppointments().add(new Doctor.availableAppointment(date,time));
  }
  public ArrayList<availableAppointment> getAvailableAppointments(){
      return availableAppointments;
  }
  public void showAvailableAppointment(){
      for(Doctor.availableAppointment aA : this.getAvailableAppointments()){
          System.out.println(aA.getDate() + " " + aA.getTime());
      }
  }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + getSpeciality() + "\nAvailable: " + getAvailableAppointments().toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Employee of hospital: Cruz Roja");
        System.out.println("Department: Oncologist");
    }
}
