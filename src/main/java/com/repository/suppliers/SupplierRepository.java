package com.repository.suppliers;

import com.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<BuyerEntity, String>, JpaSpecificationExecutor<BuyerEntity> {

    @Transactional
    @Modifying
    @Query(value = "update buyer set buyer_name = ?2, contact_information = ?3, remarks = ?4, production_category = ?5, purchasing_categories = ?6, legal_person = ?7, contact = ?8, sex = ?9, post = ?10, mail = ?11 where buyer_number = ?1", nativeQuery = true)
    void updateSingleSupplier(String supplierNumber, String supplierName, String contactInformation, String remarks, String productionCategory, String purchasingCategories, String legalPerson, String contact, String sex, String post, String mail);

    @Query(value = "select * from buyer order by buyerNumber + 1 DESC", nativeQuery = true)
    List<BuyerEntity> findBySupplierNumberDesc();

    @Query(value = "select * from buyer order by buyerNumber + 1", nativeQuery = true)
    List<BuyerEntity> findBySupplierNumberInc();

}
