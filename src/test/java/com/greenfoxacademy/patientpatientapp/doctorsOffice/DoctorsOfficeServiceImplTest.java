package com.greenfoxacademy.patientpatientapp.doctorsOffice;

import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorDto;
import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOffice;
import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOfficeRepository;
import com.greenfoxacademy.patientpatientapp.doctorsOffice.DoctorsOfficeServiceImpl;
import com.greenfoxacademy.patientpatientapp.exception.DoctorsOfficeException;
import com.greenfoxacademy.patientpatientapp.user.ApplicationUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorsOfficeServiceImplTest {

  private ApplicationUser testDoctor1;
  private ApplicationUser testDoctor2;
  private DoctorsOffice testDoctorsOffice1;
  private DoctorsOffice testDoctorsOffice2;
  private List<DoctorsOffice> testDoctorsOffices;

  @Mock
  private DoctorsOfficeRepository doctorsOfficeRepository;

  private DoctorsOfficeServiceImpl doctorsOfficeServiceImpl;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    doctorsOfficeServiceImpl = new DoctorsOfficeServiceImpl(doctorsOfficeRepository);
    testDoctor1 = new ApplicationUser();
    testDoctor1.setName("Dr Duna");
    testDoctor2 = new ApplicationUser();
    testDoctorsOffice1 = new DoctorsOffice(1, "Test street 1", testDoctor1);
    testDoctorsOffice2 = new DoctorsOffice(2, "Test street 2", testDoctor2);
    testDoctorsOffices = new ArrayList<>();
    testDoctorsOffices.add(testDoctorsOffice1);
    testDoctorsOffices.add(testDoctorsOffice2);
  }

  @Test(expected = DoctorsOfficeException.class)
  public void saveDoctorsOffice_exsisting_throwsException() throws DoctorsOfficeException {
    when(doctorsOfficeRepository.findByAddress(testDoctorsOffice1.getAddress()))
            .thenReturn(testDoctorsOffice1);
    doctorsOfficeServiceImpl.saveDoctorsOffice(testDoctorsOffice1);
  }

  @Test
  public void saveDoctorsOffice_ableToSave() throws DoctorsOfficeException {
    when(doctorsOfficeRepository.findByAddress(testDoctorsOffice1.getAddress())).thenReturn(null);
    when(doctorsOfficeRepository.save(testDoctorsOffice1)).thenReturn(testDoctorsOffice1);
    assertEquals(testDoctorsOffice1.getAddress(),
            doctorsOfficeServiceImpl.saveDoctorsOffice(testDoctorsOffice1).getAddress());
  }

  @Test
  public void getDoctors_twoSizeArray() {
    when(doctorsOfficeRepository.findAll()).thenReturn(testDoctorsOffices);
    List<DoctorDto> resultList = doctorsOfficeServiceImpl.getDoctors();
    assertEquals(2, doctorsOfficeServiceImpl.getDoctors().size());
    assertEquals("Dr Duna", resultList.get(0).getName());
  }

  @Test
  public void getDoctors_addBackRightClass() {
    when(doctorsOfficeRepository.findAll()).thenReturn(testDoctorsOffices);
    assertTrue(doctorsOfficeServiceImpl.getDoctors().get(0) instanceof DoctorDto);
    assertEquals("DoctorDto",
            doctorsOfficeServiceImpl.getDoctors().get(1).getClass().getSimpleName());
  }


}
