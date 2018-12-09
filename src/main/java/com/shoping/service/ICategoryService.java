package com.shoping.service;

import com.shoping.common.ServerResponse;
import com.shoping.pojo.Category;

import java.util.List;

/**
 * @author Perkins
 * @Date 2018/11/18 22:59
 */
public interface ICategoryService {
    /**
     * 添加商品品类
     * @param categoryName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新商品名称
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 通过商品品类父节点获取所有子节点
     * @param categoryId 父节点id
     * @return
     */
    ServerResponse<List<Category>> getChildrenCategory(Integer categoryId);

    /**
     * 递归查询出所有的子节点及子节点的子节点
     * @param categoryId
     * @return
     */
    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
