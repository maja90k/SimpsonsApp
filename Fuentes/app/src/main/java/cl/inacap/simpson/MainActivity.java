package cl.inacap.simpson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
=======
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Request;

>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.inacap.simpson.adapters.PersonajesAdapters;
<<<<<<< HEAD
import cl.inacap.simpson.dto.Personaje;
=======
<<<<<<< HEAD
import cl.inacap.simpson.dto.Personaje;
=======
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98
import cl.inacap.simpson.fragments.PersonajesFragment;
>>>>>>> 264d5fc4d05ed4fb56e62ccf5cadf71859c6c330

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private ListView pl;
    private List<Personaje> personajes;
    private PersonajesAdapters pa;
    private PersonajesFragment pf;



    private List<Personaje> personajes = new ArrayList<>();
    private ListView persList;
    private PersonajesAdapters personajesAdapter;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        this.pl = findViewById(R.id.persoList);
=======
<<<<<<< HEAD
        this.vp = findViewById(R.id.vPager);
        this.button = findViewById(R.id.soliBtn);
        this.spinner = findViewById(R.id.spinner_per);

        ArrayAdapter<CharSequence> opcion = ArrayAdapter.createFromResource(this, R.array.frases, android.R.layout.simple_spinner_item);
=======
        this.vp   =     findViewById(R.id.vPager);
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98
        this.button =   findViewById(R.id.soliBtn);

        this.spinner =  findViewById(R.id.spinner_per);
        ArrayAdapter<CharSequence> opcion = ArrayAdapter.createFromResource(this,R.array.frases, android.R.layout.simple_spinner_item );
>>>>>>> 264d5fc4d05ed4fb56e62ccf5cadf71859c6c330
        spinner.setAdapter(opcion);
        jsonDownload();

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                if (spinner!=null){
                    jsonDownload();
                    //deberia de mostrar el viewpager con el consejo y del personaje proviniente.

=======
                if (spinner != null) {
                    //Aqui  despues de haber solicitado el "consejo"
                    //deberia de mostrar el viewpager con el consejo y del personaje proviniente.
<<<<<<< HEAD


                } else {
                    Toast.makeText(getApplicationContext(), "Seleccione un personaje", Toast.LENGTH_SHORT).show();
=======
                    vp.getCurrentItem();
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98
                    //pero como obtenemos los datos de la api dentro del viewPager?

                }else{
                    Toast.makeText(getApplicationContext(),"Seleccione un personaje", Toast.LENGTH_SHORT).show();
>>>>>>> 264d5fc4d05ed4fb56e62ccf5cadf71859c6c330
                }
            }
        });

<<<<<<< HEAD
    }
    public void parJSON(View view){

    }

    String url_json = "https://thesimpsonsquoteapi.glitch.me/quotes?count=num";
    public void jsonDownload(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_json, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    personajes = new ArrayList<>();
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("personajes");
                    for(int i=0; i<jsonArray.length();i++){
                        Personaje p = new Personaje();
                        JSONObject innerObject = jsonArray.getJSONObject(i);
                        Log.e(" error", object.toString());
                        String nombre =    innerObject.getString("character");
                        String frase =     innerObject.getString("quote");
                        String img =      innerObject.getString("image");
                        p.setCharacter(nombre);
                        p.setQuote(frase);
                        p.setImage(img);
                        personajes.add(p);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PersonajesAdapters adapter = new PersonajesAdapters(MainActivity.this, R.layout.list_personajes, personajes);
                pl.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
=======
        public static void consumoApi() {
            queue = Volley.newRequestQueue(this.getActivity());
            this.persList = findViewById(R.id.personajes_Lv);
            this.personajesAdapter = new PersonajesAdapters(this.getActivity(), R.layout.list_personajes, this.personajes);
            this.persList.setAdapter(this.personajesAdapter);
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, "https://thesimpsonsquoteapi.glitch.me/quotes?count=num", null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                personajes.clear();
                                Personaje[] array =
                                        new Gson().fromJson(response.getString("results"), Personaje[].class);
                                personajes.addAll(Arrays.asList(array));
                            } catch (Exception ex) {
                                personajes.clear();
                                Log.e("PERSONAJES FRAGMENT", "ERROR");
                            } finally {
                                personajesAdapter.notifyDataSetChanged();
                            }
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    personajes.clear();
                    Log.e("PERSONAJES FRAGMENT", "ERROR");
                    personajesAdapter.notifyDataSetChanged();
                }
            });
            queue.add(jsonReq);
        }
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}