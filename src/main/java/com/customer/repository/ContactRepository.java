package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

	List<Contact> findByCustomerId(int customerId);

}

