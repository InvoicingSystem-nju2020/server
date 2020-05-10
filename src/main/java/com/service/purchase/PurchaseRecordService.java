package com.service.purchase;

import com.bean.purchase.*;

public interface PurchaseRecordService {
    String addPurchaseRecord(AddPurchaseRecordBean purchaseRecordBean);

    PurchaseRecordsBean getPurchaseRecords(GetPurchaseRecordsBean bean);

    SinglePurchaseRecordByIdBean getSinglePurchaseRecordById(String id);

    String updateSinglePurchaseRecordById(UpdateSinglePurchaseRecordsBean bean);
}
