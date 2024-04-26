package raghudev.transactional.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Aspect
public class EmployeeAOP {

    @Before("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public void beforeAdviceSaveEmployee(JoinPoint joinPoint){
        System.out.println("Inside Employee method : "+joinPoint.getSignature()+" Time: "+ Instant.now());
    }

    @After("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public void afterAddEmployeeAdvice(JoinPoint joinPoint){
        System.out.println("After Employee method : "+joinPoint.getSignature()+" Time: "+ Instant.now());
    }
}
