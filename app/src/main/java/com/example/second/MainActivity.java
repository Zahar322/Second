package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.second.adapter.Adapters;
import com.example.second.model.Coffee;
import com.example.second.model.User;
import com.example.second.service.RestService;
import com.example.second.ui.login.LoginActivity;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RestService restService;
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restService = new RestService();
        initImageLoader();
    }

    public void click(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        textView.setText(editText.getText());
        disposable.add(restService.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((users, throwable) -> {
                    if (throwable != null) {
                        Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                    } else {
                        ListView listView = (ListView) findViewById(R.id.listView);
//                        ArrayAdapter<Coffee> adapter = Adapters.coffeeAdapter(users, this, this);
                        ArrayAdapter<User> adapter = Adapters.userAdapter(users, this);
                        listView.setAdapter(adapter);
                        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = getIntentMain();
                                User user = users.get(position);
                                intent.putExtra("user", user);
//                                intent.putExtra("bitmap", adapter)
                                startActivity(intent);
                            }
                        };
                        listView.setOnItemClickListener(itemClickListener);
                        Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    public void clicker(View view) {
        Intent intent = new Intent(this, FreelanceActivity.class);
        this.startActivity(intent);
    }

    public Intent getIntentMain() {
        return new Intent(this, FreelanceActivity.class);
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }

    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions)

                .memoryCache(new LruMemoryCache(20 * 1024 * 1024))
                .memoryCacheSize(20 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config);
    }

}