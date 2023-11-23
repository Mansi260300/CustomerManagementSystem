package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entities.Contact;
import com.customer.service.ContactService;



@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/getcontact")
    public List<Contact> getContactsForCustomer() {
        return  contactService.getContactsForCustomer();
    }

    @GetMapping("byid/{contactId}")
    public Optional<Contact> getContactById(@PathVariable int contactId) {
        return contactService.getContactById(contactId);
                
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Contact> createContactForCustomer(
            @PathVariable int customerId,
            @RequestBody Contact contact) {
        try {
            Contact createdContact = contactService.createContactForCustomer(customerId, contact);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable int contactId,
            @RequestBody Contact updatedContact) {
        return contactService.updateContact(contactId, updatedContact)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable int contactId) {
        boolean deleted = contactService.deleteContact(contactId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}


	 
	 


