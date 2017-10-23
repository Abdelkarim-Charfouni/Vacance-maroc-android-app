package com.charfouni.karim.vacancemaroc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AvisiterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AvisiterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AvisiterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AvisiterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AvisiterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AvisiterFragment newInstance(String param1, String param2) {
        AvisiterFragment fragment = new AvisiterFragment();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_avisiter, container, false);
        GridView avisiterGridView=(GridView)view.findViewById(R.id.AvisiterGridView);
        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
        /*databaseHelper.insertRowPlace("A Visiter","Dar Dbagh","For many centuries, traditional craft is the economic engine of the famous city of Fes. Craft leather tanning is of the jobs many people practice to earn a living.\n" +
                "Places like «3arssa», «Lakbira», «Shwara», and «Dar-Addahab» .. all the names of places of tanning leather in the ancient city of Fez.\n" +
                "The House of tanning are used to be called «Gold House», and there located next to a small river known as «Wade Bouchrarb», also called «Wade jewaher». Over 700 craftsman works here distributed to 400 shops manufacturing all types of traditional leather products.\n" +
                "The products are sold on traditional shops called “Bazaaras”.","Marrakech","Dar Dbagh, Marrakech 40000, Maroc",60.0,R.drawable.dar_dbagh);
        databaseHelper.insertRowPlace("A Visiter","Dar Dbagh","For many centuries, traditional craft is the economic engine of the famous city of Fes. Craft leather tanning is of the jobs many people practice to earn a living.\n" +
                "Places like «3arssa», «Lakbira», «Shwara», and «Dar-Addahab» .. all the names of places of tanning leather in the ancient city of Fez.\n" +
                "The House of tanning are used to be called «Gold House», and there located next to a small river known as «Wade Bouchrarb», also called «Wade jewaher». Over 700 craftsman works here distributed to 400 shops manufacturing all types of traditional leather products.\n" +
                "The products are sold on traditional shops called “Bazaaras”.","Marrakech","Dar Dbagh, Marrakech 40000, Maroc",70.0,R.drawable.dar_dbagh);
        databaseHelper.insertRowPlace("A Visiter","Dar Dbagh","For many centuries, traditional craft is the economic engine of the famous city of Fes. Craft leather tanning is of the jobs many people practice to earn a living.\n" +
                "Places like «3arssa», «Lakbira», «Shwara», and «Dar-Addahab» .. all the names of places of tanning leather in the ancient city of Fez.\n" +
                "The House of tanning are used to be called «Gold House», and there located next to a small river known as «Wade Bouchrarb», also called «Wade jewaher». Over 700 craftsman works here distributed to 400 shops manufacturing all types of traditional leather products.\n" +
                "The products are sold on traditional shops called “Bazaaras”.","Marrakech","Dar Dbagh, Marrakech 40000, Maroc",80.0,R.drawable.dar_dbagh);
        databaseHelper.insertRowPlace("A Visiter","Dar Dbagh","For many centuries, traditional craft is the economic engine of the famous city of Fes. Craft leather tanning is of the jobs many people practice to earn a living.\n" +
                "Places like «3arssa», «Lakbira», «Shwara», and «Dar-Addahab» .. all the names of places of tanning leather in the ancient city of Fez.\n" +
                "The House of tanning are used to be called «Gold House», and there located next to a small river known as «Wade Bouchrarb», also called «Wade jewaher». Over 700 craftsman works here distributed to 400 shops manufacturing all types of traditional leather products.\n" +
                "The products are sold on traditional shops called “Bazaaras”.","Marrakech","Dar Dbagh, Marrakech 40000, Maroc",90.0,R.drawable.dar_dbagh);
        databaseHelper.insertRowPlace("A Visiter","Dar Dbagh","For many centuries, traditional craft is the economic engine of the famous city of Fes. Craft leather tanning is of the jobs many people practice to earn a living.\n" +
                "Places like «3arssa», «Lakbira», «Shwara», and «Dar-Addahab» .. all the names of places of tanning leather in the ancient city of Fez.\n" +
                "The House of tanning are used to be called «Gold House», and there located next to a small river known as «Wade Bouchrarb», also called «Wade jewaher». Over 700 craftsman works here distributed to 400 shops manufacturing all types of traditional leather products.\n" +
                "The products are sold on traditional shops called “Bazaaras”.","Marrakech","Dar Dbagh, Marrakech 40000, Maroc",95.0,R.drawable.dar_dbagh);
        */
        try {

            databaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        databaseHelper.openDataBase();


        final ArrayList<Avisiter> avisiters=databaseHelper.getAllAvisiterrecord();
        final ArrayList<Integer> images=new ArrayList<>();

        images.add(R.drawable.artisanat_marocain);
        images.add(R.drawable.aqua_park);
        images.add(R.drawable.bedroom);

        avisiterGridView.setAdapter(new MyAvisiterAdapter(avisiters));
        avisiterGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                intent.putExtra("hotelName",avisiters.get(position).getName());
                intent.putExtra("hotelDescription",avisiters.get(position).getDescription());
                intent.putExtra("hoteladdress",avisiters.get(position).getAddress());
                intent.putExtra("images",images);
                startActivity(intent);
            }
        });

        return view;
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
