//package gr.uninystems.rdi.iot_data_aquisition.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
//
//@Entity
//public class User {
//    @org.springframework.data.annotation.Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @jakarta.persistence.Id
//    @Column(name = "`ID`")
//    private Long Id;
//    @Column(name = "`USERNAME`")
//    private String username;
//    @Column(name = "`PASSWORD`")
//    private String password;
//    @Column(name = "`EMAIL`")
//    private String email;
//    @Column(name = "`ROLE`")
//    private String role;
//
//    public User() {
//    }
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//}
