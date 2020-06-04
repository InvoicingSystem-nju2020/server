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
    public GoodsBean getPurchaseRecords(@RequestParam GetGoodsBean bean){
        return goodsService.getGoods(bean);
    }

    @RequestMapping(value = "/{goodsNumber}", method = RequestMethod.GET)
    public SingleGoodByGoodsNumberBean getSingleGoodByGoodsNumber(@PathVariable(value="goodsNumber") String goodsNumber){
        return goodsService.getSingleGoodByGoodsNumberBean(goodsNumber);
    }

    @RequestMapping(value = "/{goodsNumber}", method = RequestMethod.PUT)
    public String updateSingleGoodsBeanByGoodsNumber(@RequestBody UpdateSingleGoodsBean bean,@PathVariable("goodsNumber") String goodsNumber){
        return goodsService.updateSingleGoodsByGoodsNumber(bean,goodsNumber);
    }

    @RequestMapping(value = "/{goodsNumber}", method = RequestMethod.DELETE)
    public boolean deleteSingleGoodByGoodsNumber(@PathVariable(value="goodsNumber") String goodsNumber){
        return goodsService.deleteSingleGoodsByGoodsNumber(goodsNumber);
    }
}
