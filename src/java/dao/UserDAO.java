/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import model.Users;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class UserDAO {
    @PersistenceContext 
    private EntityManager em;
    
    @Transactional
    public void insert(Users user){
        em.persist(user);
        
    }
    @Transactional
    public String getName(int id){
       Users found=em.find( Users.class, id);
       String name= found.getName();
       return name;
    }
    @Transactional
    public List<Users> list(String i){
        List<Users> k;
        Query q= em.createQuery("SELECT u FROM Users u where u.name LIKE:name",Users.class);
        q.setParameter("name",i +"%");
        k=q.getResultList();
        return k;
    }
    
}
