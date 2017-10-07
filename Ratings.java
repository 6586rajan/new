package ProblemSet2;


import java.io.*;
import java.util.*;

public class Ratings
{


    static int count  = 0;
    public static void main(String[] args)
    {
        ArrayList<Double> number = new ArrayList<>();
        ArrayList<String> movie = new ArrayList<>();


        HashMap<String, Double> rating = new HashMap<>();
        HashMap<String, Integer> review = new HashMap<>();

        BufferedReader br;
        FileReader fr;

        int entries = 0;

        try{

            fr = new FileReader("E:\\Fall 2017\\CMPSC 221\\Problem Sets\\src\\ProblemSet2\\Movies.txt");
            br = new BufferedReader(fr);

            String line;



            while ((line = br.readLine()) != null) {
                if (count == 0)
                {
                     entries = Integer.parseInt(line);
                     count++;
                }
                else if (count % 2 == 0)
                {
                    number.add(Double.parseDouble(line));
                    count++;
                }
                else
                {
                    movie.add(line);
                    count++;
                }
            }

            br.close();
        }
        catch (FileNotFoundException fnex) {
            System.err.println("Exception!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }



        for (int x = 0; x < entries; x++)
        {

            for (int y = x; y < entries; y++)
            {
                if (movie.get(x) == movie.get(y))
                {

                }
            }
        }

        for (int i = 0; i < movie.size(); i++)
        {
            System.out.println(movie.get(i) + " " + number.get(i));
            if (!rating.containsKey(movie.get(i)))
            {
                rating.put(movie.get(i), number.get(i));
                review.put(movie.get(i), 1);
            }
            else
            {
                double x = rating.get(movie.get(i)) + number.get(i);
                rating.replace(movie.get(i), x);
                review.replace(movie.get(i), review.get(movie.get(i)) + 1);
            }

        }

        for(Map.Entry<String,Double> entry : rating.entrySet())
        {
            String key = entry.getKey();
            double num = entry.getValue();


            double avg = num / review.get(key);

            System.out.println(key + ": " + review.get(key) + " reviews, Avereage of " + avg + " / 5");
        }

    }

}
