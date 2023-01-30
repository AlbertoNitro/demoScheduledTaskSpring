package com.inditex.demoTaskScheduler;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "10m")
public class DemoTaskSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTaskSchedulerApplication.class, args);
	}

}
