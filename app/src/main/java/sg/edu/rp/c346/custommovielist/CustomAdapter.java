package sg.edu.rp.c346.custommovielist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16039013 on 16/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {

    Context parent_Content;
    int layout_id; // is movie item
    ArrayList<MovieItem> movieList;

    // resource represent the layout file
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieItem> objects) {
        super(context, resource, objects);
        parent_Content = context;
        layout_id = resource;
        movieList = objects;
    }

    // When call?
    //  - This method will be use when try to run the one row of the list (one of each row -- if have 12 lists, will call 12)
    //  - When scroll up and down
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_Content.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        MovieItem currentItem = movieList.get(position); // new MovieItem("Avengers Infinity War","Release Date: 2018.04"); - from Main Activity
        String name = currentItem.getName(); // in the MovieItem getName() method to return the name
        String date = currentItem.getDate();

        tvName.setText(name);
        tvDate.setText(date);

        return rowView;
    }
}