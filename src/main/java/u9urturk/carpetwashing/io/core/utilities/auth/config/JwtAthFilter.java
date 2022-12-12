package u9urturk.carpetwashing.io.core.utilities.auth.config;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;
import u9urturk.carpetwashing.io.dataAccess.abstracts.UserDao;





@Component
@RequiredArgsConstructor
public class JwtAthFilter  extends OncePerRequestFilter {
	
	private final UserDao userDao;
	private final JwtUtils jwtUtils;
	
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)throws ServletException, IOException {
		
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String userEmail;
		final String jwtToken;
		
		
		if(authHeader == null || !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwtToken = authHeader.substring(7);
		userEmail =jwtUtils.extractUsername(jwtToken);
		if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			
			User userD = new User(
					userDao.findByEmail(userEmail).getEmail(),
					userDao.findByEmail(userEmail).getPassword(),
					Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
					
					);
			
			
			
			UserDetails userDetails = userD;
			//System.out.println(userDetails);
			
			if(jwtUtils.isTokenValid(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken authToken =
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}
}
