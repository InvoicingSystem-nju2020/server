package com.service.goods;


import com.bean.goods.*;

public interface goodsService {
    String addGoods(AddGoodBean bean);
    GoodsBean getGoods(GetGoodsBean bean);
    SingleGoodByGoodsNumberBean getSingleGoodByGoodsNumberBean(String goodsNumber);
    String updateSingleGoodsByGoodsNumber(UpdateSingleGoodsBean bean,String goodsNumber);
    boolean deleteSingleGoodsByGoodsNumber(String goodsNumber);
}
