package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Protocollen extends Fragment {


    public Protocollen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_protocollen, container, false);
//        SelectCardFragment fragment = new SelectCardFragment();
//        android.support.v4.app.FragmentTransaction fragmentTransaction =
//                getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.isAddToBackStackAllowed();
//        fragmentTransaction.addToBackStack("");
//        fragmentTransaction.commit();
        return view;
    }

}
