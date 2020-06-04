package com.controller.goods;

import com.bean.goods.*;
import com.service.goods.goodsService;
import com.serviceImpl.goods.GoodsImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("goods")
public class GoodsController {
    goodsService goodsService = new GoodsImpl();

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addGood(@RequestBody AddGoodBean addGoodBean){
        return goodsService.addGoods(addGoodBean);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public GoodsBean getGoods(@RequestParam(defaultValue = "") String goodsNumber,@RequestParam(defaultValue = "") String goodsName,
                              @RequestParam(defaultValue = "") String abbreviation, @RequestParam(defaultValue = "") String[] brand,
                              @RequestParam(defaultValue = "") String model, @RequestParam(defaultValue = "") String goodsNo,
                              @RequestParam(defaultValue = "") String material, @RequestParam(defaultValue = "0") String colour,
                              @RequestParam(defaultValue = "") String[] type, @RequestParam(defaultValue = "") String[] place,
                              @RequestParam(defaultValue = "0") double minRetailPrice,@RequestParam(defaultValue = "0") double maxRetailPrice,
                              @RequestParam(defaultValue = "") String sorter, @RequestParam(defaultValue = "0") Integer  desc,
                              @RequestParam(defaultValue = "0") Integer  startIndex, @RequestParam(defaultValue = "100") Integer  num){
        GetGoodsBean bean=new GetGoodsBean();
        bean.setGoodsNumber(goodsNumber);
        bean.setGoodsName(goodsName);
        bean.setAbbreviation(abbreviation);
        bean.setBrand(brand);
        bean.setModel(model);
        bean.setGoodsNo(goodsNo);
        bean.setMaterial(material);
        bean.setColour(colour);
        bean.setType(type);
        bean.setPlace(place);
        bean.setMinRetailPrice(minRetailPrice);
        bean.setMaxRetailPrice(maxRetailPrice);
        bean.setSorter(sorter);
        bean.setDesc(desc);
        bean.setStartIndex(startIndex);
        bean.setNum(num);
        return goodsService.getGoods(bean);
    }

    @RequestMapping(value = "/{goodsNumber}", method = RequestMethod.GET)
    public SingleGoodByGoodsNumberBean getSingleGoodByGoodsNumber(@PathVariable(value="goodsNumber") String goodsNumber){
        return goodsService.getSingleGoodByGoodsNumberBean(goodsNumber);
    }

    @RequestMapping(value = "/{goodsNumber}", method = RequestMethod.PUT)
    public String updateSingleGoodsBeanByGoodsNumber(@RequestBody UpdateSingleGoodsBean bean, @PathVariable("goodsNumber") String goodsNumber){
        return goodsService.updateSingleGoodsByGoodsNumber(bean,goodsNumber);
    }

    @RequestMapping(value = "/{goodsNumber}", method = RequestMethod.DELETE)
    public boolean deleteSingleGoodByGoodsNumber(@PathVariable(value="goodsNumber") String goodsNumber){
        return goodsService.deleteSingleGoodsByGoodsNumber(goodsNumber);
    }
}
