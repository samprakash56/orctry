package example.orctry.Controller;

import example.orctry.Entity.Student;
import example.orctry.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String mainPage(){
        return studentService.mainPage();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Map<String,Object>> getStudentById(@PathVariable("id") Integer id) {
        Student student =  studentService.getStudentById(id);
        Map<String,Object> response = new HashMap<>();
        if (student == null){
            response.put("message","Student not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("message","Student found");
        response.put("data",student);
        response.put("status",HttpStatus.OK);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/students")
    public String addStudents(@RequestBody List<Student> students) {
        int k = students.size();  // ✅ use size() instead of length()
        studentService.addStudents(students);
        return k + " students added successfully";
    }

}
