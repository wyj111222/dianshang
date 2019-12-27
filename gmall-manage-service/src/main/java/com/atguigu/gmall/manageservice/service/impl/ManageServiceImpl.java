package com.atguigu.gmall.manageservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.ManageService;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manageservice.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2(BaseCatalog2 baseCatalog2) {
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> getCatalog3(BaseCatalog3 baseCatalog3) {
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> getAttrInfoList(BaseAttrInfo baseAttrInfo) {
        return baseAttrInfoMapper.select(baseAttrInfo);
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if(baseAttrInfo.getId()!=null){
            baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
        }else{
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        //属性值先删除(修改）
        //delete from BaseAttrValue where attrId = ?
        BaseAttrValue baseAttrValueDel = new BaseAttrValue();
        baseAttrValueDel.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValueDel);

        //再增加
        List<BaseAttrValue> list = baseAttrInfo.getAttrValueList();
        
        if(list != null && list.size()>0){
            for (BaseAttrValue baseAttrValue : list) {
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(baseAttrValue);
            }    
            
        }
                
    }

    @Override
    public List<BaseAttrValue> getAttrValueList(BaseAttrValue baseAttrValue) {
        return baseAttrValueMapper.select(baseAttrValue);
    }
}
