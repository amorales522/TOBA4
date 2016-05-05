/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import JavaBeans.Transaction;
import JavaBeans.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Morales
 */
public class TransactionDB {

    public boolean insertTranction(Transaction transaction, String type) {
        transaction.setType(type);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        entitymanager.persist(transaction);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        return true;

    }

    public void getTranction(int accountId, List<Transaction> list) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Query q = entitymanager.createQuery("Select t FROM Transaction t WHERE t.account=:account");
        q.setParameter("account", accountId);

        List<Transaction> todoList = q.getResultList();
        User a = new User();
        for (Transaction rs : todoList) {

            list.add(rs);
            //  isLogin = true;
        }

        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();

    }
}
