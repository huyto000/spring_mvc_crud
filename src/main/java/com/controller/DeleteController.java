package com.controller;

import com.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value="/delete/{studentId}",method = RequestMethod.GET)
    public String deleteController(@PathVariable("studentId") int studentId, ModelMap model) {
        int counter = studentDao.deleteStudent(studentId);
        model.addAttribute("students", studentDao.read());
        if (counter > 0) {

            model.addAttribute("msg", "Delete successfully!");
            model.addAttribute("color", "green");
        } else {

            model.addAttribute("msg", "Delete fail!");
            model.addAttribute("color", "red");
        }
        return "read";
    }
}
