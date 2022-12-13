package u9urturk.carpetwashing.io.core.utilities.auth.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.dataAccess.abstracts.RoleListDao;
import u9urturk.carpetwashing.io.dataAccess.abstracts.UserDao;
import u9urturk.carpetwashing.io.entities.concretes.dtos.RoleListWithUserAndRoleDto;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {
	
	private final JwtAthFilter jwtAuthFilter;
	private final UserDao userDao;
	private final RoleListDao roleListDao;

	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//System.out.println("40 ! ");
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**/auth/**").permitAll()
				.antMatchers("/api/images/getalldetails").hasRole("USER")
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class)
				;
			
			return http.build();
			
			
			
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		//System.out.println("66.satır çalıştı");
		final DaoAuthenticationProvider authenticationProvider  = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configure) throws Exception {
		//System.out.println("75.satır çalıştı");
		return configure.getAuthenticationManager();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder();
	}
	
	
	@Bean 
	public UserDetailsService userDetailsService() {
		
		//System.out.println("88.satır çalıştı");
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String email) {
				
				
				User userD = new User(
						userDao.findByEmail(email).getEmail(),
						userDao.findByEmail(email).getPassword(),
						Collections.singleton(new SimpleGrantedAuthority(roleListDao.getDetailsByEmail(email).getRole()))
						);
				
				return userD;
			};
		};
	}
	
	
}
