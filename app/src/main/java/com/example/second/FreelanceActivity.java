package com.example.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.second.adapter.PhotosAdapter;
import com.example.second.adapter.ProgressAdapter;
import com.example.second.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import de.hdodenhof.circleimageview.CircleImageView;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;
import static com.example.second.adapter.CoffeeAdapter.URL;

public class FreelanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freelance);
        User user = (User) getIntent().getSerializableExtra("user");
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile);
        TextView nameView = (TextView) findViewById(R.id.textView2);
        TextView aboutView = (TextView) findViewById(R.id.textView3);
        uploadImage(circleImageView, user);
        nameView.setText(user.getUsername());
        aboutView.setText(user.getPassword());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        PhotosAdapter photosAdapter = new PhotosAdapter();
        recyclerView.setAdapter(photosAdapter);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.progress);
        ProgressAdapter progressAdapter = new ProgressAdapter();
        recycler.setAdapter(progressAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recycler.setLayoutManager(gridLayoutManager);
        CircleImageView circleImageView1 = (CircleImageView) findViewById(R.id.profile_image);
        circleImageView1.setImageBitmap(user.getBitmap());
        TextView textView = (TextView) findViewById(R.id.name_and_lastname);
        TextView text = (TextView) findViewById(R.id.followers);
        TextView location = (TextView) findViewById(R.id.location);
        textView.setText("Thomas Anderson");
        text.setText("634 997 5189");
        location.setText("Instanbul, Turkey");
    }

    private void uploadImage(ImageView imageView, User user) {
        ImageLoader.getInstance().loadImage(URL + user.getMedia().imagePath(), new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (!isFinishing()) {
                    imageView.setImageBitmap(loadedImage);
                    user.setBitmap(loadedImage);
                }
            }
        });
    }
}