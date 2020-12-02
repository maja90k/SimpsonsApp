package cl.inacap.simpson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Request;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.inacap.simpson.adapters.PersonajesAdapters;
import cl.inacap.simpson.dto.Personaje;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private ViewPager vp;
    private PersonajesAdapters pa;
    private ListView listview;


    private List<Personaje> personajes = new ArrayList<>();
    private ListView persList;
    private PersonajesAdapters personajesAdapter;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vp = findViewById(R.id.vPager);
        this.button = findViewById(R.id.soliBtn);
        this.spinner = findViewById(R.id.spinner_per);

        ArrayAdapter<CharSequence> opcion = ArrayAdapter.createFromResource(this, R.array.frases, android.R.layout.simple_spinner_item);
        spinner.setAdapter(opcion);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner != null) {
                    //Aqui  despues de haber solicitado el "consejo"
                    //deberia de mostrar el viewpager con el consejo y del personaje proviniente.


                } else {
                    Toast.makeText(getApplicationContext(), "Seleccione un personaje", Toast.LENGTH_SHORT).show();
                }
            }
        });

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


    }
}