import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Countries {
    public static Map<String, List<Country>> countryMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    public static List<Country> countryList = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        buildHashMap();
        System.out.println("Please input a letter:");
        writeFile(scanner.nextLine());

    }

    public static void writeFile(String keyInput) throws IOException{

        List<Country> list = new ArrayList<>();
        if (countryMap.get(keyInput) != null){
            list = countryMap.get(keyInput);
            File f = new File(String.format("%s-countries\n", keyInput));
            FileWriter fileWriter = new FileWriter(f);

            for (Country country: list) {
                String fileContent = String.format("%s | %s\n", country.getAbbreviation(), country.getName());
                fileWriter.write(fileContent);
            }
            fileWriter.close();
        }
        else {
            System.out.println("Error: Invalid input.");
        }

    }

    static void buildHashMap() throws FileNotFoundException{
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);


        String keyletter = "#";


        while (fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country((columns[0]), columns[1]);
            if (country.getName().startsWith(keyletter)) {
                countryList.add(country);
                countryMap.put(keyletter, countryList);

            }
            else {
                keyletter = country.getName().substring(0, 1);
                countryList = new ArrayList<>();
                countryList.add(country);
                countryMap.put(keyletter, countryList);

            }
        }
        fileScanner.close();

    }
}
