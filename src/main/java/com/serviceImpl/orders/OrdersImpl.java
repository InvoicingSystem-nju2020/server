package com.serviceImpl.orders;

import com.bean.orders.*;
import com.entity.OrdersEntity;
import com.repository.orders.OrdersRepository;
import com.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class OrdersImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    private static OrdersImpl ordersImpl;
    private static int idLength = 6;

    @PostConstruct
    public void init(){
        ordersImpl = this;
        ordersImpl.ordersRepository = this.ordersRepository;
    }

    @Override
    public String addOrder(AddOrderBean bean) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String id = "";
        for(int i = 0; i < idLength; i++) id = id + "" + (int)(Math.random() * 10);
        id = time + id;

        OrdersEntity order = new OrdersEntity();

        order.setId(id);
        order.setOrderNumber(id);
        order.setSalesPerson(bean.getSalesPerson());
        order.setCreateTime(time);
        order.setDealTime(time);
        order.setClient(bean.getClientName());
        order.setWriteAnInvoice(bean.getWriteAnInvoice());
        order.setGoodsNumber(bean.getGoodsNumbers());
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

    @Override
    public OrdersBean getOrders(GetOrdersBean bean) {

        return null;
    }

    @Override
    public SingleOrderByOrderNumberBean getSingleOrderByOrderNumber(String orderNumber) {

        return null;
    }

    @Override
    public String updateSingleOrderByOrderNumber(UpdateSingleOrderBean bean) {

        return null;
    }

    @Override
    public List<String> updateOrders(UpdateOrdersBean bean) {

        return null;
    }

    @Override
    public boolean deleteSingleOrderByOrderNumber(String orderNumber) {

        return false;
    }

}
