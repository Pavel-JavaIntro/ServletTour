package by.course.tourist.aspect;

import by.course.tourist.model.Tour;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
public class LogAspect {

  @Around("execution(* by.course.tourist.controller.rest.TourRestController.getTours())")
  public ResponseEntity<List<Tour>> logTourCheck(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("before " + joinPoint.getSignature().getName());
    ResponseEntity<List<Tour>> re = (ResponseEntity) joinPoint.proceed();
    log.info("after");
    return re;
  }

  @Before("@annotation(by.course.tourist.annotation.LogAnnotation)")
  public void markAnnotation() {
    log.info("Method with annotation invoked");
  }
}
