package BackEnd.EduGate.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAdminS() {
        return adminService.getAdmins();
    }

    @PostMapping
    public Void registerNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
        return null;
    }

    @DeleteMapping(path = "{adminId}")
    public void deleteAdmin(@PathVariable("adminId") Long adminId) {
        adminService.deleteAdmin(adminId);
    }

    @PutMapping(path = "{adminId}")
    public void updateAdmin(
            @PathVariable("adminId") Long adminId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                adminService.updateAdmin(adminId, name, email);

    }

}
