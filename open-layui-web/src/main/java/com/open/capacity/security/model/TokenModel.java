package com.open.capacity.security.model;

import java.util.Date;

public class TokenModel extends BaseEntity<String> {

	private static final long serialVersionUID = 4566334160572911795L;

	/**
	 * 过期时间
	 */
	private Date expireTime;
	/**
	 * LoginUser的json串
	 */
	private String val;

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
