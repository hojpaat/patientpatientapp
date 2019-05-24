package com.greenfoxacademy.patientpatientapp.security;

public class SecurityConstants {
  public static final String SECRET = "AragonitE";
  public static final long EXPIRATION_TIME = 172_800_000; // 2 days
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/register";
  public static final String DOCTORS_URL = "/doctors";
}
