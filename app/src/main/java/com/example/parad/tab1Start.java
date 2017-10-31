package com.example.parad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Константин on 26.10.2017.
 */

public class tab1Start extends Fragment{

    ImageView iv;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gallery_item_start_demo, container, false);

        iv=rootView.findViewById(R.id.iv6);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(getActivity(),AddPhotoActivity.class);
                startActivity(intent);
            }
        });




        return rootView;
    }
}
