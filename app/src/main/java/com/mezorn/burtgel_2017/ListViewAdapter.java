package com.mezorn.burtgel_2017;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by manlai on 5/25/17.
 */

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<VoterNames> voterNamesList = null;
    private ArrayList<VoterNames> arraylist;

    public ListViewAdapter(Context context, List<VoterNames> animalNamesList) {
        mContext = context;
        this.voterNamesList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<VoterNames>();
        this.arraylist.addAll(animalNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return voterNamesList.size();
    }

    @Override
    public VoterNames getItem(int position) {
        return voterNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(voterNamesList.get(position).getVoterName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        voterNamesList.clear();
        if (charText.length() == 0) {
            voterNamesList.addAll(arraylist);
        } else {
            for (VoterNames wp : arraylist) {
                if (wp.getVoterName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    voterNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }




}