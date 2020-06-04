package com.serviceImpl.dataAnalysis;

import com.alibaba.fastjson.JSON;
import com.repository.dataAnalysis.dataAnalysisRepository;
import com.service.dataAnalysis.dataAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataAnalysisImpl implements dataAnalysisService {
    @Autowired
    private dataAnalysisRepository dataAnalysisRepository;

    private static DataAnalysisImpl dataAnalysisImpl;
    @PostConstruct
    public void init(){
        dataAnalysisImpl = this;
        dataAnalysisImpl.dataAnalysisRepository = this.dataAnalysisRepository;
    }

    @Override
    public String getDaySales(String date) {
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        String yesterday = new SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());

        if(date.equals("")||date==null){
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countTodaySales(today)-dataAnalysisImpl.dataAnalysisRepository.countTodaySales(yesterday);
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countTodaySales(today));
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
        else{
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countTodaySales(date)-dataAnalysisImpl.dataAnalysisRepository.countLastDaySales(date);
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countTodaySales(date));
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
    }

    @Override
    public String getDayIncome(String date) {
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        String yesterday = new SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());


        if(date.equals("")||date==null){
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countTodayIncome(today)-dataAnalysisImpl.dataAnalysisRepository.countTodayIncome(yesterday);
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countTodayIncome(today));
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
        else{
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countTodayIncome(date)-dataAnalysisImpl.dataAnalysisRepository.countLastDayIncome(date);
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countTodayIncome(date));
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
    }

    @Override
    public String getDayPerClientType(String date) {
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        String yesterday = new SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());

       if(date.equals("")||date==null){
           List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
           Map<String, Object> map1 = new HashMap<String, Object>();
           Object a1= dataAnalysisImpl.dataAnalysisRepository.countSalesByClient0(today);
           Object a2= dataAnalysisImpl.dataAnalysisRepository.countSalesByClient0(yesterday);

           double d1 = a1 == null ? 0 : Double.parseDouble(a1.toString());
           double d2 = a2 == null ? 0 : Double.parseDouble(a2.toString());
           double increase1=d1-d2;
           System.out.println(increase1);
           map1.put("num",d1);
           map1.put("increase", increase1);

           Map<String, Object> map2 = new HashMap<String, Object>();
           Object a3= dataAnalysisImpl.dataAnalysisRepository.countSalesByClientTS(today);
           Object a4= dataAnalysisImpl.dataAnalysisRepository.countSalesByClientTS(yesterday);

           double d3 = a3 == null ? 0 : Double.parseDouble(a3.toString());
           double d4 = a4 == null ? 0 : Double.parseDouble(a4.toString());

           double increase2=d3-d4;
           map2.put("num",d3);
           map2.put("increase", increase2);

           Map<String, Object> map3 = new HashMap<String, Object>();
           Object a5= dataAnalysisImpl.dataAnalysisRepository.countSalesByClientPF(today);
           Object a6= dataAnalysisImpl.dataAnalysisRepository.countSalesByClientPF(yesterday);

           double d5 = a5 == null ? 0 : Double.parseDouble(a5.toString());
           double d6 = a6 == null ? 0 : Double.parseDouble(a6.toString());


           double increase3=d5-d6;
           map3.put("num",d5);
           map3.put("increase", increase3);

           list.add(map1);
           list.add(map2);
           list.add(map3);
           String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        else{
           List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
           Map<String, Object> map1 = new HashMap<String, Object>();
           Object a1= dataAnalysisImpl.dataAnalysisRepository.countSalesByClient0(date);
           Object a2= dataAnalysisImpl.dataAnalysisRepository.countLastdaySalesByClient0(date);

           double d1 = a1 == null ? 0 : Double.parseDouble(a1.toString());
           double d2 = a2 == null ? 0 : Double.parseDouble(a2.toString());
           double increase1=d1-d2;
           System.out.println(increase1);
           map1.put("num",d1);
           map1.put("increase", increase1);

           Map<String, Object> map2 = new HashMap<String, Object>();
           Object a3= dataAnalysisImpl.dataAnalysisRepository.countSalesByClientTS(date);
           Object a4= dataAnalysisImpl.dataAnalysisRepository.countLastdaySalesByClientTS(date);

           double d3 = a3 == null ? 0 : Double.parseDouble(a3.toString());
           double d4 = a4 == null ? 0 : Double.parseDouble(a4.toString());

           double increase2=d3-d4;
           map2.put("num",d3);
           map2.put("increase", increase2);

           Map<String, Object> map3 = new HashMap<String, Object>();
           Object a5= dataAnalysisImpl.dataAnalysisRepository.countSalesByClientPF(date);
           Object a6= dataAnalysisImpl.dataAnalysisRepository.countLastdaySalesByClientPF(date);

           double d5 = a5 == null ? 0 : Double.parseDouble(a5.toString());
           double d6 = a6 == null ? 0 : Double.parseDouble(a6.toString());


           double increase3=d5-d6;
           map3.put("num",d5);
           map3.put("increase", increase3);

           list.add(map1);
           list.add(map2);
           list.add(map3);
           String mapJson = JSON.toJSONString(list);
            return mapJson;
        }

    }

    @Override
    public String getDayPerBrand(String date) {
        String inputDate=date;
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        if(date.equals("")||date==null){
            inputDate=today;
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<String> getData=dataAnalysisImpl.dataAnalysisRepository.countLastDaySalesByBrand(inputDate);
        ArrayList<String> getData1=dataAnalysisImpl.dataAnalysisRepository.countTodaySalesByBrand(inputDate);
        int total1=getData.size();
            int total2=getData1.size();
            if(total1==total2) {
                for (int i = 0; i < total1 / 3; i++) {
                    map.put("name", getData1.get(i + 0));
                    map.put("num", getData1.get(i + 1));
                    map.put("increase", Double.valueOf(getData1.get(i + 2))-Double.valueOf(getData.get(i + 2)));
                    list.add(map);
                    map.clear();
                }
            }
            else if(total1>total2){

            }
            String mapJson = JSON.toJSONString(list);
            return mapJson;
    }

    @Override
    public int[] getDayPerState(String date) {
        String inputDate=date;
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        if(date.equals("")||date==null){
            inputDate=today;
        }
        Object in1=dataAnalysisImpl.dataAnalysisRepository.countSalesByStateDFK(inputDate);
        Object in2=dataAnalysisImpl.dataAnalysisRepository.countSalesByStateSZZ(inputDate);
        Object in3=dataAnalysisImpl.dataAnalysisRepository.countSalesByStateYDZ(inputDate);
        Object in4=dataAnalysisImpl.dataAnalysisRepository.countSalesByStateYS(inputDate);
        Object in5=dataAnalysisImpl.dataAnalysisRepository.countSalesByStateYQX(inputDate);
        Object in6=dataAnalysisImpl.dataAnalysisRepository.countSalesByStateYWC(inputDate);
        int d1 = in1 == null ? 0 : Integer.parseInt(in1.toString());
        int d2 = in2 == null ? 0 : Integer.parseInt(in2.toString());
        int d3 = in3 == null ? 0 : Integer.parseInt(in3.toString());
        int d4 = in4 == null ? 0 : Integer.parseInt(in4.toString());
        int d5 = in5 == null ? 0 : Integer.parseInt(in5.toString());
        int d6 = in6 == null ? 0 : Integer.parseInt(in6.toString());
        int[] output=new int[6];
        output[0]=d1;output[1]=d2;output[2]=d3;output[3]=d4;output[4]=d5;output[5]=d6;
        return output;
    }

    @Override
    public int[] getDayWriteAnInvoice(String date) {
        String inputDate=date;
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        if(date.equals("")||date==null){
            inputDate=today;
        }
        int data0=dataAnalysisImpl.dataAnalysisRepository.countTodayWriteAnInvoice0(inputDate);
        int data1=dataAnalysisImpl.dataAnalysisRepository.countTodayWriteAnInvoice1(inputDate);
        int[] output=new int[2];
        output[0]=data1;output[1]=data0;
        return output;

    }

    @Override
    public String getDayPerHour(String date) {
        String inputDate=date;
        Date date0 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today=formatter.format(date0);

        if(date.equals("")||date==null){
            inputDate=today;
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        ArrayList<String[]> getData=dataAnalysisImpl.dataAnalysisRepository.getTodayperHour(inputDate);
        int total1=getData.size();
        for (int i = 0; i < total1; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("hour", Integer.valueOf(getData.get(i)[0]));
            map.put("num", Integer.valueOf(getData.get(i)[1]));
            map.put("sales", Double.valueOf(getData.get(i)[2]));
            map.put("income", Double.valueOf(getData.get(i)[3]));
            list.add(map);
        }
        String mapJson = JSON.toJSONString(list);
        return mapJson;

    }

    @Override
    public String getWeekSales(String date) {
        if(date.equals("")||date==null){
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countThisWeekSales()-dataAnalysisImpl.dataAnalysisRepository.countLastWeekSales();
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countThisWeekSales());
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getWeekIncome(String date) {
        if(date.equals("")||date==null){
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countThisWeekIncome()-dataAnalysisImpl.dataAnalysisRepository.countLastWeekIncome();
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countThisWeekIncome());
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getWeekPerClientType(String date) {
        if(date.equals("")||date==null){
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            double increase1=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByClient0()-dataAnalysisImpl.dataAnalysisRepository.countLastWeekSalesByClient0();
            map1.put("num",dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByClient0());
            map1.put("increase", increase1);

            Map<String, Object> map2 = new HashMap<String, Object>();
            double increase2=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByClientTS()-dataAnalysisImpl.dataAnalysisRepository.countLastWeekSalesByClientTS();
            map2.put("num",dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByClientTS());
            map2.put("increase", increase2);

            Map<String, Object> map3 = new HashMap<String, Object>();
            double increase3=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByClientPF()-dataAnalysisImpl.dataAnalysisRepository.countLastWeekSalesByClientPF();
            map3.put("num",dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByClientPF());
            map3.put("increase", increase3);

            list.add(map1);
            list.add(map2);
            list.add(map3);
            String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getWeekPerBrand(String date) {
        if(date.equals("")||date==null){
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> getData=dataAnalysisImpl.dataAnalysisRepository.countLastWeekSalesByBrand();
            ArrayList<String> getData1=dataAnalysisImpl.dataAnalysisRepository.countThisWeekSalesByBrand();
            int total1=getData.size();
            int total2=getData1.size();
            if(total1==total2) {
                for (int i = 0; i < total1 / 3; i++) {
                    map.put("name", getData1.get(i + 0));
                    map.put("num", getData1.get(i + 1));
                    map.put("increase", Double.valueOf(getData1.get(i + 2))-Double.valueOf(getData.get(i + 2)));
                    list.add(map);
                    map.clear();
                }
            }
            else if(total1>total2){

            }
            String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        return null;
    }

    @Override
    public int[] getWeekPerState(String date) {
        if(date.equals("")||date==null){
            int in1=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByStateDFK();
            int in2=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByStateSZZ();
            int in3=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByStateYDZ();
            int in4=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByStateYS();
            int in5=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByStateYQX();
            int in6=dataAnalysisImpl.dataAnalysisRepository.countWeekSalesByStateYWC();
            int[] output=new int[6];
            output[0]=in1;output[1]=in2;output[2]=in3;output[3]=in4;output[4]=in5;output[5]=in6;
            return output;
        }
        return null;
    }

    @Override
    public int[] getWeekWriteAnInvoice(String date) {
        if(date.equals("")||date==null){
            int data0=dataAnalysisImpl.dataAnalysisRepository.countThisWeekWriteAnInvoice0();
            int data1=dataAnalysisImpl.dataAnalysisRepository.countThisWeekWriteAnInvoice1();
            int[] output=new int[2];
            output[0]=data1;output[1]=data0;
            return output;
        }
        return null;
    }

    @Override
    public String getWeekPerDay(String date) {
        if(date.equals("")||date==null){
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> getData=dataAnalysisImpl.dataAnalysisRepository.getThisWeekperDay();
            int total1=getData.size();
            for (int i = 0; i < total1 / 4; i++) {
                map.put("date", Integer.valueOf(getData.get(i + 0)));
                map.put("num", Integer.valueOf(getData.get(i + 1)));
                map.put("sales", Double.valueOf(getData.get(i + 2)));
                map.put("income", Double.valueOf(getData.get(i + 3)));
                list.add(map);
                map.clear();
            }
            String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getMonthSales(String date) {
        if(date.equals("")||date==null){
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countThisMonthSales()-dataAnalysisImpl.dataAnalysisRepository.countLastMonthSales();
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countThisMonthSales());
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getMonthIncome(String date) {
        if(date.equals("")||date==null){
            Map<String, Object> map = new HashMap<String, Object>();
            double increase=dataAnalysisImpl.dataAnalysisRepository.countThisMonthIncome()-dataAnalysisImpl.dataAnalysisRepository.countLastMonthIncome();
            map.put("num",dataAnalysisImpl.dataAnalysisRepository.countThisMonthIncome());
            map.put("increase", increase);
            String mapJson = JSON.toJSONString(map);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getMonthPerClientType(String date) {
        if(date.equals("")||date==null){
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            double increase1=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByClient0()-dataAnalysisImpl.dataAnalysisRepository.countLastMonthSalesByClient0();
            map1.put("num",dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByClient0());
            map1.put("increase", increase1);

            Map<String, Object> map2 = new HashMap<String, Object>();
            double increase2=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByClientTS()-dataAnalysisImpl.dataAnalysisRepository.countLastMonthSalesByClientTS();
            map2.put("num",dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByClientTS());
            map2.put("increase", increase2);

            Map<String, Object> map3 = new HashMap<String, Object>();
            double increase3=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByClientPF()-dataAnalysisImpl.dataAnalysisRepository.countLastMonthSalesByClientPF();
            map3.put("num",dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByClientPF());
            map3.put("increase", increase3);

            list.add(map1);
            list.add(map2);
            list.add(map3);
            String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        return null;
    }

    @Override
    public String getMonthPerBrand(String date) {
        if(date.equals("")||date==null){
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> getData=dataAnalysisImpl.dataAnalysisRepository.countLastMonthSalesByBrand();
            ArrayList<String> getData1=dataAnalysisImpl.dataAnalysisRepository.countThisMonthSalesByBrand();
            int total1=getData.size();
            int total2=getData1.size();
            if(total1==total2) {
                for (int i = 0; i < total1 / 3; i++) {
                    map.put("name", getData1.get(i + 0));
                    map.put("num", getData1.get(i + 1));
                    map.put("increase", Double.valueOf(getData1.get(i + 2))-Double.valueOf(getData.get(i + 2)));
                    list.add(map);
                    map.clear();
                }
            }
            else if(total1>total2){

            }
            String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        return null;
    }

    @Override
    public int[] getMonthPerState(String date) {
        if(date.equals("")||date==null){
            int in1=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByStateDFK();
            int in2=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByStateSZZ();
            int in3=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByStateYDZ();
            int in4=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByStateYS();
            int in5=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByStateYQX();
            int in6=dataAnalysisImpl.dataAnalysisRepository.countMonthSalesByStateYWC();
            int[] output=new int[6];
            output[0]=in1;output[1]=in2;output[2]=in3;output[3]=in4;output[4]=in5;output[5]=in6;
            return output;
        }
        return null;
    }

    @Override
    public int[] getMonthWriteAnInvoice(String date) {
        if(date.equals("")||date==null){
            int data0=dataAnalysisImpl.dataAnalysisRepository.countThisMonthWriteAnInvoice0();
            int data1=dataAnalysisImpl.dataAnalysisRepository.countThisMonthWriteAnInvoice1();
            int[] output=new int[2];
            output[0]=data1;output[1]=data0;
            return output;
        }
        return null;
    }

    @Override
    public String getMonthPerDay(String date) {
        if(date.equals("")||date==null){
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> getData=dataAnalysisImpl.dataAnalysisRepository.getThisMonthperDay();
            int total1=getData.size();
            for (int i = 0; i < total1 / 4; i++) {
                map.put("date", Integer.valueOf(getData.get(i + 0)));
                map.put("num", Integer.valueOf(getData.get(i + 1)));
                map.put("sales", Double.valueOf(getData.get(i + 2)));
                map.put("income", Double.valueOf(getData.get(i + 3)));
                list.add(map);
                map.clear();
            }
            String mapJson = JSON.toJSONString(list);
            return mapJson;
        }
        return null;
    }
}
