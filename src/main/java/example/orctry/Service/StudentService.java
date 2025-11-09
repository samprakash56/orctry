package example.orctry.Service;

import example.orctry.Entity.Student;
import example.orctry.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String mainPage() {
        return "Hii da!!!!";
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void addStudents(List<Student> student) {
        studentRepository.saveAll(student);
    }


}
