package com.timecapsule.service;

import com.timecapsule.mapper.CapsuleMapper;
import com.timecapsule.pojo.Capsule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CapsuleService")
public class CapsuleServiceImp implements CapsuleService {

    @Autowired
    CapsuleMapper capsuleMapper;
    
    public int insertSoundCapsule(Capsule capsule) {
        return capsuleMapper.insertSoundCapsule(capsule);

    }

    public int insertMovieCapsule(Capsule capsule) {
        return capsuleMapper.insertMovieCapsule(capsule);
    }

}
