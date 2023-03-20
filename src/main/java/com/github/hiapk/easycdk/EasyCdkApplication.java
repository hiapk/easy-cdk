package com.github.hiapk.easycdk;

import com.github.hiapk.easycdk.entiy.EasyCdkConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.file.Paths;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class EasyCdkApplication {

    private static FilterFileConfig filterFileConfig;
    private static CheckService checkService;

    private static EasyCdkConfig config;

    @Autowired
    public void setFilterFileConfig(FilterFileConfig filterFileConfig) {
        EasyCdkApplication.filterFileConfig = filterFileConfig;
    }

    @Autowired
    public void setCheckService(CheckService checkService) {
        EasyCdkApplication.checkService = checkService;
    }


    public static void main(String[] args) {
        SpringApplication.run(EasyCdkApplication.class, args);
        String rootPath = Paths.get("").toAbsolutePath().toString();
        // TODO
        rootPath = "/Users/yunzhanghu_bj1265/Workspace/test";
        try {
            config = checkService.configCheck(rootPath);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        filterFileConfig.startMonitor(rootPath);
    }
}
