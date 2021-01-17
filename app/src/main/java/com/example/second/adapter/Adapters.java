package com.example.second.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;


import com.example.second.R;
import com.example.second.model.Coffee;
import com.example.second.model.User;

import java.util.List;

public class Adapters {

//    public static ArrayAdapter<User> userAdapter(List<User> userList, Context context) {
//        return new UserAdapter(context, R.layout.listitem, userList);
//    }

    public static ArrayAdapter<User> userAdapter(List<User> userList, Context context) {
        return new UserAdapter(context, R.layout.coffee_item, userList);
    }

    public static ArrayAdapter<Coffee> coffeeAdapter(List<Coffee> coffees, Context context, Activity activity) {
        return new CoffeeAdapter(context, R.layout.coffee_item, coffees, activity);
    }

    public static ArrayAdapter<Integer> imageAdapter(Context context) {
        return new ImageAdapter(context, R.layout.image_item);
    }

    public static ArrayAdapter<User> postAdapter(List<User> userList, Context context) {
        return new PostAdapter(context, R.layout.post_item, userList);
    }
}
