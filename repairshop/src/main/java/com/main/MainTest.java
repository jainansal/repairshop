package com.main;

import javax.persistence.EntityManager;

import com.main.model.Clerk;
import com.main.provider.EntityManagerFactoryProvider;

public class MainTest {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactoryProvider.getEntityManager();
		Clerk clerk = new Clerk(0, "Ansal", "ansal@gmail.com", "8723890165", null);
		em.getTransaction().begin();
		em.persist(clerk);
		em.getTransaction().commit();
	}
}
