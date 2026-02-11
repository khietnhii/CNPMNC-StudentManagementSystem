package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequestMapping("/students")

public class StudentWebController {
    @Autowired
    private StudentService service;

    // Route: GET http://localhost:8080/students
    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;

        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
        } else {
            students = service.getAll();
        }

        model.addAttribute("dsSinhVien", students);
        model.addAttribute("keyword", keyword);
        return "students";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable("id") Integer id, Model model) {
        Student student = service.getById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "student_detail";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Thêm Sinh Viên Mới");
        return "student_form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student,
                              @RequestParam(value = "isUpdate", required = false) Boolean isUpdate,
                              Model model) {
        
        if ((isUpdate == null || !isUpdate) && service.getById(student.getId()) != null) {
            model.addAttribute("error", "Lỗi: ID " + student.getId() + " đã tồn tại! Vui lòng chọn ID khác.");
            model.addAttribute("pageTitle", "Thêm Sinh Viên Mới");
            return "student_form";
        }

        service.save(student);

        if (isUpdate != null && isUpdate) {
            return "redirect:/students/" + student.getId();
        } else {
            return "redirect:/students";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Student student = service.getById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "Chỉnh Sửa Thông Tin Sinh Viên (ID: " + id + ")");
        return "student_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/students";
    }
}
