package com.mftplus.jee03practice.model.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JpaProvider {
    @Getter
    private static JpaProvider jpa = new JpaProvider();
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mftEE3");//This Is Instead Of Connection connection=DriverManager.getConnection :

    private JpaProvider() {}

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
