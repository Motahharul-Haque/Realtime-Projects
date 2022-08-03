package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService contactService; 
	
	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact)
	{
		String status = contactService.upsert(contact);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/contact")
	public ResponseEntity<List<Contact>> getAllContacts()
	{
		List<Contact> allContacts = contactService.getAllContacts();
		return new ResponseEntity<>(allContacts, HttpStatus.OK);
	}
	
	@GetMapping("/contact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable int cid)
	{
		Contact contact = contactService.getContact(cid);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
	
	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid)
	{
		String deleteContact = contactService.deleteContact(cid);
		return new ResponseEntity<>(deleteContact, HttpStatus.OK);
	}
}
