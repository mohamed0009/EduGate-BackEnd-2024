package BackEnd.EduGate.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        boolean studentById = studentRepository.existsById(student.getIdEleve());
        if (studentById) {
            throw new IllegalStateException("Eleve already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (exists) {
            studentRepository.deleteById(studentId);
        } else {
            throw new IllegalStateException("Eleve with id " + studentId + " not found ");
        }
    }

    public void updateStudent(Long studentId, Student updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setClasse(updatedStudent.getClasse());
            studentRepository.save(student);
        } else {
            throw new IllegalStateException("Eleve with id " + studentId + " not found ");
        }
    }
}
