package com.github.hiapk.easycdk;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class FilterFileConfig {

    @Autowired
    private FileListener fileListener;

    public void FileFilter(String rootDir) {
        // 轮询间隔 1 秒
        long interval = TimeUnit.SECONDS.toMillis(1);
        System.out.println(interval);
        // 创建过滤器
//        IOFileFilter directories = FileFilterUtils.and(
//                FileFilterUtils.directoryFileFilter(),
//                HiddenFileFilter.VISIBLE);
//        IOFileFilter files = FileFilterUtils.and(
//                FileFilterUtils.fileFileFilter(),
//                FileFilterUtils.suffixFileFilter(".txt"));
//        IOFileFilter filter = FileFilterUtils.or(directories, files);
        // 使用过滤器
        // FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir), filter);

        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));
        observer.addListener(fileListener);
        //创建文件变化监听器（默认为1000毫秒执行一次扫描）
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        try {
            monitor.start();
            log.info("开始监听--------");
        } catch (Exception e) {
            log.error("异常处理", e);
        }
    }
}