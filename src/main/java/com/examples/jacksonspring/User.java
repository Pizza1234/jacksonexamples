package com.examples.jacksonspring;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

  public User(Long id, String firstname, String lastname, String email, String address, String postalCode, String city, String country) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.address = address;
    this.postalCode = postalCode;
    this.city = city;
    this.country = country;
  }

  @JsonView(View.Summary.class)
  private Long id;

  @JsonView(View.Summary.class)
  private String firstname;

  @JsonView(View.Summary.class)
  private String lastname;

  private String email;
  private String address;
  private String postalCode;
  private String city;
  private String country;
}
