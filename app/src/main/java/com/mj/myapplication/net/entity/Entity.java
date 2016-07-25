package com.mj.myapplication.net.entity;

import com.google.gson.Gson;

/**
 * 实体类抽象
 * Created By: Robin Yang
 * Created At: 2015-03-23 01:00
 */
public abstract class Entity {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
