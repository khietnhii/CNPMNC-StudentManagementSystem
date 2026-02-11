package vn.edu.hcmut.cse.adsoftweng.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    // JpaRepository<Student, String> có nghĩa là:
    // - Student: Thực thể cần quản lý
    // - String: Kiểu dữ liệu của khóa chính (@Id)

    // Tìm kiếm theo tên, chứa từ khóa (Containing) và không phân biệt hoa thường (IgnoreCase)
    List<Student> findByNameContainingIgnoreCase(String name);
}