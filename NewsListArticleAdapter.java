package fr.ihm.polytech.com.tuto;

import android.content.Context;
import android.media.tv.TvContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 29/03/2017.
 */

public class NewsListArticleAdapter extends ArrayAdapter<Article> {
    public NewsListArticleAdapter(@NonNull Context context, @NonNull List<Article> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView = inflater.inflate(R.layout.article,null);
        }
        Article article = getItem(position);
        //Title
        TextView title = (TextView)convertView.findViewById(R.id.titleTextView);
        title.setText(article.getTitle());
        //Date
        TextView date = (TextView)convertView.findViewById(R.id.dateTextView);
        date.setText(article.getDate().toString());
        //Category
        TextView category = (TextView)convertView.findViewById(R.id.categoryTextView);
        category.setText(article.getCategory().toString());

        //Media
        ImageView image = (ImageView)convertView.findViewById(R.id.image_article);
        ImageView logo_play = (ImageView)convertView.findViewById(R.id.play_logo);
        if(article.getMediatype().equals(MediaType.PHOTO)){
            new ImageAsyncTask(image).execute(String.valueOf(article.getUrl()));
            logo_play.setVisibility(View.INVISIBLE);
        }else{
            String videoString = String.valueOf(article.getUrl());
            if(videoString.contains("youtube.com")) {
                String id = videoString.split("/")[3].split("=")[1];
                new ImageAsyncTask(image).execute("http://img.youtube.com/vi/" + id + "/default.jpg");
                logo_play.setVisibility(View.VISIBLE);
            }
        }


        return convertView;
    }

    @Nullable
    @Override
    public Article getItem(int position) {
        return super.getItem(position);
    }


}
