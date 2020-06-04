package com.repository.clients;

import com.entity.ClientBalanceRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clientBalanceRecordRepository extends JpaRepository<ClientBalanceRecordEntity, String>, JpaSpecificationExecutor<ClientBalanceRecordEntity> {

    @Query(value = "select * from clientbalancerecord c where c.clientNumber=?1 order by month", nativeQuery = true)
    List<ClientBalanceRecordEntity> findOneByClientsNumber(String clientNumber);
}
