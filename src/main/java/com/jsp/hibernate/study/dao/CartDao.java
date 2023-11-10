package com.jsp.hibernate.study.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jsp.hibernate_case_study_.entity.Cart;
import com.jsp.hibernate_case_study_.entity.Product;

public class CartDao {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sf=cfg.buildSessionFactory();
	
	Scanner sc=new Scanner(System.in);
	
	public void createCart() {
		Session s=sf.openSession();
		Transaction trans=s.beginTransaction();
		System.out.println("Enter the cart Id: ");
		int cardId=sc.nextInt();
		Cart c=new Cart();
		c.setCartId(cardId);
		s.save(c);
		trans.commit();
		s.close();
		
	}	
public void addProductToCart() {
	Session s=sf.openSession();
	Transaction trans=s.beginTransaction();
	Cart c=s.get(Cart.class, 111);
	c.getProduct().add(s.get(Product.class, 101));
	s.update(c);		
	trans.commit();
	s.close();
}




public void removeProductFromCart(Product product) {
	Session s=sf.openSession();
	Transaction trans=s.beginTransaction();
//	Query deleteProduct=s.delete();
//	deleteProduct.setParameter("id", "101");
//	int r=deleteProduct.executeUpdate();
//	System.out.println(r+" rows affected!");
	trans.commit();
	s.close();
}

}
