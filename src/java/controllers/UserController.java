/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserDAO;
import java.util.List;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("users")



public class UserController {
    
    @Autowired
  private UserDAO K;
    @RequestMapping("/insert")
    public void insert(){
        Users test= new Users();
        test.setId(101);
        test.setLastname("Shakur");
        test.setName("Tupac");
        test.setPassword("Hitemup");
        K.insert(test);
        String k=K.getName(test.getId());
        }
    @RequestMapping("/getName")
    public Users nameFinder(int i){
        Users pac= new Users();
       String name= K.getName(i);
       pac.setName(name);
       return pac;
    }
    
    @RequestMapping(value="name", method=RequestMethod.GET)
    public String list(ModelMap model,@RequestParam(value="name")String name){
     List<Users> rouf=K.list(name);
     model.addAttribute("list",rouf);
     return "table";
    }
}
