package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.SellDetailsModel;

public class StatisticsProductController {
    
    public static ArrayList<String[]> getStatisticProduct(String type, String time) {
        SellDetailsModel sellDetailsModel = new SellDetailsModel();
        LocalDate now = LocalDate.now();
        LocalDate oneWeekAgo = now.minusDays(6);
        LocalDate oneMonthAgo = now.minusDays(29);
        
        if (type.equals("BEST")) {
            switch (time) {
                case "All Time":
                    return sellDetailsModel.run(5, "EXEC StatisticsBestAllTime");
                case "Today":
                    return sellDetailsModel.run(5, "EXEC StatisticsBestToday");
                case "7 Days Ago":
                    return sellDetailsModel.run(
                            5, 
                            String.format(
                                    "EXEC StatisticsBestPeriodTime @StartTime = '%s', @EndTime = '%s'", 
                                    oneWeekAgo.toString(), 
                                    now.toString()
                            )
                    );
                case "30 Days Ago":
                    return sellDetailsModel.run(
                            5, 
                            String.format(
                                    "EXEC StatisticsBestPeriodTime @StartTime = '%s', @EndTime = '%s'", 
                                    oneMonthAgo.toString(), 
                                    now.toString()
                            )
                    );
                default:
            }
        } else if (type.equals("WORSE")) {
            switch (time) {
                case "All Time":
                    return sellDetailsModel.run(5, "EXEC StatisticsWorseAllTime");
                case "Today":
                    return sellDetailsModel.run(5, "EXEC StatisticsWorseToday");
                case "7 Days Ago":
                    return sellDetailsModel.run(
                            5, 
                            String.format(
                                    "EXEC StatisticsWorsePeriodTime @StartTime = '%s', @EndTime = '%s'", 
                                    oneWeekAgo.toString(), 
                                    now.toString()
                            )
                    );
                case "30 Days Ago":
                    return sellDetailsModel.run(
                            5, 
                            String.format(
                                    "EXEC StatisticsWorsePeriodTime @StartTime = '%s', @EndTime = '%s'", 
                                    oneMonthAgo.toString(), 
                                    now.toString()
                            )
                    );
                default:
            }
        }
        
        return null;
        
    }
    
    public static ArrayList<String[]> customDateStatistics(String type, LocalDate startTime, LocalDate endTime) {
        SellDetailsModel sellDetailsModel = new SellDetailsModel();
        if (type.equals("BEST")) {
            return sellDetailsModel.run(
                    5, 
                    String.format(
                            "EXEC StatisticsBestPeriodTime @StartTime = '%s', @EndTime = '%s'",
                            startTime.toString(),
                            endTime.toString()
                    )
            );
        } else if (type.equals("WORSE")) {
            return sellDetailsModel.run(
                    5, 
                    String.format(
                            "EXEC StatisticsWorsePeriodTime @StartTime = '%s', @EndTime = '%s'",
                            startTime.toString(),
                            endTime.toString()
                    )
            );
        }
        return null;
    }
    
    public static String[] getBestCustomer(int productID, LocalDate startTime, LocalDate endTime) {
        return new SellDetailsModel().run(
                3,
                String.format(
                        "EXEC BestCustomerForAProduct @product_id = %d, @start_time = '%s', @end_time = '%s'",
                        productID,
                        startTime.toString(),
                        endTime.toString()
                )
        ).get(0);
    }
    
    public static String getPriceForOne(int productID) {
        return new SellDetailsModel().run(
                1,
                "EXEC PriceForOne @product_id = " + productID
        ).get(0)[0];
    }
}
