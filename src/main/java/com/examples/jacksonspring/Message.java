package com.examples.jacksonspring;

import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Message {

  @JsonView(View.Summary.class)
  private Long id;

  @JsonView(View.Summary.class)
  private LocalDate created;

  @JsonView(View.Summary.class)
  private String title;

  @JsonView(View.Summary.class)
  private User author;

  private List<User> recipients;

  private String body;

  public Message() {
    this.created = LocalDate.now();
  }

  public Message(Long id, String title, String body, User author, User... recipients) {
    this();
    this.id = id;
    this.title = title;
    this.body = body;
    this.author = author;
    this.recipients = Arrays.asList(recipients);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getCreated() {
    return created;
  }

  public void setCreated(LocalDate created) {
    this.created = created;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public List<User> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<User> recipients) {
    this.recipients = recipients;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}