package org.contacts.search;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SearchNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String search = reader.nextLine();
		File f = new File("/Users/shegde/work/shreelola/search/hibernate.cfg.xml");
		SessionFactory sessionFactory = new Configuration().configure(f).buildSessionFactory();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		//String sql = "SELECT * FROM sys.contacts where first_name like '"+search+"%'";
		List contacts = session.createQuery("FROM org.contacts.search.ContactSearch where first_name like '"+search+"%'").list();
		for (Iterator iterator = 
				contacts.iterator(); iterator.hasNext();)
		{
			System.out.println();
			ContactSearch search_name = (ContactSearch) iterator.next();
			System.out.println(search_name.getF_name());
			
		}
		
	}

}
