package com.controller.orders;

import com.bean.orders.*;
import com.service.orders.OrdersService;
import com.serviceImpl.orders.OrdersImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {
    OrdersService ordersService = new OrdersImpl();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addOrder(@RequestBody AddOrderBean bean){
        return ordersService.addOrder(bean);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public OrdersBean getOrders(@RequestBody GetOrdersBean bean){
        return ordersService.getOrders(bean);
    }

    @RequestMapping(value = "/{orderNumber}", method = RequestMethod.GET)
    public SingleOrderByOrderNumberBean getSingleOrderByOrderNumber(@PathVariable(value="orderNumber") String orderNumber){
        return ordersService.getSingleOrderByOrderNumber(orderNumber);
    }

    @RequestMapping(value = "/{orderNumber}", method = RequestMethod.PUT)
    public String updateSingleOrderByOrderNumber(@RequestBody UpdateSingleOrderBean bean){
        return ordersService.updateSingleOrderByOrderNumber(bean);
    }

    @RequestMapping(value = "/{state}", method = RequestMethod.PATCH)
    public List<String> updateOrders(@RequestBody UpdateOrdersBean bean){
        return ordersService.updateOrders(bean);
    }

    @RequestMapping(value = "/{orderNumber}", method = RequestMethod.DELETE)
    public boolean deleteSingleOrderByOrderNumber(@PathVariable(value="orderNumber") String orderNumber){
        return ordersService.deleteSingleOrderByOrderNumber(orderNumber);
    }

}
