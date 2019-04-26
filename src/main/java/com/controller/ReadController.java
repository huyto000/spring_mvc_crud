package com.controller;

import com.dao.StudentDao;
import com.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReadController {
    @Autowired
    private StudentDao studentDao;
    @RequestMapping(value="read")
    public String readData(ModelMap model){
        List<Student> students = studentDao.read();
        model.addAttribute("students",students);
        return "read";
    }
}
