package com.contact.service;

import java.util.List;

import com.contact.entity.Contact;

public interface ContactService {

	String upsert(Contact contact);
	List<Contact> getAllContacts();
	Contact getContact(int cid);
	String deleteContact(int cid);
}
