package pl.lucky.libraryspringaopjpatraining.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class TimeLoggerAspect {

    @Around("execution(* pl.lucky.libraryspringaopjpatraining.service.BookRepository.*(..))")
    public Object measuerExecTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant before = Instant.now();
//            @Before
        try {
            Object result = pjp.proceed();
//            @After
            return result;
//        } catch (Throwable a) {
//            @AfterThrowing gdyby nie było thows
        } finally {
//            @AfterReturning
            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms/n\n", pjp.toShortString(), execTime.toMillis());
        }
    }
}
