package com.main;

import javax.persistence.EntityManager;

import com.main.provider.EntityManagerFactoryProvider;

public class MainTest {
	private static EntityManager em = EntityManagerFactoryProvider.getEntityManager();
	public static void main(String[] args) {
		System.out.println("Hi");
	}
}
