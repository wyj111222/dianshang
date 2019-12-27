package com.atguigu.gmall.manageweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.ManageService;
import com.atguigu.gmall.bean.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class ManageController {

    @Reference
    private ManageService manageService;

    //http://localhost:8082/getCatalog1
    @RequestMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1();
    }

    //http://localhost:8082/getCatalog2?catalog1Id=1
    //对象传值
    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(BaseCatalog2 baseCatalog2){
        return manageService.getCatalog2(baseCatalog2);
    }

    //http://localhost:8082/getCatalog3?catalog2Id=13
    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(BaseCatalog3 baseCatalog3){
        return manageService.getCatalog3(baseCatalog3);
    }
    //http://localhost:8082/attrInfoList?catalog3Id=61
    @RequestMapping("attrInfoList")
    public List<BaseAttrInfo> attrInfoList(BaseAttrInfo baseAttrInfo){
        return manageService.getAttrInfoList(baseAttrInfo);
    }
    //http://localhost:8082/saveAttrInfo
    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
         manageService.saveAttrInfo(baseAttrInfo);
    }
    //http://localhost:8082/getAttrValueList?attrId=100
    @RequestMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(BaseAttrValue baseAttrValue){
        return manageService.getAttrValueList(baseAttrValue);
    }

}
