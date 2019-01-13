package cn.sunline.tiny;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.sunline.tiny.web.Context;


@Aspect
@Component("tbsAudit")
public class TbsAudit  {
	private static final Logger LOG = LoggerFactory.getLogger(TbsAudit.class);
	//@Pointcut("execution(* cn.sunline.tiny.AppController.index(..))")
	//@Pointcut("execution(* cn.sunline.tiny.controller.TestController.doControl(..))")
	//@Pointcut("execution(* cn.sunline.tiny.AppController.doControl(..))")
	@Pointcut("execution(* cn.sunline.tiny.core.control.MainCtl.doControl(..))")
	public void doControlTmlPointCut() {
		
		//LOG.debug("execution...........................doControlTmlPointCut");
	}

	
	@Around("doControlTmlPointCut()")
	public int Interceptor(ProceedingJoinPoint pjp) {
		
		LOG.debug("Interceptor++++++++++++++++++++++++++++=");
		
		Context ct = null;
		int result = 0;
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if (arg instanceof Context) {
				ct = (Context) arg;
			}
		}
		
		try {
			pjp.proceed(args);
			 
		} catch (Throwable e) {
			e.printStackTrace();
		}
		LOG.debug("Interceptor+++++++++++++222222+++++++++++++++=");
		return 0;
	}

	

	
}
