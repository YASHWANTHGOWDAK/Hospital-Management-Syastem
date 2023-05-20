package com.ty.hospital.service;

import com.ty.hospital.dao.ipm.HospitalDaoImp;
import com.ty.hospital.dto.Hospital;
public class HospitalService {

	public void saveHospital(Hospital hospital) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		Hospital hospital2 = hospitalDaoImp.saveHospital(hospital);
		if(hospital2!=null) {
			System.out.println("data saved successfully");
		}
		else {
			System.out.println("sorry unfortunately data not saved");
		}
	}

	public void deleteHospitalById(int hid) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		boolean flag = hospitalDaoImp.deleteHospitalById(hid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}

	public Hospital updateHospitalById(int hid,Hospital hospital) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		Hospital hospital2 = hospitalDaoImp.updateHospitalById(hid,hospital);
		if(hospital2!=null) {
			return hospital2;
		}
		else {
			return null;
		}
	}
	
	public Hospital getHospitalById(int hid) {
		HospitalDaoImp hospitalDaoImp = new HospitalDaoImp();
		Hospital hospital = hospitalDaoImp.getHospitalById(hid);
		if(hospital!=null) {
			return hospital;
		}
		else {
			return null;
		}
	}
}
