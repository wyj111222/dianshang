package com.atguigu.gmall;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {
    /**
     * 获取一级分类
     * @return
     */
    List<BaseCatalog1> getCatalog1();

    /**
     * 获取二级分类
     * @param baseCatalog2
     * @return
     */
    List<BaseCatalog2> getCatalog2(BaseCatalog2 baseCatalog2);



    /**
     * 获取三级分类
     * @param baseCatalog3
     */
    List<BaseCatalog3> getCatalog3(BaseCatalog3 baseCatalog3);

    /**
     * 获取属性信息
     * @param baseAttrInfo
     * @return
     */
    List<BaseAttrInfo> getAttrInfoList(BaseAttrInfo baseAttrInfo);

    /**
     * 保存属性和属性值
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 获取属性值
     * @param baseAttrValue
     * @return
     */
    List<BaseAttrValue> getAttrValueList(BaseAttrValue baseAttrValue);
}
