package com.app.raghu;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Test {

	public static void main(String[] args) {
		String secret = "TestAppOneSample";
		
		String token = 
		Jwts.builder()
		.setId("8562455") //user UnqId
		.setSubject("sample") //username
		.setIssuedAt(new Date(System.currentTimeMillis())) //created time
		.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2))) //exp time
		.setIssuer("ASHOKIT") //token provider name
		.signWith(SignatureAlgorithm.HS256, secret.getBytes()) //sec algo, secret
		.compact();
		
		System.out.println(token);
		
		Claims c =
		Jwts.parser()
		.setSigningKey(secret.getBytes())
		.parseClaimsJws(token).getBody();
		
		System.out.println(c.getSubject());
		System.out.println(c.getIssuer());
		System.out.println(c.getExpiration());
		
	}
}
