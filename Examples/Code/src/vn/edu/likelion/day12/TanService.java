package vn.edu.likelion.day12;

import java.util.ArrayList;
import java.util.List;

public class TanService implements People <TanEntity> {

    private ArrayList<TanEntity> list = new ArrayList<>();

    @Override
    public void insert(TanEntity Object) {
        list.add(Object);
    }

    @Override
    public void update(TanEntity Object) {

    }

    @Override
    public List<TanEntity> findAll() {
        return list;
    }

    @Override
    public void remove(TanEntity Object) {

    }
}
