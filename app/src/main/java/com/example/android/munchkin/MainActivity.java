package com.example.android.munchkin;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;


import com.example.android.munchkin.data.Player;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    ArrayList<Player> playerArrayList;

    final Fragment fragment1 = new WelcomeFragment();
    final Fragment fragment2 = new PlayersFragment();
    final Fragment fragment3 = new MainPlayerFragment();
    final FragmentManager fm = getSupportFragmentManager();
    static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm.beginTransaction().add(R.id.container_with_player, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.container_with_player, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.container_with_player, fragment1, "1").commit();


    }


}










