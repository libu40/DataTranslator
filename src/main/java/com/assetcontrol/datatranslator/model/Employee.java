package com.assetcontrol.datatranslator.model;

import java.io.Serializable;
import java.util.Objects;


public class Employee implements Serializable {

  private long id;

  private String firstName;

  private String lastName;

  private String address;

  private String city;

  private long phoneNumber;

  private String email;

  private String department;

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(final String department) {
    this.department = department;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Employee employee = (Employee) o;
    return id == employee.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", phoneNumber=" + phoneNumber +
        ", email='" + email + '\'' +
        ", department='" + department + '\'' +
        '}';
  }
}
