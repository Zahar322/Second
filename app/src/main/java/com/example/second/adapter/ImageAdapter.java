package com.example.second.adapter;

import android.content.Context;
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

import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImageAdapter extends ArrayAdapter<Integer> {

    private LayoutInflater inflater;
    private int layout;
    private List<Integer> list;

    public ImageAdapter(@NonNull Context context, int resource) {
        super(context, resource, getList());
        this.list = getList();
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(list.get(position));
        return view;
    }

    private static List<Integer> getList() {
        return Arrays.asList(R.drawable.dasha, R.drawable.diana, R.drawable.katya, R.drawable.masha, R.drawable.nastya, R.drawable.olga);
    }

}
