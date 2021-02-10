package cmsc256;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;
import java.util.List;
import java.util.ArrayList;



public class SortingLab {
    public static void main(String[] args) {
        Bridges bridges = new Bridges(3, "knightea2", "1163839024950");
        DataSource ds = bridges.getDataSource();
        List<ActorMovieIMDB> movieData = null;

        try {
            movieData = ds.getActorMovieIMDBData(Integer.MAX_VALUE);
        } catch (Exception e) {
            System.out.println("Unable to connect to Bridges.");
        }

        for (int i = 0; i < 5; i++) {
            ActorMovieIMDB entry = movieData.get(i);
            System.out.println("" + i + ".  " + entry.getActor() + " was in " + entry.getMovie());
        }


        for (ActorMovieIMDB i : movieData) {
            if (i.getMovie().equals("Being_John_Malkovich_(1999)")) {
                System.out.println(i.getActor());
            }
        }


        ArrayList<ActorMovieIMDB> filteredMovieList = new ArrayList<>();
        for (ActorMovieIMDB i : movieData) {
            if (i.getMovie().equals("Being_John_Malkovich_(1999)")) {
                filteredMovieList.add(i);
            }
        }

        System.out.println("\n");

        filteredMovieList.sort(new ActorComparator());
        for (int i = 0; i < filteredMovieList.size(); i++) {
            System.out.println(filteredMovieList.get(i).getActor());
        }


    }
}
