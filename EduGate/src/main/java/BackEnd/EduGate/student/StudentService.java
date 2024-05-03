package BackEnd.EduGate.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public List<Student> getStudentS() {
		return List.of(
				new Student(
						1L,
						"John",
						"john.c.breckinridge@altostrat.com",
						LocalDate.of(2000, 1, 5),
						23));
	}
}
