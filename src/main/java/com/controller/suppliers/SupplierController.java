package com.controller.suppliers;

import com.bean.suppliers.*;
import com.service.suppliers.SupplierService;
import com.serviceImpl.suppliers.SupplierImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("suppliers")
public class SupplierController {
    SupplierService supplierService = new SupplierImpl();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addSupplier(@RequestBody AddSupplierBean bean){
        return supplierService.addSupplier(bean);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public SuppliersReturnBean getSuppliers(@RequestBody GetSuppliersBean bean){
        return supplierService.getSuppliers(bean);
    }

    @RequestMapping(value = "/{supplierNumber}", method = RequestMethod.GET)
    public SingleSupplierBean getSingleSupplier(@PathVariable(value="supplierNumber") String supplierNumber){
        return supplierService.getSingleSupplier(supplierNumber);
    }

    @RequestMapping(value = "/{supplierNumber}", method = RequestMethod.PUT)
    public String updateSingleSupplierBySupplierNumber(@RequestBody UpdateSingleSupplierBean bean){
        return supplierService.updateSingleSupplierBySupplierNumber(bean);
    }

    @RequestMapping(value = "/{supplierNumber}", method = RequestMethod.DELETE)
    public boolean deleteSingleSupplierBySupplierNumber(@PathVariable(value="supplierNumber") String supplierNumber){
        return supplierService.deleteSingleSupplierBySupplierNumber(supplierNumber);
    }
}
