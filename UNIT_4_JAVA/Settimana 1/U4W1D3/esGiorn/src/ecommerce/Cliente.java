package ecommerce;

import java.util.Date;

public class Cliente {
    private String customerCode;
    private String firstName;
    private String lastName;
    private String email;
    private Date registrationDate;

    public Cliente(String customerCode, String firstName, String lastName, String email, Date registrationDate) {
        this.customerCode = customerCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void stampaCliente(){
        System.out.println(this.customerCode);
        System.out.println(this.firstName);
        System.out.println(this.lastName);
        System.out.println(this.email);
        System.out.println(this.registrationDate);
    }
}
