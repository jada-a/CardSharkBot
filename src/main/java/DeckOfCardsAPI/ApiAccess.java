package DeckOfCardsAPI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

        //Shuffles the whole deck of cards.
        public boolean shuffle(String deckID){
            String json = getJSON(baseURL + deckID + "/shuffle");
            JSONObject jsonObject = getObj(json);
            return (Boolean)jsonObject.get("success");
        }


        //Draws cards from the whole deck.
        public List<Card> drawCards(int num, String deckID){
            List<Card> cards = new ArrayList<>();
            String json = getJSON(baseURL + deckID + "/draw?count=" + num);
            JSONObject jsonObject = getObj(json);
            JSONArray cardArr = (JSONArray) jsonObject.get("cards");
            for (Object o : cardArr) {
                JSONObject cardObject = (JSONObject) o;
                String cardImg = (String) cardObject.get("image");
                String cardVal = (String) cardObject.get("value");
                String cardSuit = (String) cardObject.get("suit");
                String cardCode = (String) cardObject.get("code");

                cards.add(new Card(cardImg, cardVal, cardSuit, cardCode));
            }
            return cards;
        }

        public ArrayList<Object>createPile(String deckID, String pileName, List<Card> cards){
            StringBuilder apiURL = new StringBuilder(baseURL + deckID + "/pile/" + pileName + "/add/?cards=");

            apiURL.append(cards.get(0).getCode());

            for(int i = 1; i < cards.size();i++){
                apiURL.append(",").append(cards.get(i).getCode());
            }

            String json = getJSON(apiURL.toString());
            JSONObject jsonObject = getObj(json);
            JSONObject pilesObject = (JSONObject) jsonObject.get("piles");
            JSONObject pileInfo = (JSONObject) pilesObject.get(pileName);
            Pile pile = new Pile(deckID, (Long)pileInfo.get("remaining"),pileName,cards);
            ArrayList<Object> returnValues = new ArrayList<>();
            returnValues.add(jsonObject.get("success"));
            returnValues.add(pile);
            return returnValues;
        }



}
