package BackEnd.EduGate.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		System.out.println(student);
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("Email already taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (exists) {
			studentRepository.deleteById(studentId);
		} else {
			throw new IllegalStateException("Student with id " + studentId + " not found ");
		}
	}

	@Transactional
	public void updateStudent(Long studentId,
			String name,
			String email) {
		Student student = studentRepository.findById(studentId).orElseThrow(
				() -> new IllegalStateException(
						"Student with id " + studentId + " not found "));

		;
		if (name != null && name.length() > 0
				&& !Objects.equals(student.getName(),
						name)) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
			if (studentByEmail.isPresent()) {
				throw new IllegalStateException("Email already taken");
			}
			student.setEmail(email);

		}

	}
}
