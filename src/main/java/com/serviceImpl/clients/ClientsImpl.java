package com.serviceImpl.clients;

import com.bean.clients.*;
import com.entity.ClientBalanceRecordEntity;
import com.entity.ClientsEntity;


import com.repository.clients.clientsRepository;
import com.repository.clients.clientBalanceRecordRepository;
import com.service.clients.cliensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ClientsImpl implements cliensService  {
    @Autowired
    private clientsRepository clientsRepository;
    @Autowired
    private clientBalanceRecordRepository clientBalanceRecordRepository;
    private static ClientsImpl clientsImpl;
    private static int idLength = 6;

    @PostConstruct
    public void init(){
        clientsImpl = this;
        clientsImpl.clientsRepository = this.clientsRepository;
        clientsImpl.clientBalanceRecordRepository=this.clientBalanceRecordRepository;
    }

    //4.1录入客户
    @Override
    public String addClient(AddClientBean bean) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = dateFormat.format(new Date());
        String id = "";
        for(int i = 0; i < idLength; i++) id = id + "" + (int)(Math.random() * 10);
        id = time + id;

        ClientsEntity addClientEntity =new ClientsEntity();
        addClientEntity.setId(id);
        addClientEntity.setClientsNumber(bean.getClientsNumber());
        addClientEntity.setClientsName(bean.getClientsName());
        addClientEntity.setClientsType(bean.getClientsType());
        addClientEntity.setBalance(bean.getBalance());
        addClientEntity.setClientsContact(bean.getClientsContact());
        addClientEntity.setClientsSex(bean.getClientsSex());
        addClientEntity.setClientsPost(bean.getClientsPost());
        addClientEntity.setContactInformation(bean.getContactInformation());
        addClientEntity.setMail(bean.getMail());
        addClientEntity.setRemarks(bean.getRemarks());
        addClientEntity.setOther(bean.getOther());

        try{
            clientsImpl.clientsRepository.save(addClientEntity);
            return id;
        }catch (Exception addException){
            addException.printStackTrace();
            return "添加客户出错";
        }

    }

    //4.2 查看客户列表
    @Override
    public ClientsBean getCLients(GetClientsBean bean) {
        List<ClientsListBean> totalClientsList = new ArrayList<>();
        List<ClientsListBean> resultClientsList = new ArrayList<>();
        List<ClientsEntity> clientsEntityList = new ArrayList<>();
        int total = 0;

        String clientsNumber=bean.getClientsNumber();
        String clientsName=bean.getClientsName();
        String[] clientsType=bean.getClientsType();
        String clientsContact=bean.getClientsContact();
        String contactInformation=bean.getContactInformation();
        String mail=bean.getMail();
        int clientsSex=bean.getClientsSex();
        String sorter=bean.getSorter();
        int desc=bean.getDesc();
        int startIndex=bean.getStartIndex();
        int num=bean.getNum();

        if(sorter.equals("") || sorter == null ||sorter.equals("clientsNumber")){
            if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByClientsNumberDesc();
            else clientsEntityList = clientsImpl.clientsRepository.findByClientsNumberInc();
        }
        else if(sorter.equals("clientsName")){
            if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByClientsNameDesc(clientsName);
            else clientsEntityList = clientsImpl.clientsRepository.findByClientsNameLike(clientsName);
        }
        else if(sorter.equals("clientsType")) {
            if (desc == 1) {
                for (String a : clientsType) {
                    if (clientsRepository.findListByClientsTypeDesc(a) != null) {
                        clientsEntityList.add(clientsRepository.findListByClientsType(a));
                    }
                }
            } else {
                for (String a : clientsType) {
                    if (clientsRepository.findListByClientsType(a) != null) {
                        clientsEntityList.add(clientsRepository.findListByClientsType(a));
                    }
                }
            }
        }
        else if(sorter.equals("clientsContact")){
            if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByClientsContactDesc(clientsContact);
            else clientsEntityList = clientsImpl.clientsRepository.findByClientsContact(clientsContact);
        }
        else if(sorter.equals("contactInformation")){
            if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByContactInformationDesc(contactInformation);
            else clientsEntityList = clientsImpl.clientsRepository.findByContactInformation(contactInformation);
        }
        else if(sorter.equals("mail")){
            if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByMailDesc(mail);
            else clientsEntityList = clientsImpl.clientsRepository.findByMail(mail);
        }
        else if(sorter.equals("clientsSex")){
            String Sex="";
            if(clientsSex==0){
                if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByClientsNumberDesc();
                else clientsEntityList = clientsImpl.clientsRepository.findByClientsNumberInc();
            }
            else if(clientsSex==1){Sex="男";}
            else if(clientsSex==2){Sex="女";}
            if(desc == 1) clientsEntityList = clientsImpl.clientsRepository.findByClientsSexDesc(Sex);
            else clientsEntityList = clientsImpl.clientsRepository.findByClientsSex(Sex);
        }

        for(ClientsEntity clientsEntity : clientsEntityList){

            ClientsListBean clientsListBean = new ClientsListBean();

            clientsListBean.setClientsNumber(clientsEntity.getClientsNumber());
            clientsListBean.setClientsName(clientsEntity.getClientsName());
            clientsListBean.setClientsType(clientsEntity.getClientsType());
            clientsListBean.setBalance(clientsEntity.getBalance());
            clientsListBean.setClientsContact(clientsEntity.getClientsContact());
            clientsListBean.setClientsSex(clientsEntity.getClientsSex());
            clientsListBean.setClientsPost(clientsEntity.getClientsPost());
            clientsListBean.setContactInformation(clientsEntity.getContactInformation());
            clientsListBean.setMail(clientsEntity.getMail());
            clientsListBean.setRemarks(clientsEntity.getRemarks());
            clientsListBean.setOther(clientsEntity.getOther());

            totalClientsList.add(clientsListBean);
        }

        total = totalClientsList.size();
        if(startIndex==0&&num==0){resultClientsList=totalClientsList;}
        else if(num==0&&startIndex + num>=total){
            for (int index = startIndex; index < total; index++)
                resultClientsList.add(totalClientsList.get(index));
        }
        else {
            if (startIndex + num < total) {
                for (int index = startIndex; index < startIndex + num; index++)
                    resultClientsList.add(totalClientsList.get(index));
            }
        }
        ClientsBean clientsBean = new ClientsBean(resultClientsList, total);
        return clientsBean;
    }

    //4.3 查询单个客户的信息
    @Override
    public SingleClientByClientsNumberBean getSingleClientByClientsNumber(String clientsNumber) {
        List<ClientsEntity> optionalClient = clientsImpl.clientsRepository.findByClientsNumber(clientsNumber);
        ClientsEntity client = optionalClient.get(0);
        if(client != null) {
            SingleClientByClientsNumberBean clientBean = new SingleClientByClientsNumberBean();

            clientBean.setClientsNumber(client.getClientsNumber());
            clientBean.setClientsName(client.getClientsName());
            clientBean.setClientsType(client.getClientsType());
            clientBean.setBalance(client.getBalance());
            clientBean.setClientsContact(client.getClientsContact());
            clientBean.setClientsSex(client.getClientsSex());
            clientBean.setClientsPost(client.getClientsPost()+"");
            clientBean.setContactInformation(client.getContactInformation());
            clientBean.setMail(client.getMail());
            clientBean.setRemarks(client.getRemarks());
            clientBean.setOther(client.getOther());

            return clientBean;
        }
        return null;
    }

    //4.4 修改客户信息
    @Override
    public String updateSingleClientByClientNumber(UpdateSingleClientBean bean,String clientsNumber) {
        List<ClientsEntity> optionalClient = clientsImpl.clientsRepository.findByClientsNumber(clientsNumber);
        ClientsEntity client = optionalClient.get(0);
        if(client != null) {
            try{

                clientsImpl.clientsRepository.updateSingleClient(clientsNumber,bean.getClientsName(), bean.getClientsType(), bean.getClientsContact(),
                        bean.getClientsSex(), bean.getClientsPost(), bean.getContactInformation(),
                        bean.getMail(), bean.getRemarks(), bean.getOther());

                return client.getClientsNumber();
            }catch (Exception ex){
                ex.printStackTrace();
                return "更新出错";
            }
        }
        return "未能检索到客户";
    }

    //4.5 删除客户
    @Override
    public boolean deleteSingleClientByClientNumber(String clientsNumber) {
        List<ClientsEntity> optionalClient = clientsImpl.clientsRepository.findOneByClientsNumber(clientsNumber);
        ClientsEntity client = optionalClient.get(0);
        if(client != null) {
            try{
                clientsImpl.clientsRepository.deleteById(client.getId());
                return true;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    //4.6 充值
    @Override
    public boolean changeClientBalance(String clientNumber, double change) {
        List<ClientsEntity> optionalClient = clientsImpl.clientsRepository.findByClientsNumber(clientNumber);
        ClientsEntity client = optionalClient.get(0);
        if(client != null) {
            try{
                clientsImpl.clientsRepository.updateClientBalance(clientNumber,client.getBalance()+change);
                return true;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }

    //4.7 查询客户的汇款信息
    @Override
    public ClientBalanceRecordsBean getSingleClientBalanceRecordsByClientNumber(SingleClientBalanceRecordsByClientNumberBean bean, String clientsNumber) {
        List<ClientBalanceRecordsListBean> totalClientBalanceRecordsList = new ArrayList<>();
        List<ClientBalanceRecordsListBean> resultClientBalanceRecordsList = new ArrayList<>();
        List<ClientBalanceRecordEntity> clientBalanceRecordEntityList = new ArrayList<>();
        int total = 0;

        String startMonth=bean.getStartMonth();
        String endMonth=bean.getEndMonth();
        String startRemittanceDate=bean.getStartRemittanceDate();
        String endRemittanceDate=bean.getEndRemittanceDate();
        double minRemittanceAmount=bean.getMinRemittanceAmount();
        double maxRemittanceAmount=bean.getMaxRemittanceAmount();
        double minPurchaseAmount=bean.getMinPurchaseAmount();
        double maxPurchaseAmount=bean.getMaxPurchaseAmount();

        int startIndex=bean.getStartIndex();
        int num=bean.getNum();

        if(startMonth.equals("") || startMonth == null ||endMonth.equals("") || endMonth == null ||
                startRemittanceDate.equals("") || startRemittanceDate == null ||
                endRemittanceDate.equals("") || endRemittanceDate == null ||
                minRemittanceAmount==0 || maxRemittanceAmount == 0||
                minPurchaseAmount== 0 || maxPurchaseAmount == 0){
             clientBalanceRecordEntityList = clientsImpl.clientBalanceRecordRepository.findOneByClientsNumber(clientsNumber);

        }

        for(ClientBalanceRecordEntity clientBalanceRecordEntity : clientBalanceRecordEntityList){

            ClientBalanceRecordsListBean clientBalanceRecordsListBean = new ClientBalanceRecordsListBean();

            clientBalanceRecordsListBean.setMonth(clientBalanceRecordEntity.getMonth());
            clientBalanceRecordsListBean.setLastMonthSBalance(clientBalanceRecordEntity.getLastMonthSBalance());
            clientBalanceRecordsListBean.setRemittanceDate(clientBalanceRecordEntity.getRemittanceDate());
            clientBalanceRecordsListBean.setRemittanceBalance(clientBalanceRecordEntity.getRemittanceBalance());
            clientBalanceRecordsListBean.setPurchaseBalance(clientBalanceRecordEntity.getPurchaseBalance());


            totalClientBalanceRecordsList.add(clientBalanceRecordsListBean);
        }

        total = totalClientBalanceRecordsList.size();
        if(startIndex + num < total){
            for(int index = startIndex; index < startIndex + num; index++)
                resultClientBalanceRecordsList.add(totalClientBalanceRecordsList.get(index));
        }
        ClientBalanceRecordsBean clientBalanceRecordsBean = new ClientBalanceRecordsBean(resultClientBalanceRecordsList, total);
        return clientBalanceRecordsBean;
    }

}
