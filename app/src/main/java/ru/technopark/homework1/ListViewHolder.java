package ru.technopark.homework1;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private TextView listItemView;
    private LinearLayout root;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        listItemView = itemView.findViewById(R.id.list_item);
        root = itemView.findViewById(R.id.list_item_root);
    }

    public LinearLayout getRoot() {
        return root;
    }

    public TextView getListItemView() {
        return listItemView;
    }

    public void bind(@NonNull final ListViewNumber numberSingleton, @NonNull final ItemClickListener clickListener) {
        TextView mListItemView = getListItemView();
        mListItemView.setText(numberSingleton.toString());
        getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(numberSingleton);
            }
        });

        if (numberSingleton.isOdd()) {
            mListItemView.setTextColor(Color.RED);
        } else {
            mListItemView.setTextColor(Color.BLUE);
        }
    }
}

