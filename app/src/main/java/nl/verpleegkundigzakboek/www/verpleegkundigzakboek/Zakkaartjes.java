package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Zakkaartjes extends Fragment {

    TextView tv1, tv2, tv3;

    public Zakkaartjes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zakkaartjes, container, false);

        tv1 = (TextView)view.findViewById(R.id.tvDB1);
        tv2 = (TextView)view.findViewById(R.id.tvDB2);
        tv3 = (TextView)view.findViewById(R.id.tvDB3);
        
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectCardFragment();
            }
        });
        
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectCardFragment();
            }
        });
        
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectCardFragment();
            }
        });
        
        return view;
    }

    private void openSelectCardFragment() {

        SelectCardFragment fragment = new SelectCardFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.isAddToBackStackAllowed();
//        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();

    }

}
