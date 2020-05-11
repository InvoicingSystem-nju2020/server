package com.service.orders;

import com.bean.orders.*;
import java.util.List;

public interface OrdersService {
    String addOrder(AddOrderBean bean);

    OrdersBean getOrders(GetOrdersBean bean);

    SingleOrderByOrderNumberBean getSingleOrderByOrderNumber(String orderNumber);

    String updateSingleOrderByOrderNumber(UpdateSingleOrderBean bean);

    List<String> updateOrders(UpdateOrdersBean bean);

    boolean deleteSingleOrderByOrderNumber(String orderNumber);
}
