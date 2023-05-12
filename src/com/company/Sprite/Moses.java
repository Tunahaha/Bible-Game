package com.company.Sprite;

import com.company.GameView.DisasterView;
import com.company.GameView.RedSeaGameView;
import com.company.GameView.TenComandmentsView;
import com.company.Main;
import com.company.Sprite.DisasterView.Bug;
import com.company.Sprite.DisasterView.Frog;
import com.company.Sprite.DisasterView.Ice;
import com.company.Sprite.DisasterView.Tombstone;
import com.company.Sprite.RedSeaViewSprite.Anubis;
import com.company.Sprite.RedSeaViewSprite.Cat;
import com.company.Sprite.RedSeaViewSprite.Pharaoh;
import com.company.Sprite.TenComandmentSprite.TenComandment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Moses extends Sprite {
    public Moses(int x, int y){
        setPosition(x, y);
        img = new ImageIcon("Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if(Main.gameView instanceof DisasterView){
            ArrayList<Frog>frogs=((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug>bugs=((DisasterView) Main.gameView).getBugs();
            for(Frog f :frogs){
                if (f.getRelativePosition() !=null && x==f.getRelativePosition().x && y==f.getRelativePosition().y){
                    return "Die";
                }
            }
            for(Bug b :bugs){
                if (b.getRelativePosition() !=null && x==b.getRelativePosition().x && y==b.getRelativePosition().y){
                    return "Die";
                }
            }
            //  檢查ice跟石頭
            ArrayList<Ice>ices=((DisasterView) Main.gameView).getIceCubes();
            ArrayList<Tombstone>tombstones=((DisasterView) Main.gameView).getStones();
            for(Ice i :ices){
                if (i.getRelativePosition() !=null && x==i.getRelativePosition().x && y==i.getRelativePosition().y){
                    return "Die";
                }
            }
            for(Tombstone s :tombstones){
                if (s.getRelativePosition() !=null && x==s.getRelativePosition().x && y==s.getRelativePosition().y){
                    return "Cannot move";
                }
            }
            //check doors
            Door door=Main.gameView.getDoor();
            if(x==door.getRelativePosition().x && y==door.getRelativePosition().y){
                return "Next level";
            }
        } else if (Main.gameView instanceof RedSeaGameView) {
            ArrayList<Cat>cats=((RedSeaGameView) Main.gameView).getCats();
            for(Cat s :cats){
                if (s.getRelativePosition() !=null && x==s.getRelativePosition().x && y==s.getRelativePosition().y){
                    return "Cannot move";
                }
            }
            ArrayList<Anubis>anubis=((RedSeaGameView) Main.gameView).getAnubis();
            ArrayList<Pharaoh>pharaohs=((RedSeaGameView) Main.gameView).getPharaohs();
            for(Anubis a :anubis){
                if (a.getRelativePosition() !=null && x==a.getRelativePosition().x && y==a.getRelativePosition().y){
                    return "Die";
                }
            }
            for(Pharaoh p :pharaohs){
                if (p.getRelativePosition() !=null && x==p.getRelativePosition().x && y==p.getRelativePosition().y){
                    return "Die";
                }
            }
            Door door=Main.gameView.getDoor();
            if(x==door.getRelativePosition().x && y==door.getRelativePosition().y){
                return "Next level";
            }}else if(Main.gameView instanceof TenComandmentsView){
            ArrayList<TenComandment> stones = ((TenComandmentsView) Main.gameView).getStones();
            for (TenComandment stone : stones) {
                if (stone.getRelativePosition() != null && stone.getRelativePosition().x == x && stone.getRelativePosition().y == y) {
                    stone.setNullPosition();
                    ((TenComandmentsView) Main.gameView).setCount(1);
                    if (((TenComandmentsView) Main.gameView).getCount() == 10) {
                        return "Game over";
                    } else {
                        return "none";
                    }
                }
            }
            }


        return "none";
    }
}
