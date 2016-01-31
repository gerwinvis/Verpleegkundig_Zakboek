package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Druppelsnelheid.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Druppelsnelheid#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Druppelsnelheid extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etMillimeters, etUren;
    private Button btBereken;
    private TextView tvResult;


    private OnFragmentInteractionListener mListener;

    public Druppelsnelheid() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Druppelsnelheid.
     */
    // TODO: Rename and change types and number of parameters
    public static Druppelsnelheid newInstance(String param1, String param2) {
        Druppelsnelheid fragment = new Druppelsnelheid();
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
        View view = inflater.inflate(R.layout.fragment_druppelsnelheid, container, false);
        etMillimeters = (EditText) view.findViewById(R.id.etInvoermilliliters);
        etUren = (EditText) view.findViewById(R.id.etInvoeruren);
        btBereken = (Button) view.findViewById(R.id.button_20);
        tvResult = (TextView) view.findViewById(R.id.uitkomstdruppelsperminuut);

        btBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etMillimeters.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Vul zowef milliliters als uren in!", Toast.LENGTH_SHORT).show();
                } else {
                    if (etUren.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "Vul zowef milliliters als uren in!", Toast.LENGTH_SHORT).show();
                    } else {
                        tvResult.setText(roundOffTo2DecPlaces((Float.parseFloat(etMillimeters.getText().toString()) * 20)
                                / (Float.parseFloat(etUren.getText().toString()) * 60)));
                    }
                }
            }
        });

        return view;
    }

    private String roundOffTo2DecPlaces(float val) {
        return String.format("%.2f", val);
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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
