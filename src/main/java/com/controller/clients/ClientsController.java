package com.controller.clients;

import com.bean.clients.*;
import com.service.clients.cliensService;
import com.serviceImpl.clients.ClientsImpl;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("clients")
public class ClientsController {
    cliensService cliensService = new ClientsImpl();

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addOrder(@RequestBody AddClientBean bean){
        return cliensService.addClient(bean);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ClientsBean getOrders(@RequestParam GetClientsBean bean){
        return cliensService.getCLients(bean);
    }

    @RequestMapping(value = "/{clientsNumber}", method = RequestMethod.GET)
    public SingleClientByClientsNumberBean SingleClientByClientsNumber(@PathVariable("clientsNumber") String clientsNumber){
        return cliensService.getSingleClientByClientsNumber(clientsNumber);
    }

    @RequestMapping(value = "/{clientsNumber}", method = RequestMethod.PUT)
    public String updateSingleClientByClientNumber(@RequestBody UpdateSingleClientBean bean,@PathVariable("clientsNumber") String clientsNumber){
        return cliensService.updateSingleClientByClientNumber(bean,clientsNumber);
    }

    @RequestMapping(value = "/{balance}", method = RequestMethod.PATCH)
    public boolean changeClientBalance(@RequestBody UpdateSingleClientBean bean,double balance){
        return cliensService.changeClientBalance(bean.getClientsNumber(),balance);
    }

    @RequestMapping(value = "/{clientsNumber}", method = RequestMethod.DELETE)
    public boolean deleteSingleClientByOrderNumber(@PathVariable("clientsNumber") String clientsNumber){
        return cliensService.deleteSingleClientByClientNumber(clientsNumber);
    }

}
