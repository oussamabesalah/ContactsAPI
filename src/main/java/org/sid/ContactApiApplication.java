package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactApiApplication  {

	@Autowired
	private ContactRepository contactRepository ; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(ContactApiApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("oussama", "bensalah", df.parse("18/05/1992"), "oussama.ben-salah@proxym.com", 53523482, "oussama.jpeg"));
		contactRepository.save(new Contact("ahmed", "salah", df.parse("19/05/1994"), "ahmed.ben-salah@proxym.com", 54523482, "ahmed.jpeg"));
		contactRepository.save(new Contact("ali", "salah", df.parse("17/05/1999"), "ali.ben-salah@proxym.com", 54583482, "ali.jpeg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}*/
}
