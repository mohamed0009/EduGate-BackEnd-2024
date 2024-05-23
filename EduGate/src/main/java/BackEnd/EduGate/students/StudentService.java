package BackEnd.EduGate.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackEnd.EduGate.classes.Classe;
import BackEnd.EduGate.classes.ClasseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    private StudentDTO convertToDTO(Student student) {
        Classe classe = student.getClasse();
        ClasseDTO classeDTO = new ClasseDTO(
                classe.getIdClasse(),
                classe.getNomClasse(),
                classe.getNiveau());

        return new StudentDTO(student.getIdEleve(), classeDTO);
    }
}
