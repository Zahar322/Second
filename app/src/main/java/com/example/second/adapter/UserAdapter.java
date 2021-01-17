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
import com.example.second.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.second.adapter.CoffeeAdapter.URL;

public class UserAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private int layout;
    private List<User> users;

    public UserAdapter(@NonNull Context context, int resource, List<User> users) {
        super(context, resource, users);
        this.users = users;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View view = inflater.inflate(this.layout, parent, false);
//
//        ImageView flagView = (ImageView) view.findViewById(R.id.icon);
//        TextView nameView = (TextView) view.findViewById(R.id.test);
//
//        User user = users.get(position);
//
//        flagView.setImageResource(R.drawable.ic_launcher_background);
//        nameView.setText(user.toString());
//
//        return view;
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

//        ImageView imageView = (ImageView) view.findViewById(R.id.icon1);
//        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.icon1);
        ImageView circleImageView = (ImageView) view.findViewById(R.id.icon1);
        TextView nameView = (TextView) view.findViewById(R.id.test1);
        TextView aboutView = (TextView) view.findViewById(R.id.test2);

        User user = users.get(position);
        uploadImage(circleImageView, URL + user.getMedia().imagePath());
        nameView.setText(user.getUsername());
        aboutView.setText(user.getDescription().getDescription());
        return view;
    }

    private void uploadImage(ImageView imageView, String url) {
        Activity activity = (Activity) getContext();
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
