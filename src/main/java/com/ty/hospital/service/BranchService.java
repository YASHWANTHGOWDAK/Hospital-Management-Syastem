package com.ty.hospital.service;
import com.ty.hospital.dao.ipm.BranchDaoImp;
import com.ty.hospital.dto.Branch;

public class BranchService {

	public void saveBranch(int hid,Branch branch) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch2 = branchDaoImp.saveBranch(hid,branch);
		if(branch2!=null) {
			System.out.println("Data saved successfully");
		}
		else {
			System.out.println("Sorry,Data cannot be saved");
		}
	}
	
	public void deleteBranchById(int bid) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		boolean flag = branchDaoImp.deleteBranchById(bid);
		if(flag) {
			System.out.println("data deleted successfully");
		}
		else {
			System.out.println("data not deleted");
		}
	}

	public Branch updateBranchById(int bid,Branch branch) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch2 = branchDaoImp.updateBranchById(bid,branch);
		if(branch2!=null) {
			return branch2;
		}
		else {
			return null;
		}
	}
	
	public Branch getBranchById(int bid) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch = branchDaoImp.getBranchById(bid);
		if(branch!=null) {
			return branch;
		}
		else {
			return null;
		}
	}
}
