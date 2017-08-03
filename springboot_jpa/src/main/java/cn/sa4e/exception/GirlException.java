package cn.sa4e.exception;

import cn.sa4e.enums.ResultEnum;

public class GirlException extends RuntimeException{

	private Integer code;
	
	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
}
