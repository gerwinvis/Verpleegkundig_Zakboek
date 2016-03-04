package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nl.verpleegkundigzakboek.www.verpleegkundigzakboek.rekenen.Druppelsnelheid;
import nl.verpleegkundigzakboek.www.verpleegkundigzakboek.rekenen.Oplossingen;
import nl.verpleegkundigzakboek.www.verpleegkundigzakboek.rekenen.Zuurstof;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rekenen extends Fragment {

    Button btDruppelsnelheid;
    Button btZuurstof;
    Button btOplossingen;

    public Rekenen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_rekenen, container, false);

        btDruppelsnelheid = (Button)view.findViewById(R.id.button_druppelsnelheid);
        btDruppelsnelheid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Druppelsnelheid fragment = new Druppelsnelheid();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
//                fragmentTransaction.isAddToBackStackAllowed();
//                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });
        btZuurstof = (Button)view.findViewById(R.id.button_zuurstof);
        btZuurstof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Zuurstof fragment = new Zuurstof();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
//                fragmentTransaction.isAddToBackStackAllowed();
//                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });
        btOplossingen = (Button)view.findViewById(R.id.button_oplossingen);
        btOplossingen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oplossingen fragment = new Oplossingen();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
//                fragmentTransaction.isAddToBackStackAllowed();
//                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });



        return view;
    }



}
