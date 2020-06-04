package com.serviceImpl.goods;


import com.bean.goods.*;
import com.entity.GoodsEntity;
import com.repository.goods.goodsRepository;
import com.service.goods.goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsImpl implements goodsService{
    @Autowired
    private goodsRepository goodsRepository;

    private static GoodsImpl goodsImpl;
    private static int idLength = 6;

    @PostConstruct
    public void init(){
        goodsImpl = this;
        goodsImpl.goodsRepository = this.goodsRepository;
    }

    //5.1 录入商品
    @Override
    public String addGoods(AddGoodBean bean) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String id = "";
        for(int i = 0; i < idLength; i++) id = id + "" + (int)(Math.random() * 10);
        id = time + id;

        GoodsEntity addGoodEntity =new GoodsEntity();
        addGoodEntity.setGoodsNumber(id);
        addGoodEntity.setGoodsName(bean.getGoodsName());
        addGoodEntity.setAbbreviation(bean.getAbbreviation());
        addGoodEntity.setBrand(bean.getBrand());
        addGoodEntity.setModel(bean.getModel());
        addGoodEntity.setGoodsNo(bean.getGoodsNo());
        addGoodEntity.setMaterial(bean.getMaterial());
        addGoodEntity.setColour(bean.getColour());
        addGoodEntity.setType(bean.getType());
        addGoodEntity.setSpecifications(bean.getSpecifications());
        addGoodEntity.setUnit(bean.getUnit());
        addGoodEntity.setWeight(bean.getWeight());
        addGoodEntity.setStock(bean.getStock());
        //addGoodEntity.setBuyingPrice(bean.getBuyingPrice());
        addGoodEntity.setRetailPrice(bean.getRetailPrice());
        addGoodEntity.setPlaceOfProduction(bean.getPlaceOfProduction());
        addGoodEntity.setQualityGuaranteePeriod(bean.getQualityGuaranteePeriod());
        addGoodEntity.setRemarks(bean.getRemarks());

        try{
            goodsImpl.goodsRepository.save(addGoodEntity);
            return id;
        }catch (Exception addException){
            addException.printStackTrace();
            return "添加商品出错";
        }
    }

    //5.2 查看商品列表
    @Override
    public GoodsBean getGoods(GetGoodsBean bean) {
        List<GoodsListBean> totalGoodsList = new ArrayList<>();
        List<GoodsListBean> resultGoodsList = new ArrayList<>();
        List<GoodsEntity> goodsEntityList = new ArrayList<>();
        int total = 0;


        String goodsNumber=bean.getGoodsNumber();
        String goodsName=bean.getGoodsName();
        String abbreviation=bean.getAbbreviation();
        String[] brand=bean.getBrand();
        String model=bean.getModel();
        String goodsNo=bean.getGoodsNo();
        String material=bean.getMaterial();
        String colour=bean.getColour();
        String[] type=bean.getType();
        String[] place=bean.getPlace();
        double minRetailPrice=bean.getMinRetailPrice();
        double maxRetailPrice=bean.getMaxRetailPrice();
        String sorter=bean.getSorter();
        int desc=bean.getDesc();
        int startIndex=bean.getStartIndex();
        int num=bean.getNum();

        if(sorter.equals("") || sorter == null ||sorter.equals("goodsNumber")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByGoodsNumberDesc();
            else goodsEntityList = goodsImpl.goodsRepository.findByGoodsNumberInc();
        }
        else if(sorter.equals("goodsName")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByGoodsNameDesc(goodsName);
            else goodsEntityList = goodsImpl.goodsRepository.findByGoodsName(goodsName);
        }
        else if(sorter.equals("abbreviation")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByAbbreviationDesc(abbreviation);
            else goodsEntityList = goodsImpl.goodsRepository.findByAbbreviation(abbreviation);
        }
        else if(sorter.equals("brand")){
            if (desc == 1) {
                for (String a : brand) {
                    if (goodsImpl.goodsRepository.findByBrandDesc(a) != null) {
                        goodsEntityList.add(goodsImpl.goodsRepository.findByBrandDesc(a));
                    }
                }
            } else {
                for (String a : brand) {
                    if (goodsImpl.goodsRepository.findByBrand(a) != null) {
                        goodsEntityList.add(goodsImpl.goodsRepository.findByBrand(a));
                    }
                }
            }
        }
        else if(sorter.equals("model")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByModelDesc(model);
            else goodsEntityList = goodsImpl.goodsRepository.findByModel(model);
        }
        else if(sorter.equals("goodsNo")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByGoodsNoDesc(goodsNo);
            else goodsEntityList = goodsImpl.goodsRepository.findByGoodsNo(goodsNo);
        }
        else if(sorter.equals("material")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByMaterialDesc(material);
            else goodsEntityList = goodsImpl.goodsRepository.findByMaterial(material);
        }
        else if(sorter.equals("colour")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByColourDesc(colour);
            else goodsEntityList = goodsImpl.goodsRepository.findByColour(colour);
        }
        else if(sorter.equals("type")){
            if (desc == 1) {
                for (String a : brand) {
                    if (goodsImpl.goodsRepository.findByTypeDesc(a) != null) {
                        goodsEntityList.add(goodsImpl.goodsRepository.findByTypeDesc(a));
                    }
                }
            } else {
                for (String a : brand) {
                    if (goodsImpl.goodsRepository.findByType(a) != null) {
                        goodsEntityList.add(goodsImpl.goodsRepository.findByType(a));
                    }
                }
            }

        }
        else if(sorter.equals("place")){
            if (desc == 1) {
                for (String a : brand) {
                    if (goodsImpl.goodsRepository.findByPlaceDesc(a) != null) {
                        goodsEntityList.add(goodsImpl.goodsRepository.findByPlaceDesc(a));
                    }
                }
            } else {
                for (String a : brand) {
                    if (goodsImpl.goodsRepository.findByPlace(a) != null) {
                        goodsEntityList.add(goodsImpl.goodsRepository.findByPlace(a));
                    }
                }
            }
        }
        else if(sorter.equals("minRetailPrice")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByMinRetailPriceDesc(minRetailPrice);
            else goodsEntityList = goodsImpl.goodsRepository.findByMinRetailPrice(minRetailPrice);
        }
        else if(sorter.equals("maxRetailPrice")){
            if(desc == 1) goodsEntityList = goodsImpl.goodsRepository.findByMaxRetailPriceDesc(maxRetailPrice);
            else goodsEntityList = goodsImpl.goodsRepository.findByMaxRetailPrice(maxRetailPrice);
        }

        for(GoodsEntity goodsEntity : goodsEntityList){

            GoodsListBean goodsListBean = new GoodsListBean();

            goodsListBean.setGoodsNumber(goodsEntity.getGoodsNumber());
            goodsListBean.setGoodsName(goodsEntity.getGoodsName());
            goodsListBean.setAbbreviation(goodsEntity.getAbbreviation());
            goodsListBean.setBrand(goodsEntity.getBrand());
            goodsListBean.setModel(goodsEntity.getModel());
            goodsListBean.setGoodsNo(goodsEntity.getGoodsNo());
            goodsListBean.setMaterial(goodsEntity.getMaterial());
            goodsListBean.setColour(goodsEntity.getColour());
            goodsListBean.setType(goodsEntity.getType());
            goodsListBean.setSpecifications(goodsEntity.getSpecifications());
            goodsListBean.setUnit(goodsEntity.getUnit());
            goodsListBean.setWeight(goodsEntity.getWeight());
            goodsListBean.setStock(goodsEntity.getStock());
            goodsListBean.setBuyingPrice(goodsEntity.getBuyingPrice());
            goodsListBean.setRetailPrice(goodsEntity.getRetailPrice());
            goodsListBean.setPlaceOfProduction(goodsEntity.getPlaceOfProduction());
            goodsListBean.setQualityGuaranteePeriod(goodsEntity.getQualityGuaranteePeriod());
            goodsListBean.setRemarks(goodsEntity.getRemarks());

            totalGoodsList.add(goodsListBean);
        }

        total = totalGoodsList.size();
        if(startIndex==0&&num==0){resultGoodsList=totalGoodsList;}
        else if(num==0&&startIndex + num>=total){
            for (int index = startIndex; index < total; index++)
                resultGoodsList.add(totalGoodsList.get(index));
        }
        else {
            if (startIndex + num < total) {
                for (int index = startIndex; index < startIndex + num; index++)
                    resultGoodsList.add(totalGoodsList.get(index));
            }
        }
        GoodsBean goodsBean = new GoodsBean(resultGoodsList, total);
        return goodsBean;
    }

    //5.3 查询单个商品的信息
    @Override
    public SingleGoodByGoodsNumberBean getSingleGoodByGoodsNumberBean(String goodsNumber) {
        List<GoodsEntity> optionalGood = goodsImpl.goodsRepository.findByGoodsNumber(goodsNumber);
        GoodsEntity good = optionalGood.get(0);
        if(good != null) {
            SingleGoodByGoodsNumberBean goodBean = new SingleGoodByGoodsNumberBean();

            goodBean.setGoodsNumber(good.getGoodsNumber());
            goodBean.setGoodsName(good.getGoodsName());
            goodBean.setAbbreviation(good.getAbbreviation());
            goodBean.setBrand(good.getBrand());
            goodBean.setModel(good.getModel());
            goodBean.setGoodsNo(good.getGoodsNo());
            goodBean.setMaterial(good.getMaterial());
            goodBean.setColour(good.getColour());
            goodBean.setType(good.getType());
            goodBean.setSpecifications(good.getSpecifications());
            goodBean.setUnit(good.getUnit());
            goodBean.setWeight(good.getWeight());
            goodBean.setStock(good.getStock());
            goodBean.setBuyingPrice(good.getBuyingPrice());
            goodBean.setRetailPrice(good.getRetailPrice());
            goodBean.setPlaceOfProduction(good.getPlaceOfProduction());
            goodBean.setQualityGuaranteePeriod(good.getQualityGuaranteePeriod());
            goodBean.setRemarks(good.getRemarks());

            return goodBean;
        }
        return null;
    }


    //5.4 修改商品信息
    @Override
    public String updateSingleGoodsByGoodsNumber(UpdateSingleGoodsBean bean,String goodsNumber) {
        List<GoodsEntity> optionalGood = goodsImpl.goodsRepository.findByGoodsNumber(goodsNumber);
        GoodsEntity good = optionalGood.get(0);
        if(good != null) {
            try{

                goodsImpl.goodsRepository.updateSingleGood(bean.getGoodsNumber(), bean.getGoodsName(), bean.getAbbreviation(),
                        bean.getBrand(), bean.getModel(), bean.getGoodsNo(),bean.getMaterial(),bean.getColour(),bean.getType(),
                        bean.getSpecifications(), bean.getUnit(), bean.getWeight(), bean.getRetailPrice(),bean.getPlaceOfProduction()
                        ,bean.getQualityGuaranteePeriod(),bean.getRemarks());

                return good.getGoodsNumber();
            }catch (Exception ex){
                ex.printStackTrace();
                return "更新出错";
            }
        }
        return "未能检索到商品";
    }

    //5.5 删除商品
    @Override
    public boolean deleteSingleGoodsByGoodsNumber(String goodsNumber) {
        List<GoodsEntity> optionalGood = goodsImpl.goodsRepository.findByGoodsNumber(goodsNumber);
        GoodsEntity good = optionalGood.get(0);
        if(good != null) {
            try{
                goodsImpl.goodsRepository.deleteById(goodsNumber);
                return true;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
