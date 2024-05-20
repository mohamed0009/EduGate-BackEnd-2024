package BackEnd.EduGate.admins;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        boolean adminById = adminRepository.existsById(admin.getId());
        if (adminById) {
            throw new IllegalStateException("Admin already exists");
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
}
