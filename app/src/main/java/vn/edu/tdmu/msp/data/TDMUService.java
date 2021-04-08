package vn.edu.tdmu.msp.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.tdmu.msp.data.model.TDMUResponse;

public interface TDMUService {

    @GET("student/{student_code}")
    Call<TDMUResponse> getStudentInfo(@Path("student_code") String studentCode);
}
