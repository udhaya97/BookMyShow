/*
 * package com.security;
 * 
 * import java.util.Collection; import java.util.Collections;
 * 
 * import org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails;
 * 
 * import com.model.UserReg;
 * 
 * public class UserDetailsImpl implements UserDetails {
 * 
 * private UserReg user;
 * 
 * public UserDetailsImpl(UserReg user) { super(); this.user = user; }
 * 
 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
 * 
 * return Collections.singletonList(new SimpleGrantedAuthority("Admin")); }
 * 
 * @Override public String getPassword() { // TODO Auto-generated method stub
 * return user.getPass(); }
 * 
 * @Override public String getUsername() { // TODO Auto-generated method stub
 * return user.getuName(); }
 * 
 * @Override public boolean isAccountNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * 
 * @Override public boolean isAccountNonLocked() { // TODO Auto-generated method
 * stub return true; }
 * 
 * @Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * 
 * @Override public boolean isEnabled() { // TODO Auto-generated method stub
 * return true; }
 * 
 * }
 */