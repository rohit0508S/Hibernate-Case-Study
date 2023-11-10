package com.jsp.hibernate_case_study_1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.study.dao.CartDao;
import com.jsp.hibernate.study.dao.ProductDao;
import com.jsp.hibernate_case_study_.entity.Cart;
import com.jsp.hibernate_case_study_.entity.Product;

import service.ProductService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
//    	SessionFactory sf=cfg.buildSessionFactory();
//    	Session s=sf.openSession();
//    	Transaction trans=s.beginTransaction();
    	
    	
//    	
//    	Product product=new Product();
//    	ProductService ps=new ProductService();
//    	
//    	ps.addProduct();
//    	
    	
      ProductDao pd=new ProductDao();
      Scanner s=new Scanner(System.in);      
      System.out.println("Enter your choice");      
      System.out.println("1. Insert\n"+ "2.SearchById\n"+"3.Get all records\n"+"4.UpdateById\n"+"5.UpdateAll\n"+"6.DeleteBYId\n"+"7.DeleteAll");
      int ch=s.nextInt();
      switch(ch) {
      case 1:
        System.out.println("Enter how many products you want to add:");
        int n=s.nextInt();
        for(int i=1;i<=n;i++) {
          pd.addProduct();
        }
        break;
      case 2:
        pd.getProductById();
        break;
      case 3:
    	pd.getAllProduct();
    	break;
      case 4:
        pd.updateProductById();
        break;
      case 5:
        pd.updateAllProduct();
        break;
      case 6:
        pd.deleteProductById();
        break;
      case 7:
        pd.deleteAllProduct();
        default:
        	System.out.println("Invalid input");
      }
      

//    	CartDao c=new CartDao();    	
//    	c.createCart();
//    	c.addProductToCart(s.get(Cart.class,111), s.get(Product.class, 101));
//  c.addProductToCart();
//    	Product p=new Product();
//    	c.removeProductFromCart(p);
//    	trans.commit();
//    	s.close();


    }
}
