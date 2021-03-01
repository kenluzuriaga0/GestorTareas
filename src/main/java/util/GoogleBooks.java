/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entities.Libros;
import entities.dto.Items;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author kenlu
 */
public class GoogleBooks {
    //api
    String api_key = "AIzaSyCXFjrdW519DD6ESoHr8_BRSn-yif6SFPw";
    String busqueda;
    ArrayList<Items> arrayDeJson;

    public GoogleBooks() {
        arrayDeJson = new ArrayList<Items>();

    }

    public void verLibros() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.googleapis.com/books/v1/volumes?q=" + this.getBusqueda() + "&maxResults=40&key=" + this.getApi_key())
                .get().build();
        Response response = client.newCall(request).execute();

        //2. creamos variable String Json (se guarda el objeto respuesta en un string)
        String elJson = response.body().string();

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        //Crear un json y parsearlo desde el string
        JsonObject jsonDatos = new JsonParser().parse(elJson).getAsJsonObject();
        JsonElement array = jsonDatos.get("items"); //crear un nuevo json a partir el atributo "item" (array) 

        //Al querer leer un array de objetos, se usa un TypeTolken
        Type listType = new TypeToken<List<Items>>() {}.getType();
        arrayDeJson = gson.fromJson(String.valueOf(array), listType);
        
        response.close();
    
    }

    public void guardarLibro() {
//        libro.setId(BigDecimal.valueOf(1 + librosFacade.getMaxId()));
//
//        libro.setNombre(arrayDeJson.get(index).getVolumeInfoObject().getTitle());
//        libro.setAutor(arrayDeJson.get(index).getVolumeInfoObject().getAuthors().get(0));
        System.out.println("keeeeeeeeeeeeeeeeeeen");
        
    }

    public String getApi_key() {
        return api_key;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public ArrayList<Items> getArrayDeJson() {
        return arrayDeJson;
    }

    public void setArrayDeJson(ArrayList<Items> arrayDeJson) {
        this.arrayDeJson = arrayDeJson;
    }

}
