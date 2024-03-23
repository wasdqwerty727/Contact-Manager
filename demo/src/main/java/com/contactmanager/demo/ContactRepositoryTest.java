package com.contactmanager.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactRepositoryTest {

    @Mock
    private ContactRepository contactRepositoryMock;

    @InjectMocks
    private ContactService contactService;

    @Test
    public void testFindAllContacts() {
        // Arrange
        Contact contact1 = new Contact("John Doe", "john@example.com", "1234567890");
        Contact contact2 = new Contact("Jane Doe", "jane@example.com", "0987654321");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);

        when(contactRepositoryMock.findAll()).thenReturn(contacts);

        // Act
        List<Contact> result = contactService.getAllContacts();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("jane@example.com", result.get(1).getEmail());
    }

    @Test
    public void testFindContactById() {
        // Arrange
        Contact contact = new Contact("John Doe", "john@example.com", "1234567890");
        contact.setId(1L);

        when(contactRepositoryMock.findById(1L)).thenReturn(Optional.of(contact));

        // Act
        Optional<Contact> result = contactService.getContactById(1L);

        // Assert
        assertEquals("John Doe", result.get().getName());
        assertEquals("john@example.com", result.get().getEmail());
    }

    // Add more test methods for other CRUD operations as needed
}
