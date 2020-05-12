package com.repository.goods;

import com.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, String>, JpaSpecificationExecutor<GoodsEntity> {

    @Query(value = "select * from goods where goodsNumber = ?1", nativeQuery = true)
    Optional<GoodsEntity> findByGoodsNumber(String goodsNumber);
}
