package com.example.cardstackview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends BaseAdapter {

    private Context context;
    private List<Profile> profiles;
    private LayoutInflater layoutInflater;

    public CardAdapter(Context context, List<Profile> profiles) {
        this.context = context;
        this.profiles = profiles;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return profiles.size();
    }

    @Override
    public Profile getItem(int position) {
        return profiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_card, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.item_image);
            viewHolder.nameTextView = convertView.findViewById(R.id.item_name);
            viewHolder.ageTextView = convertView.findViewById(R.id.item_age);
            viewHolder.bioTextView = convertView.findViewById(R.id.item_bio);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Profile profile = profiles.get(position);
        viewHolder.imageView.setImageResource(profile.getImageResourceId());
        viewHolder.nameTextView.setText(profile.getName());
        viewHolder.ageTextView.setText(String.valueOf(profile.getAge()));
        viewHolder.bioTextView.setText(profile.getBio());

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView ageTextView;
        TextView bioTextView;
    }
}