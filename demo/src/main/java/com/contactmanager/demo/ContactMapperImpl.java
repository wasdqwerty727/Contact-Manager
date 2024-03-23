package com.contactmanager.demo;

import org.springframework.stereotype.Component;

@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactDTO contactToContactDTO(Contact contact) {
        if (contact == null) {
            return null;
        }

        ContactDTO contactDTO = new ContactDTO();

        contactDTO.setId(contact.getId());
        contactDTO.setName(contact.getName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setPhoneNumber(contact.getPhoneNumber());

        return contactDTO;
    }

    @Override
    public Contact contactDTOToContact(ContactDTO contactDTO) {
        if (contactDTO == null) {
            return null;
        }

        Contact contact = new Contact();

        contact.setId(contactDTO.getId());
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());

        return contact;
    }
}
