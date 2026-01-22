package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Aplic {

	public static void main(String[] args) {
		Department obj = new Department(1, "Books");
		
		Seller seller = new Seller(20, "Roberto", "Roberto@gmail.com", new Date(), 3000.0, obj);

		System.out.println(obj);
		System.out.println(seller);
	}

}
