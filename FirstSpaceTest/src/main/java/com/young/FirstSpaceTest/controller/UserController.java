package com.young.FirstSpaceTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/17 0017.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getName(){
        return "hi,i am zhangsan";
    }
}
