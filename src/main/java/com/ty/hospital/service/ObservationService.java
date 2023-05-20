
package com.ty.hospital.service;

import com.ty.hospital.dao.ipm.ObservationDaoImp;
import com.ty.hospital.dto.Observation;

public class ObservationService {

	public void saveObservation(int eid,Observation observation) {
		ObservationDaoImp observationDaoImp = new ObservationDaoImp();
		Observation observation2 = observationDaoImp.saveObservation(eid,observation);
		if(observation2!=null) {
			System.out.println("Data saved successfully");
		}
		else {
			System.out.println("Sorry,Data cannot be saved");
		}
	}
	
	public void deleteObservationById(int oid) {
		ObservationDaoImp observationDaoImp = new ObservationDaoImp();
		boolean flag = observationDaoImp.deleteObservationById(oid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}

	public Observation updateObservationById(int oid,Observation observation) {
		ObservationDaoImp observationDaoImp = new ObservationDaoImp();
		Observation observation2 = observationDaoImp.updateObservationById(oid,observation);
		if(observation2!=null) {
			return observation2;
		}
		else {
			return null;
		}
	}
	
	public Observation getObsservationById(int oid) {
		ObservationDaoImp observationDaoImp = new ObservationDaoImp();
		Observation observation = observationDaoImp.getObsservationById(oid);
		if(observation!=null) {
			return observation;
		}
		else {
			return null;
		}
	}
}