package com.example.android.munchkin;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainPlayerFragment extends Fragment {


    public Game playerStats = new Game();


    public static final String TAG =
            MainPlayerFragment.class.getSimpleName();


    ScrollView scrollView;
    Button add_level, del_level, add_jewelry, del_jewerly, add_monster, del_monster, changeView;
    TextView score, level, jewerly, monster;
    EditText raceEditText, classEditText;


    public MainPlayerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Load the saved state (the list of images and list index) if there is one

        final View rootView = inflater.inflate(R.layout.main_player_fragment, container, false);


        add_jewelry = rootView.findViewById(R.id.add_jewelry);
        del_jewerly = rootView.findViewById(R.id.del_jewelry);
        add_level = rootView.findViewById(R.id.add_level);
        del_level = rootView.findViewById(R.id.del_level);
        add_monster = (Button) rootView.findViewById(R.id.add_monster);
        del_monster = (Button) rootView.findViewById(R.id.del_monster);
        changeView = (Button) rootView.findViewById(R.id.change_players);
        raceEditText = rootView.findViewById(R.id.name_race_player_one);
        classEditText = rootView.findViewById(R.id.name_class_player_one);
        score = rootView.findViewById(R.id.player_one_score);
        jewerly = rootView.findViewById(R.id.player_one_jewerly);
        level = rootView.findViewById(R.id.player_one_level);
        monster = rootView.findViewById(R.id.player_one_monsters);


        add_jewelry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                addOneForJewerlyOne(rootView);
            }


        });
        del_jewerly.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                minusOneForJewerlyOne(rootView);
            }

        });
        del_level.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                minusOneForLevelOne(rootView);
            }

        });
        add_level.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addOneForLevelOne(rootView);
            }

        });
        del_monster.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                minusOneForMonstersOne(rootView);
            }

        });
        add_monster.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addOneForMonstersOne(rootView);
            }

        });

        writeEditText();
        classEditText.getText().toString();
        raceEditText.getText().toString();

        scrollView = (ScrollView) rootView.findViewById(R.id.scrollview);

        changeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onBackPressed();

            }
        });
        score.setText(String.valueOf(playerStats.getScore()));
        level.setText(String.valueOf(playerStats.getLevel()));
        jewerly.setText(String.valueOf(playerStats.getJewerly()));
        monster.setText(String.valueOf(playerStats.getMonster()));

        //}


        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //Показывает общий счет первого игрока
    public void displayPlayerOne(int score) {
        TextView scoreView = getView().findViewById(R.id.player_one_score);
        scoreView.setText(String.valueOf(score));
    }


    //Показывает сумму очков от шмоток первого игрока
    public void displayPlayerJewerly(int score) {
        TextView scoreView = getView().findViewById(R.id.player_one_jewerly);
        scoreView.setText(String.valueOf(score));
    }

    //Добавляет очко в шмотки
    public void addOneForJewerlyOne(View v) {
//
        if (playerStats.getJewerly() == 100) {
            Toast.makeText(getContext(),
                    "Количество очков не может быть больше ста", Toast.LENGTH_SHORT).show();
            return;
        }
        playerStats.setJewerly(playerStats.getJewerly() + 1);
        playerStats.setScore(playerStats.getScore() + 1);
        displayPlayerJewerly(playerStats.getJewerly());
        displayPlayerOne(playerStats.getScore());
    }

    // Убирает очко из шмоток
    public void minusOneForJewerlyOne(View v) {
//
        if (playerStats.getJewerly() == 0) {
            Toast.makeText(getContext(),
                    "Количество очков не может быть меньше 0", Toast.LENGTH_SHORT).show();
            return;
        }
        playerStats.setJewerly(playerStats.getJewerly() - 1);
        playerStats.setScore(playerStats.getScore() - 1);
        displayPlayerJewerly(playerStats.getJewerly());
        displayPlayerOne(playerStats.getScore());

    }

    // Показывает уровень игрока
    public void displayPlayerLevel(int score) {
        TextView scoreView = getView().findViewById(R.id.player_one_level);
        scoreView.setText(String.valueOf(score));
    }

    //Уменьшает уровень игрока на один
    public void minusOneForLevelOne(View rootView) {


        if (playerStats.getLevel() == 1) {
            Toast.makeText(getContext(),
                    "Уровень игрока не может быть меньше 1", Toast.LENGTH_SHORT).show();
            return;
        }
        playerStats.setLevel(playerStats.getLevel() - 1);
        playerStats.setScore(playerStats.getScore() - 1);
        displayPlayerLevel(playerStats.getLevel());
        displayPlayerOne(playerStats.getScore());
    }

    //Прибавляет уровень игрока на один
    public void addOneForLevelOne(View rootView) {

        if (playerStats.getLevel() == 10) {
            Toast.makeText(getContext(),
                    "Уровень игрока не может быть больше 10", Toast.LENGTH_SHORT).show();
            return;
        }
        playerStats.setLevel(playerStats.getLevel() + 1);
        playerStats.setScore(playerStats.getScore() + 1);
        displayPlayerLevel(playerStats.getLevel());
        displayPlayerOne(playerStats.getScore());
    }

    //Показывает общий урон монстров на руке игрока
    public void displayPlayerMonsters(int score) {
        TextView scoreView = getView().findViewById(R.id.player_one_monsters);
        scoreView.setText(String.valueOf(score));
    }

    //Уменьшает общий урон монстра на один
    public void minusOneForMonstersOne(View v) {

        if (playerStats.getMonster() == 0) {
            Toast.makeText(getContext(),
                    "Количество урона не может быть меньше 0", Toast.LENGTH_SHORT).show();
            return;
        }
        playerStats.setMonster(playerStats.getMonster() - 1);
        displayPlayerMonsters(playerStats.getMonster());
    }

    //Увеличивает общий урон монстра на один
    public void addOneForMonstersOne(View v) {

        if (playerStats.getMonster() == 100) {
            Toast.makeText(getContext(),
                    "Количество урона не может быть больше ста", Toast.LENGTH_SHORT).show();
            return;
        }
        playerStats.setMonster(playerStats.getMonster() + 1);
        displayPlayerMonsters(playerStats.getMonster());
    }


    public static MainPlayerFragment newInstance() {
        MainPlayerFragment fragmentB = new MainPlayerFragment();
        fragmentB.playerStats.saveAttribute(PlayersFragment.playerStatsBackup);

        return fragmentB;
    }

    @Override
    public void onResume() {

        super.onResume();
        // add this piece of code in onResume method
        this.getView().setFocusableInTouchMode(true);
        this.getView().requestFocus();

    }

    @Override
    public void onPause() {
        super.onPause();
        updateEditText();
    }

    public void onBackPressed() {


        if (getFragmentManager().getBackStackEntryCount() > 0) {
            PlayersFragment.playerStatsBackup.saveAttribute(playerStats);
            getFragmentManager().popBackStack();

        }


    }

    public void updateEditText() {

        String racePlayer = raceEditText.getText().toString();
        String classPlayer = classEditText.getText().toString();

        SharedPreferences sp = this.getActivity().getSharedPreferences("kontakt", 0);
        SharedPreferences.Editor sedt = sp.edit();
        sedt.putString("textvalue", racePlayer);
        sedt.putString("txtopertaive", classPlayer);
        sedt.commit();

    }

    public void writeEditText() {

        SharedPreferences sp = getActivity().getSharedPreferences("kontakt", 0);
        String tValue = sp.getString("textvalue", "");
        String tOperative = sp.getString("txtopertaive", "");

        raceEditText.setText(tValue);
        classEditText.setText(tOperative);

    }

}
