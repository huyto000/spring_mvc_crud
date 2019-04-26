package com.controller;

import com.dao.StudentDao;
import com.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UpdateController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/update/{studentId}", method = RequestMethod.GET)
    public String getStudentById(ModelMap model, @PathVariable("studentId") int studentId) {
        Student student = studentDao.findStudentById(studentId);
        model.addAttribute("student", student);

        return "update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateStudent(ModelMap model,@RequestParam("id") int id, @RequestParam("name") String name,@RequestParam("email") String email, @RequestParam("course") String course){
        Student student = new Student(id,name,email,course);
        int counter = studentDao.updateStudent(student);

        System.out.println(counter);
        if(counter>0) {
            model.addAttribute("students",studentDao.read());
            model.addAttribute("msg","Update data successfully!");
            model.addAttribute("color","green");
        }
        else{
            model.addAttribute("msg","Update data fail!");
            model.addAttribute("color","red");
        }
        return "read";
    }
}
