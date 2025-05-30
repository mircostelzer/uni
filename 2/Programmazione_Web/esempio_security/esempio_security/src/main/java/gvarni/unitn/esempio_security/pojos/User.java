package gvarni.unitn.esempio_security.pojos;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role;

    public User() {
            this.id = 0;
            this.firstName = "";
            this.lastName = "";
            this.email = "";
            this.username = "";
            this.password = "";
            this.role = "";
    }

    public User(String firstName, String lastName, String email, String username, String password, String role) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmail() {return email;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getRole() {return role;}

    public void setId(int id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(String role) {this.role = role;}
}
