package com.codegym.hien_thi_danh_sach.repository;

import com.codegym.hien_thi_danh_sach.model.Sandwich;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

@Repository
public class SandwichReposirory implements ISandwichRepository{
    private static List<Sandwich> sandwichList = new ArrayList<>();

    static {
        sandwichList.add(new Sandwich("lettucce"));
        sandwichList.add(new Sandwich("tomato"));
        sandwichList.add(new Sandwich("mustard"));
        sandwichList.add(new Sandwich("sprouts"));
    }


    @Override
    public List<Sandwich> findAll() {
        return sandwichList;
    }
}
