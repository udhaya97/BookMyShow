/*
 * package com.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationProvider; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class LoginConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * 
 * @Autowired private UserDetailsService userDetailsService;
 * 
 * @Bean public AuthenticationProvider authProvider() {
 * DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
 * provider.setUserDetailsService(userDetailsService);
 * //provider.setPasswordEncoder(Base64.encode); return provider;
 * 
 * }
 * 
 * 
 * // temporary user deffined uname and psd
 * 
 * @Bean
 * 
 * @Override protected UserDetailsService userDetailsService() {
 * 
 * List<UserDetails> users = new ArrayList<>();
 * 
 * users.add(User.withDefaultPasswordEncoder().username("Admin").password(
 * "Admin").roles("Admin").build());
 * 
 * return new InMemoryUserDetailsManager(users); }
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { //
 * 
 * http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().
 * anyRequest().authenticated().and().formLogin().loginPage("/logi").permitAll()
 * .and().logout().invalidateHttpSession(true).clearAuthentication(true).
 * logoutRequestMatcher(new
 * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logi").permitAll();
 * 
 * //http.authorizeRequests().anyRequest().authenticated().and().formLogin().
 * loginPage("/createuser").permitAll();
 * 
 * }
 * 
 * }
 */