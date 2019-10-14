package ru.technopark.homework1;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ListViewHolder extends RecyclerView.ViewHolder {
    private TextView listItemView;
    private LinearLayout root;

    ListViewHolder(@NonNull View itemView) {
        super(itemView);
        listItemView = itemView.findViewById(R.id.list_item);
        root = itemView.findViewById(R.id.list_item_root);
    }

    private LinearLayout getRoot() {
        return root;
    }

    TextView getListItemView() {
        return listItemView;
    }

    void bind(@NonNull final ListViewNumber numberItem, @NonNull final ItemClickListener clickListener) {
        TextView mListItemView = getListItemView();
        mListItemView.setText(numberItem.toString());
        getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(numberItem);
            }
        });

        if (numberItem.isOdd()) {
            mListItemView.setTextColor(Color.RED);
        } else {
            mListItemView.setTextColor(Color.BLUE);
        }
    }
}

