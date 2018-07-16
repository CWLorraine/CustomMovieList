package sg.edu.rp.c346.custommovielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<MovieItem> alMovieList; // create an ArrayList and the data type is <MovieItem> -- MovieItem(String name, String date)
    CustomAdapter caMovie; // using a custom Adapter to design the row.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);

        alMovieList = new ArrayList<>(); //  -- MovieItem(String name, String date)

        MovieItem movie1 = new MovieItem("Avengers Infinity War","Release Date: 2018.04"); //  follow the design, because using data<MovieItem> -- MovieItem(String name, String date)
        MovieItem movie2 = new MovieItem( "Justice League","Release Date: 2017.11"); //  -- MovieItem(String name, String date)

        alMovieList.add(movie1); // add into the arrayList -- new MovieItem("Avengers Infinity War","Release Date: 2018.04");
        alMovieList.add(movie2);

        // connect the custom adapter to the arrayList as well as the ListView
        caMovie = new CustomAdapter(this, R.layout.movie_item, alMovieList);
        lvMovie.setAdapter(caMovie);
    }
}
