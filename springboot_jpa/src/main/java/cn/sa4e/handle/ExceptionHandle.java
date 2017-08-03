package cn.sa4e.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sa4e.exception.GirlException;
import cn.sa4e.pojo.Result;
import cn.sa4e.utils.ResultUtils;

//包含@Component。可以被扫描到。统一处理异常
@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	//用在方法上面表示遇到这个异常就执行以下方法。
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof GirlException) {
			GirlException girlException = (GirlException) e;
			return ResultUtils.error(girlException.getCode(), girlException.getMessage());
		}
		logger.error("【系统异常】{}",e);
		return ResultUtils.error(-1, "未知错误!");
	}
}
