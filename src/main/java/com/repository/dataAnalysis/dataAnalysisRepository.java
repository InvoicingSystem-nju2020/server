package com.repository.dataAnalysis;

import com.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface dataAnalysisRepository extends JpaRepository<OrdersEntity,String>, JpaSpecificationExecutor<OrdersEntity>{

    //该日总销售额及对比昨日增长
    @Query(value = "select sum(totalamount) from orders where DATE_FORMAT(createtime,'%Y%m%d')= CURDATE()-1", nativeQuery = true)
    double countLastDaySales();

    @Query(value = "select sum(totalamount) from orders where DATE_FORMAT(createtime,'%Y%m%d') = CURDATE()", nativeQuery = true)
    double countTodaySales();

    @Query(value = "select sum(totalamount) from orders where DATE_FORMAT(createtime,'%Y%m%d')= ?1 - 1", nativeQuery = true)
    double countLastDaySales(String date);

    @Query(value = "select sum(totalamount) from orders where DATE_FORMAT(createtime,'%Y%m%d') = ?1", nativeQuery = true)
    double countTodaySales(String date);


    //该日总收入及对比昨日增长
    @Query(value = "select sum((finalprice-buyingprice)*numbers) from orders where  DATE_FORMAT(createtime,'%Y%m%d')  = ?1 - 1", nativeQuery = true)
    double countLastDayIncome(String date);

    @Query(value = "select sum((finalprice-buyingprice)*numbers) from orders where  DATE_FORMAT(createtime,'%Y%m%d')  = ?1", nativeQuery = true)
    double countTodayIncome(String date);


    //该日各客户类型的销售金额及对比昨日增长
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and client like'0' ", nativeQuery = true)
    Object countSalesByClient0(String date);
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 -1  and client like'0' ", nativeQuery = true)
    Object countLastdaySalesByClient0(String date);

    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and client like'TS%' ", nativeQuery = true)
    Object countSalesByClientTS(String date);
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 -1  and client like'TS%' ", nativeQuery = true)
    Object countLastdaySalesByClientTS(String date);

    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and client like'PF%' ", nativeQuery = true)
    Object countSalesByClientPF(String date);
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 -1  and client like'PF%' ", nativeQuery = true)
    Object countLastdaySalesByClientPF(String date);

    //该日各品牌的销售金额及对比昨日增长
    @Query(value = "select brand,sum(numbers),sum((finalprice-buyingprice)*numbers) from orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1-1 group by brand", nativeQuery = true)
    ArrayList<String> countLastDaySalesByBrand(String date);

    @Query(value = "select brand,sum(numbers),sum((finalprice-buyingprice)*numbers) from orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 group by brand", nativeQuery = true)
    ArrayList<String> countTodaySalesByBrand(String date);

    //该日各类订单状态的统计
    @Query(value = "SELECT count(state) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and state like'待付款' group by client", nativeQuery = true)
    Object countSalesByStateDFK(String date);
    @Query(value = "SELECT count(state) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and state like'赊账中' group by client", nativeQuery = true)
    Object countSalesByStateSZZ(String date);
    @Query(value = "SELECT count(state) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and state like'已到账' group by client", nativeQuery = true)
    Object countSalesByStateYDZ(String date);
    @Query(value = "SELECT count(state) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and state like'已售' group by client", nativeQuery = true)
    Object countSalesByStateYS(String date);
    @Query(value = "SELECT count(state) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and state like'已取消' group by client", nativeQuery = true)
    Object countSalesByStateYQX(String date);
    @Query(value = "SELECT count(state) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1  and state like'已完成' group by client", nativeQuery = true)
    Object countSalesByStateYWC(String date);


    //该日订单是否开票的数量
    @Query(value = "select count(writeaninvoice) from orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 and writeaninvoice=1 group by writeaninvoice", nativeQuery = true)
    int countTodayWriteAnInvoice1(String date);
    @Query(value = "select count(writeaninvoice) from orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 and writeaninvoice=0 group by writeaninvoice", nativeQuery = true)
    int countTodayWriteAnInvoice0(String date);

    //该日订单按成交时间的时段统计
    @Query(value = " SELECT DATE_FORMAT(createtime,'%H'),sum(numbers),sum(totalamount),sum((finalprice-buyingprice)*numbers) FROM orders where  DATE_FORMAT(createtime,'%Y%m%d') =?1 group by DATE_FORMAT(createtime,'%H')", nativeQuery = true)
    ArrayList<String[]> getTodayperHour(String date);



    //该周总销售额及对比上周增长
    @Query(value = "select sum(totalamount) from orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())-1", nativeQuery = true)
    double countLastWeekSales();

    @Query(value = "select sum(totalamount) from orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())", nativeQuery = true)
    double countThisWeekSales();

    //该周总收入及对比上周增长
    @Query(value = "select sum((finalprice-buyingprice)*numbers)from orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())-1", nativeQuery = true)
    double countLastWeekIncome();

    @Query(value = "select sum((finalprice-buyingprice)*numbers)from orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())", nativeQuery = true)
    double countThisWeekIncome();

    //该周各客户类型的销售金额及对比上周增长
    @Query(value = "SELECT sum(totalamount) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and client like'0' group by client", nativeQuery = true)
    double countWeekSalesByClient0();
    @Query(value = "SELECT sum(totalamount) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now()) -1  and client like'0' group by client", nativeQuery = true)
    double countLastWeekSalesByClient0();

    @Query(value = "SELECT sum(totalamount) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and client like'TS%' group by client", nativeQuery = true)
    double countWeekSalesByClientTS();
    @Query(value = "SELECT sum(totalamount) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())-1  and client like'TS%' group by client", nativeQuery = true)
    double countLastWeekSalesByClientTS();

    @Query(value = "SELECT sum(totalamount) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and client like'PF%' group by client", nativeQuery = true)
    double countWeekSalesByClientPF();
    @Query(value = "SELECT sum(totalamount) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())-1  and client like'PF%' group by client", nativeQuery = true)
    double countLastWeekSalesByClientPF();

    //该周各品牌的销售金额及对比上周增长
    @Query(value = "select brand,sum((finalprice-buyingprice)*numbers) from orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())-1 group by brand", nativeQuery = true)
    ArrayList<String> countLastWeekSalesByBrand();

    @Query(value = "select brand,sum((finalprice-buyingprice)*numbers) from orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now()) group by brand", nativeQuery = true)
    ArrayList<String> countThisWeekSalesByBrand();

    //该周各类订单状态的统计
    @Query(value = "SELECT count(state) FROM orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and state like'待付款' group by client", nativeQuery = true)
    int countWeekSalesByStateDFK();
    @Query(value = "SELECT count(state) FROM orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now()) and state like'赊账中' group by client", nativeQuery = true)
    int countWeekSalesByStateSZZ();
    @Query(value = "SELECT count(state) FROM orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and state like'已到账' group by client", nativeQuery = true)
    int countWeekSalesByStateYDZ();
    @Query(value = "SELECT count(state) FROM orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and state like'已售' group by client", nativeQuery = true)
    int countWeekSalesByStateYS();
    @Query(value = "SELECT count(state) FROM orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and state like'已取消' group by client", nativeQuery = true)
    int countWeekSalesByStateYQX();
    @Query(value = "SELECT count(state) FROM orders where YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now())  and state like'已完成' group by client", nativeQuery = true)
    int countWeekSalesByStateYWC();

    //该周订单是否开票的数量
    @Query(value = "select count(writeaninvoice) from orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now()) and writeaninvoice=1 group by writeaninvoice", nativeQuery = true)
    int countThisWeekWriteAnInvoice1();
    @Query(value = "select count(writeaninvoice) from orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now()) and writeaninvoice=0 group by writeaninvoice", nativeQuery = true)
    int countThisWeekWriteAnInvoice0();
    //该周各天的订单数，总销售额和总收入。
    @Query(value = " SELECT DATE_FORMAT(createtime,'%Y/%m/%d'),sum(numbers),sum(totalamount),sum((finalprice-buyingprice)*numbers) FROM orders where  YEARWEEK(DATE_FORMAT(createtime,'%Y%m%d'))=YEARWEEK(now()) group by DATE_FORMAT(createtime,'%Y/%m/%d')", nativeQuery = true)
    ArrayList<String> getThisWeekperDay();




    //该月总销售额及对比上月增长
    @Query(value = "select sum(totalamount) from orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')-1", nativeQuery = true)
    double countLastMonthSales();

    @Query(value = "select sum(totalamount) from orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')", nativeQuery = true)
    double countThisMonthSales();

    //该月总收入及对比上月增长
    @Query(value = "select sum((finalprice-buyingprice)*numbers)from orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')-1", nativeQuery = true)
    double countLastMonthIncome();

    @Query(value = "select sum((finalprice-buyingprice)*numbers)from orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')", nativeQuery = true)
    double countThisMonthIncome();

    //该月各客户类型的销售金额及对比上月增长
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and client like'0' group by client", nativeQuery = true)
    double countMonthSalesByClient0();
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') -1  and client like'0' group by client", nativeQuery = true)
    double countLastMonthSalesByClient0();

    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and client like'TS%' group by client", nativeQuery = true)
    double countMonthSalesByClientTS();
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')-1  and client like'TS%' group by client", nativeQuery = true)
    double countLastMonthSalesByClientTS();

    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and client like'PF%' group by client", nativeQuery = true)
    double countMonthSalesByClientPF();
    @Query(value = "SELECT sum(totalamount) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')-1  and client like'PF%' group by client", nativeQuery = true)
    double countLastMonthSalesByClientPF();

    //该月各品牌的销售金额及对比上月增长
    @Query(value = "select brand,sum((finalprice-buyingprice)*numbers) from orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')-1 group by brand", nativeQuery = true)
    ArrayList<String> countLastMonthSalesByBrand();

    @Query(value = "select brand,sum((finalprice-buyingprice)*numbers) from orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') group by brand", nativeQuery = true)
    ArrayList<String> countThisMonthSalesByBrand();

    //该月各类订单状态的统计
    @Query(value = "SELECT count(state) FROM orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and state like'待付款' ", nativeQuery = true)
    int countMonthSalesByStateDFK();
    @Query(value = "SELECT count(state) FROM orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') and state like'赊账中' ", nativeQuery = true)
    int countMonthSalesByStateSZZ();
    @Query(value = "SELECT count(state) FROM orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and state like'已到账'", nativeQuery = true)
    int countMonthSalesByStateYDZ();
    @Query(value = "SELECT count(state) FROM orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and state like'已售' ", nativeQuery = true)
    int countMonthSalesByStateYS();
    @Query(value = "SELECT count(state) FROM orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') and state like'已取消'", nativeQuery = true)
    int countMonthSalesByStateYQX();
    @Query(value = "SELECT count(state) FROM orders where DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m')  and state like'已完成' ", nativeQuery = true)
    int countMonthSalesByStateYWC();

    //该月订单是否开票的数量
    @Query(value = "select count(writeaninvoice) from orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') and writeaninvoice=1 group by writeaninvoice", nativeQuery = true)
    int countThisMonthWriteAnInvoice1();
    @Query(value = "select count(writeaninvoice) from orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') and writeaninvoice=0 group by writeaninvoice", nativeQuery = true)
    int countThisMonthWriteAnInvoice0();
    //该月各天的订单数，总销售额和总收入。
    @Query(value = " SELECT DATE_FORMAT(createtime,'%Y/%m/%d'),sum(numbers),sum(totalamount),sum((finalprice-buyingprice)*numbers) FROM orders where  DATE_FORMAT(createtime,'%Y%m')=DATE_FORMAT(CURDATE(),'%Y%m') group by DATE_FORMAT(createtime,'%Y/%m/%d')", nativeQuery = true)
    ArrayList<String> getThisMonthperDay();
}
