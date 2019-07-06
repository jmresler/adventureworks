/**
 * 
 */
package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.entities.Address;
import org.jmresler.spring.aw.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John
 *
 */
@RestController
public class AddressController {

	@Autowired protected AddressRepository addressRepository;
	
	@RequestMapping("/getaddress/{id}")
	public Address getAddress(int id) {
		return addressRepository.getOne(id);
	}
	
}
