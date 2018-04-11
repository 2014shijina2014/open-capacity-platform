package com.open.capacity.security.dto;

import java.io.Serializable;

public class LayuiFile implements Serializable {

	private static final long serialVersionUID = 35435494737590569L;

	private Integer code;
	private String msg;
	private LayuiFileData data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LayuiFileData getData() {
		return data;
	}

	public void setData(LayuiFileData data) {
		this.data = data;
	}

	public static class LayuiFileData implements Serializable {

		private static final long serialVersionUID = 7907356434695924597L;
		private String src;
		private String title;

		public String getSrc() {
			return src;
		}

		public void setSrc(String src) {
			this.src = src;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
