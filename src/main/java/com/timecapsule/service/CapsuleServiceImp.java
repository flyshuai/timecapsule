package com.timecapsule.service;

import com.timecapsule.mapper.CapsuleMapper;
import com.timecapsule.pojo.Capsule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("CapsuleService")
public class CapsuleServiceImp implements CapsuleService {

    @Autowired
    CapsuleMapper capsuleMapper;
    @Override
    public int insertSoundCapsule(Capsule capsule) {

        return capsuleMapper.insertSoundCapsule(capsule);

    }

    @Override
    public int insertMovieCapsule(Capsule capsule) {
        return capsuleMapper.insertMovieCapsule(capsule);
    }

    @Override
    public Capsule findCapsuleByOpenPassword(String openPassword, String date) {
        return capsuleMapper.findCapsuleByOpenPasswod(openPassword,date);
    }

}
