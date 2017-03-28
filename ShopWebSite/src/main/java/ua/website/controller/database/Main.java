/*package ua.website.controller.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.website.entity.Category;
import ua.website.service.CategoryService;

public class Main {

	public static void main(String[] args) {
		final EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		final EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/appContext.xml");
		
		context.close();

		
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
*/