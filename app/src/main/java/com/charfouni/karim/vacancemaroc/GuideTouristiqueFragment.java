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
 * {@link GuideTouristiqueFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GuideTouristiqueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuideTouristiqueFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GuideTouristiqueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuideTouristiqueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuideTouristiqueFragment newInstance(String param1, String param2) {
        GuideTouristiqueFragment fragment = new GuideTouristiqueFragment();
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
        View view=inflater.inflate(R.layout.fragment_guide_touristique, container, false);
        GridView guidesTouristiquesGridView=(GridView)view.findViewById(R.id.guidesTouristiquesGridView);
        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
        /*databaseHelper.insertRowPlace("Guide Touristique","guide touristique1","Admirez les villages berbères et les chutes d’Ouzoud pendant une visite d’un jour à partir de Marrakech. Plongez dans les eaux de la rivière Al Abid pour une baignade dans la nature. Allez à la rencontre des singes du Grand Atlas et bien plus encore.","Marrakech","adress1",60.0,R.drawable.guide_touristique);
        databaseHelper.insertRowPlace("Guide Touristique","guide touristique1","Admirez les villages berbères et les chutes d’Ouzoud pendant une visite d’un jour à partir de Marrakech. Plongez dans les eaux de la rivière Al Abid pour une baignade dans la nature. Allez à la rencontre des singes du Grand Atlas et bien plus encore.","Marrakech","adress1",70.0,R.drawable.guide_touristique);
        databaseHelper.insertRowPlace("Guide Touristique","guide touristique1","Admirez les villages berbères et les chutes d’Ouzoud pendant une visite d’un jour à partir de Marrakech. Plongez dans les eaux de la rivière Al Abid pour une baignade dans la nature. Allez à la rencontre des singes du Grand Atlas et bien plus encore.","Marrakech","adress1",80.0,R.drawable.guide_touristique);
        databaseHelper.insertRowPlace("Guide Touristique","guide touristique1","Admirez les villages berbères et les chutes d’Ouzoud pendant une visite d’un jour à partir de Marrakech. Plongez dans les eaux de la rivière Al Abid pour une baignade dans la nature. Allez à la rencontre des singes du Grand Atlas et bien plus encore.","Marrakech","adress1",90.0,R.drawable.guide_touristique);
        databaseHelper.insertRowPlace("Guide Touristique","guide touristique1","Admirez les villages berbères et les chutes d’Ouzoud pendant une visite d’un jour à partir de Marrakech. Plongez dans les eaux de la rivière Al Abid pour une baignade dans la nature. Allez à la rencontre des singes du Grand Atlas et bien plus encore.","Marrakech","adress1",95.0,R.drawable.guide_touristique);
*/
        try {

            databaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        databaseHelper.openDataBase();


        final ArrayList<GuideTouristique> guideTouristiques=databaseHelper.getAllGuideTouristiquerecord();
        final ArrayList<Integer> images=new ArrayList<>();

        images.add(R.drawable.artisanat_marocain);
        images.add(R.drawable.aqua_park);
        images.add(R.drawable.bedroom);

        guidesTouristiquesGridView.setAdapter(new MyGuideTouristiqueAdapter(guideTouristiques));
        guidesTouristiquesGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                intent.putExtra("hotelName",guideTouristiques.get(position).getName());
                intent.putExtra("hotelDescription",guideTouristiques.get(position).getDescription());
                intent.putExtra("hoteladdress",guideTouristiques.get(position).getAddress());
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
