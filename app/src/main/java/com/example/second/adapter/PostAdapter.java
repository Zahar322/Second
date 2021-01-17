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
import com.example.second.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private int layout;
    private List<User> users;

    public PostAdapter(@NonNull Context context, int resource, List<User> users) {
        super(context, resource, users);
        this.users = users;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.icon1);
        TextView nameView = (TextView) view.findViewById(R.id.test1);
        TextView aboutView = (TextView) view.findViewById(R.id.test2);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        User user = users.get(position);
        imageView.setImageBitmap(user.getBitmap());
        circleImageView.setImageBitmap(user.getBitmap());
        nameView.setText(user.getUsername());
        aboutView.setText(user.getDescription().getDescription());
        return view;
    }
}
