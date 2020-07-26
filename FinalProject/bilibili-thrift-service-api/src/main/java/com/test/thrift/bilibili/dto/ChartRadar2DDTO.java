package com.test.thrift.bilibili.dto;

import java.io.Serializable;
import java.util.List;

public class ChartRadar2DDTO implements Serializable {
    private List<String> key;
    private List<List<Long>> value;

    public ChartRadar2DDTO() {
    }

    public ChartRadar2DDTO(List<String> key, List<List<Long>> value) {
        this.key = key;
        this.value = value;
    }

    public List<String> getKey() {
        return key;
    }

    public void setKey(List<String> key) {
        this.key = key;
    }

    public List<List<Long>> getValue() {
        return value;
    }

    public void setValue(List<List<Long>> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChartRadar2DDTO{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
