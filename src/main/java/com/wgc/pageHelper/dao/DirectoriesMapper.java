package com.wgc.pageHelper.dao;

import com.wgc.pageHelper.entity.Directories;
import java.util.List;

public interface DirectoriesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Directories record);

    Directories selectByPrimaryKey(Integer id);

    List<Directories> selectAll();

    int updateByPrimaryKey(Directories record);
}