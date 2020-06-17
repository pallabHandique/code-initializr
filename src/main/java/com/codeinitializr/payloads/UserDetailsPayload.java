package com.codeinitializr.payloads;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.codeinitializr.models.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserDetailsPayload
 */
public class UserDetailsPayload implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
	private String firstName;
	private String lastName;
    private String email;
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean accountNonExpired = true;
    
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean accountNonLocked = true;
    
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean credentialsNonExpired = true;
    
	@Column(columnDefinition = "tinyint(1) default 0")
    private boolean isEnabled = true;
    
    private List<GrantedAuthority> authorities;

    public UserDetailsPayload(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.accountNonExpired = user.getAccountNonExpired();
        this.accountNonLocked = user.getAccountNonLocked();
        this.credentialsNonExpired = user.getCredentialsNonExpired();
        this.isEnabled = user.getIsEnabled();
        this.authorities = user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


    public UserDetailsPayload() {
    }

    public UserDetailsPayload(String username, String password, String firstName, String lastName, String email, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean isEnabled, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getAccountNonExpired() {
        return this.accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean getAccountNonLocked() {
        return this.accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean getCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isIsEnabled() {
        return this.isEnabled;
    }

    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public UserDetailsPayload username(String username) {
        this.username = username;
        return this;
    }

    public UserDetailsPayload password(String password) {
        this.password = password;
        return this;
    }

    public UserDetailsPayload firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDetailsPayload lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDetailsPayload email(String email) {
        this.email = email;
        return this;
    }

    public UserDetailsPayload accountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public UserDetailsPayload accountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public UserDetailsPayload credentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public UserDetailsPayload authorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDetailsPayload)) {
            return false;
        }
        UserDetailsPayload userDetailsPayload = (UserDetailsPayload) o;
        return Objects.equals(username, userDetailsPayload.username) && Objects.equals(password, userDetailsPayload.password) && Objects.equals(firstName, userDetailsPayload.firstName) && Objects.equals(lastName, userDetailsPayload.lastName) && Objects.equals(email, userDetailsPayload.email) && accountNonExpired == userDetailsPayload.accountNonExpired && accountNonLocked == userDetailsPayload.accountNonLocked && credentialsNonExpired == userDetailsPayload.credentialsNonExpired && isEnabled == userDetailsPayload.isEnabled && Objects.equals(authorities, userDetailsPayload.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, email, accountNonExpired, accountNonLocked, credentialsNonExpired, isEnabled, authorities);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", accountNonExpired='" + isAccountNonExpired() + "'" +
            ", accountNonLocked='" + isAccountNonLocked() + "'" +
            ", credentialsNonExpired='" + isCredentialsNonExpired() + "'" +
            ", isEnabled='" + isIsEnabled() + "'" +
            ", authorities='" + getAuthorities() + "'" +
            "}";
    }

}