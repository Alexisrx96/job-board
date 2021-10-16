package sv.edu.udb.www.jobboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import sv.edu.udb.www.jobboard.services.MyUserDetailsService;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private MyUserDetailsService userDetailsService;

    //Calls auth provider
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
       //auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/font-awesome/**", "/fonts/**",
                        "/img/**", "/js/**","/login","/home",
                        "/register-company","/register-professional").permitAll()
                .antMatchers("/p/**").hasAnyRole("Profesional")
                .antMatchers("/a/**").hasAnyRole("Admin")
                .antMatchers("/c/**").hasAnyRole("Empresa")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/login").permitAll()
                .defaultSuccessUrl("/home", true)
                .successForwardUrl("/home")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //http.addFilter(new AuthFilter());
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        /*
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/products", "/api/products/**").permitAll()
                //.antMatchers("/api/orders").hasAnyRole("Customer", "Admin")
                //.antMatchers(HttpMethod.POST, "/api/submit-order").hasAnyRole("Customer", "Admin")
                //.antMatchers("/api/**", "/create-admin").hasRole("Admin")
                .anyRequest().permitAll()
        //http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);*/
    }

    //this is how encrypt the user's password
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }
    //Password encoder
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

