package com.mohanty.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(User users) {
    	 this.active = users.getActive();
         this.email = users.getEmail();
         this.roles = users.getRoles();
         this.name = users.getName();
         this.lastName =users.getLastName();
         this.id = users.getId();
         this.password = users.getPassword();
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "active")
    private int active;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", 
    		   joinColumns = @JoinColumn(name = "user_id"), 
    		   inverseJoinColumns = @JoinColumn(name = "role_id")
    			)
    private Set<Role> roles ;
    
    

}
