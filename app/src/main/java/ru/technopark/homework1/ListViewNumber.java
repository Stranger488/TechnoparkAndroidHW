package ru.technopark.homework1;

import androidx.annotation.NonNull;

public class ListViewNumber {
    private int mNumber;

    int getmNumber() {
        return mNumber;
    }

    ListViewNumber(int num) {
        this.mNumber = num;
    }

    @NonNull
    public String toString() {
        return String.valueOf(mNumber);
    }

    boolean isOdd() {
        return mNumber % 2 == 0;
    }
}
