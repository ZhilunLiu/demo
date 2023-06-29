package com.charles.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charles.demo.DemoApplication;
import com.charles.demo.Entity.ResponseViewEntity;
import com.charles.demo.Entity.UserEntity;
import com.charles.demo.Repository.UserRepository;


@RestController
@RequestMapping(value="/Users")
public class UserController {


    public static final Logger LOGGER =
            LoggerFactory.getLogger(DemoApplication.class);

    private UserRepository userRepository;

 
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @RequestMapping(value="/getAllbyName",method= RequestMethod.GET)
    public ResponseViewEntity<List<UserEntity>> getAllUsersByName(String username){
        ResponseViewEntity<List<UserEntity>> rsp = new ResponseViewEntity<List<UserEntity>>();

        List<UserEntity> result = userRepository.findAllByName(username);

        if(result.size() > 0){
            LOGGER.error("result=====",result);;
            rsp.setData(result);
            rsp.setRetMsg("found datas");
        }

        if(result.size()==0){
            result = userRepository.findAll();
            LOGGER.error("result=====",result.get(0).getName());;
            rsp.setData(result);
            rsp.setRetMsg("findAll datas");
        }
        return rsp;
    }

    @RequestMapping(value="/addNew",method= RequestMethod.POST)
    public ResponseViewEntity<UserEntity> addNewUser(String username){
        ResponseViewEntity<UserEntity> rsp = new ResponseViewEntity<UserEntity>();
        UserEntity user = new UserEntity();
        user.setName(username);
        userRepository.save(user);
        rsp.setRetCode(0);
        rsp.setRetMsg("success");
        return rsp;
    }
    
}
