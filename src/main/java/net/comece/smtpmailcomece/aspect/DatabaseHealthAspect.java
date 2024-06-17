package net.comece.smtpmailcomece.aspect;

import net.comece.smtpmailcomece.service.DatabaseHealthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Aspect
@Component
public class DatabaseHealthAspect {

    @Autowired
    private DatabaseHealthService databaseHealthService;

    @Before("execution(* net.comece.smtpmailcomece.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void checkDatabaseHealth() {
        if (!databaseHealthService.isDatabaseUp()) {
            throw new DatabaseDownException("Database is down");
        }
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public static class DatabaseDownException extends RuntimeException {
        public DatabaseDownException(String message) {
            super(message);
        }
    }
}


