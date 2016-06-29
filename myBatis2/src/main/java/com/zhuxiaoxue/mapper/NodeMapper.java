package com.zhuxiaoxue.mapper;

import com.zhuxiaoxue.pojo.Node;

import java.util.List;

/**
 * Created by Eric on 2016/6/29.
 */
public interface NodeMapper {
    Node findById(Integer id);

    List<Node> findAll();
}
