package com.example.contactapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.contactapp.model.Contact;
import com.example.contactapp.repository.ContactRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactRepository repo;

    // Save data
    @PostMapping("/contact")
    public String saveContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        Contact c = new Contact();
        c.setName(name);
        c.setEmail(email);
        c.setMessage(message);

        repo.save(c);

        return "Data saved successfully!";
    }

    // Fetch all data
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }
}
