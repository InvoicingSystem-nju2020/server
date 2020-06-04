package com.bean.goods;

import java.util.List;

public class GoodsBean {
    private List<GoodsListBean> GoodsList;
    private int total;

    public GoodsBean(){

    }

    public GoodsBean(List<GoodsListBean> _goodsList, int _total){
        this.GoodsList = _goodsList;
        this.total = _total;
    }

    public void setGoodsList(List<GoodsListBean> _goodsList){
        this.GoodsList = _goodsList;
    }

    public List<GoodsListBean> getGoodsList(){
        return GoodsList;
    }

    public void setTotal(int _total){
        this.total = _total;
    }

    public int getTotal(){
        return total;
    }
}

