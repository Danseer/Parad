package com.example.parad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 26.10.2017.
 */

public class tab3Top extends Fragment {
    private RecyclerView CardRecyclerView;
    private List<galleryStartItem> mItems = new ArrayList<>();
    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab3top, container, false);




        galleryStartItem gs=new galleryStartItem();
        gs.setDate("DATA");
        gs.setHashtag("HASHTAG");
        gs.setLocation("LOCATION");
        gs.setName("NAME");
        gs.setTime("TIME");
        gs.setTitle("TITLE");

        galleryStartItem gs2=new galleryStartItem();
        gs2.setDate("DATA");
        gs2.setHashtag("HASHTAG");
        gs2.setLocation("LOCATION");
        gs2.setName("NAME");
        gs2.setTime("TIME");
        gs2.setTitle("TITLE");

        galleryStartItem gs3=new galleryStartItem();
        gs3.setDate("DATA");
        gs3.setHashtag("HASHTAG");
        gs3.setLocation("LOCATION");
        gs3.setName("NAME");
        gs3.setTime("TIME");
        gs3.setTitle("TITLE");

        galleryStartItem gs4=new galleryStartItem();
        gs4.setDate("DATA");
        gs4.setHashtag("HASHTAG");
        gs4.setLocation("LOCATION");
        gs4.setName("NAME");
        gs4.setTime("TIME");
        gs4.setTitle("TITLE");

        mItems.add(gs);
        mItems.add(gs2);
        mItems.add(gs3);
        mItems.add(gs4);

        setCardRecyclerView();
        setUpAdapter();

        return rootView;
    }

    private void setCardRecyclerView() {
        CardRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_start);
        CardRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
    }



    private void setUpAdapter() {
        CardRecyclerView.setAdapter(new StartAdapter(mItems));
    }
}


