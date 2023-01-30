package com.inditex.demoTaskScheduler.scheduledTask;

import com.inditex.demoTaskScheduler.services.WechatService;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@ConditionalOnExpression("#{${wechat.enabled:true} and ${mecmesy.notificationType.wechat:true}}")
public class RefreshWechatTokenScheduledTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    private final WechatService wechatService;
    
    @Autowired
    public RefreshWechatTokenScheduledTask(WechatService wechatService) {
        this.wechatService = wechatService;
    }


    @Scheduled(
            fixedRateString = "${fixedRate.in.seconds}", 
            timeUnit = TimeUnit.MINUTES)
    @SchedulerLock(name = "refreshAccessToken", lockAtLeastFor = "119m", lockAtMostFor = "119m")
    // Activar alerta de we chat token error, al recibir solo un valor de 1 en dicha metrica
    public void refreshAccessToken() {
        LockAssert.assertLocked();
        log.info("ScheduledTask begin {}", dateFormat.format(new Date()));
        wechatService.getAccessToken();
        log.info("ScheduledTask finished {}", dateFormat.format(new Date()));
        log.info("-----------------------------");
    }
    
}
