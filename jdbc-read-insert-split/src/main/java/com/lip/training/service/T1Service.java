package com.lip.training.service;

import com.lip.training.mbg.model.T1;

public interface T1Service {

    T1 selectByPrimaryKey(Integer id);

    int insert(T1 t);
}
