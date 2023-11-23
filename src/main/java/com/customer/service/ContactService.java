package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Contact;
import com.customer.entities.Customer;
import com.customer.repository.ContactRepository;
import com.customer.repository.CustomerRespository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CustomerRespository customerRepository;

    public List<Contact> getContactsForCustomer() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(int contactId) {
        return contactRepository.findById(contactId);
    }

    public Contact createContactForCustomer(int customerId, Contact contact) throws ClassNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            contact.setCustomer(customer);
            return contactRepository.save(contact);
        } else {
            throw new ClassNotFoundException("Customer with ID " + customerId + " not found");
        }
    }

    public Optional<Contact> updateContact(int contactId, Contact updatedContact) {
        return contactRepository.findById(contactId);
    }

    public boolean deleteContact(int contactId) {
        if (contactRepository.existsById(contactId)) {
            contactRepository.deleteById(contactId);
            return true;
        } else {
            return false;
        }
    }
}
