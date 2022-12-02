package com.xbisme.quizzapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;


import androidx.lifecycle.ViewModelProvider;

import androidx.navigation.NavController;

import androidx.navigation.Navigation;

import android.content.Intent;
import android.media.MediaPlayer;
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
    private MediaPlayer mediaPlayer;

    //set up menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_host,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feedback:
                Intent intent;
                intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:20021493@vnu.edu.vn"));
                intent.putExtra(Intent.EXTRA_EMAIL, "caoxuanbinhcne0403@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Góp ý ứng dụng QuizzApp");
                startActivity(intent);
                return true;
            case R.id.aboutUs:
                NavController navController = Navigation.findNavController(this,R.id.fragmentContainerView);
                navController.navigate(R.id.action_global_informationFragment);
                return true;

//                            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
//                            b.setTitle("About us");
//                            b.setMessage("Cao Xuân Bình - 20021493\n" +
//                                    "Nguyễn Minh Tâm - 20021580\n" +
//                                    "Đề tài: QuizzApp thuộc học phần Lập trình cho thiết bị di động \n" +
//                                    "Contact us\n" +
//                                    "20021493@edu.vnu.vn\n" +
//                                    "or\n" +
//                                    "20021580@edu.vnu.vn");
//                            b.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.cancel();
//                                }
//                            });
//                            //Tạo Dialog
//                            AlertDialog al = b.create();
//                            //Hiển thị
//                            al.show();
            case R.id.Mute:
                mediaPlayer.pause();
                return true;
            case R.id.UnMute:
                mediaPlayer.start();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get Data from fragment
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
        // set up background music
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.background_music);
        mediaPlayer.start();
        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    public static String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        MainActivity.topic = topic;
    }

    public static String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        MainActivity.level = level;
    }

    public static Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        MainActivity.score = score;
    }

}
