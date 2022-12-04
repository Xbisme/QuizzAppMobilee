package com.xbisme.quizzapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

public class MainActivity extends AppCompatActivity {
    private Topic_Level_ViewModel viewModel;
    private static String topic;
    private static String level;
    private static Integer score;
    private MediaPlayer mediaPlayer;
    private Toolbar toolbar;
    private Menu menu;
    private BottomNavigationView bottomNavigationView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_host, menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(Topic_Level_ViewModel.class);

        viewModel.getTopic().observe(this, item -> {
            setTopic(item);
        });
        viewModel.getLevel().observe(this, item -> {
            setLevel(item);
        });
        viewModel.getScore().observe(this, item -> {
            setScore(item);
        });
        //set up music background;
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        // set up toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
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
                    case R.id.aboutUs1:
                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView);
                        navController.navigate(R.id.action_global_aboutUs);
                        return true;
                    case R.id.UnMute:
                        menu.getItem(2).setVisible(false);
                        menu.getItem(3).setVisible(true);
                        mediaPlayer.pause();
                        return true;
                    case R.id.Mute:
                        menu.getItem(2).setVisible(true);
                        menu.getItem(3).setVisible(false);
                        mediaPlayer.start();
                        return true;
                }
                return false;
            }


        });
        // set up bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView);
                switch (item.getItemId()) {
                    case R.id.play_btn:
                        navController.navigate(R.id.action_global_chooseTopic);
                        return true;
                    case R.id.history_btn:
                        navController.navigate(R.id.action_global_history);
                        return true;
                }
                return false;
            }
        });
    }


    @Override
        protected void onStart () {
            super.onStart();
        }

        @Override
        protected void onStop () {
            super.onStop();
        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        @Override
        protected void onPause () {
            super.onPause();
            mediaPlayer.pause();
        }

        @Override
        protected void onResume () {
            super.onResume();
            mediaPlayer.start();
        }

        @Override
        protected void onRestart () {
            super.onRestart();
        }

        public static String getTopic () {
            return topic;
        }

        public void setTopic (String topic){
            this.topic = topic;
        }

        public static String getLevel () {
            return level;
        }

        public void setLevel (String level){
            this.level = level;
        }

        public static Integer getScore () {
            return score;
        }

        public void setScore (Integer score){
            this.score = score;
        }


    }
