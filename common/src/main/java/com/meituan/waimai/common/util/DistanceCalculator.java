package com.meituan.waimai.common.util;
import static java.lang.Math.*;

public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371.393; // 地球半径，单位为千米

    public static double calculateDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double radLng1 = toRadians(longitude1); // 将经度转换为弧度
        double radLat1 = toRadians(latitude1); // 将纬度转换为弧度
        double radLng2 = toRadians(longitude2);
        double radLat2 = toRadians(latitude2);

        double a = sin((radLat1 - radLat2) / 2) * sin((radLat1 - radLat2) / 2) +
                cos(radLat1) * cos(radLat2) *
                        sin((radLng1 - radLng2) / 2) * sin((radLng1 - radLng2) / 2);

        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return EARTH_RADIUS * c * 1000; // 将结果从千米转换为米
    }

    public static void main(String[] args) {
        double longitude1 = 104.066030;
        double latitude1 = 30.659613;
        double longitude2 = 104.067231;
        double latitude2 = 30.659772;

        double distance = calculateDistance(longitude1, latitude1, longitude2, latitude2);
        System.out.println("The distance between (" + longitude1 + ", " + latitude1 + ") and (" +
                longitude2 + ", " + latitude2 + ") is " + distance + " meters.");
    }
}
