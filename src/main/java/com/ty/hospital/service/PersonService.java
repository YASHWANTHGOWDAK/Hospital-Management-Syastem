
package com.ty.hospital.service;

import com.ty.hospital.dao.ipm.PersonDaoImp;
import com.ty.hospital.dto.Person;

public class PersonService {

	public void savePerson(int eid,Person person) {
		PersonDaoImp personDaoImp = new PersonDaoImp();
		Person person2 = personDaoImp.savePerson(eid,person);
		if(person2!=null) {
			System.out.println("Data saved successfully");
		}
		else {
			System.out.println("Sorry,Data cannot be saved");
		}
	}
	
	public void deletePersonById(int pid) {
		PersonDaoImp personDaoImp = new PersonDaoImp();
		boolean flag = personDaoImp.deletePersonById(pid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}
	
	public Person getPersonById(int pid) {
		PersonDaoImp personDaoImp = new PersonDaoImp();
		Person person = personDaoImp.getPersonById(pid);
		if(person!=null) {
			return person;
		}
		else {
			return null;
		}
	}
}
