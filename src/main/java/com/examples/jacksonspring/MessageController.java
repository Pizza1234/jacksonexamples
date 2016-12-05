package com.examples.jacksonspring;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

  @Autowired
  private MessageService messageService;

  @JsonView(View.Summary.class)
  @RequestMapping("/")
  public List<Message> getAllMessages() {
    return messageService.getAll();
  }

  @RequestMapping("/{id}")
  public Message getMessage(@PathVariable Long id) {
    return messageService.get(id);
  }
}