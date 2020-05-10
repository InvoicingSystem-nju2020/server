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

    @RequestMapping(value = "",method = RequestMethod.GET)
    public PurchaseRecordsBean getPurchaseRecords(@RequestBody GetPurchaseRecordsBean bean){
        return purchaseRecordService.getPurchaseRecords(bean);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public SinglePurchaseRecordByIdBean getSinglePurchaseRecordById(@PathVariable(value="id") String id){
        return purchaseRecordService.getSinglePurchaseRecordById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateSinglePurchaseRecordById(@RequestBody UpdateSinglePurchaseRecordsBean bean){
        return purchaseRecordService.updateSinglePurchaseRecordById(bean);
    }

}
