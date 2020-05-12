package com.repository.purchase;

import com.entity.PurchaseRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecordEntity, String>, JpaSpecificationExecutor<PurchaseRecordEntity> {

    @Query(value = "select * from purchaserecord order by id + 1 DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByIdDesc();

    @Query(value = "select * from purchaserecord order by id + 1", nativeQuery = true)
    List<PurchaseRecordEntity> findByIdInc();

    @Query(value = "select * from purchaserecord order by goodsNumber + 1 DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByGoodsNumberDesc();

    @Query(value = "select * from purchaserecord order by goodsNumber + 1", nativeQuery = true)
    List<PurchaseRecordEntity> findByGoodsNumberInc();

    @Query(value = "select * from purchaserecord order by numbers DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByNumbersDesc();

    @Query(value = "select * from purchaserecord order by numbers", nativeQuery = true)
    List<PurchaseRecordEntity> findByNumbersInc();

    @Query(value = "select * from purchaserecord order by balance DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByRetailPriceDesc();

    @Query(value = "select * from purchaserecord order by balance", nativeQuery = true)
    List<PurchaseRecordEntity> findByRetailPriceInc();

    @Query(value = "select * from purchaserecord order by discount DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByDiscountDesc();

    @Query(value = "select * from purchaserecord order by discount", nativeQuery = true)
    List<PurchaseRecordEntity> findByDiscountInc();

    @Query(value = "select * from purchaserecord order by unitPrice DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByUnitPriceDesc();

    @Query(value = "select * from purchaserecord order by unitPrice", nativeQuery = true)
    List<PurchaseRecordEntity> findByUnitPriceInc();

    @Query(value = "select * from purchaserecord order by balance DESC", nativeQuery = true)
    List<PurchaseRecordEntity> findByTotalAmountDesc();

    @Query(value = "select * from purchaserecord order by balance", nativeQuery = true)
    List<PurchaseRecordEntity> findByTotalAmountInc();

    @Transactional
    @Modifying
    @Query(value = "update purchaserecord set purchaseTime = ?2, goodsNumber = ?3, numbers = ?4, discount = ?5, unitPrice = ?6, balance = ?7, taxIncluded = ?8, precautionForPreservation = ?9, buyerNumber = ?10, remarks = ?11 where id = ?1", nativeQuery = true)
    void updateSinglePurchaseRecord(String id, String purchaseTime, String goodsNumber, int numbers, double discount, double unitPrice, double totalAmount, int taxIncluded, String precautionForPreservation, String supplierNumber, String remarks);

}
