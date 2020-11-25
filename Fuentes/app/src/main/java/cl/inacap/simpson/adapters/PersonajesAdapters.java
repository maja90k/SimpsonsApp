package cl.inacap.simpson.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.simpson.R;
import cl.inacap.simpson.dto.Personaje;

public class PersonajesAdapters extends ArrayAdapter<Personaje> {

    private List<Personaje> personajes;
    private Activity activity;
    public PersonajesAdapters(@NonNull Activity context, int resource, @NonNull List<Personaje> objects) {
        super(context, resource, objects);
        this.personajes = objects;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View rV = inflater.inflate(R.layout.listview_personajes, null, true);
        TextView nombre = rV.findViewById(R.id.name);
        ImageView img = rV.findViewById(R.id.image);
        nombre.setText(personajes.get(position).getCharacter());
        Picasso.get().load(this.personajes.get(position).getImage())
                .resize(350,350)
                .centerCrop()
                .into(img);
        return rV;
    }
}
