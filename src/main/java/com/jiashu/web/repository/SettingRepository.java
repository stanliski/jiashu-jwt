package com.jiashu.web.repository;

import com.jiashu.web.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SettingRepository extends JpaRepository<Setting, Long> {

    @Query(value = "select * from webguiSetting where webguiSetting.key = ?", nativeQuery = true)
    Setting findSettingByKey(String key);

}
