package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Person;


public interface PersonDao {
	public Person savePerson(int eid,Person person);
	public boolean deletePersonById(int pid);
	public Person getPersonById(int pid);
	public Person updatePersonById(int pid,Person person);
	public List<Person> getAllPerson();
	public List<Person> getPersonByGender(String gender);
	public List<Person> getPersonByAge(int age);
	public List<Person> getPersonByphno(long phno);
	

}
