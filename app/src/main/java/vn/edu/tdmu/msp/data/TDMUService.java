package vn.edu.tdmu.msp.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.tdmu.msp.NewsActivity;
import vn.edu.tdmu.msp.data.model.News;
import vn.edu.tdmu.msp.data.model.NewsDetail;
import vn.edu.tdmu.msp.data.model.TDMUResponse;

public interface TDMUService {

    @GET("student/{student_code}")
    Call<TDMUResponse> getStudentInfo(@Path("student_code") String studentCode);

    @GET("news")
    Call<List<News>> getNews();

    @GET("news/{cat_name}|{id_name}")
    Call<NewsDetail> getNewsDetail(@Path("cat_name") String cat, @Path("id_name") String id);
}
