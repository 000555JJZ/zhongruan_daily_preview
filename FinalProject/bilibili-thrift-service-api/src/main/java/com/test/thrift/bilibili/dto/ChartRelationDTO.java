package com.test.thrift.bilibili.dto;

import java.io.Serializable;
import java.util.List;

public class ChartRelationDTO implements Serializable {
    private List<String> key;
    private List<Long> value;
    private List<Integer> category;
    private List<String> source;
    private List<String> target;

    public ChartRelationDTO(List<String> key, List<Long> value, List<Integer> category, List<String> source, List<String> target) {
        this.key = key;
        this.value = value;
        this.category = category;
        this.source = source;
        this.target = target;
    }

    public ChartRelationDTO() {
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

    public List<Integer> getCategory() {
        return category;
    }

    public void setCategory(List<Integer> category) {
        this.category = category;
    }

    public List<String> getSource() {
        return source;
    }

    public void setSource(List<String> source) {
        this.source = source;
    }

    public List<String> getTarget() {
        return target;
    }

    public void setTarget(List<String> target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "ChartRelationDTO{" +
                "key=" + key +
                ", value=" + value +
                ", category=" + category +
                ", source=" + source +
                ", target=" + target +
                '}';
    }
}
