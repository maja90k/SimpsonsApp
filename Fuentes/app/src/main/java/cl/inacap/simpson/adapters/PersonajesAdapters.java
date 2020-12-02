package cl.inacap.simpson.adapters;

import android.app.Activity;
<<<<<<< HEAD
import android.content.Context;
=======
import android.util.Log;
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
<<<<<<< HEAD
=======
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
>>>>>>> 264d5fc4d05ed4fb56e62ccf5cadf71859c6c330

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.inacap.simpson.R;
import cl.inacap.simpson.adapters.PersonajesAdapters;
import cl.inacap.simpson.dto.Personaje;

public class PersonajesAdapters extends ArrayAdapter<Personaje>{

<<<<<<< HEAD
    List<Personaje> personajes;
    Activity activity;
    Context context;
=======

    private List<Personaje> personajes;
    private Activity activity;
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98

    public PersonajesAdapters(@NonNull Context context, int resource, @NonNull List<Personaje> objects ) {
        super(context, resource, objects);
        this.personajes = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

<<<<<<< HEAD
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view  = inflater.inflate(R.layout.list_personajes, null, true);

        TextView nombre =    view.findViewById(R.id.nombre_txt);
        TextView frase =     view.findViewById(R.id.quote);
        ImageView img =      view.findViewById(R.id.image);
=======
<<<<<<< HEAD
        TextView nombre = rV.findViewById(R.id.nombre_txt);
        TextView frase = rV.findViewById(R.id.quote);
        ImageView img = rV.findViewById(R.id.image);

=======
        TextView nombre =    rV.findViewById(R.id.nombre_txt);
        TextView frase =     rV.findViewById(R.id.quote);
        ImageView img =      rV.findViewById(R.id.image);
>>>>>>> 264d5fc4d05ed4fb56e62ccf5cadf71859c6c330
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98

        nombre.setText(personajes.get(position).getCharacter());
        frase.setText(personajes.get(position).getQuote());
        Picasso.get().load(this.personajes.get(position).getImage())
                .resize(350, 350)
                .centerCrop()
                .into(img);
        return view;
    }

<<<<<<< HEAD
    @Override
    public int getCount() {
        return super.getCount();
    }

=======
>>>>>>> f4739e0f6ebce6bb37bce295fb5e1229a7632a98
}
