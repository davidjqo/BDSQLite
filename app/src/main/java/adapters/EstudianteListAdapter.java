package adapters;

import android.content.Context;
import android.widget.*;

import entities.*;

import java.util.*;

import android.view.*;

import com.example.david.bdsqlite.R;

public class EstudianteListAdapter extends ArrayAdapter<Estudiante> {
    private Context context;
    private List<Estudiante> estudiantes;

    public EstudianteListAdapter(Context context, List<Estudiante> estudiantes) {
        super(context, R.layout.estudiante_layout, estudiantes);
        this.context = context;
        this.estudiantes = estudiantes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.estudiante_layout, parent, false);
        TextView textViewId = view.findViewById(R.id.textViewId);
        textViewId.setText(estudiantes.get(position).getId());
        TextView textViewNombre = view.findViewById(R.id.textViewNombre);
        textViewNombre.setText(estudiantes.get(position).getNombre());
        TextView textViewApellido = view.findViewById(R.id.textViewApellido);
        textViewApellido.setText(estudiantes.get(position).getApellido());
        TextView textViewEdad = view.findViewById(R.id.textViewEdad);
        textViewEdad.setText(String.valueOf(estudiantes.get(position).getEdad()));
        return view;
    }
}
