package com.serviceImpl.orders;

import com.bean.orders.*;
import com.entity.GoodsEntity;
import com.entity.OrdersEntity;
import com.repository.goods.goodsRepository;
import com.repository.orders.OrdersRepository;
import com.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class OrdersImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private goodsRepository goodsRepository;

    private static OrdersImpl ordersImpl;
    private static int idLength = 6;

    @PostConstruct
    public void init(){
        ordersImpl = this;
        ordersImpl.ordersRepository = this.ordersRepository;
        ordersImpl.goodsRepository = this.goodsRepository;
    }

    @Override
    public String addOrder(AddOrderBean bean) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String id = "";
        for(int i = 0; i < idLength; i++) id = id + "" + (int)(Math.random() * 10);
        id = time + id;

        String goodsNumber = bean.getGoodsNumbers();
        Optional<GoodsEntity> optionalGoods = ordersImpl.goodsRepository.findByGoodsNumberFromGoods(goodsNumber);
        GoodsEntity goods = optionalGoods.isPresent() ? optionalGoods.get() : null;
        if(goods != null) {
            OrdersEntity order = new OrdersEntity();

            order.setId(id);
            order.setOrderNumber(id);
            order.setSalesPerson(bean.getSalesPerson());
            order.setCreateTime(time);
            order.setDealTime(time);
            order.setState(bean.getState());
            order.setClientNumber(bean.getClientNumber());
            order.setWriteAnInvoice(bean.getWriteAnInvoice());
            order.setGoodsNumber(bean.getGoodsNumbers());
            order.setGoodsName(goods.getGoodsName());
            order.setGoodsNo(goods.getGoodsNo());
            order.setBrand(goods.getBrand());
            order.setBuyingPrice(goods.getBuyingPrice());
            order.setRetailPrice(goods.getRetailPrice());
            order.setFinalPrice(bean.getFinalPrice());
            order.setNumbers(bean.getNumbers());
            order.setTotalAmount(bean.getTotalAmount());
            order.setTypeOfPayment(bean.getTypeOfPayment());
            order.setTypeOfShipping(bean.getTypeOfShipping());

            try {
                ordersImpl.ordersRepository.save(order);
                return order.getOrderNumber();
            }catch (Exception ex){
                ex.printStackTrace();
                return null;
            }
        }
        return null;

    }

    @Override
    public OrdersBean getOrders(GetOrdersBean bean) {
        List<OrdersListBean> totalOrdersList = new ArrayList<>();
        List<OrdersListBean> resultOrdersList = new ArrayList<>();
        List<OrdersEntity> ordersEntityList = new ArrayList<>();
        int total = 0;

        String salesPerson = bean.getSalesPerson();
        String goodsName = bean.getGoodsName();
        String goodsNumber = bean.getGoodsNumber();
        String[] brand = bean.getBrand();
        double minTotalAmount = bean.getMinTotalAmount();
        double maxTotalAmount = bean.getMaxTotalAmount();
        String[] state = bean.getState();
        int writeAnInvoice = bean.getWriteAnInvoice();
        String sorter = bean.getSorter();
        int desc = bean.getDesc();
        int startIndex = bean.getStartIndex();
        int num = bean.getNum();

        if(sorter.equals("") || sorter == null || sorter.equals("orderNumber") || sorter.equals("startTime") ||
                sorter.equals("endTime") || sorter.equals("clientName")|| sorter.equals("salesPerson") ||
                sorter.equals("goodsName")|| sorter.equals("brand")|| sorter.equals("state")){
            if(desc == 1) ordersEntityList = ordersImpl.ordersRepository.findAllByIdDesc();
            else ordersEntityList = ordersImpl.ordersRepository.findAllByIdInc();
        }

        else if(sorter.equals("goodsNumber")){
            if(desc == 1) ordersEntityList = ordersImpl.ordersRepository.findAllByGoodsNumberDesc();
            else ordersEntityList = ordersImpl.ordersRepository.findAllByGoodsNumberInc();
        }

        else if(sorter.equals("totalAmount")){
            if(desc == 1) ordersEntityList = ordersImpl.ordersRepository.findAllByTotalAmountDesc();
            else ordersEntityList = ordersImpl.ordersRepository.findAllByTotalAmountInc();
        }
        else if(sorter.equals("writeAnInvoice")){
            if(desc == 1) ordersEntityList = ordersImpl.ordersRepository.findAllByWriteAnInvoiceDesc();
            else ordersEntityList = ordersImpl.ordersRepository.findAllByWriteAnInvoiceInc();
        }

        for(OrdersEntity ordersEntity : ordersEntityList){
            String entityOrderNumber = ordersEntity.getOrderNumber();
            String entitySalesPerson = ordersEntity.getSalesPerson();
            String entityCreateTime = ordersEntity.getCreateTime();
            String entityDealTime = ordersEntity.getDealTime();
            String entityState = ordersEntity.getState();
            String entityClientNumber = ordersEntity.getClientNumber();
            int entityWriteAnInvoice = ordersEntity.getWriteAnInvoice();
            String entityGoodsNumber = ordersEntity.getGoodsNumber();
            String entityGoodsName = ordersEntity.getGoodsName();
            String  entityBrand = ordersEntity.getBrand();
            double entityFinalPrice = ordersEntity.getFinalPrice();
            int entityNumbers = ordersEntity.getNumbers();
            double entityTotalAmount = ordersEntity.getTotalAmount();
            String entityTypeOfPayment = ordersEntity.getTypeOfPayment();
            String entityTypeOfShipping = ordersEntity.getTypeOfShipping();

            boolean flag = entitySalesPerson.equals(salesPerson) &&
                    entityGoodsName.equals(goodsName) && entityGoodsNumber.equals(goodsNumber) &&
                    writeAnInvoice == entityWriteAnInvoice;
            boolean totalAmountFlag = entityTotalAmount > minTotalAmount && entityTotalAmount < maxTotalAmount;
            boolean brandFlag = false;
            boolean stateFlag = false;

            for(String brandString : brand){
                if(brandString.equals(entityBrand)) brandFlag = true;
            }
            for(String stateString : state){
                if(stateString.equals(entityState)) stateFlag = true;
            }

            if(flag && totalAmountFlag && brandFlag && stateFlag){
                String unit = "";
                Optional<GoodsEntity> optionalGoods = ordersImpl.goodsRepository.findByGoodsNumberFromGoods(entityGoodsNumber);
                GoodsEntity goods = optionalGoods.isPresent() ? optionalGoods.get() : null;
                if(goods != null) {
                    unit = goods.getUnit();
                }
                OrdersListBean ordersListBean = new OrdersListBean();
                ordersListBean.setOrdersNumber(entityOrderNumber);
                ordersListBean.setClientName(entityClientNumber);
                ordersListBean.setSalesPerson(entitySalesPerson);
                ordersListBean.setGoodsNumber(entityGoodsNumber);
                ordersListBean.setBrand(entityBrand);
                ordersListBean.setGoodsName(entityGoodsName);
                ordersListBean.setFinalPrice(entityFinalPrice);
                ordersListBean.setUnit(unit);
                ordersListBean.setNumbers(entityNumbers);
                ordersListBean.setTotalAmount(entityTotalAmount);
                ordersListBean.setTypeOfPayment(entityTypeOfPayment);
                ordersListBean.setTypeOfShipping(entityTypeOfShipping);
                ordersListBean.setCreateTime(entityCreateTime);
                ordersListBean.setDealTime(entityDealTime);
                ordersListBean.setState(entityState);

                totalOrdersList.add(ordersListBean);
            }
        }

        total = totalOrdersList.size();
        if(startIndex + num < total){
            for(int index = startIndex; index < startIndex + num; index++)
                resultOrdersList.add(totalOrdersList.get(index));
        }
        OrdersBean ordersBean = new OrdersBean(resultOrdersList, total);

        return ordersBean;
    }

    @Override
    public SingleOrderByOrderNumberBean getSingleOrderByOrderNumber(String orderNumber) {
        Optional<OrdersEntity> optionalOrder = ordersImpl.ordersRepository.findById(orderNumber);
        OrdersEntity order = optionalOrder.isPresent() ? optionalOrder.get() : null;
        if(order != null) {
            SingleOrderByOrderNumberBean orderBean = new SingleOrderByOrderNumberBean();

            orderBean.setOrderNumber(order.getOrderNumber());
            orderBean.setCreateTime(order.getCreateTime());
            orderBean.setDealTime(order.getDealTime());
            orderBean.setState(order.getState());
            orderBean.setSalesPerson(order.getSalesPerson());
            orderBean.setClientName(order.getClientNumber());
            orderBean.setWriteAnInvoice(order.getWriteAnInvoice()+"");
            orderBean.setGoodsNumber(order.getGoodsNumber());
            orderBean.setBrand(order.getBrand());
            orderBean.setGoodsName(order.getGoodsName());
            orderBean.setGoodsNo(order.getGoodsNo());
            orderBean.setBuyingPrice(order.getBuyingPrice());
            orderBean.setRetailPrice(order.getRetailPrice());
            orderBean.setFinalPrice(order.getFinalPrice());
            orderBean.setNumber(order.getNumbers());
            orderBean.setTotalAmount(order.getTotalAmount());
            orderBean.setTypeOfPayment(order.getTypeOfPayment());
            orderBean.setTypeOfShipping(order.getTypeOfShipping());

            return orderBean;
        }
        return null;
    }

    @Override
    public String updateSingleOrderByOrderNumber(UpdateSingleOrderBean bean) {
        Optional<OrdersEntity> optionalOrder = ordersImpl.ordersRepository.findById(bean.getOrderNumber());
        OrdersEntity order = optionalOrder.isPresent() ? optionalOrder.get() : null;
        if(order != null) {
            try{
                int writeAnInvoice = bean.getWriteAnInvoice().equals("1") ? 1 : 0;
                ordersImpl.ordersRepository.updateSingleOrder(bean.getOrderNumber(), bean.getState(), bean.getSalesPerson(),
                        bean.getClientNumber(), writeAnInvoice, bean.getGoodsNumber(), bean.getFinalPrice(),
                        bean.getNumbers(), bean.getTotalAmount(), bean.getTypeOfPayment(), bean.getTypeOfShipping());

                return order.getOrderNumber();
            }catch (Exception ex){
                ex.printStackTrace();
                return "更新出错";
            }
        }
        return "未能检索到订单";
    }

    @Override
    public List<String> updateOrders(UpdateOrdersBean bean) {
        List<String> updatedList = new ArrayList<>();
        List<String> orderNumbersList = bean.getOrderNumbersList();
        String state = bean.getState();
        for(String orderNumber : orderNumbersList){
            Optional<OrdersEntity> optionalOrder = ordersImpl.ordersRepository.findById(orderNumber);
            OrdersEntity order = optionalOrder.isPresent() ? optionalOrder.get() : null;
            if(order != null) {
                try{
                   ordersImpl.ordersRepository.updateOrderState(orderNumber, state);
                   updatedList.add(orderNumber);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return updatedList;
    }

    @Override
    public boolean deleteSingleOrderByOrderNumber(String orderNumber) {
        Optional<OrdersEntity> optionalOrder = ordersImpl.ordersRepository.findById(orderNumber);
        OrdersEntity order = optionalOrder.isPresent() ? optionalOrder.get() : null;
        if(order != null) {
            try{
                ordersImpl.ordersRepository.deleteById(orderNumber);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

}
