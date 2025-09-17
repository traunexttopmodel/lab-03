package com.example.listycitylab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {
    public CityArrayAdapter(Context context, ArrayList<City> cities) {
        // layout = 0 because we'll define layout later
        /* p/s:
        the adapter's constructor takes the context (eg. Activity)
        and the layout id so its getView() inflates the layout XML into a View object.
        but the default getView() only inflates ONE textView view,
        so to display multiple views in a row, we assign 0 to inflate our own view later.
         */
        super(context, 0, cities);
    }

    @NonNull
    @Override
    /* args:
    1. position = index of the city in ArrayList<>
    2. convertView = recycled view (view that got scrolled off-screen) to be reused instead of inflating a new one
    3. parent = the parent view that everything belong in
     */
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;

        // if view is new, inflate it (convert content.xml to a new view obj)
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.content,
                    parent, false);
        } else {
            view = convertView;
        }

        City city = getItem(position);

        // get view type in layout to display
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        // set the actual strings to those views
        cityName.setText(city.getName());
        provinceName.setText(city.getProvince());

        return view;
    }

}
