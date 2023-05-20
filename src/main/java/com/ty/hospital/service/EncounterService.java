package com.ty.hospital.service;
import com.ty.hospital.dao.ipm.EncounterDaoImp;
import com.ty.hospital.dto.Encounter;


public class EncounterService {

	public void deleteEncounterById(int eid) {
		EncounterDaoImp encounterDaoImp = new EncounterDaoImp();
		boolean flag = encounterDaoImp.deleteEncounterById(eid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}

	public Encounter updateEncounterById(int eid,Encounter encounter) {
		EncounterDaoImp encounterDaoImp = new EncounterDaoImp();
		Encounter encounter2 = encounterDaoImp.updateEncounterById(eid,encounter);
		if(encounter!=null) {
			return encounter2;
		}
		else {
			return null;
		}
	}
	
	public Encounter getEncounterById(int eid) {
		EncounterDaoImp encounterDaoImp = new EncounterDaoImp();
		Encounter encounter = encounterDaoImp.getEncounterById(eid);
		if(encounter!=null) {
			return encounter;
		}
		else {
			return null;
		}
	}
}
