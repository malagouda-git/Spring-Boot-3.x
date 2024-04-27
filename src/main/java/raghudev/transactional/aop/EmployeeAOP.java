package raghudev.transactional.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import raghudev.transactional.entities.EmployeeEntity;

import java.time.Instant;

@Component
@Aspect
public class EmployeeAOP {

    //Executes 1st line of the method start
    @Before("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public void beforeAdviceSaveEmployee(JoinPoint joinPoint){
        System.out.println("Inside Employee method : "+joinPoint.getSignature()+" Time: "+ Instant.now());
    }

    //Executes Last line of the method end
    @After("execution(* raghudev.transactional.controllers.EmployeeController.*(..))")
    public void afterAddEmployeeAdvice(JoinPoint joinPoint){
        System.out.println("After Emplyee Advice : "+joinPoint.getSignature()+" Time: "+ Instant.now());
    }

    //Execute only if there is an exception in saving employee process
    @AfterThrowing(value = "execution(* raghudev.transactional.controllers.EmployeeController.*(..))", throwing = "exception")
    public void afterAddEmployeeAdviceError(JoinPoint joinPoint, Exception exception){
        System.out.println("Error in saving Employee : "+joinPoint.getSignature()+" Time: "+ Instant.now()+" error : "+exception.getMessage());
    }

    //Execute only if there is no exception in saving employee process, successfull save of employee
    @AfterReturning(value = "execution(* raghudev.transactional.controllers.EmployeeController.*(..))", returning = "employee")
    public void afterAddEmployeeAdviceSuccess(JoinPoint joinPoint, EmployeeEntity employee){
        System.out.println("Employee Saved Successful : "+joinPoint.getSignature()+" Time: "+ Instant.now()+" emp id "+employee.getEmployeeId());
    }

    //(..) means any number of arguments (0 or more
}
