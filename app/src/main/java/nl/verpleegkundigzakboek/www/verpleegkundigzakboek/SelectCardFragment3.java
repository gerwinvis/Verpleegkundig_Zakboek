package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;

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
import utils.NiceSpinner;

/**
 * Created by Prince on 30-01-2016.
 */
public class SelectCardFragment3 extends Fragment {

    TextView tvCardTitle;
    ImageView ivCardImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_selectcard, container, false);

        NiceSpinner niceSpinner = (NiceSpinner) view.findViewById(R.id.spinner);
        final List<String> dataset = new LinkedList<>(Arrays.asList("Card One", "Card Two", "Card Three", "Card Four", "Card Five"));
        niceSpinner.attachDataSource(dataset);

        tvCardTitle = (TextView) view.findViewById(R.id.tvCardTitle);
        ivCardImage = (ImageView) view.findViewById(R.id.ivCardImage);

        niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvCardTitle.setText(dataset.get(i));
                if (i % 2 == 0) {
                    ivCardImage.setImageResource(R.drawable.bglogo);
                } else {
                    ivCardImage.setImageResource(R.drawable.ic_menu_camera);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}
