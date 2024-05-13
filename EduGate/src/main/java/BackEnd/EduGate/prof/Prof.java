package BackEnd.EduGate.prof;

public class Prof {
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public Prof(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Prof() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prof(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Prof [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
