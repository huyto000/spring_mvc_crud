package com.controller;

import com.dao.StudentDao;
import com.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartPageController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView mainPage( ModelAndView mv){
      /*  Student student = new Student(name,email,course);
        int counter = studentDao.create(student);
        if(counter>0){
            mv.addObject("msg","Student registration successful!");
        }
        else{
            mv.addObject("msg","Error while create student");
        }*/
        mv.setViewName("index");
        return mv;
    }
}
