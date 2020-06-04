package com.service.dataAnalysis;

public interface dataAnalysisService {
    String getDaySales(String date);
    String getDayIncome(String date);
    String getDayPerClientType(String date);
    String getDayPerBrand(String date);
    int[] getDayPerState(String date);
    int[] getDayWriteAnInvoice(String date);
    String getDayPerHour(String date);


    String getWeekSales(String date);
    String getWeekIncome(String date);
    String getWeekPerClientType(String date);
    String getWeekPerBrand(String date);
    int[] getWeekPerState(String date);
    int[] getWeekWriteAnInvoice(String date);
    String getWeekPerDay(String date);

    String getMonthSales(String date);
    String getMonthIncome(String date);
    String getMonthPerClientType(String date);
    String getMonthPerBrand(String date);
    int[] getMonthPerState(String date);
    int[] getMonthWriteAnInvoice(String date);
    String getMonthPerDay(String date);

}
