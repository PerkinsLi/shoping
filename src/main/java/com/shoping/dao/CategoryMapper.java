package com.shoping.dao;

import com.shoping.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    // 自定义代码

    /**
     * 根据父节点id获取所有子节点品类信息
     * @param parentId
     * @return
     */
    List<Category> selectCategoryChildreByParentId(Integer parentId);
}