package com.contactmanager.demo.controller;

import com.contactmanager.demo.dto.ContactDTO;
import com.contactmanager.demo.dto.ContactMapper;
import com.contactmanager.demo.entity.Contact;
import com.contactmanager.demo.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    public ContactController(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<ContactDTO> contactDTOList = contactService.getAllContacts()
                .stream()
                .map(contactMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(contactDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
        Contact createdContact = contactService.createContact(contactMapper.convertToEntity(contactDTO));
        return new ResponseEntity<>(contactMapper.convertToDto(createdContact), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            return new ResponseEntity<>(contactMapper.convertToDto(contact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        Contact updatedContact = contactService.updateContact(id, contactMapper.convertToEntity(contactDTO));
        if (updatedContact != null) {
            return new ResponseEntity<>(contactMapper.convertToDto(updatedContact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
