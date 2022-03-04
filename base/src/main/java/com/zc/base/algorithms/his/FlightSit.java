package com.zc.base.algorithms.his;

public class FlightSit {

    /**
     * [0,0,0,0]
     * [1,3,2] -> [2,0,0,-2]
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] sits = new int[n];
        int len = bookings.length;
        for(int i = 0; i < len; i ++){
            int[] sit = bookings[i];
            sits[sit[0] - 1] += sit[2];
            if(sit[1] < n){
                sits[sit[1]] -= sit[2];
            }
        }
        for(int i = 1; i < n; i ++){
            sits[i] = sits[i-1] + sits[i];
        }
        return sits;
    }

    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] sits = new int[n];
        int len = bookings.length;
        for(int i = 0; i < len; i ++){
            int[] sit = bookings[i];
            for(int j = sit[0] - 1; j <= sit[1] - 1; j ++){
                sits[j] += sit[2];
            }
        }
        return sits;
    }

}
