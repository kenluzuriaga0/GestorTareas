/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entities.Libros;
import entities.dto.Items;
import entities.dto.VolumeInfo;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sessions.Local.LibrosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanGoogleBooks")
@ViewScoped
public class BeanGoogleBooks implements Serializable {


}
