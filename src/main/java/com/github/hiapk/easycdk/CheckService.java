package com.github.hiapk.easycdk;

import com.alibaba.fastjson2.JSON;
import com.github.hiapk.easycdk.entiy.EasyCdkConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
public class CheckService {
    public EasyCdkConfig configCheck(String rootPath) throws Exception {
        if (StringUtils.isEmpty(rootPath)) {
            throw new Exception("rootPath should not be empty");
        }
        String fileContent = FileUtils.readFileToString(new File(rootPath + "/.easy-cdk.config"), StandardCharsets.UTF_8);
        if (StringUtils.isEmpty(fileContent)) {
            throw new Exception("config should not be empty");
        }
        return JSON.parseObject(fileContent, EasyCdkConfig.class);
    }
}
