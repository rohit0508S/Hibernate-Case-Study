package service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study_.entity.Product;

public class ProductService {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory sf=cfg.buildSessionFactory();
	Scanner sc=new Scanner(System.in);

	public void addProduct() {
		Product p1=new Product();
		System.out.println("Enter product name:");
		String pname=sc.next();
		System.out.println("Enter Id");
		int id=sc.nextInt();
		
		System.out.println("Enter product price:");
		double price=sc.nextInt();
		System.out.println("Enter the Quantity");
		int Quant=sc.nextInt();
		
		p1.setProductId(id);
		p1.setProductName(pname);
		p1.setProductPrice(price);
		p1.setProductQuantity(Quant);
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		s.save(p1);
		trans.commit();
		s.close();
	}
	
	public void getProductById() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		
		System.out.println("Enter the product id:");
		int id=sc.nextInt();
		
		Product p=s.get(Product.class, id);
		System.out.println(p);
		trans.commit();
		s.close();
	}
	
}
