package com.greenfoxacademy.patientpatientapp.user;

import com.greenfoxacademy.patientpatientapp.exception.UserException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
  
  private ApplicationUser testUser1;
  
  @Mock
  private UserRepository userRepository;
  @Mock
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  
  private UserServiceImpl userServiceImpl;
  
  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    userServiceImpl = new UserServiceImpl(userRepository, bCryptPasswordEncoder);
    testUser1 = new ApplicationUser();
    testUser1.setName("TestElek");
  }
  
  @Test(expected = UserException.class)
  public void saveUser_exsistingName_throwsException() throws UserException {
    when(userRepository.findByUsername(testUser1.getUsername())).thenReturn(testUser1);
    userServiceImpl.saveUser(testUser1);
  }
  
  
}
