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
    public SuppliersReturnBean getSuppliers(@RequestParam(defaultValue = "") String supplierNumber, @RequestParam(defaultValue = "") String supplierName,
                                            @RequestParam(defaultValue = "") String productionCategory, @RequestParam(defaultValue = "") String purchasingCategories,
                                            @RequestParam(defaultValue = "") String contact, @RequestParam(defaultValue = "") String contactInformation,
                                            @RequestParam(defaultValue = "") String mail, @RequestParam(defaultValue = "0") Integer sex,
                                            @RequestParam(defaultValue = "") String sorter, @RequestParam(defaultValue = "0") Integer  desc,
                                            @RequestParam(defaultValue = "0") Integer  startIndex, @RequestParam(defaultValue = "100") Integer  num){
        GetSuppliersBean bean = new GetSuppliersBean();
        bean.setSupplierNumber(supplierNumber);
        bean.setSupplierName(supplierName);
        bean.setProductionCategory(productionCategory);
        bean.setPurchasingCategories(purchasingCategories);
        bean.setContact(contact);
        bean.setContactInformation(contactInformation);
        bean.setMail(mail);
        bean.setSex(sex);
        bean.setSorter(sorter);
        bean.setDesc(desc);
        bean.setStartIndex(startIndex);
        bean.setNum(num);
        return supplierService.getSuppliers(bean);
    }

    @RequestMapping(value = "/{supplierNumber}", method = RequestMethod.GET)
    public SingleSupplierBean getSingleSupplier(@PathVariable(value="supplierNumber") String supplierNumber){
        return supplierService.getSingleSupplier(supplierNumber);
    }

    @RequestMapping(value = "/{supplierNumber}", method = RequestMethod.PUT)
    public String updateSingleSupplierBySupplierNumber(@PathVariable(value="supplierNumber") String supplierNumber, @RequestBody UpdateSingleSupplierBean bean){
        return supplierService.updateSingleSupplierBySupplierNumber(supplierNumber, bean);
    }

    @RequestMapping(value = "/{supplierNumber}", method = RequestMethod.DELETE)
    public String deleteSingleSupplierBySupplierNumber(@PathVariable(value="supplierNumber") String supplierNumber){
        return supplierService.deleteSingleSupplierBySupplierNumber(supplierNumber);
    }
}
