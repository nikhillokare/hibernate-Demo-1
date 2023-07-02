package com.bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.login.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Book Details:\nBook Name,Author Name and Price");
		
        String bn = br.readLine();
        String an = br.readLine();
        float bp  = Float.parseFloat(br.readLine());
        
        //orm
        Book b = new Book();
        b.setBook_name(bn);
        b.setAuthor_name(an);
        b.setPrice(bp);
        
        //after build path
        org.hibernate.cfg.Configuration  cf= new AnnotationConfiguration().configure();
		//SessionFactory=>session
		SessionFactory sf=cf.buildSessionFactory();
		//session
		Session s2=sf.openSession();
		Transaction t=s2.beginTransaction();//commit,rollback
        int i =(int) s2.save(b);
        if(i>0)
        {
        	t.commit();
        	System.out.println("Transaction Completed");
        }
        else
        {
        	System.out.println("Try Again");
        }
	}   

}
