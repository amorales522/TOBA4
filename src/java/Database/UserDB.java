/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import JavaBeans.User;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import util.PasswordUtil;

/**
 *
 * @author Morales
 */
public class UserDB {

    @Resource(name = "jdbc/toba")
    private DataSource ds;

    public boolean insert(User user) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        entitymanager.persist(user);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        return true;
    }

    public boolean update(User user) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        User user1 = entitymanager.find(User.class, user.getId());

        //before update
        user1.setPassword(user.getPassword());
        user1.setSalt(user.getSalt());
        entitymanager.getTransaction().commit();

      //after update
        //    System.out.println( employee );
        entitymanager.close();
        emfactory.close();
        return true;
    }

    @SuppressWarnings("unchecked")
    public User check(String username, String password) {
        boolean isLogin = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        //User user1 = entitymanager.
        Query q = entitymanager.createQuery("Select a FROM User a WHERE a.username=:user");
        q.setParameter("user", username);

        List<User> todoList = q.getResultList();
        User a = new User();
        for (User rs : todoList) {
            try {
                if(PasswordUtil.hashPassword(password+rs.getSalt()).equals(rs.getPassword()))
                {
                    a.setId(rs.getId());
                    a.setUsername(username);
                    a.setPassword(password);
                    a.setSalt(rs.getSalt());
                    a.setFirstName(rs.getFirstName());
                    a.setLastName(rs.getLastName());
                    a.setAddress(rs.getAddress());
                    a.setPhoneNumber(rs.getPhoneNumber());
                    a.setCity(rs.getCity());
                    a.setState(rs.getState());
                    a.setEmail(rs.getEmail());
                    a.setZipCode(rs.getZipCode());
                    a.setDate(rs.getDate());
                    isLogin = true;
                }
                
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        if (isLogin) {
            return a;
        } else {
            return null;
        }
    }
    
     public ArrayList<User> getUsers() {
         ArrayList<User> list = new ArrayList<User>();
        boolean isLogin = false;
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TOBAPU");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        //User user1 = entitymanager.
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         Date date = new Date();
         Date date1 = new Date();
         date.setDate(1);
         date1.setDate(1);
         date1.setMonth(date1.getMonth()+1);
         
        Query q = entitymanager.createQuery("Select a FROM User a WHERE a.date >= :date and a.date <=:date1");
        q.setParameter("date", dateFormat.format(date));
        q.setParameter("date1", dateFormat.format(date1));

        List<User> todoList = q.getResultList();
        User a = new User();
        for (User rs : todoList) {
            
                    a.setId(rs.getId());
                    a.setUsername(rs.getUsername());
                    a.setPassword(rs.getPassword());
                    a.setSalt(rs.getSalt());
                    a.setFirstName(rs.getFirstName());
                    a.setLastName(rs.getLastName());
                    a.setAddress(rs.getAddress());
                    a.setPhoneNumber(rs.getPhoneNumber());
                    a.setCity(rs.getCity());
                    a.setState(rs.getState());
                    a.setEmail(rs.getEmail());
                    a.setZipCode(rs.getZipCode());
                    a.setDate(rs.getDate());
                    isLogin = true;
                    list.add(a);
                }
      
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
        if (isLogin) {
            return list;
        } else {
            return null;
        }
    }


}
