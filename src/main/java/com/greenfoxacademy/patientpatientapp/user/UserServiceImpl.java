package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.exception.UserException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public ApplicationUserDto saveUser(ApplicationUser user)
          throws UserException {
    if (userRepository.findByUsername(user.getUsername()) == null && checkIfValid(user)) {
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      return mapUserToDto(userRepository.save(user));
    }
    throw new UserException("Username already taken, please choose an other one.");
  }

  public boolean checkIfValid(ApplicationUser user) throws UserException {
    boolean missingUserName = user.getUsername() == null || user.getUsername().length() == 0;
    boolean missingPassword = user.getPassword() == null || user.getPassword().length() == 0;
    if (missingUserName && missingPassword) {
      throw new UserException("Missing parameter(s): username, password");
    } else if (missingUserName) {
      throw new UserException("Missing parameter(s): username!");
    } else if (missingPassword) {
      throw new UserException("Missing parameter(s): password!");
    }
    return true;
  }

  public ApplicationUserDto mapUserToDto(ApplicationUser applicationUser) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(applicationUser, ApplicationUserDto.class);
  }
  
  public ApplicationUser getLoggedInUser(Authentication auth) {
    return userRepository.findByUsername(auth.getPrincipal().toString());
  }
}
