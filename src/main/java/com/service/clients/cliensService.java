package com.service.clients;

import com.bean.clients.*;

public interface cliensService {
   String addClient(AddClientBean bean);
   ClientsBean getCLients(GetClientsBean bean);
   SingleClientByClientsNumberBean getSingleClientByClientsNumber(String clientsNumber);
   String updateSingleClientByClientNumber(UpdateSingleClientBean bean,String clientNumber);
   boolean deleteSingleClientByClientNumber(String clientNumber);
   boolean changeClientBalance(String clientNumber,double change);
   ClientBalanceRecordsBean getSingleClientBalanceRecordsByClientNumber(SingleClientBalanceRecordsByClientNumberBean bean, String clientsNumber);

}
