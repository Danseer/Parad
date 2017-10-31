package com.example.parad;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Konstantin on 01.11.2017.
 */

public class StartAdapter extends RecyclerView.Adapter<StartAdapter.StartHolder> {

    public class StartHolder extends RecyclerView.ViewHolder {

        private TextView Name;
        private TextView Location;
        private TextView Title;
        private TextView Time;
        private TextView Hashtag;
        private TextView Date;

        public StartHolder(View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(R.id.tv_play_name);
            Location = (TextView) itemView.findViewById(R.id.tv_play_location);
            Title = (TextView) itemView.findViewById(R.id.tv_title_play);
            Time = (TextView) itemView.findViewById(R.id.tv_time_play);
            Hashtag = (TextView) itemView.findViewById(R.id.tv_hashtag_play);
            Date = (TextView) itemView.findViewById(R.id.tv_data_play_cardview);

        }
    }
        private List<galleryStartItem> mGalleryItems;

        public StartAdapter(List<galleryStartItem> items) {
            mGalleryItems = items;
        }

        @Override
        public StartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.gallery_item, parent, false);
            return new StartHolder(v);
        }

        @Override
        public void onBindViewHolder(StartHolder holder, final int position) {
            galleryStartItem GalleryItem = mGalleryItems.get(position);

            holder.Name.setText(mGalleryItems.get(position).getName());
            holder.Location.setText(mGalleryItems.get(position).getLocation());
            holder.Time.setText(mGalleryItems.get(position).getTime());
            holder.Title.setText(mGalleryItems.get(position).getTitle());
            holder.Hashtag.setText(mGalleryItems.get(position).getHashtag());
            holder.Date.setText(mGalleryItems.get(position).getDate());

        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }


