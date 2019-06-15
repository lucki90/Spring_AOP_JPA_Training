package pl.lucky.libraryspringaopjpatraining.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.*(..)))")
    public void logInfoBefore(){
        System.out.println("1111 LOG @Before");
    }

    @After("execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.*(..))")
    public void logInfoAfter(){
        System.out.println("2222 LOG @After");
    }

    @AfterThrowing("execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.*(..))")
    public void logError(){
        System.out.println("3333 LOG @AfterThrowing");
    }

    @AfterReturning("execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.*(..))")
    public void logSuccess(){
        System.out.println("4444 LOG @AfterReturning");
    }

}
