package com.example.android.munchkin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.munchkin.data.Player;

import java.util.ArrayList;

public class WelcomeFragment extends Fragment {
    Button bt_add, bt_start, bt_del;
    EditText d;
    ListView listView;
    ArrayList<Player> playerArrayList;
    private CustomAdapter mAdapter;

    public WelcomeFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.welcome_screen, container, false);

        bt_add = (Button) rootView.findViewById(R.id.add_player);
        bt_del = (Button) rootView.findViewById(R.id.delete);
        bt_start = (Button) rootView.findViewById(R.id.start);
        listView = (ListView) rootView.findViewById(R.id.list_test);
        d = (EditText) rootView.findViewById(R.id.write_player);
        playerArrayList = new ArrayList<Player>();
        mAdapter = new CustomAdapter(getActivity(), playerArrayList);

        listView.setAdapter(mAdapter);


//Добавить игрока
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String got_player = d.getText().toString();
                if (got_player.matches("")) {
                    Toast.makeText(getActivity(), "Вы не вписали имя игрока", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (got_player != null) {

                    Player player = new Player(got_player, 1);
                    if (playerArrayList.size() < 6) {
                        playerArrayList.add(player);
                        mAdapter.notifyDataSetChanged();
                        d.setText(" ");
                    }

                }
            }


        });

        //Удалить игрока

        bt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playerArrayList.size() != 0) {
                    // Remove / Delete first item from List
                    playerArrayList.remove(playerArrayList.size() - 1);
                } else {
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.editor_fail_zero),
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                mAdapter.notifyDataSetChanged();
            }
        });

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerArrayList.size() > 1) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("Example Item", (ArrayList) playerArrayList);
                    PlayersFragment fragInfo = new PlayersFragment();
                    fragInfo.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_with_player, fragInfo)
                            .commit();


                } else {
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.editor_fail_start),
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        });

        return rootView;

    }

}



