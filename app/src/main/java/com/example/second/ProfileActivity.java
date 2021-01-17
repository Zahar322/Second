package com.example.second;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.second.adapter.Adapters;
import com.example.second.adapter.PhotosAdapter;
import com.example.second.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.Collections;

import de.hdodenhof.circleimageview.CircleImageView;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;
import static com.example.second.adapter.CoffeeAdapter.URL;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        User user = (User) getIntent().getSerializableExtra("user");
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.icon1);
        TextView nameView = (TextView) findViewById(R.id.textView2);
        TextView aboutView = (TextView) findViewById(R.id.textView3);
        uploadImage(circleImageView, user);
        nameView.setText(user.getUsername());
        aboutView.setText(user.getPassword());
        ListView listView = (ListView) findViewById(R.id.posts);
        ArrayAdapter<User> postAdapter = Adapters.postAdapter(Collections.singletonList(user), this);
        listView.setAdapter(postAdapter);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        PhotosAdapter photosAdapter = new PhotosAdapter();
        recyclerView.setAdapter(photosAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(100);
//        WebView webView = (WebView) findViewById(R.id.wedview);
//        webView.loadUrl("http://fizmat.by/math/equation/quadratic");

//        ArrayAdapter<Integer> arrayAdapter = Adapters.imageAdapter(this);
//        listView.setAdapter(arrayAdapter);

    }

    private void uploadImage(ImageView imageView, User user) {
        ImageLoader.getInstance().loadImage(URL + user.getMedia().imagePath(), new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (!isFinishing()) {
//                    photo = loadedImage;
                    imageView.setImageBitmap(loadedImage);
                    user.setBitmap(loadedImage);

                }
            }
        });
    }
}