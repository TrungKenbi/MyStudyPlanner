package vn.edu.tdmu.msp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.apache.commons.text.StringEscapeUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
    private final static String TAG = "NewsActivity";
    private TDMUService mService;

    TextView txtContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        TextView txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
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
                                txtContent.setText(Html.fromHtml(content, new ImageGetter(), null));
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

    private class ImageGetter implements Html.ImageGetter {
        @Override
        public Drawable getDrawable(String source) {
            LevelListDrawable d = new LevelListDrawable();
            Drawable empty = getResources().getDrawable(R.drawable.avatar);
            d.addLevel(0, 0, empty);
            d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());

            new LoadImage().execute(source, d);

            return d;
        }
    };

    class LoadImage extends AsyncTask<Object, Void, Bitmap> {

        private LevelListDrawable mDrawable;

        @Override
        protected Bitmap doInBackground(Object... params) {
            String source = (String) params[0];
            mDrawable = (LevelListDrawable) params[1];
            try {
                InputStream is = new URL(source).openStream();
                return BitmapFactory.decodeStream(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable d = new BitmapDrawable(bitmap);
                mDrawable.addLevel(1, 1, d);
                mDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                mDrawable.setLevel(1);
                CharSequence t = txtContent.getText();
                txtContent.setText(t);
            }
        }
    };
}
