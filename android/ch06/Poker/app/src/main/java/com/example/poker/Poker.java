package com.example.poker;

import java.util.Arrays;

public class Poker {
    boolean poker[][] = new boolean[4][13];

    public Poker() {
        onSetPoker();
    }

    public void onSetPoker() {
        for(int i=0; i<poker.length; i++){
            Arrays.fill(poker[i], true);
        }
    }

    public void onSetCard(){
        int shape, num;
        while (true){
            shape = (int) (Math.random()*4)+1;
            num = (int) (Math.random()*13)+1;
            if(poker[shape][num]) break;
        }
        poker[shape][num] = false;

        return;
    }

    public boolean[][] getPoker() {
        return poker;
    }

    public void setPoker(boolean[][] poker) {
        this.poker = poker;
    }

}
