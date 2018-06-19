package org.sid.web;

import java.util.List;



import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactRepository ;

	
	
	//APIGetAllContacts
	@RequestMapping(value="/contacts" ,method=RequestMethod.GET)
	public List<Contact> getContacts()
	{
		return contactRepository.findAll() ;
		
	}
	
	
	
	//APIGetContactsByID
		@RequestMapping(value="/contacts/{id}" ,method=RequestMethod.GET)
		public Contact getContact(@PathVariable Long id)
		{
			return contactRepository.findOne(id) ;
			
		}
	
		
		
	//APIAddContacts
		 @RequestMapping(value="/contacts" ,method=RequestMethod.POST)
		public Contact addContact(@RequestBody Contact c)
		{
			return contactRepository.save(c) ;
					
		}
	
		 
		 
	//APIDeleteContactsByID
		@RequestMapping(value="/contacts/{id}" ,method=RequestMethod.DELETE)
		public boolean deleteContact(@PathVariable Long id)
		{
			contactRepository.delete(id);
			return true ;
				
		}
	
		
	//APIUpdateContacts
		 @RequestMapping(value="/contacts/{id}" ,method=RequestMethod.PUT)
		public Contact updateContact(@PathVariable Long id ,@RequestBody Contact c)
		{
			 c.setId(id);
			return contactRepository.save(c) ;
					
		}
	
	
	//APIFindContact
			@RequestMapping(value="/find" ,method=RequestMethod.GET)
			public Page <Contact> chercher(
					@RequestParam(name="mc" , defaultValue="") String mc,
					@RequestParam(name="page" , defaultValue="0")int page ,
					@RequestParam(name="size" , defaultValue="5")int size)
			{
				return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size) ) ;
				
			}
		 
		 
		 
		 
	
}
