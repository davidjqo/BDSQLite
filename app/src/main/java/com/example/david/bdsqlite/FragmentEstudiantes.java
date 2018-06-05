package com.example.david.bdsqlite;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import adapters.EstudianteListAdapter;
import database.EstudianteDB;
import entities.Estudiante;
import database.*;

import android.view.View;
import android.widget.*;
import android.content.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentEstudiantes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentEstudiantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEstudiantes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Button buttonBack;
    private Button buttonSave;
    private EditText editTextId, editTextNombre, editTextApellido, editTextEdad;

    public FragmentEstudiantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEstudiantes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEstudiantes newInstance(String param1, String param2) {
        FragmentEstudiantes fragment = new FragmentEstudiantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_fragment_estudiantes, container);

        this.editTextId = view.findViewById(R.id.editTextId);
        this.editTextNombre = view.findViewById(R.id.editTextNombre);
        this.editTextApellido = view.findViewById(R.id.editTextApellido);
        this.editTextEdad = view.findViewById(R.id.editTextEdad);
        this.buttonBack = view.findViewById(R.id.buttonVer);

        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), ListViewEstudiantes.class);
                startActivity(intent1);
            }
        });

        this.buttonSave = view.findViewById(R.id.buttonSave);
        this.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EstudianteDB estudianteDB = new EstudianteDB(getActivity().getBaseContext());
                Estudiante estudiante = new Estudiante();
                estudiante.setId(editTextId.getText().toString());
                estudiante.setNombre(editTextNombre.getText().toString());
                estudiante.setApellido(editTextApellido.getText().toString());
                estudiante.setEdad(Integer.parseInt(editTextEdad.getText().toString()));
                if (estudianteDB.create(estudiante)) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_main, new FragmentEstudiantes()).commit();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Error");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.create().show();
                }
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_estudiantes, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
