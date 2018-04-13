package com.jiashu.web.service.impl;


import com.jiashu.web.entity.Setting;
import com.jiashu.web.repository.SettingRepository;
import com.jiashu.web.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingRepository settingRepository;

    @Override
    public Setting loadAccountSetting() {
        return settingRepository.findSettingByKey("account");
    }
}
