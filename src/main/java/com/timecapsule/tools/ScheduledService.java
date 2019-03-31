package com.timecapsule.tools;


import com.timecapsule.mapper.CapsuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledService {

    @Autowired
    CapsuleMapper capsuleMapper;
    @Autowired
    EmailTool emailTool;
    @Scheduled(cron = "0 36 09 * * ? ")
    public void scheduledScan() throws MessagingException {
        System.out.println("定时任务开始------扫描数据库");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String,Object>> list = capsuleMapper.findTimedCapsule(simpleDateFormat.format(date));
        System.out.println("扫描数据库结束------有"+list.size()+"个胶囊可打开,发送邮件开始");
        for (int i=0;i<list.size();i++){
            Map<String,Object> map = list.get(i);
            emailTool.sendEmailSchedule(map);
        }
        System.out.println("发送邮件结束------定时任务结束");
    }
}
