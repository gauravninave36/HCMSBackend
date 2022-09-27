package com.app.service;
import java.io.Console;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AdminCustomerRepository;
import com.app.dao.AdminEntityRepository;
import com.app.dao.AdminRepository;
import com.app.dao.adminClub;
import com.app.dto.AdminPlanCustomerSummary;
import com.app.dto.Employeedto;
import com.app.dto.LoginRequestDTO;
import com.app.dto.summarydto;
import com.app.entity.ClubEntity;
import com.app.entity.CustomerEntity;
import com.app.entity.EmployeeEntity;
import com.app.entity.RoleEnum;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository AdminRepo;
	
	@Autowired
	private adminClub Club;
	
	@Autowired
	private AdminCustomerRepository adminCust;
	
	@Autowired
	private AdminEntityRepository adminEntity;
	
	//Admin signin authetication logic
	@Override
	public EmployeeEntity authenticateAdmin(LoginRequestDTO admin) {
		// TODO Auto-generated method stub
		EmployeeEntity Admin = AdminRepo.findByEmailAndPassword(admin.getEmail(),admin.getPassword())
				.orElseThrow(()-> new ResourceNotFoundException("NOT FOUND"));
		if(Admin.getRole()== RoleEnum.ADMIN) {
			System.out.println("its a admin");
			return Admin;
		}else if(Admin.getRole()== RoleEnum.EMPLOYEE){
			System.out.println("Its a employee");
			return Admin;
		}else {
			return null;
		}
	}
	
	//getEmployeeid
	@Override
	public EmployeeEntity getbyid(Long id) {
		// TODO Auto-generated method stub
		EmployeeEntity employee = AdminRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found Exception"));
		return employee;
	}
	
	//adding employee  
	@Override
	public EmployeeEntity addEmployee(Employeedto emp) {
		// TODO Auto-generated method stub
			ClubEntity employeeclub = Club.findById(emp.getClub_id()).orElseThrow(()-> new ResourceNotFoundException("cluberror"));
//			String firstName, String lastName, String address, Long empContact, String email, String password,
//			RoleEnum role,ClubEntity club
			EmployeeEntity transemployee= new EmployeeEntity(emp.getFirstName(),emp.getLastName(),emp.getAddress(),emp.getEmpContact(),emp.getEmail(),emp.getPassword(),emp.getRole(),employeeclub);
			EmployeeEntity persistentemployee = AdminRepo.save(transemployee);
			System.out.println(persistentemployee);
			return persistentemployee;
	}
	
	//getting all employees
	@Override
	public List<EmployeeEntity> getAllemployees(){
		// TODO Auto-generated method stub
		List<EmployeeEntity> empList = AdminRepo.findAll();
		return empList;

	}

	//Update emplyee details
	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity emp) {
		// TODO Auto-generated method stub
		EmployeeEntity persistentEmployee = AdminRepo.save(emp);
		return persistentEmployee;
	}
	
	//Delete employee details
	@Override
	public String deleteEmpdetails(Long emp_id) {
		// TODO Auto-generated method stub
		if(AdminRepo.existsById(emp_id)) {
			AdminRepo.deleteById(emp_id);
			return ("employee"+emp_id+" got deleted.");
		}else {
			return ("No record found");
		}
	}

	@Override
	public List<ClubEntity> getAllclub() {
		// TODO Auto-generated method stub
		return Club.findAll();

	}

	@Override
	public List<summarydto> getAdminsummary() {
		// TODO Auto-generated method stub
		List<summarydto> frachisesummarylist = new LinkedList<>();
		List<Long> clubids = adminCust.findList();
		List<Long> salesperClub = Club.findList();
		List<String> locationlist = AdminRepo.findList();
		List<Long> noofCustomerinFranchise = adminEntity.NumberofCustomerInFrachise();
		List<String> NameofCustomer =adminEntity.Nameforcustomerinfrachise(); 
		
		for (int i =0;i<clubids.size();i++) {
			frachisesummarylist.add(new summarydto(clubids.get(i),  NameofCustomer.get(i),locationlist.get(i),salesperClub.get(i),noofCustomerinFranchise.get(i)));
		}
		
		return frachisesummarylist;
	}

	@Override
	public List<CustomerEntity> AllCustomer() {
		// TODO Auto-generated method stub
		
		return adminEntity.Allcustomer();
	}
	
	public  List<AdminPlanCustomerSummary> PlanSummary(){
		List<AdminPlanCustomerSummary> planCustomerSummary = new LinkedList<AdminPlanCustomerSummary>();
		List<String> clubName = adminEntity.planName();
		List<Long> customerCount = adminEntity.customerInPlanCount();
		for(int i=0;i<clubName.size();i++) {
			planCustomerSummary.add(new AdminPlanCustomerSummary(clubName.get(i),customerCount.get(i)));
		}
		return planCustomerSummary;
	}
	
	public ClubEntity addClub(ClubEntity club) {
		System.out.println(club);
		ClubEntity persistentclub = Club.save(club);	
		return persistentclub;
		
	}

	@Override
	public ClubEntity clubByid(Long id) {
		// TODO Auto-generated method stub
		return Club.findById(id).orElseThrow(()-> new ResourceNotFoundException("cluberror"));
	}

	
	@Override
	public String deleteClubbyid(Long id) {
		// TODO Auto-generated method stub
		if(Club.existsById(id)) {
			Club.deleteById(id);
			return ("employee"+id+" got deleted.");
		}else {
			return ("No record found");
		}
		
	}


		
	
}
