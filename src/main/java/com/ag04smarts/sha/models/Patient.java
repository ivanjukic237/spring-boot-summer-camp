package com.ag04smarts.sha.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Model of a patient with attributes: first name, last name, name of the therapy used on the patient,
 * date of birth, sex and SSN (Social Security Number). This class is used as an entity.
 *
 * @Author Ivan Jukić
 */

@Entity
@Table(name ="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name="First_Name")
    private String firstName;
    @Column(name="Last_Name")
    private String lastName;
    @Column(name="Therapy")
    private String therapy;
    @Column(name="Date_Of_Birth")
    private LocalDate dateOfBirth;
    @Column(name="Sex")
    private String sex;
    @Column(name="SSN", unique = true)
    private Long SSN;

    /**
     * Default constructor for Patient;
     */

    public Patient(){
    }

    /**
     * Constructor for the patient model.
     *
     * @param firstName   first name of the patient
     * @param lastName    last name of the patient
     * @param therapy     therapy used on the patient
     * @param dateOfBirth date of birth of the patient
     * @param sex         sex of the patient
     * @param SSN         Social Security Number of the patient
     */

    public Patient(String firstName, String lastName, String therapy, LocalDate dateOfBirth, String sex, Long SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.therapy = therapy;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.SSN = SSN;
    }

    /**
     * Setter for the patient id.
     * @param id patient id
     */

    public void setId(Long id){
        this.id = id;
    }

    /**
     * Getter for the patient id.
     *
     * @return patient id
     */

    public long getId() {
        return id;
    }

    /**
     * Getter for the first name of the patient.
     *
     * @return the first name of the patient
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the first name of the patient.
     *
     * @param firstName first name of the patient
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the last name of the patient.
     *
     * @return the last name of the patient
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last name of the patient.
     *
     * @param lastName last name of the patient
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the therapy of the patient.
     *
     * @return name of the therapy
     */

    public String getTherapy() {
        return therapy;
    }

    /**
     * Setter for the name of the therapy of the patient.
     *
     * @param therapy therapy of the patient
     */

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    /**
     * Getter for the date of birth of the patient.
     *
     * @return date of birth of the patient
     */

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter for the date of birth of the patient.
     *
     * @param dateOfBirth date of birth of the patient
     */

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter for the sex of the patient.
     *
     * @return the sex of the patient
     */

    public String getSex() {
        return sex;
    }

    /**
     * Setter for the sex of the patient.
     *
     * @param sex the sex of the patient
     */

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter for the Social Security Number of the patient.
     *
     * @return Social Security Number of the patient
     */

    public Long getSSN() {
        return SSN;
    }

    /**
     * Setter for the Social Security Number of the patient.
     *
     * @param SSN Social Security Number of the patient.
     */

    public void setSSN(Long SSN) {
        this.SSN = SSN;
    }

    /**
     * {@inheritdoc}
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        return SSN != null ? SSN.equals(patient.SSN) : patient.SSN == null;
    }

    /**
     * {@inheritdoc}
     */

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (therapy != null ? therapy.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (SSN != null ? SSN.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritdoc}
     */

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", therapy='" + therapy + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                ", SSN=" + SSN +
                '}';
    }
}
