package com.repository.goods;

import com.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface goodsRepository extends JpaRepository<GoodsEntity, String>, JpaSpecificationExecutor<GoodsEntity> {

    @Query(value = "select * from goods where goodsNumber = ?1", nativeQuery = true)
    Optional<GoodsEntity> findByGoodsNumberFromGoods(String goodsNumber);

    @Transactional
    @Modifying
    @Query(value = "update goods g set g.goodsName = ?2, g.abbreviation = ?3, g.brand = ?4, g.model = ?5, g.goodsNo = ?6, g.material = ?7, g.colour = ?8, g.type = ?9, g.specifications = ?10,g.unit=?11,g.weight=?12,g.retailPrice=?13,g.placeOfProduction=?14,g.qualityGuaranteePeriod=?15,g.remarks=?16   where g.goodsNumber = ?1", nativeQuery = true)
    void updateSingleGood(String goodsNumber,  String goodsName, String abbreviation,  String brand, String model, String goodsNo,String material, String colour, String type,String specifications,String unit,String weight,double retailPrice,String placeOfProduction,int qualityGuaranteePeriod,String remarks);



    @Query(value = "select * from clients c where c.goodsNumber=?1", nativeQuery = true)
    List<GoodsEntity> findByGoodsNumber(String goodsNumber);

    @Query(value = "select * from goods g where g.goodsNumber=?1 order by month", nativeQuery = true)
    List<GoodsEntity> findOneByGoodsNumber(String goodsNumber);

    @Query(value = "select * from goods order by goodsNumber", nativeQuery = true)
    List<GoodsEntity> findByGoodsNumberInc();

    @Query(value = "select * from goods order by goodsNumber DESC ", nativeQuery = true)
    List<GoodsEntity> findByGoodsNumberDesc();

    @Query(value = "select * from goods g where g.goodsName like CONCAT('%',?1,'%') order by goodsName", nativeQuery = true)
    List<GoodsEntity> findByGoodsName(String goodsName);

    @Query(value = "select * from goods g where g.goodsName like CONCAT('%',?1,'%') order by goodsName DESC", nativeQuery = true)
    List<GoodsEntity> findByGoodsNameDesc(String goodsName);

    @Query(value = "select * from goods g where g.abbreviation like CONCAT('%',?1,'%') order by abbreviation", nativeQuery = true)
    List<GoodsEntity> findByAbbreviation(String abbreviation);

    @Query(value = "select * from goods g where g.abbreviation like CONCAT('%',?1,'%') order by abbreviation DESC", nativeQuery = true)
    List<GoodsEntity> findByAbbreviationDesc(String abbreviation);

    @Query(value = "select * from goods g where FIND_IN_SET(c.brand,?1)  order by brand", nativeQuery = true)
    GoodsEntity findByBrand(String brand);

    @Query(value = "select * from goods g where FIND_IN_SET(c.brand,?1)  order by brand DESC", nativeQuery = true)
    GoodsEntity findByBrandDesc(String brand);

    @Query(value = "select * from goods g where g.model=?1 order by model", nativeQuery = true)
    List<GoodsEntity> findByModel(String model);

    @Query(value = "select * from goods g where g.model=?1 order by model DESC", nativeQuery = true)
    List<GoodsEntity> findByModelDesc(String model);

    @Query(value = "select * from goods g where g.goodsNo=?1 order by goodsNo", nativeQuery = true)
    List<GoodsEntity> findByGoodsNo(String goodsNo);

    @Query(value = "select * from goods g where g.goodsNo=?1 order by goodsNo DESC", nativeQuery = true)
    List<GoodsEntity> findByGoodsNoDesc(String goodsNo);

    @Query(value = "select * from goods g where g.material=?1 order by material", nativeQuery = true)
    List<GoodsEntity> findByMaterial(String material);

    @Query(value = "select * from goods g where g.material=?1 order by material DESC", nativeQuery = true)
    List<GoodsEntity> findByMaterialDesc(String material);

    @Query(value = "select * from goods g where g.colour=?1 order by colour", nativeQuery = true)
    List<GoodsEntity> findByColour(String colour);

    @Query(value = "select * from goods g where g.colour=?1 order by colour DESC", nativeQuery = true)
    List<GoodsEntity> findByColourDesc(String colour);

    @Query(value = "select * from goods g where FIND_IN_SET(c.type,?1) order by type", nativeQuery = true)
    GoodsEntity findByType(String type);

    @Query(value = "select * from goods g where FIND_IN_SET(c.type,?1)  order by type DESC", nativeQuery = true)
    GoodsEntity findByTypeDesc(String type);

    @Query(value = "select * from goods g where FIND_IN_SET(c.place,?1)  order by place", nativeQuery = true)
    GoodsEntity findByPlace(String place);

    @Query(value = "select * from goods g where FIND_IN_SET(c.place,?1) order by place DESC", nativeQuery = true)
    GoodsEntity findByPlaceDesc(String place);

    @Query(value = "select * from goods g where g.retailPrice > ?1 order by retailPrice", nativeQuery = true)
    List<GoodsEntity> findByMinRetailPrice(double minRetailPrice);

    @Query(value = "select * from goods g where g.retailPrice > ?1 order by retailPrice DESC", nativeQuery = true)
    List<GoodsEntity> findByMinRetailPriceDesc(double minRetailPrice);

    @Query(value = "select * from goods g where g.retailPrice < ?1 order by retailPrice", nativeQuery = true)
    List<GoodsEntity> findByMaxRetailPrice(double maxRetailPrice);

    @Query(value = "select * from goods g where g.retailPrice < ?1 order by retailPrice DESC", nativeQuery = true)
    List<GoodsEntity> findByMaxRetailPriceDesc(double maxRetailPrice);

}
