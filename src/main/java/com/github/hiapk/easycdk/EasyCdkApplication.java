package com.github.hiapk.easycdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EasyCdkApplication {

    private static FilterFileConfig filterFileConfig;

    @Autowired
    public void setFilterFileConfig(FilterFileConfig filterFileConfig) {
        this.filterFileConfig = filterFileConfig;
    }


    public static void main(String[] args) {
        SpringApplication.run(EasyCdkApplication.class, args);
        filterFileConfig.FileFilter("/Users/yunzhanghu_bj1265/Workspace/test");
    }
}
