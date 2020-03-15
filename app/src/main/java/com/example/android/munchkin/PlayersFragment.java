package com.example.android.munchkin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.example.android.munchkin.data.Player;

import java.util.ArrayList;


public class PlayersFragment extends Fragment {

    private ArrayList<Player> playerArrayList = new ArrayList<Player>();


    Button changeView, bt_add, bt_del;

    public static final String TAG =
            PlayersFragment.class.getSimpleName();

    public static final String PLAYERS_STATE = "players_state";
    public static final String SCORE_ONE = "score_one";
    public static final String SCORE_TWO = "score_two";
    public static final String SCORE_THREE = "score_three";
    public static final String SCORE_FOUR = "score_four";
    public static final String SCORE_FIVE = "score_five";

    public static Game playerStatsBackup = new Game();

    int scorePlayerOne = 1;
    int scorePlayerTwo = 1;
    int scorePlayerThree = 1;
    int scorePlayerFour = 1;
    int scorePlayerFive = 1;


    public PlayersFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.players_fragment_main, container, false);

        if (savedInstanceState != null) {
            playerArrayList = savedInstanceState.getParcelableArrayList(PLAYERS_STATE);
            scorePlayerOne = savedInstanceState.getInt(SCORE_ONE);
            scorePlayerTwo = savedInstanceState.getInt(SCORE_TWO);
            scorePlayerThree = savedInstanceState.getInt(SCORE_THREE);
            scorePlayerFour = savedInstanceState.getInt(SCORE_FOUR);
            scorePlayerFive = savedInstanceState.getInt(SCORE_FIVE);
        }

        Bundle bundle = this.getArguments();


        if (bundle != null) {
            playerArrayList = bundle.getParcelableArrayList("Example Item");

            PlayerAdapter adapter = new PlayerAdapter(getActivity(), playerArrayList);


            ListView listView = (ListView) rootView.findViewById(R.id.listview_players);


            listView.setAdapter(adapter);


        }


        changeView = (Button) rootView.findViewById(R.id.change_main);

        changeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFragmentB();
            }
        });


        final TextView quantityView = (TextView) rootView.findViewById(R.id.player_score);
        bt_add = (Button) rootView.findViewById(R.id.plus);
        bt_del = (Button) rootView.findViewById(R.id.minus);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {

                        return true;
                    }
                }
                return false;
            }
        });

        return rootView;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(PLAYERS_STATE, playerArrayList);
        outState.putInt(SCORE_ONE, scorePlayerOne);
        outState.putInt(SCORE_TWO, scorePlayerTwo);
        outState.putInt(SCORE_THREE, scorePlayerThree);
        outState.putInt(SCORE_FOUR, scorePlayerFour);
        outState.putInt(SCORE_FIVE, scorePlayerFive);
    }

    void openFragmentB() {

        FragmentManager fragmentManager =
                getActivity().getSupportFragmentManager();
        MainPlayerFragment fragmentB = MainPlayerFragment.newInstance();

        if (fragmentB.isAdded()) {

            return;
        } else {

            fragmentManager.
                    beginTransaction().
                    add(R.id.container_with_player, fragmentB).
                    addToBackStack(MainPlayerFragment.TAG).
                    commit();
        }
    }


}

