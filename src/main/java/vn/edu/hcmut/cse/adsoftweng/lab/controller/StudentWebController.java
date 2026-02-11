package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Lưu ý: Dùng @Controller
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

        // Nếu có từ khóa tìm kiếm thì gọi hàm search, ngược lại gọi hàm getAll
        if (keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
        } else {
            students = service.getAll();
        }

        model.addAttribute("dsSinhVien", students);
        model.addAttribute("keyword", keyword); // Truyền lại từ khóa để hiển thị trong ô input
        return "students";
    }

    // 1. Hiển thị Form Thêm Mới
    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("student", new Student()); // Tạo object rỗng để form điền vào
        model.addAttribute("pageTitle", "Thêm Sinh Viên Mới");
        return "student_form"; // Trả về file student_form.html
    }

    // 2. Xử lý Lưu Sinh Viên (Dùng cho cả Thêm và Sửa)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/students"; // Lưu xong quay về trang danh sách
    }

    // 3. Hiển thị Form Chỉnh Sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Student student = service.get(id);
        if (student == null) {
            return "redirect:/students"; // Không tìm thấy thì quay về
        }
        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "Chỉnh Sửa Thông Tin Sinh Viên (ID: " + id + ")");
        return "student_form"; // Tái sử dụng form trên
    }

    // 4. Xử lý Xóa
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/students";
    }
}
