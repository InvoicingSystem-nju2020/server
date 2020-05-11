package com.repository.suppliers;

import com.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<BuyerEntity, String>, JpaSpecificationExecutor<BuyerEntity> {

}
