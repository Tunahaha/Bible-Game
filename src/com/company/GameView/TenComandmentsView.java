package com.company.GameView;

import com.company.Sprite.TenComandmentSprite.TenComandment;

import javax.swing.*;
import java.util.ArrayList;

public class TenComandmentsView extends GameView{
    public ArrayList<TenComandment> getStones() {
        return stones;
    }

    private ArrayList<TenComandment>stones=new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }

    private int count;
    public TenComandmentsView(){
        img=new ImageIcon("mountain.jpg");
        elements=new ArrayList<>();
        count=0;
        stones.add(new TenComandment(5, 5));
        stones.add(new TenComandment(1, 5));
        stones.add(new TenComandment(3, 4));
        stones.add(new TenComandment(2, 5));
        stones.add(new TenComandment(3, 5));
        stones.add(new TenComandment(4, 5));
        stones.add(new TenComandment(5, 7));
        stones.add(new TenComandment(8, 9));
        stones.add(new TenComandment(1, 10));
        stones.add(new TenComandment(2, 10));
        elements.addAll(stones);
    }


}
