package com.repository.orders;

import com.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, String>, JpaSpecificationExecutor<OrdersEntity> {

    @Transactional
    @Modifying
    @Query(value = "update orders set state = ?2, salesPerson = ?3, clientNumber = ?4, writeAnInvocie = ?5, goodsNumber = ?6, finalPrice = ?7, numbers = ?8, totalAmount = ?9, typeOfPayment = ?10, typeOfShipping = ?11 where id = ?1", nativeQuery = true)
    void updateSingleOrder(String orderNumber, String state, String salesPerson, String clientNumber, int writeAnInvoice, String goodsNumber, double finalPrice, int numbers, double totalAmount, String typeOfPayment, String typeOfShipping);

    @Transactional
    @Modifying
    @Query(value = "update orders set state = ?2 where orderNumber = ?1", nativeQuery = true)
    void updateOrderState(String orderNumber, String state);

    @Query(value = "select * from orders order by id + 1 DESC", nativeQuery = true)
    List<OrdersEntity> findAllByIdDesc();

    @Query(value = "select * from orders order by id + 1", nativeQuery = true)
    List<OrdersEntity> findAllByIdInc();

    @Query(value = "select * from orders order by goodsNumber + 1 DESC", nativeQuery = true)
    List<OrdersEntity> findAllByGoodsNumberDesc();

    @Query(value = "select * from orders order by goodsNumber + 1", nativeQuery = true)
    List<OrdersEntity> findAllByGoodsNumberInc();

    @Query(value = "select * from orders order by totalAmount DESC", nativeQuery = true)
    List<OrdersEntity> findAllByTotalAmountDesc();

    @Query(value = "select * from orders order by totalAmount", nativeQuery = true)
    List<OrdersEntity> findAllByTotalAmountInc();

    @Query(value = "select * from orders order by writeAnInvoice DESC", nativeQuery = true)
    List<OrdersEntity> findAllByWriteAnInvoiceDesc();

    @Query(value = "select * from orders order by writeAnInvoice", nativeQuery = true)
    List<OrdersEntity> findAllByWriteAnInvoiceInc();
}
