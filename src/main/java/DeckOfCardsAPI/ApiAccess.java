package DeckOfCardsAPI;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiAccess{
        URL url;
        HttpURLConnection conn;
        String baseURL = "https://deckofcardsapi.com/api/deck/";

        //This method connects to the website, collects the JSON information and returns it.
        public String getJSON(String link){
            StringBuilder inline = new StringBuilder();
            try{
                url = new URL(link);
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int rc = conn.getResponseCode();
                if(rc != 200) throw new RuntimeException("HttpResponseCode: " + rc);
                else{
                    Scanner sc = new Scanner(url.openStream());
                    while(sc.hasNext()){
                        inline.append(sc.nextLine());
                    }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return inline.toString();
        }

        //This method turns the string of Json information into a JSON object that can get specific json fields
        public JSONObject getObj(String json) {
            JSONParser p = new JSONParser();
            JSONObject jObj = null;
            try {
                Object obj = p.parse(json);
                jObj = (JSONObject) obj;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return jObj;
        }

        //This method will retrieve a eck from the API and insert the information into a Deck object.
        public Deck createDeck(){
            String json = getJSON(baseURL + "new/");
            JSONObject jsonObject = getObj(json);

            Deck deck = new Deck(
                    //Have to cast each output since this method returns a generic object.
                    (String)jsonObject.get("deck_id"),
                    (Long) jsonObject.get("remaining")
            );
            deck.setShuffled(false);
            return deck;
        }
}
