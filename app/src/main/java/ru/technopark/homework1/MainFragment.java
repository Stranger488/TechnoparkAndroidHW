package ru.technopark.homework1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static ru.technopark.homework1.CommonConstants.LANDSCAPE_COLUMN_NUMBER;
import static ru.technopark.homework1.CommonConstants.PORTRAIT_COLUMN_NUMBER;

public class MainFragment extends Fragment {
    private List<ListViewNumber> mData;

    private ListViewAdapter mListViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private Button mAddButton;
    private Parcelable mListState;

    public MainFragment() {
        //
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ItemClickListener clickListener = new ItemClickListener() {
            @Override
            public void onItemClick(ListViewNumber item) {


            }
        };

        mRecyclerView = view.findViewById(R.id.list_view);
        mAddButton = view.findViewById(R.id.button_add);

        mLayoutManager = new GridLayoutManager(getContext(), calculateNumberOfColumns());


        if (savedInstanceState != null) {
            mListState = savedInstanceState.getParcelable(CommonConstants.LIST_STATE);
            mLayoutManager.onRestoreInstanceState(mListState);
        }

        mListViewAdapter = new ListViewAdapter(ListViewSingleton.getInstance().getData(), clickListener);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mListViewAdapter);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        mListState = mLayoutManager.onSaveInstanceState();
        outState.putParcelable(CommonConstants.LIST_STATE, mListState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mListState = savedInstanceState.getParcelable(CommonConstants.LIST_STATE);
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mLayoutManager != null) {
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                ((GridLayoutManager) mLayoutManager).setSpanCount(PORTRAIT_COLUMN_NUMBER);
            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                ((GridLayoutManager) mLayoutManager).setSpanCount(LANDSCAPE_COLUMN_NUMBER);
            }
        }
    }

    private int calculateNumberOfColumns() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return LANDSCAPE_COLUMN_NUMBER;
        }
        return PORTRAIT_COLUMN_NUMBER;
    }
}