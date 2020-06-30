package com.abc.xyz.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.xyz.message.request.LoginForm;
import com.abc.xyz.message.request.SignUpForm;
import com.abc.xyz.message.response.JwtResponse;
import com.abc.xyz.message.response.ResponseMesssage;
import com.abc.xyz.entity.Account;
import com.abc.xyz.entity.Product;
import com.abc.xyz.entity.Role;
import com.abc.xyz.entity.RoleName;
//import com.abc.xyz.entity.User;
import com.abc.xyz.repository.AccountRepository;
import com.abc.xyz.repository.RoleRepository;
import com.abc.xyz.repository.AccountRepository;
import com.abc.xyz.security.jwt.JwtProvider;
import com.abc.xyz.service.AccountPrinciple;
import com.abc.xyz.service.AccountService;
import com.abc.xyz.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountService accountService;
	
	@Autowired
	RoleRepository roleRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public Optional<Account> deteilAccount(@PathVariable(value = "id") int id)
    {
        return accountService.deteilAccount(id);
    }

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getAccountname(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@PostMapping("/signup123")
	public @Valid String registerUser111(@Valid @RequestBody SignUpForm signUpRequest) {
		return signUpRequest.getAccountname();
	}

	@PostMapping("/signup")
	public @Valid ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (accountRepository.existsByAccountname(signUpRequest.getAccountname())) {
			return new ResponseEntity<>(new ResponseMesssage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMesssage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Account user = new Account(signUpRequest.getName(), signUpRequest.getAccountname(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		accountRepository.save(user);

		return new ResponseEntity<>(new ResponseMesssage("User registered successfully!"), HttpStatus.OK);
	}
}