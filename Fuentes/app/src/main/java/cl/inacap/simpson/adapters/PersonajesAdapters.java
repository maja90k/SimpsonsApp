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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.simpson.R;
import cl.inacap.simpson.dto.Personaje;

public class PersonajesAdapters extends ArrayAdapter<Personaje>{

    List<Personaje> personajes;
    Activity activity;
    Context context;

    public PersonajesAdapters(@NonNull Context context, int resource, @NonNull List<Personaje> objects ) {
        super(context, resource, objects);
        this.personajes = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view  = inflater.inflate(R.layout.list_personajes, null, true);

        TextView nombre =    view.findViewById(R.id.nombre_txt);
        TextView frase =     view.findViewById(R.id.quote);
        ImageView img =      view.findViewById(R.id.image);

        nombre.setText(personajes.get(position).getCharacter());
        frase.setText(personajes.get(position).getQuote());
        Picasso.get().load(this.personajes.get(position).getImage())
                .resize(350,350)
                .centerCrop()
                .into(img);
        return view;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

}
