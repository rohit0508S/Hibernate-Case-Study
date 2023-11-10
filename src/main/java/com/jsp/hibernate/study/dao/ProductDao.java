package com.jsp.hibernate.study.dao;



import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_.entity.Product;

import service.ProductService;

public class ProductDao {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory sf=cfg.buildSessionFactory();
	Scanner sc=new Scanner(System.in);
	ProductService productService ;
	
public void addProduct() {
	productService =new ProductService();
	productService.addProduct();	
}
public void getProductById() {
	
}
	public void getAllProduct() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		 Query<Product> query=s.createQuery(" from Product");
	      List<Product> products=query.list();
	        for(Product c:products) {
	        	System.out.println(
	       "Product Id: "+c.getProductId()+"\n"+"Product Name: "+c.getProductName()+"\n"+"Product Price: "+c.getProductPrice()+"\n"+"Product Quantity: "+c.getProductQuantity()+"\n");
	        }

		trans.commit();
		s.close();
	}
	public void updateProductById() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		System.out.println("Enter the Id:");
		int i=sc.nextInt();
		Query q=s.createQuery("update Product set productName=:n where id=:i");  
		q.setParameter("n","Tablet");  
		q.setParameter("i",101);  
		int status=q.executeUpdate();  
		System.out.println(status+" row affected!"); 
		trans.commit();
		s.close();
		}
	public void updateAllProduct() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();

		Query q=s.createQuery("update Product set productName=:n");  
		q.setParameter("n","Tablet");  
  
		int status=q.executeUpdate();  
		System.out.println(status+" row affected!"); 
		trans.commit();
		s.close();
	}
	public void deleteProductById() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		System.out.println("Enter the Id:");
		int i=sc.nextInt();
		Query q=s.createQuery(" delete from Product  where id=:i");  
		q.setParameter("i", i);
		int status=q.executeUpdate();  
		System.out.println(status+" row affected!"); 
		trans.commit();
		s.close();
		
	}
	public void deleteAllProduct() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		Query q=s.createQuery(" delete from Product");  		
		int status=q.executeUpdate();  
		System.out.println(status+" row affected!"); 
		trans.commit();
		s.close();
	}
}
