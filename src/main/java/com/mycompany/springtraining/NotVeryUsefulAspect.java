/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springtraining;

import org.aspectj.lang.annotation.Aspect;

/**
 * In Spring AOP, it is not possible to have aspects themselves be the target of advice 
 * from other aspects. The @Aspect annotation on a class marks it as an aspect, 
 * and hence excludes it from auto-proxying.
 * 
 * Due to the proxy-based nature of Spring’s AOP framework, protected methods are by 
 * definition not intercepted, neither for JDK proxies (where this isn’t applicable) nor 
 * for CGLIB proxies (where this is technically possible but not recommendable for AOP 
 * purposes). 
 * As a consequence, any given pointcut will be matched against public methods only!
 * If your interception needs include protected/private methods or even constructors,
 * consider the use of Spring-driven native AspectJ weaving instead of Spring’s 
 * proxy-based AOP framework
 * 
 * 
 * @author Patgaonkar
 */
@Aspect
public class NotVeryUsefulAspect {
    
}
