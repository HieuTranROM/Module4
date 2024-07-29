package com.codegym.ung_dung_muon_sach.aspect;

import com.codegym.ung_dung_muon_sach.service.IBookService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Aspect
@Component
public class UserAspect {
    private Logger logger = Logger.getLogger(UserAspect.class.getName());

    @Autowired
    private IBookService bookService;

    @Pointcut("execution(* com.codegym.ung_dung_muon_sach.service.impl.BorrowService.*(..))")
    public void loginService() {
    }

    @Around("loginService()")
    public Object writeLogBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        int bookCountBefore = bookService.getBookCount();
        logger.info("========== Before call method: " + methodName + " | Số lượng sách: " + bookCountBefore);
        Object result = joinPoint.proceed();
        int bookCountAfter = bookService.getBookCount();
        logger.info("========== After call method: " + methodName + " | Số lượng sách: " + bookCountAfter);
        return result;
    }

    @Pointcut("execution(* com.codegym.ung_dung_muon_sach.controller.user.UserController.*(..))")
    public void loginController() {
    }

    @Around("loginController()")
    public Object writeLogController(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("========== Có người truy cập vào thư viện");
        Object result = joinPoint.proceed();
        logger.info("========== Người dùng đã gọi phương thức: " + methodName + " lúc " + LocalDateTime.now());
        return result;
    }
}
