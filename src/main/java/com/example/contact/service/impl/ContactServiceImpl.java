package com.example.contact.service.impl;

import com.example.contact.entity.Contact;
import com.example.contact.entity.User;
import com.example.contact.exception.ResourceNotFoundException;
import com.example.contact.repository.ContactRepository;
import com.example.contact.repository.UserRepository;
import com.example.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getContactById(Integer id) {
        return null;
    }

    @Override
    public Contact createContact(Contact contact, Integer userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "User not found");
        }
        User user = optionalUser.get();
        contact.setUser(user);
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact, Integer userId, Integer id) {

        Contact contactById = contactRepository.getContactById(userId, id);
        if (contactById == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (contact.getName() != null) contactById.setName(contact.getName());
        if (contact.getPhoneNo() != null) contactById.setPhoneNo(contact.getPhoneNo());
        if (contact.getAddress() != null) contactById.setAddress(contact.getAddress());
        if (contact.getImage() != null) contactById.setImage(contact.getImage());
        return contactRepository.save(contactById);
    }

    @Override
    public Object deleteContact(Integer user_id, Integer id) {

        int deleted = contactRepository.deleteContact(user_id, id);
        if (deleted == 0) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "");
        }
        return "DELLETD SUCCESSFULLY";
    }
}
