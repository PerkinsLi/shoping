package com.shoping.service;

import com.github.pagehelper.PageInfo;
import com.shoping.common.ServerResponse;
import com.shoping.pojo.Product;
import com.shoping.vo.ProductDetailVo;

/**
 * @author Perkins
 * @Date 2018/12/18 16:16
 */
public interface IProductService {
    /**
     * 产品更新和增加操作，根据传来的id参数是否为空判断执行更新还是增加
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 更新产品状态
     * @param productId
     * @param status
     * @return
     */
    ServerResponse setSaleStatus(Integer productId, Integer status);

    /**
     * 获取产品详情
     * @param productId
     * @return
     */
    ServerResponse manageProductDetail(Integer productId);

    /**
     * 分页获取产品信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse getProductList(int pageNum, int pageSize);

    /**
     * 搜索产品信息
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    /**
     * 用户获取产品详情
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
     *
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
}
