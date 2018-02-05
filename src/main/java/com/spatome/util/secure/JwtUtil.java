package com.spatome.util.secure;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @ClassName: JwtUtil
 * @Description: TOKEN生成、解析工具
 * @author: zhangwei
 * @date: 2017年7月21日 下午2:31:01
 */
public class JwtUtil {
	private final static String BASE_SECRET = "demo.spatome.com";

	public final static ObjectMapper OM = new ObjectMapper();
	static{
		OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 生成TOKEN
	 * 
	 * @param TokenInfo
	 * @param ttlMillis
	 *            过期时间：毫秒 ， 不过期：0
	 * @return
	 * @throws Exception
	 */
	public static String sign(TokenInfo tokenInfo, long ttlMillis) throws Exception {
		String tokenInfoJson = OM.writeValueAsString(tokenInfo);

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject(tokenInfoJson).signWith(SignatureAlgorithm.HS512, BASE_SECRET);
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		return builder.compact();
	}

	/**
	 * 解密 ExpiredJwtException 过期异常,自行扑捉
	 * 
	 * @param token
	 * @return userSN
	 * @throws Exception
	 */
	public static TokenInfo unSign(String token) throws Exception {
		Claims claims = Jwts.parser().setSigningKey(BASE_SECRET).parseClaimsJws(token).getBody();
		
		String tokenInfoJson = claims.getSubject();
		TokenInfo tokenInfo = OM.readValue(tokenInfoJson, TokenInfo.class);

		return  tokenInfo;
	}

	public static class TokenInfo {
		private String userNo;
		private String roleNo;

		public TokenInfo() {
		}

		public TokenInfo(String userNo) {
			this.userNo = userNo;
		}
		public TokenInfo(String userNo, String roleNo) {
			this.userNo = userNo;
			this.roleNo = roleNo;
		}

		public String getUserNo() {
			return userNo;
		}

		public void setUserNo(String userNo) {
			this.userNo = userNo;
		}

		public String getRoleNo() {
			return roleNo;
		}

		public void setRoleNo(String roleNo) {
			this.roleNo = roleNo;
		}
	}

	public static void main(String[] args) {
		//String ss = "{\"userNo\":null,\"roleNo\":\"admin\"}";
		String ss = "{\"userNo\":\"aaa\",\"roleNo\":\"admin\"}";
		
		try {
			TokenInfo tokenInfo = OM.readValue(ss, TokenInfo.class);
			
			System.out.println(tokenInfo.getUserNo());
			System.out.println(tokenInfo.getRoleNo());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
