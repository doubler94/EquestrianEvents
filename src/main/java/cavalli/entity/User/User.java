package cavalli.entity.User;

import cavalli.entity.Rider.Rider;

import javax.persistence.*;

/**
 * Created by Ola on 05.11.2016.
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Username")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    @OneToOne
    @JoinColumn(name = "Id")
    public Rider rider;

//    @OneToOne
//    @JoinColumn(name = "Id")
//    public Organizer organizer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
