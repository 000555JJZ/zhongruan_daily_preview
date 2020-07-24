package com.test.thrift.bilibili.dto;

import java.io.Serializable;
import java.util.List;

public class ChartDTO implements Serializable {
    private List<String> key;
    private List<Long> value;

    public ChartDTO() {
    }

    public ChartDTO(List<String> key, List<Long> value) {
        this.key = key;
        this.value = value;
    }

    public List<String> getKey() {
        return key;
    }

    public void setKey(List<String> key) {
        this.key = key;
    }

    public List<Long> getValue() {
        return value;
    }

    public void setValue(List<Long> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChartDTO{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
