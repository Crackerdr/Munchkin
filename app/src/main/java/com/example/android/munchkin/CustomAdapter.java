package com.example.android.munchkin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.munchkin.data.Player;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Player> playerArrayList;

    public CustomAdapter(Context context, ArrayList<Player> playerArrayList) {

        this.context = context;
        this.playerArrayList = playerArrayList;
    }


    @Override
    public int getCount() {
        return playerArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //добавление игрока в лист
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.players_list, null);

        }

        TextView playerName = (TextView) v.findViewById(R.id.playerName);


        playerName.setText(playerArrayList.get(i).getPlayer());


        return v;
    }
}
