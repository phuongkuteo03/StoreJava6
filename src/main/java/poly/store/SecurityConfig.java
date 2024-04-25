package poly.store;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import poly.store.entity.Account;
import poly.store.service.AccountService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountService accountService;
	@Autowired
	BCryptPasswordEncoder pe;

	// Cung cap nguon du lieu dang nhap
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(username -> {
			try {
				Account user = accountService.findById(username);
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream()
						.map(er -> er.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				throw new UsernameNotFoundException(username + " not found!");
			}
		});
	}

	// Phan quyen su dung
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().cors().disable(); //Ngăn chặn các request giả lập - Ngăn chặn chia sẻ tài nguyên
		http.authorizeRequests()
				.antMatchers("/order/**").authenticated()
				.antMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
				.antMatchers("/rest/authorities").hasRole("DIRE")
				.anyRequest().permitAll();

		http.formLogin()
				.loginPage("/security/login/form")
				.loginProcessingUrl("/security/login")
				.defaultSuccessUrl("/security/login/success", false)
				.failureForwardUrl("/security/login/error");
		http.rememberMe()
				.tokenValiditySeconds(86400);

		http.exceptionHandling() // xử lý ngoại lệ
				.accessDeniedPage("/security/unauthoried"); // truy cập trang bị từ chối

		http.logout()
				.logoutUrl("/security/logoff")
				.logoutSuccessUrl("/security/logoff/success");

		// Dang nhap mang xa hoi
		http.oauth2Login()
				.loginPage("/security/login/form")
				.defaultSuccessUrl("/oauth2/login/success", true)
				.failureUrl("/security/login/error")
				.authorizationEndpoint()
					.baseUri("/security/authorization")
					.authorizationRequestRepository(getRepository())
				.and().tokenEndpoint()
					.accessTokenResponseClient(getToken());
	}
	
	@Bean
	public AuthorizationRequestRepository<OAuth2AuthorizationRequest> getRepository(){
		return new HttpSessionOAuth2AuthorizationRequestRepository();
	}
	
	@Bean
	public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> getToken(){
		return new DefaultAuthorizationCodeTokenResponseClient();
	}

	// Co che ma hoa mat khau
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Cho phep truy xuat REST API tu ben ngoai(domain khac)
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
