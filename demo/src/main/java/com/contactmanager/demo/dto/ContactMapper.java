package com.contactmanager.demo.dto;

import com.contactmanager.demo.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    private final ModelMapper modelMapper;

    public ContactMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ContactDTO convertToDto(Contact contact) {
        return modelMapper.map(contact, ContactDTO.class);
    }

    public Contact convertToEntity(ContactDTO contactDTO) {
        return modelMapper.map(contactDTO, Contact.class);
    }
}
