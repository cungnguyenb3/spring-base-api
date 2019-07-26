package vn.com.minori.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "password")
    private String password;

//    @ManyToMany(cascade=CascadeType.MERGE)
//    @JoinTable(
//        name="users_roles",
//        joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
//        inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")}
//    )
//    private List<Role> roles;

}
