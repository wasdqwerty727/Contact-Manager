package com.contactmanager.demo.service;
import com.contactmanager.demo.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact createContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
}