package proyectoprogramacion2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RellenarListas {

    private static final String API_KEY = "e1dd8357febbf0ee0827cf7cc776bafb";

    private List<Pelicula> peliculas = new ArrayList<>();
    private List<Pelicula> Popularpeliculas = new ArrayList<>();

    public void RellenarListaTotal(String query) {
        Map<Integer, String> generoMap = obtenerGenerosDeTMDB();
        int numeroDePagina = 1;
        int totalDePaginas = 10; // Ajusta esto según cuántas páginas quieras recuperar

        try {
            while (numeroDePagina <= totalDePaginas) {

                URL apiUrl = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY + "&query=" + query + "&language=es-ES&page=" + numeroDePagina);

                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                JsonArray results = jsonObject.getAsJsonArray("results");
                for (int i = 0; i < results.size(); i++) {
                    JsonObject movie = results.get(i).getAsJsonObject();

                    String title = movie.get("title").getAsString();
                    String originalTitle = movie.get("original_title").getAsString();
                    String overview = movie.get("overview").getAsString();
                    String posterPath = movie.get("poster_path").getAsString();

                    JsonArray genreIdsJsonArray = movie.getAsJsonArray("genre_ids");
                    List<String> generos = new ArrayList<>();
                    for (JsonElement genreIdElement : genreIdsJsonArray) {
                        int genreId = genreIdElement.getAsInt();
                        String nombreGenero = generoMap.getOrDefault(genreId, "Desconocido");
                        generos.add(nombreGenero);
                    }

                    Pelicula p = new Pelicula(title, originalTitle, overview, posterPath, generos);
                    peliculas.add(p);
                    

                }

                numeroDePagina++;
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }

    }

    public void RellenarListaPopular(String query) {
         Map<Integer, String> generoMap = obtenerGenerosDeTMDB();
        int numeroDePagina = 1;
        int totalDePaginas = 10;
        try {
            URL apiUrl = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY + "&query=" + query + "&language=es-ES&page=" + numeroDePagina);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");
            for (int i = 0; i < results.size(); i++) {

                JsonObject movie = results.get(i).getAsJsonObject();

                String title = movie.get("title").getAsString();
                String originalTitle = movie.get("original_title").getAsString();
                String overview = movie.get("overview").getAsString();
                String posterPath = movie.get("poster_path").getAsString();

                                    JsonArray genreIdsJsonArray = movie.getAsJsonArray("genre_ids");
                    List<String> generos = new ArrayList<>();
                    for (JsonElement genreIdElement : genreIdsJsonArray) {
                        int genreId = genreIdElement.getAsInt();
                        String nombreGenero = generoMap.getOrDefault(genreId, "Desconocido");
                        generos.add(nombreGenero);
                    }
                Pelicula p = new Pelicula(title, originalTitle, overview, posterPath, generos);
                Popularpeliculas.add(p);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pelicula> getPopularpeliculas() {
        return Popularpeliculas;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    private Map<Integer, String> obtenerGenerosDeTMDB() {
        Map<Integer, String> generoMap = new HashMap<>();
        try {
            URL url = new URL("https://api.themoviedb.org/3/genre/movie/list?api_key=e1dd8357febbf0ee0827cf7cc776bafb&language=es-ES");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Procesar la respuesta JSON para extraer los géneros
            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray genres = jsonObject.getAsJsonArray("genres");
            for (JsonElement genreElement : genres) {
                JsonObject genreObject = genreElement.getAsJsonObject();
                int id = genreObject.get("id").getAsInt();
                String name = genreObject.get("name").getAsString();
                generoMap.put(id, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generoMap;
    }
    
      /*  public void imprimirTodasLasPeliculas() {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getTitulo()+pelicula.getGeneros());
            System.out.println("---------------------------------");
        }
    }  
    */

}
