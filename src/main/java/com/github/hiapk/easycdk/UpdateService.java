package com.github.hiapk.easycdk;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Slf4j
public class UpdateService {
    private String notice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("检测到文件更新，是否需要重新部署？");
        String answer = sc.nextLine();//接收字符串
        sc.close();
        return answer;
    }

    private void update() {
        log.info("正在执行cdk update");
    }

    public void checkAndProcess() {
        String answer = this.notice();
        if (answer.equalsIgnoreCase("y")) {
            this.update();
        }
    }
}
