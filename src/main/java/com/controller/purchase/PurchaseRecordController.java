package com.controller.purchase;

import com.bean.purchase.*;
import com.service.purchase.PurchaseRecordService;
import com.serviceImpl.purchase.PurchaseRecordImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("purchase_records")
public class PurchaseRecordController {
    PurchaseRecordService purchaseRecordService = new PurchaseRecordImpl();

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addPurchaseRecord(@RequestBody AddPurchaseRecordBean purchaseRecordBean){
        return purchaseRecordService.addPurchaseRecord(purchaseRecordBean);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public PurchaseRecordsBean getPurchaseRecords(@RequestParam(defaultValue = "") String startPurchaseTime, @RequestParam(defaultValue = "") String endPurchaseTime,
                                                  @RequestParam(defaultValue = "") String startCreateTime, @RequestParam(defaultValue = "") String endCreateTime,
                                                  @RequestParam(defaultValue = "") String goodsName, @RequestParam(defaultValue = "") String goodsNumber,
                                                  @RequestParam(defaultValue = "") String brand, @RequestParam(defaultValue = "") String supplier,
                                                  @RequestParam(defaultValue = "0") Integer minNumbers, @RequestParam(defaultValue = "0") Integer  maxNumbers,
                                                  @RequestParam(defaultValue = "0.00") Double  minRetailPrice, @RequestParam(defaultValue = "0.00") Double maxRetailPrice,
                                                  @RequestParam(defaultValue = "0.00") Double  minDiscount, @RequestParam(defaultValue = "0.00") Double maxDiscount,
                                                  @RequestParam(defaultValue = "0.00") Double  minUnitPrice, @RequestParam(defaultValue = "0.00") Double maxUnitPrice,
                                                  @RequestParam(defaultValue = "0.00") Double  minTotalAmount, @RequestParam(defaultValue = "0.00") Double maxTotalAmount,
                                                  @RequestParam(defaultValue = "-1") Integer  taxIncluded, @RequestParam(defaultValue = "") String sorter,
                                                  @RequestParam(defaultValue = "0") Integer  desc, @RequestParam(defaultValue = "0") Integer startIndex,
                                                  @RequestParam(defaultValue = "100") Integer num){

        GetPurchaseRecordsBean bean = new GetPurchaseRecordsBean();
        bean.setStartPurchaseTime(startPurchaseTime);bean.setEndPurchaseTime(endPurchaseTime);
        bean.setStartCreateTime(startCreateTime);bean.setEndCreateTime(endCreateTime);
        bean.setGoodsName(goodsName);bean.setGoodsNumber(goodsNumber);
        bean.setBrand(brand);bean.setSupplier(supplier);
        bean.setMinNumbers(minNumbers);bean.setMaxNumbers(maxNumbers);
        bean.setMinRetailPrice(minRetailPrice);bean.setMaxRetailPrice(maxRetailPrice);
        bean.setMinDiscount(minDiscount);bean.setMaxDiscount(maxDiscount);
        bean.setMinUnitPrice(minUnitPrice);bean.setMaxUnitPrice(maxUnitPrice);
        bean.setMinTotalAmount(minTotalAmount);bean.setMaxTotalAmount(maxTotalAmount);
        bean.setTaxIncluded(taxIncluded);bean.setSorter(sorter);
        bean.setDesc(desc);bean.setStartIndex(startIndex);bean.setNum(num);

        return purchaseRecordService.getPurchaseRecords(bean);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SinglePurchaseRecordByIdBean getSinglePurchaseRecordById(@PathVariable(value="id") String id){
        return purchaseRecordService.getSinglePurchaseRecordById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateSinglePurchaseRecordById(@RequestBody UpdateSinglePurchaseRecordsBean bean){
        return purchaseRecordService.updateSinglePurchaseRecordById(bean);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteSinglePurchaseRecordById(@PathVariable(value="id") String id){
        return purchaseRecordService.deleteSinglePurchaseRecordById(id);
    }
}
