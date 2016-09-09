import jodd.json.JsonParser;

import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jeremypitt on 9/9/16.
 */
public class Country {
    private String name;
    private String abbreviation;
    public static Country country;
    static List<String> list = new ArrayList<>();

    public Country(String abbreviation, String name){
        this.name = name;
        this.abbreviation = abbreviation;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString(){
        return this.name;
    }



}
