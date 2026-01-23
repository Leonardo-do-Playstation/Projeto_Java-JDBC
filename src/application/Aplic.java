package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Aplic {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n==== TEST 2: seller findById ====");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 3: findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "João Silva", "joao@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Insert! New id inserted is: " + newSeller.getId());

		System.out.println("\n==== TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Seller updated: New name is " + seller.getName());

		System.out.println("\n==== TEST 6: seller update ====");
		seller = sellerDao.findById(newSeller.getId());
		sellerDao.deleteById(seller.getId());
		System.out.println("It´s done. Id exclued is " + seller.getId());
	}
}
