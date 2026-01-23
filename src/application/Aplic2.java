package application;

import java.util.ArrayList;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Aplic2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("==== TEST 1: department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n==== TEST 2: findAll ====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 3: department insert ====");
		Department newDepartment = new Department(null, "Generics");
		departmentDao.insert(newDepartment);
		System.out.println("Add! The new id inserted is: " + newDepartment.getId());

		
		System.out.println("\n==== TEST 4: department update ====");
		department = departmentDao.findById(6);
		department.setName("Human Resources");
		departmentDao.update(department);
		System.out.println("Department updated: New name is " + department.getName());
	
		System.out.println("\n==== TEST 5: department delete ====");
		departmentDao.deleteById(newDepartment.getId());
		System.out.println("It´s done. Id exclued is " + newDepartment.getId());
	}

}
