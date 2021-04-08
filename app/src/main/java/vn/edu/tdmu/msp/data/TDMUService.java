package vn.edu.tdmu.msp.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TDMUService {

    @GET("/student/{student_code}")
    Call<List<Object>> getStudentInfo(@Path("student_code") int studentCode);
}
