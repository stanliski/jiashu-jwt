package com.jiashu.web.entity;

import javax.persistence.*;


@Entity
@Table(name = "webguiSetting")
public class Setting {

    @GeneratedValue
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "INT(10) UNSIGNED")
    private int id;
    @Column(name = "key", unique = true)
    private String key;
    @Column(name = "value")
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
