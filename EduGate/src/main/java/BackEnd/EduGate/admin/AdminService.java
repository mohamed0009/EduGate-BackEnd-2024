package BackEnd.EduGate.admin;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
	private final AdminRepository adminRepository;

	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	public void addNewAdmin(Admin admin) {
		Optional<Admin> AdminByEmail = adminRepository.findAdminByEmail(admin.getEmail());
		System.out.println(admin);
		if (AdminByEmail.isPresent()) {
			throw new IllegalStateException("Email already taken");
		}
		adminRepository.save(admin);
	}

	public void deleteAdmin(Long adminId) {
		boolean exists = adminRepository.existsById(adminId);
		if (exists) {
			adminRepository.deleteById(adminId);
		} else {
			throw new IllegalStateException("Admin with id " + adminId + " not found ");
		}
	}

	@Transactional
	public void updateAdmin(Long adminId,
			String name,
			String email) {
		Admin admin = adminRepository.findById(adminId).orElseThrow(
				() -> new IllegalStateException(
						"Admin with id " + adminId + " not found "));

		;
		if (name != null && name.length() > 0
				&& !Objects.equals(admin.getName(),
						name)) {
			admin.setName(name);
		}
		if (email != null && email.length() > 0 && !Objects.equals(admin.getEmail(), email)) {
			Optional<Admin> adminByEmail = adminRepository.findAdminByEmail(email);
			if (adminByEmail.isPresent()) {
				throw new IllegalStateException("Email already taken");
			}
			admin.setEmail(email);

		}

	}
}
