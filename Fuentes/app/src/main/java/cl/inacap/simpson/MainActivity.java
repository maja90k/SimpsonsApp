package cl.inacap.simpson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import cl.inacap.simpson.adapters.PersonajesAdapters;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private ViewPager vp;
    private PersonajesAdapters pa;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vp   =     findViewById(R.id.vPager);
        this.button =   findViewById(R.id.soliBtn);
        this.spinner =  findViewById(R.id.spinner_per);
        ArrayAdapter<CharSequence> opcion = ArrayAdapter.createFromResource(this,R.array.frases, android.R.layout.simple_spinner_item );
        spinner.setAdapter(opcion);

        //solicitarConsejoBtn
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner!=null){
                    //Aqui  despues de haber solicitado el "consejo"
                    //deberia de mostrar el viewpager con el consejo y del personaje proviniente.
                    //pero como obtenemos los datos de la api dentro del viewPager?



                }else{
                    Toast.makeText(getApplicationContext(),"Seleccione un personaje", Toast.LENGTH_SHORT).show();
                }
            }
        });







    }
}