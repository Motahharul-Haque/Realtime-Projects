package com.contact.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;
import com.contact.service.ContactService;

@Service
public class ContactServiceImple implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public String upsert(Contact contact) {
		Contact save = contactRepository.save(contact);
		return "SUCCESS";
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContact(int cid) {
		 Optional<Contact> findById = contactRepository.findById(cid);
		 if(findById.isPresent())
		 {
			 return findById.get();
		 }
		 return null;
	}

	@Override
	public String deleteContact(int cid) {
		contactRepository.deleteById(cid);
		return null;
	}

}
