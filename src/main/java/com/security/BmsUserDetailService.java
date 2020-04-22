/*
 * package com.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.model.UserReg; import com.repo.RegRepo;
 * 
 * @Service public class BmsUserDetailService implements UserDetailsService {
 * 
 * @Autowired private RegRepo rRepo;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * UserReg user = rRepo.findByUName(username); if (user == null)
 * 
 * throw new UsernameNotFoundException("User not found");
 * 
 * return new UserDetailsImpl(user); }
 * 
 * }
 */