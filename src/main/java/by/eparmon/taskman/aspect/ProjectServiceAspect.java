package by.eparmon.taskman.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ProjectServiceAspect {

    @Before("execution(* by.eparmon.taskman.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        log.info("Searching for Project with id=" + joinPoint.getArgs()[0]);
    }
}
