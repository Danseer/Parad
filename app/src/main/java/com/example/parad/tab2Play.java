package com.example.parad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Константин on 26.10.2017.
 */

public class tab2Play extends Fragment{
    private TextView desc, opis;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gallery_item_play_demo, container, false);
        desc = (TextView) rootView.findViewById(R.id.tvDescr);
        opis = (TextView) rootView.findViewById(R.id.tvopis);

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opis.getVisibility()==View.GONE) opis.setVisibility(View.VISIBLE);
                else opis.setVisibility(View.GONE);
            }
        });

        return rootView;



    }

}
