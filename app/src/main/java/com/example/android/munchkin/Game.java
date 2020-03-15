package com.example.android.munchkin;

import android.app.Application;

public class Game extends Application {

    public Game(){
    }
    private int score = 1;
    private int jewerly = 0;
    private int level = 1;
    private int monster = 0;

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    private String playerRace;
    private String playerClass;


    public int getScore(){
        return this.score;
    }

    public void setScore(int d){
        this.score =d;
    }
    public int getJewerly(){
        return this.jewerly;
    }

    public void setJewerly(int d){
        this.jewerly =d;
    }
    public int getLevel(){
        return this.level;
    }

    public void setLevel(int d){
        this.level =d;
    }
    public int getMonster(){
        return this.monster;
    }

    public void setMonster(int d){
        this.monster =d;
    }

    public void saveAttribute(Game backup) {
        setJewerly(backup.getJewerly());
        setScore(backup.getScore());
        setLevel(backup.getLevel());
        setMonster(backup.getMonster());
    }
}
