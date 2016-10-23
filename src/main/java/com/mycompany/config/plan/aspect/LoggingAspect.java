package com.mycompany.config.plan.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	Logger log = Logger.getLogger(LoggingAspect.class);
	public LoggingAspect(){
		
	}
	
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		if(log.isDebugEnabled()){
			log.debug("Invoking method "+jp.getSignature().toShortString() +" of "+jp.getSignature().getDeclaringType().getCanonicalName());
		}
		Object[] args = jp.getArgs();
		if (args.length > 0) {
			if(log.isDebugEnabled()){
				log.debug("Arguments passed: ");
			}
			for (int i = 0; i < args.length; i++) {
				if(log.isDebugEnabled()){
					log.debug("Arg" + (i + 1) + "::" + args[i]);
				}
			}
		}
		Object result = jp.proceed(args);
		return result;
	}
}