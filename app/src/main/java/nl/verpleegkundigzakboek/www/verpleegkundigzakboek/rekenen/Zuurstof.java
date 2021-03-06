package nl.verpleegkundigzakboek.www.verpleegkundigzakboek.rekenen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nl.verpleegkundigzakboek.www.verpleegkundigzakboek.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Zuurstof.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Zuurstof#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Zuurstof extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    private EditText etBarfles, etInhoudfles, etLitersperminuut;
    private Button btBereken;
    private TextView tvResult;
    private TextView tvResult2;


    private OnFragmentInteractionListener mListener;

    public Zuurstof() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @return A new instance of fragment Druppelsnelheid.
     */
    // TODO: Rename and change types and number of parameters
    public static Zuurstof newInstance(String param1, String param2,String param3 ) {
        Zuurstof fragment = new Zuurstof();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM2, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zuurstof, container, false);
        etBarfles = (EditText) view.findViewById(R.id.etBarinfles);
        etInhoudfles = (EditText) view.findViewById(R.id.etInhoudfles);
        etLitersperminuut =(EditText) view.findViewById(R.id.etLitersperminuut);
        btBereken = (Button) view.findViewById(R.id.button_20);
        tvResult = (TextView) view.findViewById(R.id.uitkomsturen);
        tvResult2 = (TextView) view.findViewById(R.id.uitkomstminuten);

        btBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etBarfles.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Vul zowel bar in fles, inhoud fles als liters per minuut in!", Toast.LENGTH_SHORT).show();
                } else {
                    if (etInhoudfles.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "Vul zowel bar in fles, inhoud fles als liters per minuut in!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (etLitersperminuut.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "Vul zowel bar in fles, inhoud fles als liters per minuut in!", Toast.LENGTH_SHORT).show();
                        } else {
                        }
                        tvResult.setText(String.valueOf
                                        ((int) Math.floor
                                        (
                                (Float.parseFloat(etBarfles.getText().toString())
                                        *
                                (Float.parseFloat(etInhoudfles.getText().toString()))
                                        /
                                (Float.parseFloat(etLitersperminuut.getText().toString())))
                                        /
                                60)
                                )
                        );
                        tvResult2.setText(roundOffTo2DecPlaces(((((Float.parseFloat(etBarfles.getText().toString()) * Float.parseFloat(etInhoudfles.getText().toString()))
                                / Float.parseFloat(etLitersperminuut.getText().toString())) / 60) - Float.parseFloat(tvResult.getText().toString()))*60));

                        InputMethodManager inputMgr = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        EditText editText = (EditText)getView().findViewById(R.id.etLitersperminuut);
                        inputMgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    }
                }

            }
        });

        return view;
    }

    private String roundOffTo2DecPlaces(float val) {return String.format("%.0f", val);}

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
