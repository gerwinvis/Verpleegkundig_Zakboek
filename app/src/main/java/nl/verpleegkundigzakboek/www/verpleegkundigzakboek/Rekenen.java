package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Rekenen extends Fragment {

    Button btDruppelsnelheid;

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

        return view;
    }

}
