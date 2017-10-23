package com.charfouni.karim.vacancemaroc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CinemaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CinemaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CinemaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CinemaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CinemaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CinemaFragment newInstance(String param1, String param2) {
        CinemaFragment fragment = new CinemaFragment();
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
        View view=inflater.inflate(R.layout.fragment_cinema, container, false);
        GridView cinemasGridView=(GridView)view.findViewById(R.id.cinemasGridView);
        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
     /* databaseHelper.insertRowPlace("Cinema","cinema megarama","Les centres Mégarama sont présents en France et au Maroc. Nous présentons des salles de projection de films mais également des spectacles et des événements de grande envergure. \n" +
                "\n" +
                "Nos 14 salles de Casablanca en plus des 9 salles de Marrakech font de nous le plus grand complexe cinématographique du Maroc et d’Afrique. \n" +
                "\n" +
                "Vous êtes jeune et plein(e) d'énergie, vous souhaitez vous investir dans une entreprise en plein essor qui vous donnera les moyens de valoriser votre potentiel… alors n’hésitez plus à nous rejoindre !!!","Marrakech","800 Avenue du 7ème art, Marrakech",60.0,R.drawable.megarama);
        databaseHelper.insertRowPlace("Cinema","cinema megarama","Les centres Mégarama sont présents en France et au Maroc. Nous présentons des salles de projection de films mais également des spectacles et des événements de grande envergure. \n" +
                "\n" +
                "Nos 14 salles de Casablanca en plus des 9 salles de Marrakech font de nous le plus grand complexe cinématographique du Maroc et d’Afrique. \n" +
                "\n" +
                "Vous êtes jeune et plein(e) d'énergie, vous souhaitez vous investir dans une entreprise en plein essor qui vous donnera les moyens de valoriser votre potentiel… alors n’hésitez plus à nous rejoindre !!!","Marrakech","800 Avenue du 7ème art, Marrakech",70.0,R.drawable.megarama);
        databaseHelper.insertRowPlace("Cinema","cinema megarama","Les centres Mégarama sont présents en France et au Maroc. Nous présentons des salles de projection de films mais également des spectacles et des événements de grande envergure. \n" +
                "\n" +
                "Nos 14 salles de Casablanca en plus des 9 salles de Marrakech font de nous le plus grand complexe cinématographique du Maroc et d’Afrique. \n" +
                "\n" +
                "Vous êtes jeune et plein(e) d'énergie, vous souhaitez vous investir dans une entreprise en plein essor qui vous donnera les moyens de valoriser votre potentiel… alors n’hésitez plus à nous rejoindre !!!","Marrakech","800 Avenue du 7ème art, Marrakech",80.0,R.drawable.megarama);
        databaseHelper.insertRowPlace("Cinema","cinema megarama","Les centres Mégarama sont présents en France et au Maroc. Nous présentons des salles de projection de films mais également des spectacles et des événements de grande envergure. \n" +
                "\n" +
                "Nos 14 salles de Casablanca en plus des 9 salles de Marrakech font de nous le plus grand complexe cinématographique du Maroc et d’Afrique. \n" +
                "\n" +
                "Vous êtes jeune et plein(e) d'énergie, vous souhaitez vous investir dans une entreprise en plein essor qui vous donnera les moyens de valoriser votre potentiel… alors n’hésitez plus à nous rejoindre !!!","Marrakech","800 Avenue du 7ème art, Marrakech",90.0,R.drawable.megarama);
        databaseHelper.insertRowPlace("Cinema","cinema megarama","Les centres Mégarama sont présents en France et au Maroc. Nous présentons des salles de projection de films mais également des spectacles et des événements de grande envergure. \n" +
                "\n" +
                "Nos 14 salles de Casablanca en plus des 9 salles de Marrakech font de nous le plus grand complexe cinématographique du Maroc et d’Afrique. \n" +
                "\n" +
                "Vous êtes jeune et plein(e) d'énergie, vous souhaitez vous investir dans une entreprise en plein essor qui vous donnera les moyens de valoriser votre potentiel… alors n’hésitez plus à nous rejoindre !!!","Marrakech","800 Avenue du 7ème art, Marrakech",95.0,R.drawable.megarama);
        databaseHelper.insertRowPlace("Cinema","cinema megarama","Les centres Mégarama sont présents en France et au Maroc. Nous présentons des salles de projection de films mais également des spectacles et des événements de grande envergure. \n" +
                "\n" +
                "Nos 14 salles de Casablanca en plus des 9 salles de Marrakech font de nous le plus grand complexe cinématographique du Maroc et d’Afrique. \n" +
                "\n" +
                "Vous êtes jeune et plein(e) d'énergie, vous souhaitez vous investir dans une entreprise en plein essor qui vous donnera les moyens de valoriser votre potentiel… alors n’hésitez plus à nous rejoindre !!!","Marrakech","800 Avenue du 7ème art, Marrakech",100.0,R.drawable.megarama);
*/
        try {

            databaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        databaseHelper.openDataBase();
            final ArrayList<Cinema> cinemas=databaseHelper.getAllCinemasRecord();
            final ArrayList<Integer> images=new ArrayList<>();

            images.add(R.drawable.artisanat_marocain);
            images.add(R.drawable.aqua_park);
            images.add(R.drawable.bedroom);

            cinemasGridView.setAdapter(new MyCinemaAdapter(cinemas));
             cinemasGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                intent.putExtra("hotelName",cinemas.get(position).getName());
                intent.putExtra("hotelDescription",cinemas.get(position).getDescription());
                intent.putExtra("hoteladdress",cinemas.get(position).getAddress());
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
