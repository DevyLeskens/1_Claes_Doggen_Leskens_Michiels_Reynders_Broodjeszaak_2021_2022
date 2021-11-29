package application;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import domain.MovieCompany;

import ui.MovieOverview2;

public class MovieAppMain extends Application {
    public static void main(String[] args)    {
    	launch(args);
    }

    @Override
	public void start(Stage primaryStage) {
    	MovieCompany movieCompany = new MovieCompany();
		//MovieOverview view = new MovieOverview(movieCompany);
		MovieOverview2 view = new MovieOverview2(movieCompany);
	}
}
