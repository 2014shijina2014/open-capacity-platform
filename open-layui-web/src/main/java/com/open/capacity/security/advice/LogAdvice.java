package com.open.capacity.security.advice;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.model.SysLogs;
import com.open.capacity.security.service.SysLogService;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 统一日志处理切面
 * 记录中台操作/请求日志
 *
 * @author caoheyang
 * @version 20180727
 */
@Aspect
@Component
public class LogAdvice {

    @Autowired
    private SysLogService logService;

    /**
     * 记录日志的切面方法
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.open.capacity.security.annotation.LogAnnotation)")
    public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
        SysLogs sysLogs = new SysLogs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String module = null;
        LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
        module = logAnnotation.module();
        if (StringUtils.isEmpty(module)) {
            ApiOperation apiOperation = methodSignature.getMethod().getDeclaredAnnotation(ApiOperation.class);
            if (apiOperation != null) {
                module = apiOperation.value();
            }
        }

        if (StringUtils.isEmpty(module)) {
            throw new RuntimeException("没有指定日志module");
        }
        sysLogs.setModule(module);

        try {
            Object object = joinPoint.proceed();
            sysLogs.setFlag(true);
            logService.save(sysLogs);
            return object;
        } catch (Exception e) {
            sysLogs.setFlag(false);
            sysLogs.setRemark(e.getMessage());
            logService.save(sysLogs);
            throw e;
        }
    }
}
