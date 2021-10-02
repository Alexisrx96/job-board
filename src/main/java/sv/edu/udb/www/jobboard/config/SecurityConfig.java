package sv.edu.udb.www.jobboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sv.edu.udb.www.jobboard.filters.JwtRequestFilter;
import sv.edu.udb.www.jobboard.services.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
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
                //.and().sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);*/
    }
/*
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


