package com.contactmanager.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "phoneNumber", target = "phoneNumber")
    })
    ContactDTO contactToContactDTO(Contact contact);

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "phoneNumber", target = "phoneNumber")
    })
    Contact contactDTOToContact(ContactDTO contactDTO);
}
