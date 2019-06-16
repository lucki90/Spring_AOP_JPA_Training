package pl.lucky.libraryspringaopjpatraining.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.lucky.libraryspringaopjpatraining.model.Book;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("pl.lucky.libraryspringaopjpatraining.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.printf("1111 LOG @Before %s with args: %s\n", joinPoint.getSignature(), Arrays.toString(args));
    }

    @After("pl.lucky.libraryspringaopjpatraining.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoAfter() {
        System.out.println("2222 LOG @After");
    }

    @AfterThrowing(
            pointcut = "pl.lucky.libraryspringaopjpatraining.service.aspects.AspectUtil.allBookRepositoryMethods()",
            throwing = "error")
    public void logError(JoinPoint joinPoint, Throwable error) {
        System.out.printf("3333 LOG @AfterThrowing. Method %s finished with error %s. ", joinPoint.getSignature(), error.getMessage());
    }

    @AfterReturning(pointcut = "execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.get(..)) && args(isbn)", returning = "result")
    public void logSuccess(JoinPoint joinPoint, String isbn, Book result) {
        if (result != null) {
            System.out.printf("4444 LOG @AfterReturning value : %s for isbn: %s ", result, isbn);
        }
    }
}
