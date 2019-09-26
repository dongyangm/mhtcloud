package com.mht.util.jwtutil;

import io.jsonwebtoken.Claims;

public class JwtResult {
	private Claims claims;
	//0-成功，1-超时，2-解析错误，3-未知
	private int flag;
	public Claims getClaims() {
		return claims;
	}
	public void setClaims(Claims claims) {
		this.claims = claims;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "JwtResult{" +
				"claims=" + claims +
				", flag=" + flag +
				'}';
	}
}
