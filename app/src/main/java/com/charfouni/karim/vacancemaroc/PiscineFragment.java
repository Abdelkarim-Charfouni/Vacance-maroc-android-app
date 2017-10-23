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
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PiscineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PiscineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PiscineFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PiscineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PiscineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PiscineFragment newInstance(String param1, String param2) {
        PiscineFragment fragment = new PiscineFragment();
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
        View view=inflater.inflate(R.layout.fragment_piscine, container, false);
        GridView piscineGridView=(GridView)view.findViewById(R.id.piscinesGridView);
        DatabaseHelper databaseHelper=new DatabaseHelper(getActivity());
               /*databaseHelper.insertRowPlace("Piscine","Labranda Aqua Fun Club Marrakech","Surplombant les montagnes de l'Atlas, l'hôtel Labranda Aqua Fun Club Marrakech vous accueille sur un domaine de 4 hectares, à l'ombre des oliviers. Il propose un service de navette gratuit pour le centre-ville de Marrakech, 2 piscines intérieures chauffées en hiver et une salle de sport accessible gratuitement.\n" +
                "\n" +
                "Toutes les chambres climatisées du Labranda Aqua Fun Club Marrakech affichent un design moderne et disposent d'un balcon privé. Elles sont pourvues d'un coin salon équipé de la télévision par satellite.\n" +
                "\n" +
                "Un petit-déjeuner buffet est préparé tous les matins. Le restaurant sert par ailleurs une cuisine traditionnelle marocaine et méditerranéenne. Vous aurez également la possibilité de déguster un verre au bar et de profiter de la discothèque privée de l'établissement.\n" +
                "\n" +
                "Un court de tennis, un salon de beauté et un centre de bien-être sont disponibles au Labranda Aqua Fun Club Marrakech. Vous bénéficierez également d'un club pour enfants et d'une connexion Wi-Fi gratuite à la réception ouverte 24h/24.\n" +
                "\n" +
                "Proposant un parking privé gratuit, ce complexe se trouve à 15 km du centre-ville et de l'aéroport de Marrakech. Enfin, du thé à la menthe vous sera servi à l'arrivée.\n" +
                "\n" +
                "Si vous souhaitez lui demander quelque chose en particulier, vous pourrez le faire à la prochaine étape, juste avant de réserver. Une fois la réservation effectuée, nous vous communiquerons les coordonnées de l'établissement pour que vous puissiez le contacter directement.\n" +
                "\n" +
                "Nous parlons votre langue !","Marrakech","Km 18, Route De L'Ourika, 40000 Aït Hamid, Maroc ",60.0,R.drawable.piscine);
        databaseHelper.insertRowPlace("Piscine","Labranda Aqua Fun Club Marrakech","Surplombant les montagnes de l'Atlas, l'hôtel Labranda Aqua Fun Club Marrakech vous accueille sur un domaine de 4 hectares, à l'ombre des oliviers. Il propose un service de navette gratuit pour le centre-ville de Marrakech, 2 piscines intérieures chauffées en hiver et une salle de sport accessible gratuitement.\n" +
                "\n" +
                "Toutes les chambres climatisées du Labranda Aqua Fun Club Marrakech affichent un design moderne et disposent d'un balcon privé. Elles sont pourvues d'un coin salon équipé de la télévision par satellite.\n" +
                "\n" +
                "Un petit-déjeuner buffet est préparé tous les matins. Le restaurant sert par ailleurs une cuisine traditionnelle marocaine et méditerranéenne. Vous aurez également la possibilité de déguster un verre au bar et de profiter de la discothèque privée de l'établissement.\n" +
                "\n" +
                "Un court de tennis, un salon de beauté et un centre de bien-être sont disponibles au Labranda Aqua Fun Club Marrakech. Vous bénéficierez également d'un club pour enfants et d'une connexion Wi-Fi gratuite à la réception ouverte 24h/24.\n" +
                "\n" +
                "Proposant un parking privé gratuit, ce complexe se trouve à 15 km du centre-ville et de l'aéroport de Marrakech. Enfin, du thé à la menthe vous sera servi à l'arrivée.\n" +
                "\n" +
                "Si vous souhaitez lui demander quelque chose en particulier, vous pourrez le faire à la prochaine étape, juste avant de réserver. Une fois la réservation effectuée, nous vous communiquerons les coordonnées de l'établissement pour que vous puissiez le contacter directement.\n" +
                "\n" +
                "Nous parlons votre langue !","Marrakech","Km 18, Route De L'Ourika, 40000 Aït Hamid, Maroc ",70.0,R.drawable.piscine);
        databaseHelper.insertRowPlace("Piscine","Labranda Aqua Fun Club Marrakech","Surplombant les montagnes de l'Atlas, l'hôtel Labranda Aqua Fun Club Marrakech vous accueille sur un domaine de 4 hectares, à l'ombre des oliviers. Il propose un service de navette gratuit pour le centre-ville de Marrakech, 2 piscines intérieures chauffées en hiver et une salle de sport accessible gratuitement.\n" +
                "\n" +
                "Toutes les chambres climatisées du Labranda Aqua Fun Club Marrakech affichent un design moderne et disposent d'un balcon privé. Elles sont pourvues d'un coin salon équipé de la télévision par satellite.\n" +
                "\n" +
                "Un petit-déjeuner buffet est préparé tous les matins. Le restaurant sert par ailleurs une cuisine traditionnelle marocaine et méditerranéenne. Vous aurez également la possibilité de déguster un verre au bar et de profiter de la discothèque privée de l'établissement.\n" +
                "\n" +
                "Un court de tennis, un salon de beauté et un centre de bien-être sont disponibles au Labranda Aqua Fun Club Marrakech. Vous bénéficierez également d'un club pour enfants et d'une connexion Wi-Fi gratuite à la réception ouverte 24h/24.\n" +
                "\n" +
                "Proposant un parking privé gratuit, ce complexe se trouve à 15 km du centre-ville et de l'aéroport de Marrakech. Enfin, du thé à la menthe vous sera servi à l'arrivée.\n" +
                "\n" +
                "Si vous souhaitez lui demander quelque chose en particulier, vous pourrez le faire à la prochaine étape, juste avant de réserver. Une fois la réservation effectuée, nous vous communiquerons les coordonnées de l'établissement pour que vous puissiez le contacter directement.\n" +
                "\n" +
                "Nous parlons votre langue !","Marrakech","Km 18, Route De L'Ourika, 40000 Aït Hamid, Maroc ",80.0,R.drawable.piscine);
        databaseHelper.insertRowPlace("Piscine","Labranda Aqua Fun Club Marrakech","Surplombant les montagnes de l'Atlas, l'hôtel Labranda Aqua Fun Club Marrakech vous accueille sur un domaine de 4 hectares, à l'ombre des oliviers. Il propose un service de navette gratuit pour le centre-ville de Marrakech, 2 piscines intérieures chauffées en hiver et une salle de sport accessible gratuitement.\n" +
                "\n" +
                "Toutes les chambres climatisées du Labranda Aqua Fun Club Marrakech affichent un design moderne et disposent d'un balcon privé. Elles sont pourvues d'un coin salon équipé de la télévision par satellite.\n" +
                "\n" +
                "Un petit-déjeuner buffet est préparé tous les matins. Le restaurant sert par ailleurs une cuisine traditionnelle marocaine et méditerranéenne. Vous aurez également la possibilité de déguster un verre au bar et de profiter de la discothèque privée de l'établissement.\n" +
                "\n" +
                "Un court de tennis, un salon de beauté et un centre de bien-être sont disponibles au Labranda Aqua Fun Club Marrakech. Vous bénéficierez également d'un club pour enfants et d'une connexion Wi-Fi gratuite à la réception ouverte 24h/24.\n" +
                "\n" +
                "Proposant un parking privé gratuit, ce complexe se trouve à 15 km du centre-ville et de l'aéroport de Marrakech. Enfin, du thé à la menthe vous sera servi à l'arrivée.\n" +
                "\n" +
                "Si vous souhaitez lui demander quelque chose en particulier, vous pourrez le faire à la prochaine étape, juste avant de réserver. Une fois la réservation effectuée, nous vous communiquerons les coordonnées de l'établissement pour que vous puissiez le contacter directement.\n" +
                "\n" +
                "Nous parlons votre langue !","Marrakech","Km 18, Route De L'Ourika, 40000 Aït Hamid, Maroc ",90.0,R.drawable.piscine);
        databaseHelper.insertRowPlace("Piscine","Labranda Aqua Fun Club Marrakech","Surplombant les montagnes de l'Atlas, l'hôtel Labranda Aqua Fun Club Marrakech vous accueille sur un domaine de 4 hectares, à l'ombre des oliviers. Il propose un service de navette gratuit pour le centre-ville de Marrakech, 2 piscines intérieures chauffées en hiver et une salle de sport accessible gratuitement.\n" +
                "\n" +
                "Toutes les chambres climatisées du Labranda Aqua Fun Club Marrakech affichent un design moderne et disposent d'un balcon privé. Elles sont pourvues d'un coin salon équipé de la télévision par satellite.\n" +
                "\n" +
                "Un petit-déjeuner buffet est préparé tous les matins. Le restaurant sert par ailleurs une cuisine traditionnelle marocaine et méditerranéenne. Vous aurez également la possibilité de déguster un verre au bar et de profiter de la discothèque privée de l'établissement.\n" +
                "\n" +
                "Un court de tennis, un salon de beauté et un centre de bien-être sont disponibles au Labranda Aqua Fun Club Marrakech. Vous bénéficierez également d'un club pour enfants et d'une connexion Wi-Fi gratuite à la réception ouverte 24h/24.\n" +
                "\n" +
                "Proposant un parking privé gratuit, ce complexe se trouve à 15 km du centre-ville et de l'aéroport de Marrakech. Enfin, du thé à la menthe vous sera servi à l'arrivée.\n" +
                "\n" +
                "Si vous souhaitez lui demander quelque chose en particulier, vous pourrez le faire à la prochaine étape, juste avant de réserver. Une fois la réservation effectuée, nous vous communiquerons les coordonnées de l'établissement pour que vous puissiez le contacter directement.\n" +
                "\n" +
                "Nous parlons votre langue !","Marrakech","Km 18, Route De L'Ourika, 40000 Aït Hamid, Maroc ",95.0,R.drawable.piscine);
*/

        try {

            databaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }
        databaseHelper.openDataBase();

        final ArrayList<Piscine> piscines=databaseHelper.getAllPiscinesRecord();
        final ArrayList<Integer> images=new ArrayList<>();
        images.add(R.drawable.artisanat_marocain);
        images.add(R.drawable.aqua_park);
        images.add(R.drawable.bedroom);

        piscineGridView.setAdapter(new MyPiscineAdapter(piscines));
        piscineGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                intent.putExtra("hotelName",piscines.get(position).getName());
                intent.putExtra("hotelDescription",piscines.get(position).getDescription());
                intent.putExtra("hoteladdress",piscines.get(position).getAddress());
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
