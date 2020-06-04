package com.controller.dataAnalysis;


import com.service.dataAnalysis.dataAnalysisService;
import com.serviceImpl.dataAnalysis.DataAnalysisImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("statistics")
public class DataAnalysisController {
    dataAnalysisService dataAnalysisService = new DataAnalysisImpl();

    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public String dailySales(@PathVariable(value="date") String date){
        return dataAnalysisService.getDaySales(date);
    }
    public String dailyIncome(@PathVariable(value="date") String date){
        return dataAnalysisService.getDayIncome(date);
    }
    public String dailyPerClientType(@PathVariable(value="date") String date){
        return dataAnalysisService.getDayPerClientType(date);
    }
    public String dailyPerBrand(@PathVariable(value="date") String date){
        return dataAnalysisService.getDayPerBrand(date);
    }
    public int[] dailyPerState(@PathVariable(value="date") String date){
        return dataAnalysisService.getDayPerState(date);
    }
    public int[] dailyWriteAnInvoice(@PathVariable(value="date") String date){
        return dataAnalysisService.getDayWriteAnInvoice(date);
    }
    public String dailyPerHour(@PathVariable(value="date") String date){
        return dataAnalysisService.getDayPerHour(date);
    }
    @RequestMapping(value = "/weekly", method = RequestMethod.GET)
    public String weeklySales(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekSales(date);
    }
    public String weeklyIncome(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekIncome(date);
    }
    public String weeklyPerClientType(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekPerClientType(date);
    }
    public String weeklyPerBrand(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekPerBrand(date);
    }
    public int[] weeklyPerState(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekPerState(date);
    }
    public int[] weeklyWriteAnInvoice(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekWriteAnInvoice(date);
    }
    public String weeklyPerDay(@PathVariable(value="date") String date){
        return dataAnalysisService.getWeekPerDay(date);
    }

    @RequestMapping(value = "/monthly", method = RequestMethod.GET)
    public String monthlySales(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthSales(date);
    }
    public String monthlyIncome(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthIncome(date);
    }
    public String monthlyPerClientType(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthPerClientType(date);
    }
    public String monthlyPerBrand(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthPerBrand(date);
    }
    public int[] monthlyPerState(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthPerState(date);
    }
    public int[] monthlyWriteAnInvoice(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthWriteAnInvoice(date);
    }
    public String monthlyPerDay(@PathVariable(value="date") String date){
        return dataAnalysisService.getMonthPerDay(date);
    }
}
