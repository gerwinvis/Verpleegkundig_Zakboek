package nl.verpleegkundigzakboek.www.verpleegkundigzakboek.communicatie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import nl.verpleegkundigzakboek.www.verpleegkundigzakboek.R;
import nl.verpleegkundigzakboek.www.verpleegkundigzakboek.SelectCardFragment;
import utils.NiceSpinner;

/**
 * Created by Prince on 30-01-2016.
 */
public class artscontactspoed extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artscontactspoed, container, false);

        NiceSpinner niceSpinner = (NiceSpinner) view.findViewById(R.id.spinner);
        final List<String> dataset = new LinkedList<>(Arrays.asList("Arts contact spoed","Menu", "Card Three", "Card Four", "Card Five"));
        niceSpinner.attachDataSource(dataset);



        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0: //select first item in spinner to open Fragment1
                        artscontactspoed artscontactspoed= new artscontactspoed();
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 =
                                getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.fragment_container, artscontactspoed);
                        fragmentTransaction2.commit();
                        break;
                    case 1: //select second item in spinner to open fragment 2
                        SelectCardFragment SelectCardfragment = new SelectCardFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 =
                                getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.fragment_container, SelectCardfragment);
                        fragmentTransaction1.commit();
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}
