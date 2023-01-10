package com.example.contact.controller;

import com.example.contact.entity.Contact;
import com.example.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping(path = "/get_all")
    public ResponseEntity<?> getAllContacts() {
        return ResponseEntity.ok(contactService.getContacts());
    }

    @GetMapping(path = "/get_user_id/{user_id}")
    public ResponseEntity<?> getContactsByUserId(@PathVariable("user_id") Integer userId) {
        return ResponseEntity.ok(contactService.getContactById(userId));
    }

    @PostMapping(path = "/create/{user_id}")
    public ResponseEntity<?> createContactById(@RequestBody Contact contact, @PathVariable("user_id") Integer userId) {
        return ResponseEntity.ok(contactService.createContact(contact, userId));
    }

    @PutMapping(path = "/update/{user_id}/{id}")
    public ResponseEntity<?> updateContact(@RequestBody Contact contact,
                                           @PathVariable("user_id") Integer userId,
                                           @PathVariable("id") Integer id) {

        return ResponseEntity.ok(contactService.updateContact(contact, userId, id));
    }

    @DeleteMapping(path = "/delete/{user_id}/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("user_id") Integer userId,
                                           @PathVariable("id") Integer id) {

        return ResponseEntity.ok(contactService.deleteContact(userId, id));
    }
}
