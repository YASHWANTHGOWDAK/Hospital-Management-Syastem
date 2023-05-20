package com.ty.hospital.controller;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.service.HospitalService;

public class TestSaveHospital {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalService service = new HospitalService();
		hospital.setHname("Sagar Hospitall");
		hospital.setHwedsite("www.dsce.com");
		service.saveHospital(hospital);
	}
}
