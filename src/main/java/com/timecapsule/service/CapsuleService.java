package com.timecapsule.service;


import com.timecapsule.pojo.Capsule;

import java.util.Map;


public interface CapsuleService {
    public int insertSoundCapsule(Capsule capsule);
    public int insertMovieCapsule(Capsule capsule);
    public Capsule findCapsuleByOpenPassword(String openPassword,String date);
    public int insertSoundCapsuleImgs(String openPassword,String path);
}
