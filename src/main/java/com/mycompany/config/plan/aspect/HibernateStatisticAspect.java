package com.mycompany.config.plan.aspect;

import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

public class HibernateStatisticAspect {
	Logger log = Logger.getLogger(HibernateStatisticAspect.class);
	private SessionFactory sessionFactory;
	public HibernateStatisticAspect(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Object printStatistics(ProceedingJoinPoint jp) throws Throwable {
		Object[] args = jp.getArgs();
		Statistics stats = null;
		
		if(sessionFactory!=null){
			stats = sessionFactory.getStatistics();
			stats.setStatisticsEnabled(true);
		}
		
		Object result = jp.proceed(args);
		
		if(stats!=null){
		    String regions[] = stats.getSecondLevelCacheRegionNames();
		    
		    for(String regionName:regions) {
		    	if(log.isDebugEnabled()){
		    		log.debug(regionName);
		    	}
		    	if(regionName!=null && regionName.startsWith("com.mycompany")){
			        org.hibernate.stat.SecondLevelCacheStatistics stat2 = stats.getSecondLevelCacheStatistics(regionName);
			        Iterator entry= stat2.getEntries().entrySet().iterator();
			        while(entry.hasNext()){
			        	if(log.isDebugEnabled()){
				        	log.debug("Cache Entry - "+entry.next());
			        	}
			        }
			        if(log.isDebugEnabled()){
				        log.debug("2nd Level Cache(" +regionName+") Put Count: "+stat2.getPutCount());
				        log.debug("2nd Level Cache(" +regionName+") HIt Count: "+stat2.getHitCount());
				        log.debug("2nd Level Cache(" +regionName+") Miss Count: "+stat2.getMissCount());
			        }
		    	}
		    	//stats.logSummary();
		    }
		}		
		return result;
	}
}
