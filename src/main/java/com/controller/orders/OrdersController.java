package com.controller.orders;

import com.bean.orders.AddOrderBean;
import com.service.orders.OrdersService;
import com.serviceImpl.orders.OrdersImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {
    OrdersService ordersService = new OrdersImpl();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addOrder(@RequestBody AddOrderBean bean){
        return ordersService.addOrder(bean);
    }

}
