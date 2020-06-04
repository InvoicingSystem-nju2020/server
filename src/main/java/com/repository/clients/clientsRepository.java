package com.repository.clients;

import com.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface clientsRepository extends JpaRepository<ClientsEntity, String>, JpaSpecificationExecutor<ClientsEntity> {

    @Transactional
    @Modifying
    @Query(value = "update clients set clientsName = ?2, clientsType = ?3, clientsContact = ?4, clientsSex = ?5, clientsPost = ?6, contactInformation = ?7, mail = ?8, remarks = ?9, other   = ?10 where clientsNumber = ?1", nativeQuery = true)
    void updateSingleClient(String clientsNumber,  String clientsName, String clientsType,  String clientsContact, String clientsSex, String clientsPost,String contactInformation, String mail, String remarks,String other);


    @Transactional
    @Modifying
    @Query(value = "update clients set balance = ?2 where clientsNumber = ?1", nativeQuery = true)
    void updateClientBalance(String clientNumber, double resultBalance);

    @Query(value = "select * from clients c where c.clientsNumber=?1", nativeQuery = true)
    List<ClientsEntity> findOneByClientsNumber(String clientsNumber);

    @Query(value = "select * from clients order by id + 1", nativeQuery = true)
    List<ClientsEntity> findAllByIdInc();

    @Query(value = "select * from clients order by id + 1 DESC", nativeQuery = true)
    List<ClientsEntity> findAllByIdDesc();

    @Query(value = "select * from clients c where c.clientsNumber=?1", nativeQuery = true)
    List<ClientsEntity> findByClientsNumber(String clientsNumber);

    @Query(value = "select * from clients order by clientsNumber", nativeQuery = true)
    List<ClientsEntity> findByClientsNumberInc();

    @Query(value = "select * from clients order by clientsNumber DESC ", nativeQuery = true)
    List<ClientsEntity> findByClientsNumberDesc();

    @Query(value = "select * from clients c where c.clientsName like CONCAT('%',?1,'%') order by clientsName", nativeQuery = true)
    List<ClientsEntity> findByClientsNameLike(String clientsName);

    @Query(value = "select * from clients c where c.clientsName like CONCAT('%',?1,'%') order by clientsName DESC", nativeQuery = true)
    List<ClientsEntity> findByClientsNameDesc(String clientsName);

    @Query(value = "select * from clients c where FIND_IN_SET(c.clientsType,?1) order by c.clientsType", nativeQuery = true)
    ClientsEntity findListByClientsType(String clientType);

    @Query(value = "select * from clients c where FIND_IN_SET(c.clientsType,?1) order by c.clientsType DESC", nativeQuery = true)
    ClientsEntity findListByClientsTypeDesc(String clientType);

    @Query(value = "select * from clients c where c.clientsContact like CONCAT('%',?1,'%') order by clientsContact ", nativeQuery = true)
    List<ClientsEntity> findByClientsContact(String clientContact);

    @Query(value = "select * from clients c where c.clientsContact like CONCAT('%',?1,'%') order by clientContact DESC", nativeQuery = true)
    List<ClientsEntity> findByClientsContactDesc(String clientContact);

    @Query(value = "select * from clients c where c.contactInformation=?1 order by clientsNumber", nativeQuery = true)
    List<ClientsEntity> findByContactInformation(String contactInformation);

    @Query(value = "select * from clients c where c.contactInformation=?1 order by clientsNumber DESC", nativeQuery = true)
    List<ClientsEntity> findByContactInformationDesc(String contactInformation);

    @Query(value = "select * from clients c where c.mail=?1 order by clientsNumber", nativeQuery = true)
    List<ClientsEntity> findByMail(String mail);

    @Query(value = "select * from clients c where c.mail=?1 order by clientsNumber DESC ", nativeQuery = true)
    List<ClientsEntity> findByMailDesc(String mail);

    @Query(value = "select * from clients c where c.clientsSex = ?1 order by clientsName", nativeQuery = true)
    List<ClientsEntity> findByClientsSex(String clientsSex);

    @Query(value = "select * from clients c where c.clientsSex = ?1 order by clientsName DESC", nativeQuery = true)
    List<ClientsEntity> findByClientsSexDesc(String clientsSex);


}