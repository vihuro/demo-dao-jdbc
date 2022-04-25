package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findByID ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ====");
		Department departmant = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(departmant);
		for (Seller obj : list) {
			System.out.println(obj);
			
			
			
		}
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller Insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departmant);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo Id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Atualização completa!");
		
		System.out.println("\n=== TEST 6: seller delete ====");
		
		System.out.println("Coloque o numero do ID que você dejese deletar");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("ID " + id + "Deletado com sucesso!");

	}
	

}
