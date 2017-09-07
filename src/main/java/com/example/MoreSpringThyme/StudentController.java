package com.example.MoreSpringThyme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values());
        return "new_student";
    }

    @RequestMapping("/create_student")
    public String createStudent(@RequestParam(value="first_name") String firstName,
                                @RequestParam(value="last_name") String lastName,
                                @RequestParam(value="grade") Grade grade,
                                @RequestParam(value="enrolled") Boolean enrolled, Model model) {
        Student student = new Student();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(grade);
        student.setEnrolled(enrolled);

        model.addAttribute(student);

        return "view_student";
    }
}
