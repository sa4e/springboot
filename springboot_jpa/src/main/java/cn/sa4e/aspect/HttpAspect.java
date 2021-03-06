package cn.sa4e.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * cn.sa4e.controller.GirlController.*(..))")
	public void pointcut() {}
	
	//@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		logger.info("url={}", request.getRequestURL());
		
		//method
		logger.info("method={}",request.getMethod());
		
		//ip
		logger.info("ip={}",request.getRemoteAddr() + request.getRemotePort());
		
		//类方法
		logger.info("classMethod={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		//参数
		logger.info("args={}",joinPoint.getArgs());
	}
	
	
	//@After("pointcut()")
	public void after() {
		logger.info("after..........");
	}
	
	@AfterReturning(returning="object",pointcut="pointcut()")
	public void doAfterReturning(Object object) {
		logger.info("response={}",object.toString());
		
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		logger.info("url={}", request.getRequestURL());
		
		//method
		logger.info("method={}",request.getMethod());
		
		//ip
		logger.info("ip={}",request.getRemoteAddr() + request.getRemotePort());
		
		//类方法
		logger.info("classMethod={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		//参数
		logger.info("args={}",joinPoint.getArgs());
		
		//手动执行目标方法
		Object obj = joinPoint.proceed();
		
		logger.info("after={}","after.....");
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
