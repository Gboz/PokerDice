package com.example.gboz.pokerdice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

public class PlayersAdapter extends BaseAdapter {
    int limit = 0;
    String[] names;
    Context context;
    LayoutInflater inflter;

    public PlayersAdapter(Context context, String[] names) {
        this.context = context;
        this.names = names;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.list_view_items, null);
        final CheckedTextView simpleCheckedTextView = (CheckedTextView) view.findViewById(R.id.simpleCheckedTextView);
        simpleCheckedTextView.setText(names[position]);

        simpleCheckedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleCheckedTextView.isChecked()) {
                    simpleCheckedTextView.setCheckMarkDrawable(0);
                    simpleCheckedTextView.setChecked(false);
                    limit--;
                    System.out.println("TEST" + limit);
                } else {
                    if (limit < 2) {
                        simpleCheckedTextView.setCheckMarkDrawable(R.drawable.checked);
                        simpleCheckedTextView.setChecked(true);
                        limit++;
                    }
                    System.out.println("TEST" + limit);
                }
            }
        });
        return view;
    }
}
