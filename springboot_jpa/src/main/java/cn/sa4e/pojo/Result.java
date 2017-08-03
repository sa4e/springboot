package cn.sa4e.pojo;

import java.io.Serializable;

public class Result<T> implements Serializable{
	
	//错误码
	private Integer code;
	
	//提示信息
	private String message;
	
	//具体的内容
	private T data;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
