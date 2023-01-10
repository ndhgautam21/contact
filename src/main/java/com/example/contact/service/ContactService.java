package com.example.contact.service;

import com.example.contact.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getContacts();

    List<Contact> getContactById(Integer id);

    Contact createContact(Contact contact, Integer userId);

    Contact updateContact(Contact contact, Integer userId, Integer id);

    Object deleteContact(Integer user_id, Integer id);

}
