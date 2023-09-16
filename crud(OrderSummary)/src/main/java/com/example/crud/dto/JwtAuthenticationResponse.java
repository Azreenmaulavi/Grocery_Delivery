package com.example.crud.dto;
import lombok.Value;

@Value
public class JwtAuthenticationResponse {
	private String accessToken;
	private boolean authenticated;
	private UserInfo user;

}
