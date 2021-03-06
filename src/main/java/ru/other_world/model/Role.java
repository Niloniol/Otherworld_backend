package ru.other_world.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLES")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = true)
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private List<Client> clients;

    public Role(){
    }

    public Role(Role role){
        this.id = role.id;
        this.role = role.role;
        this.clients = role.clients;
    }

    public Role(Long id, String role){
        this.id = id;
        this.role = role;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Role(String role){
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
