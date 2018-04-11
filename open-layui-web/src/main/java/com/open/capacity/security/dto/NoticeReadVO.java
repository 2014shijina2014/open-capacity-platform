package com.open.capacity.security.dto;

import java.util.Date;

import com.open.capacity.security.model.Notice;

public class NoticeReadVO extends Notice {

	private static final long serialVersionUID = -3842182350180882396L;

	private Long userId;
	private Date readTime;
	private Boolean isRead;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
}
