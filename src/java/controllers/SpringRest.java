/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDAO;
import java.util.List;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("usersrest")
public class SpringRest {
     
     @Autowired
  private UserDAO K;

    /**
     *
     * @param name
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    @RequestMapping(value="usersinput", method=RequestMethod.GET, headers="Accept=*/*",produces="application/json")
      public  @ResponseBody String list(@RequestParam(value="usersinput")String text) throws JsonProcessingException{
     List<Users> rouf=K.list(text);
        ObjectMapper mapper= new ObjectMapper();
        System.out.println(mapper.writeValueAsString(rouf));
        return mapper.writeValueAsString(rouf);
    }
    
    
}
