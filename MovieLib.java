package Moblima;

import java.util.*;
import java.io.*;

class MovieLib {
    private ArrayList<Movie> movieList;
    
    public MovieLib() {
        movieList = new ArrayList<Movie>();
    }

    public ArrayList<Movie> searchMovie(String query) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieName().compareTo(query) == 0) {
                result.add(0, movieList.get(i));
            } else {
                if (movieList.get(i).getMovieName().matches(query + "+")) {
                    result.add(result.size(), movieList.get(i));
                }
            }
        }
        if (result.size() != 0) {
            System.out.println("Movie Found!");
            for (int i = 0; i < result.size(); i++) {
                System.out.println(i + " " + result.get(i).getMovieName());
            }
        }
        return result;
    }
    
    public boolean add() {
    	Scanner sc = new Scanner(System.in);
        //here is the format of adding a movie.
        //hopefully will be our data format inside a txt file.
        
        System.out.println("Name: ");
        String nameOfNewMovie = sc.nextLine();

        System.out.println("Type: ");
        String typeOfNewMove  = sc.next();

        System.out.println("Cast: ");
        String[] castOfNewMovie = sc.nextLine().split(" ");

        System.out.println("Director: ");
        String[] directorOfNewMovie = sc.nextLine().split(" ");

        System.out.println("Language: ");
        String languageOfNewMovie = sc.next();

        System.out.println("Runtime: ");
        int runtimeOfNewMovie =sc.nextInt();

        System.out.println("Description:");
        String[] description = sc.nextLine().split(" ");

        System.out.println("number of Showtime: ");
        int numOfShowtime = sc.nextInt();
        Time[] showtimeOfMovie = new Time[numOfShowtime];
        for (int i = 0; i < numOfShowtime; i++) {
            showtimeOfMovie[i] = Time.manualNewATime();
        }

        System.out.print("Opening time: ");
        Time openingTime = Time.manualNewATime();
        
        System.out.print("Rating: ");
        String ratingOfNewMovie = sc.next();
        
        Movie newMovie = new Movie(nameOfNewMovie,
                                   typeOfNewMove, 
                                   castOfNewMovie, 
                                   directorOfNewMovie, 
                                   languageOfNewMovie,
                                   runtimeOfNewMovie,
                                   description,
                                   openingTime,
                                   showtimeOfMovie,
                                   ratingOfNewMovie);
        
        movieList.add(0, newMovie);
        return true;
    }

    public boolean remove(String movieName) {
        int i;
        boolean flag = false;
        for (i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieName().compareTo(movieName) == 0) {
                movieList.remove(i);
                flag = true;
            }
        }
        if (!flag)
            return false;
        return true;
    }

    public static boolean modify(Movie toModify, int choice) {
    	Scanner sc = new Scanner(System.in);
    	
        switch (choice) {
            case 1:
                System.out.print("New name: ");
                toModify.setMovieName(sc.nextLine());
                break;
            case 2:
                System.out.print("New type: ");
                toModify.setTypeOfMovie(sc.next());
                break;
            case 3:
                System.out.print("New cast: ");
                toModify.setCast(sc.nextLine().split(" "));
                break;
            case 4:
                System.out.print("New director: ");
                toModify.setDirector(sc.nextLine().split(" "));
                break;
            case 5:
                System.out.print("New language: ");
                toModify.setLanguage(sc.next());
                break;
            case 6:
                System.out.print("New runtime: ");
                toModify.setRuntime(sc.nextInt());
                break;
            case 7:
                System.out.print("New description: ");
                toModify.setDescription(sc.nextLine().split(" "));
                break;
            case 8:
                System.out.print("New openingTime: ");
                Time openingTime = Time.manualNewATime();
                toModify.setOpeningTime(openingTime);
                break;
            case 9:
                System.out.print("New showtime : ");
                Time showTime = Time.manualNewATime();
                toModify.addSession(showTime);
                break;
            case 10:
                toModify.deleteSession();
                break;
            case 11:
                toModify.setRatingBB();
                break;
            default:
                System.out.println("invalid. again: ");
                return false;
        }
        return true;
    }
    
    public void listMovie() {
    	Scanner sc = new Scanner(System.in);
        System.out.print("From: ");
        int start = sc.nextInt();
        System.out.print("To (max - " + movieList.size() + " ): ");
        int end = sc.nextInt();
        
        if (0 <= start && start <= end && end < movieList.size()) {
        	ListIterator<Movie> iterA = movieList.listIterator(start);
        	ListIterator<Movie> iterB = movieList.listIterator(end);
        	
        	while (iterA != iterB && iterA.hasNext()) {
                System.out.println(start + "." + iterA.next().getMovieName());
                start++;
            }
        }
        else
        	System.out.println("invalid range...");
    }

    public ArrayList<Movie> get() {
    	return movieList;
    }
    
    public Movie get(int i) {
    	return movieList.get(i);
    }
}
