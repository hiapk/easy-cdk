package com.github.hiapk.easycdk;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@Component
public class FileListener extends FileAlterationListenerAdaptor {

    @Autowired
    private UpdateService updateService;

    /**
     * 文件创建执行
     */
    @SneakyThrows
    @Override
    public void onFileCreate(File file) {
        log.info("[新建]:" + file.getAbsolutePath() + file);
        updateService.checkAndProcess();
    }

    /**
     * 文件创建修改
     */
    @Override
    public void onFileChange(File file) {
        log.info("[修改]:" + file.getAbsolutePath());
        updateService.checkAndProcess();
    }

    /**
     * 文件删除
     */
    @Override
    public void onFileDelete(File file) {
        log.info("[删除]:" + file.getAbsolutePath());
        updateService.checkAndProcess();
    }

    /**
     * 目录创建
     */
    @Override
    public void onDirectoryCreate(File directory) {
        log.info("[新建]:" + directory.getAbsolutePath());
        updateService.checkAndProcess();
    }

    /**
     * 目录修改
     */
    @Override
    public void onDirectoryChange(File directory) {
        log.info("[修改]:" + directory.getAbsolutePath());
        updateService.checkAndProcess();
    }

    /**
     * 目录删除
     */
    @Override
    public void onDirectoryDelete(File directory) {
        log.info("[删除]:" + directory.getAbsolutePath());
        updateService.checkAndProcess();
    }

    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }
}