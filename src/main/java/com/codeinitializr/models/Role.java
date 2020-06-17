package com.codeinitializr.models;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

/**
 * Role
 */
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long id;

	private String role;

	@Size(max = 300)
	private String roleDescription;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;


    public Role() {
    }

    public Role(Long id, String role, String roleDescription, Collection<User> users) {
        this.id = id;
        this.role = role;
        this.roleDescription = roleDescription;
        this.users = users;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Collection<User> getUsers() {
        return this.users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Role id(Long id) {
        this.id = id;
        return this;
    }

    public Role role(String role) {
        this.role = role;
        return this;
    }

    public Role roleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
        return this;
    }

    public Role users(Collection<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(role, role.role) && Objects.equals(roleDescription, role.roleDescription) && Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, roleDescription, users);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", role='" + getRole() + "'" +
            ", roleDescription='" + getRoleDescription() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }
	
}