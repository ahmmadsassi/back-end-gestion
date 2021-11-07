package de.tekup.project.service;

import javax.transaction.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.tekup.project.Model.CustomUserBean;
import de.tekup.project.Model.User;
import de.tekup.project.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	
	




	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepository.findByUserName(username)
                 .orElseThrow(() -> new UsernameNotFoundException("User with "
                     + "user name "+ username + " not found"));
 return CustomUserBean.createInstance(user);
	}

}
