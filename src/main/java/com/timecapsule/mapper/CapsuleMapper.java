package com.timecapsule.mapper;


import com.timecapsule.pojo.Capsule;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface CapsuleMapper {
    public int insertSoundCapsule(Capsule capsule);

    public int insertMovieCapsule(Capsule capsule);
    //定时任务执行查询到开启时间的胶囊
    public List<Map<String,Object>> findTimedCapsule(String nowDate);

    public Capsule findCapsuleByOpenPasswod(String openPassword,String date);

    public int insertSoundCapsuleImgs(String openPassword,String path);

    //查询声音胶囊中的图片
    public List<Map<String,Object>> findImagesInSoundCapsule(String openPassword);
}
