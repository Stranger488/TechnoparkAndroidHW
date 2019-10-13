package ru.technopark.homework1;

import java.util.ArrayList;
import java.util.List;

public class ListViewSingleton {
    private List<ListViewNumber> mData;

    private static final ListViewSingleton sInstance = new ListViewSingleton();

    public static ListViewSingleton getInstance() {
        return sInstance;
    }

    private ListViewSingleton() {
        mData = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mData.add(new ListViewNumber(i));
        }
    }

    public List<ListViewNumber> getData() {
        return mData;
    }

    public void addNumber(int i) {
        mData.add(new ListViewNumber(i));
    }

    public void restoreState(int size) {
        if (size > 100) {
            for (int i = 101; i < size; i++) {
                mData.add(new ListViewNumber(i));
            }
        }
    }
}