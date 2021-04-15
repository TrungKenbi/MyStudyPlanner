package vn.edu.tdmu.msp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.apache.commons.text.StringEscapeUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.tdmu.msp.adapter.NewsAdapter;
import vn.edu.tdmu.msp.data.TDMUService;
import vn.edu.tdmu.msp.data.model.News;
import vn.edu.tdmu.msp.data.model.NewsDetail;
import vn.edu.tdmu.msp.utils.ApiUtils;

public class NewsActivity extends AppCompatActivity {

    private TDMUService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtContent = findViewById(R.id.txtContent);
        TextView txtViewer = findViewById(R.id.txtViewer);
        TextView txtDate = findViewById(R.id.txtDate);
        ImageView imageNews = findViewById(R.id.imageNews);

        String cat = getIntent().getStringExtra("cat");
        String id = getIntent().getStringExtra("id");
        String viewer = getIntent().getStringExtra("viewer");
        String date = getIntent().getStringExtra("date");
        String imageLink = getIntent().getStringExtra("imageLink");

        mService = ApiUtils.getTDMUService();

        mService.getNewsDetail(cat, id)
                .enqueue(new Callback<NewsDetail>() {
                    @Override
                    public void onResponse(Call<NewsDetail> call, Response<NewsDetail> response) {
                        if (response.isSuccessful()) {
                            NewsDetail newsDetail = response.body();
                            txtTitle.setText(newsDetail.getTitle());
                            txtViewer.setText(viewer);
                            txtDate.setText(date);

                            Picasso.get().load(imageLink).into(imageNews);

                            String content = StringEscapeUtils.unescapeHtml4(newsDetail.getContent());

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                txtContent.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
                            } else {
                                txtContent.setText(Html.fromHtml(content));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsDetail> call, Throwable t) {
                    }
                });;
    }
}
