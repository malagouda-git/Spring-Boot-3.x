package raghudev.transactional.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import raghudev.transactional.dtos.EmployeeDTO;
import raghudev.transactional.entities.EmployeeEntity;

import java.time.Instant;

@Component
@Aspect
public class EmployeeAOP {

    //(..) means any number of arguments (0 or more

    //Executes 1st line of the method start
    @Before("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public void beforeAdviceSaveEmployee(JoinPoint joinPoint){
        System.out.println("Before Pointcut : "+joinPoint.getSignature()+" Time: "+ Instant.now());
    }

    //Executes Last line of the method end
    @After("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public void afterAddEmployeeAdvice(JoinPoint joinPoint){
        System.out.println("After Pointcut : "+joinPoint.getSignature()+" Time: "+ Instant.now());
    }

    //Execute only if there is an exception in saving employee process
    @AfterThrowing(value = "execution(* raghudev.transactional.controllers.EmployeeController.*(..))", throwing = "exception")
    public void afterAddEmployeeAdviceError(JoinPoint joinPoint, Exception exception){
        System.out.println("After Throwing Pointcut: "+joinPoint.getSignature()+" Time: "+ Instant.now()+" error : "+exception.getMessage());
    }

    //Execute only if there is no exception in saving employee process, successfull save of employee
    @AfterReturning(value = "execution(* raghudev.transactional.controllers.EmployeeController.*(..))", returning = "responseEnitity")
    public void afterAddEmployeeAdviceSuccess(JoinPoint joinPoint, ResponseEntity responseEnitity){
        System.out.println("After Returning Pointcut: "+joinPoint.getSignature()+" Time: "+ Instant.now()+" emp id "+responseEnitity.toString());
    }

    //Get the full control of execution of the method
    //If your using both @Before and @Around then @Around takes prceedence
    //Remember to add proceedingJoinPoint.proceed() otherwise your method never executes
    //Remember to return returnType of the method which the original method is returning.
    @Around("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public ResponseEntity aroundAdviceSaveEmployee(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Start of Around PointCut : "+proceedingJoinPoint.getSignature()+" Time: "+ Instant.now());
        try {
            ResponseEntity responseEntity= (ResponseEntity) proceedingJoinPoint.proceed();// Always remember to add this line otherwise your method never executes
            System.out.println("End of Around PointCut : "+proceedingJoinPoint.getSignature()+" Time: "+ Instant.now());
            return responseEntity;
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
        return null;
    }


}
