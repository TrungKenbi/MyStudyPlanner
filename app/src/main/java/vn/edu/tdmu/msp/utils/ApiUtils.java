package vn.edu.tdmu.msp.utils;

import vn.edu.tdmu.msp.data.RetrofitClient;
import vn.edu.tdmu.msp.data.TDMUService;

public class ApiUtils {

    public static final String BASE_URL = "http://45.119.212.43/api";

    public static TDMUService getTDMUService() {
        return RetrofitClient.getClient(BASE_URL).create(TDMUService.class);
    }
}