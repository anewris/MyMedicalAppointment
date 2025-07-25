package model;

public abstract class User {
    static int id = 0;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    protected User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 10){
            System.out.println("\nTHE PHONE NUMBER MUST HAS 8 DIGITS");
        }else{
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "model.User: " + name + ", Email: " + email + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }
    public abstract void showDataUser();
}
