package com.xbisme.quizzapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

public class MainActivity extends AppCompatActivity {
    private Topic_Level_ViewModel viewModel;
    private static String topic;
    private static String level;
    private static Integer score;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_host,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(Topic_Level_ViewModel.class);

        viewModel.getTopic().observe(this,item -> {
            setTopic(item);
        });
        viewModel.getLevel().observe(this,item -> {
            setLevel(item);
        });
        viewModel.getScore().observe(this,item-> {
            setScore(item);
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId() ) {

                        case R.id.feedback:
                            Intent intent;
                            intent = new Intent();
                            intent.setAction(Intent.ACTION_SENDTO);
                            intent.setData(Uri.parse("mailto:20021493@vnu.edu.vn"));
                            intent.putExtra(Intent.EXTRA_EMAIL,"caoxuanbinhcne0403@gmail.com" );
                            intent.putExtra(Intent.EXTRA_SUBJECT,"Góp ý ứng dụng QuizzApp");
                            startActivity(intent);
                            return  true;
                        case R.id.information:
                            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                            b.setTitle("About us");
                            b.setMessage("Cao Xuân Bình - 20021493\n" +
                                    "Nguyễn Minh Tâm - 20021580\n" +
                                    "Đề tài: QuizzApp thuộc học phần Lập trình cho thiết bị di động \n" +
                                    "Contact us\n" +
                                    "20021493@edu.vnu.vn\n" +
                                    "or\n" +
                                    "20021580@edu.vnu.vn");
                            b.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            //Tạo Dialog
                            AlertDialog al = b.create();
                            //Hiển thị
                            al.show();
                            break;

                }
                return false;
            }

        });
    }


    public static String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public static String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


}