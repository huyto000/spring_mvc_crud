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
public class CreateController {
    @Autowired
    private StudentDao studentDao;
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String createStudent(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("course") String course, ModelMap model){
        Student student = new Student(name,email,course);
        int counter = studentDao.create(student);
        System.out.println(student.getName());
        System.out.println(counter);
        if (counter > 0) {
            model.addAttribute("msg", "Student registration successful.");
            model.addAttribute("color", "green");
        } else {
            model.addAttribute("color", "red");
        }

        return "index";

    }
}
