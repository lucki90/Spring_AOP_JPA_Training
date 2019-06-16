package pl.lucky.libraryspringaopjpatraining.service.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {

    @Pointcut("execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.*(..))")
    public void allBookRepositoryMethods(){

    }
}
