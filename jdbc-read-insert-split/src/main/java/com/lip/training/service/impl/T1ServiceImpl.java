package com.lip.training.service.impl;

import com.lip.training.mbg.mapper.T1Mapper;
import com.lip.training.mbg.model.T1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *****************************************************************************************
 *
 * @ClassName T1ServiceImpl
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/1/21 00:10
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       00:102/1/21     cjc                       初版
 * ******************************************************************************************
 */
@Service
public class T1ServiceImpl implements com.lip.training.service.T1Service {

    @Autowired
    private T1Mapper t1Mapper;

    @Override
    public T1 selectByPrimaryKey(Integer id){
       //return t1Mapper.selectByPrimaryKey(id);
        return t1Mapper.getMax();
    };

    @Override
    public int insert(T1 t){
        return t1Mapper.insert(t);
    }

}
