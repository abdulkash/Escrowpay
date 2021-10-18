package com.example.escrowpay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.escrowpay.R;
import com.example.escrowpay.model.ImageSliderModel;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.ViewHolder> {
    ArrayList<ImageSliderModel> sliderModels;

    public ImageSliderAdapter(ArrayList<ImageSliderModel> sliderModels) {
        this.sliderModels = sliderModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.slider_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.imageView.setImageResource(sliderModels.get(position).getSliderImage());
            viewHolder.headerCaption.setText(sliderModels.get(position).getHeaderCaption());
            viewHolder.subtitleCaption.setText(sliderModels.get(position).getSubtitleCaption());
    }

    @Override
    public int getCount() {
        return sliderModels.size();
    }

    public class ViewHolder  extends SliderViewAdapter.ViewHolder{

            ImageView imageView;
            TextView headerCaption;
            TextView subtitleCaption;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slider_img);
            headerCaption = itemView.findViewById(R.id.header_caption);
            subtitleCaption = itemView.findViewById(R.id.subtitle_caption);
        }
    }
}
