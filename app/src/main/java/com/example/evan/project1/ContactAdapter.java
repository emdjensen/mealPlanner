package com.example.evan.project1;

/*
Evan Jensen - Project 1 (Mobile App Development) - March 2018

The purpose of this project is to design daily food plan. The
program makes a daily menu allowing you to quickly design each
meal (breakfast, lunch, and dinner) using a selection of food.

A lot of the code used specifically in THIS file was found in
a tutorial as part of an online lesson using Java in Android.

The original purpose of this adapter was to load text into a
contact card (thus "ContactAdapter"), and was used in a
sandbox when trying to design this program. It was then copied
into this app to be used to create menu cards.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<MenuCard> menuCard;

    public ContactAdapter(List<MenuCard> menuCard) {
        this.menuCard = menuCard;
    }

    @Override
    public int getItemCount() {
        return menuCard.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        MenuCard ci = menuCard.get(i);
        contactViewHolder.vFood.setText(ci.food);
        contactViewHolder.vTotalCal.setText(ci.totalCal);
        contactViewHolder.vCalories.setText(ci.calories);
        contactViewHolder.vTitle.setText(ci.title);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.menu_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vFood;
        protected TextView vTotalCal;
        protected TextView vCalories;
        protected TextView vTitle;

        public ContactViewHolder(View v) {
            super(v);
            vFood =  (TextView) v.findViewById(R.id.textFood);
            vTotalCal = (TextView)  v.findViewById(R.id.textTotalCal);
            vCalories = (TextView)  v.findViewById(R.id.textCalories);
            vTitle = (TextView) v.findViewById(R.id.title);
        }
    }
}
