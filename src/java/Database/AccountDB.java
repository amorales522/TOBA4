/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import JavaBeans.Account;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author Morales
 * 
 */
public class AccountDB {

    @Resource(name = "jdbc/toba")
    private DataSource ds;

    public boolean insertAccount(Account account) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        entitymanager.persist(account);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        return true;
    }

    public boolean UpdateAccount(Account account) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Account account1 = entitymanager.find(Account.class, account.getId());

        //before update
        account1.setBalance(account.getBalance());
        entitymanager.getTransaction().commit();

      //after update
        entitymanager.close();
        emfactory.close();
        return true;
    }

    public Account getSavingAccount(String username) {
        System.out.println("in Saving");
        boolean accountFound = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Query q = entitymanager.createQuery("Select a FROM Account a WHERE a.username=:username and a.type=:type");
        q.setParameter("username", username);
        q.setParameter("type", Account.AccountType.Savings);

        List<Account> todoList = q.getResultList();
        Account a = new Account();
        for (Account rs : todoList) {

            a = new Account(rs.getId(), rs.getAccountType(), rs.getBalance(), rs.getUsername());

            accountFound = true;
        }

        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        if (accountFound) {
            return a;
        } else {
            return null;
        }
    }

    public Account getCheckingAccount(String username) {
        System.out.println("in Checking");
        boolean accountFound = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Query q = entitymanager.createQuery("Select a FROM Account a WHERE a.username=:username and a.type=:type");
        q.setParameter("username", username);
        q.setParameter("type", Account.AccountType.Checking);

        List<Account> todoList = q.getResultList();
        Account a = new Account();
        for (Account rs : todoList) {

            a = new Account(rs.getId(), rs.getAccountType(), rs.getBalance(), rs.getUsername());

            accountFound = true;
        }

        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        if (accountFound) {
            return a;
        } else {
            return null;
        }
    }
}
