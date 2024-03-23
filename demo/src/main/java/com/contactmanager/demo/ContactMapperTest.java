package com.contactmanager.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactMapperTest {

    private final ContactMapper contactMapper = new ContactMapperImpl();

    @Test
    public void testContactToContactDTO() {
        // Arrange
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("John Doe");
        contact.setEmail("john@example.com");
        contact.setPhoneNumber("1234567890");

        // Act
        ContactDTO contactDTO = contactMapper.contactToContactDTO(contact);

        // Assert
        assertEquals(contact.getId(), contactDTO.getId());
        assertEquals(contact.getName(), contactDTO.getName());
        assertEquals(contact.getEmail(), contactDTO.getEmail());
        assertEquals(contact.getPhoneNumber(), contactDTO.getPhoneNumber());
    }

    @Test
    public void testContactDTOToContact() {
        // Arrange
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1L);
        contactDTO.setName("John Doe");
        contactDTO.setEmail("john@example.com");
        contactDTO.setPhoneNumber("1234567890");

        // Act
        Contact contact = contactMapper.contactDTOToContact(contactDTO);

        // Assert
        assertEquals(contactDTO.getId(), contact.getId());
        assertEquals(contactDTO.getName(), contact.getName());
        assertEquals(contactDTO.getEmail(), contact.getEmail());
        assertEquals(contactDTO.getPhoneNumber(), contact.getPhoneNumber());
    }
}
