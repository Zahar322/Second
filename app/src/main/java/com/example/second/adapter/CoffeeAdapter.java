package com.example.second.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.second.R;
import com.example.second.model.Coffee;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CoffeeAdapter extends ArrayAdapter<Coffee> {

//    public static String URL = "http://192.168.100.225:8081";
    public static String URL = "http://192.168.43.136:8081";

    private LayoutInflater inflater;
    private int layout;
    private List<Coffee> coffees;
    private Activity activity;

    public CoffeeAdapter(@NonNull Context context, int resource, List<Coffee> coffees, Activity activity) {
        super(context, resource, coffees);
        this.coffees = coffees;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

//        ImageView imageView = (ImageView) view.findViewById(R.id.icon1);
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.icon1);
        TextView nameView = (TextView) view.findViewById(R.id.test1);
        TextView aboutView = (TextView) view.findViewById(R.id.test2);

        Coffee coffee = coffees.get(position);
        uploadImage(circleImageView, URL + coffee.getMedia().imagePath());
        nameView.setText(coffee.getTitle());
        aboutView.setText(coffee.getAbout());
        return view;
    }

    private void uploadImage(ImageView imageView, String url) {
        ImageLoader.getInstance().loadImage(url, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (!activity.isFinishing()) {
//                    photo = loadedImage;
                    imageView.setImageBitmap(loadedImage);
                }
            }
        });
    }
}
