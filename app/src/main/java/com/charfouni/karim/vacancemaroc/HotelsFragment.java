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
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotelsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    //Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HotelsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelsFragment newInstance(String param1, String param2) {
        HotelsFragment fragment = new HotelsFragment();
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
        View view=inflater.inflate(R.layout.fragment_hotels, container, false);
        GridView hotelGridView=(GridView)view.findViewById(R.id.hotelsGridView);
        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());

        /*databaseHelper.insertRowPlace("Hotel","Hotel Sofitel Marrakech Lounge and Spa","Moderne, cet hôtel haut de gamme occupe un bâtiment de style andalou, situé à 15 minutes à pied de la mosquée Koutoubia et à 2 km de la place publique Jemaa el-Fna. \n" +
                "\n" +
                "Les chambres contemporaines possèdent une salle de bain en marbre, un minibar, un écran plat, un coffre-fort et un balcon avec vue sur la ville. Les chambres de catégorie supérieure surplombent le jardin ou la piscine. Les suites de luxe disposent d'un coin salon et donnent sur la montagne. Une connexion Wi-Fi est accessible moyennant un supplément. Un service de chambre est proposé.\n" +
                "\n" +
                "L'établissement possède un restaurant méditerranéen équipé d'une terrasse, 2 restaurants internationaux, un restaurant servant une cuisine française et 5 bars. Il dispose également de 2 piscines extérieures, d'une salle de sport ainsi que d'un spa avec sauna, service de massage, hammam et jacuzzi. Le parking est gratuit.","Marrakech","Rue Harroun Errachid Quartier de l hivernage Marrakech 40000, Marrakech, Maroc",60.0,R.drawable.sofitel);
        databaseHelper.insertRowPlace("Hotel","Hotel Sofitel Marrakech Lounge and Spa","Moderne, cet hôtel haut de gamme occupe un bâtiment de style andalou, situé à 15 minutes à pied de la mosquée Koutoubia et à 2 km de la place publique Jemaa el-Fna. \n" +
                "\n" +
                "Les chambres contemporaines possèdent une salle de bain en marbre, un minibar, un écran plat, un coffre-fort et un balcon avec vue sur la ville. Les chambres de catégorie supérieure surplombent le jardin ou la piscine. Les suites de luxe disposent d'un coin salon et donnent sur la montagne. Une connexion Wi-Fi est accessible moyennant un supplément. Un service de chambre est proposé.\n" +
                "\n" +
                "L'établissement possède un restaurant méditerranéen équipé d'une terrasse, 2 restaurants internationaux, un restaurant servant une cuisine française et 5 bars. Il dispose également de 2 piscines extérieures, d'une salle de sport ainsi que d'un spa avec sauna, service de massage, hammam et jacuzzi. Le parking est gratuit.","Marrakech","Rue Harroun Errachid Quartier de l hivernage Marrakech 40000, Marrakech, Maroc",70.0,R.drawable.sofitel);
        databaseHelper.insertRowPlace("Hotel","Hotel Sofitel Marrakech Lounge and Spa","Moderne, cet hôtel haut de gamme occupe un bâtiment de style andalou, situé à 15 minutes à pied de la mosquée Koutoubia et à 2 km de la place publique Jemaa el-Fna. \n" +
                "\n" +
                "Les chambres contemporaines possèdent une salle de bain en marbre, un minibar, un écran plat, un coffre-fort et un balcon avec vue sur la ville. Les chambres de catégorie supérieure surplombent le jardin ou la piscine. Les suites de luxe disposent d'un coin salon et donnent sur la montagne. Une connexion Wi-Fi est accessible moyennant un supplément. Un service de chambre est proposé.\n" +
                "\n" +
                "L'établissement possède un restaurant méditerranéen équipé d'une terrasse, 2 restaurants internationaux, un restaurant servant une cuisine française et 5 bars. Il dispose également de 2 piscines extérieures, d'une salle de sport ainsi que d'un spa avec sauna, service de massage, hammam et jacuzzi. Le parking est gratuit.","Marrakech","Rue Harroun Errachid Quartier de l hivernage Marrakech 40000, Marrakech, Maroc",80.0,R.drawable.sofitel);
        databaseHelper.insertRowPlace("Hotel","Hotel Sofitel Marrakech Lounge and Spa","Moderne, cet hôtel haut de gamme occupe un bâtiment de style andalou, situé à 15 minutes à pied de la mosquée Koutoubia et à 2 km de la place publique Jemaa el-Fna. \n" +
                "\n" +
                "Les chambres contemporaines possèdent une salle de bain en marbre, un minibar, un écran plat, un coffre-fort et un balcon avec vue sur la ville. Les chambres de catégorie supérieure surplombent le jardin ou la piscine. Les suites de luxe disposent d'un coin salon et donnent sur la montagne. Une connexion Wi-Fi est accessible moyennant un supplément. Un service de chambre est proposé.\n" +
                "\n" +
                "L'établissement possède un restaurant méditerranéen équipé d'une terrasse, 2 restaurants internationaux, un restaurant servant une cuisine française et 5 bars. Il dispose également de 2 piscines extérieures, d'une salle de sport ainsi que d'un spa avec sauna, service de massage, hammam et jacuzzi. Le parking est gratuit.","Marrakech","Rue Harroun Errachid Quartier de l hivernage Marrakech 40000, Marrakech, Maroc",90.0,R.drawable.sofitel);
        databaseHelper.insertRowPlace("Hotel","Hotel Sofitel Marrakech Lounge and Spa","Moderne, cet hôtel haut de gamme occupe un bâtiment de style andalou, situé à 15 minutes à pied de la mosquée Koutoubia et à 2 km de la place publique Jemaa el-Fna. \n" +
                "\n" +
                "Les chambres contemporaines possèdent une salle de bain en marbre, un minibar, un écran plat, un coffre-fort et un balcon avec vue sur la ville. Les chambres de catégorie supérieure surplombent le jardin ou la piscine. Les suites de luxe disposent d'un coin salon et donnent sur la montagne. Une connexion Wi-Fi est accessible moyennant un supplément. Un service de chambre est proposé.\n" +
                "\n" +
                "L'établissement possède un restaurant méditerranéen équipé d'une terrasse, 2 restaurants internationaux, un restaurant servant une cuisine française et 5 bars. Il dispose également de 2 piscines extérieures, d'une salle de sport ainsi que d'un spa avec sauna, service de massage, hammam et jacuzzi. Le parking est gratuit.","Marrakech","Rue Harroun Errachid Quartier de l hivernage Marrakech 40000, Marrakech, Maroc",95.0,R.drawable.sofitel);
*/

        try {

            databaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        databaseHelper.openDataBase();

        final  ArrayList<Hotel> hotels=databaseHelper.getAllHotelsRecord();
        final ArrayList<Integer> images=new ArrayList<>();

        images.add(R.drawable.artisanat_marocain);
        images.add(R.drawable.aqua_park);
        images.add(R.drawable.bedroom);



        hotelGridView.setAdapter(new MyHotelAdapter(hotels));
        hotelGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                intent.putExtra("hotelName",hotels.get(position).getName());
                intent.putExtra("hotelDescription",hotels.get(position).getDescription());
                intent.putExtra("hoteladdress",hotels.get(position).getAddress());
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
