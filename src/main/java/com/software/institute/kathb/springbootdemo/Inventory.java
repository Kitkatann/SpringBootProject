package com.software.institute.kathb.springbootdemo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Inventory {
    private List<Film> films = new ArrayList();


    public Inventory(){
        films.add(new Film(0,"Ice Age","A mammoth and a sloth take on a baby"));
        films.add(new Film(1,"Jurassic Park","Ahhhh, dinosaurs everywhere!"));
        films.add(new Film(2,"Saw","Gritty horror film"));
    }

    public List<Film> GetInventory(){
        return this.films;
    }

    public String toString(){
        String json = new Gson().toJson(films);
        return  json;
    }
}
