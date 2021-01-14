package com.wgymt.sell.controller;

import com.wgymt.sell.entity.ProductCategory;
import com.wgymt.sell.entity.ProductInfo;
import com.wgymt.sell.service.CategoryService;
import com.wgymt.sell.service.ProductService;
import com.wgymt.sell.utils.ResultVOUtil;
import com.wgymt.sell.vo.ProductInfoVO;
import com.wgymt.sell.vo.ProductVO;
import com.wgymt.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Resource
    private ProductService productService;

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        // 1.查询所有的已上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2.查询类目(一次性查询, 保证性能)
        List<Integer> categoryTypeList = productInfoList
                .stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3.数据拼装, 以达到前段所显示的效果
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
