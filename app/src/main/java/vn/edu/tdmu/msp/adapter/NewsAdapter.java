package vn.edu.tdmu.msp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.tdmu.msp.data.model.News;
import vn.edu.tdmu.msp.R;

public class NewsAdapter extends ArrayAdapter<News> {
    private List<News> news;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
        news = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.listnews_items, null);
        TextView txtTieuDe = v.findViewById(R.id.txtTieuDe);
        TextView txtNoiDung = v.findViewById(R.id.txtNoiDung);
        ImageView imageView = v.findViewById(R.id.imageNews);
        txtTieuDe.setText(news.get(position).getName());
        txtNoiDung.setText(news.get(position).getDesc());
        Picasso.get().load(news.get(position).getImg()).into(imageView);
        return v;
    }
}
