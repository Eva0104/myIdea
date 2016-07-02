package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.Loginlog;

import java.util.List;

/**
 * Created by Eric on 2016/7/2.
 */
public interface LoginMapper {

    List<Loginlog> findByUserId(Integer userId);
}
