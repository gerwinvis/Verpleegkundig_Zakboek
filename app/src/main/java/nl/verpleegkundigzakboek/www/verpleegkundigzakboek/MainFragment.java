package nl.verpleegkundigzakboek.www.verpleegkundigzakboek;


import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import utils.Chronometer;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private long timeWhenStopped = 0;
    private boolean stopClicked;
    private Chronometer chronometer;
    private TextView tvStart, tvReset, tvStop;
    private TextView secondsText;


    ImageButton btnSwitch;

    private Camera camera;
    private boolean isFlashOn;
    private boolean hasFlash;
    Camera.Parameters params;
    MediaPlayer mp;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        chronometer = (Chronometer) view.findViewById(R.id.chronometer);
//        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
//            public void onChronometerTick(Chronometer cArg) {
//                long t = SystemClock.elapsedRealtime();
//                cArg.setText(DateFormat.format("kk:mm:ss", t));
//            }
//        });
        tvStart = (TextView) view.findViewById(R.id.tvStart);
        tvReset = (TextView) view.findViewById(R.id.tvReset);
        tvStop = (TextView) view.findViewById(R.id.tvStop);

        secondsText = (TextView) view.findViewById(R.id.hmsTekst);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButtonClick(view);
            }
        });

        tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonClick(view);
            }
        });

        tvStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopButtonClick(view);
            }
        });


        // flash switch button
        btnSwitch = (ImageButton) view.findViewById(R.id.btnSwitch);

		/*
         * First check if device is supporting flashlight or not
		 */
        hasFlash = getActivity().getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!hasFlash) {
            // device doesn't support flash
            // Show alert message and close the application
            final AlertDialog alert = new AlertDialog.Builder(getActivity())
                    .create();
            alert.setTitle("Error");
            alert.setMessage("Sorry, uw apparaat ondersteund geen zaklamp!");
            alert.setCancelable(true);
            alert.show();
        }

        // get the camera
        getCamera();

        // displaying button image
        toggleButtonImage();

		/*
		 * Switch button click event to toggle flash on/off
		 */
        btnSwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isFlashOn) {
                    // turn off flash
                    turnOffFlash();
                } else {
                    // turn on flash
                    turnOnFlash();
                }
            }
        });

        return view;
    }

    /*
    * Get the camera
    */
    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (RuntimeException e) {
                Log.e("Camera Error: ", e.getMessage());
            }
        }
    }

    /*
     * Turning On flash
     */
    private void turnOnFlash() {
        if (!isFlashOn) {
            if (camera == null || params == null) {
                return;
            }
            // play sound
            playSound();

            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;

            // changing button/switch image
            toggleButtonImage();
        }

    }

    /*
     * Turning Off flash
     */
    private void turnOffFlash() {
        if (isFlashOn) {
            if (camera == null || params == null) {
                return;
            }
            // play sound
            playSound();

            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;

            // changing button/switch image
            toggleButtonImage();
        }
    }

    /*
     * Playing sound
     * will play button toggle sound on flash on / off
     * */
    private void playSound() {
        if (isFlashOn) {
            mp = MediaPlayer.create(getActivity(), R.raw.light_switch_off);
        } else {
            mp = MediaPlayer.create(getActivity(), R.raw.light_switch_on);
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }
        });
        mp.start();
    }

    /*
     * Toggle switch button images
     * changing image states to on / off
     * */
    private void toggleButtonImage() {
        if (isFlashOn) {
            btnSwitch.setImageResource(R.drawable.btn_switch_on);
        } else {
            btnSwitch.setImageResource(R.drawable.btn_switch_off);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();

        // on pause turn off the flash
        turnOffFlash();
    }

    @Override
    public void onResume() {
        super.onResume();

        // on resume turn on the flash
//        if (hasFlash)
//            turnOnFlash();
    }

    @Override
    public void onStart() {
        super.onStart();

        // on starting the app get the camera params
        getCamera();
    }

    @Override
    public void onStop() {
        super.onStop();

        // on stop release the camera
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }


    // the method for when we press the 'reset' button
    public void resetButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
        secondsText.setText("0 seconds");
    }

    // the method for when we press the 'start' button
    public void startButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
        stopClicked = false;

    }

    // the method for when we press the 'stop' button
    public void stopButtonClick(View v) {
        if (!stopClicked) {
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            int seconds = (int) timeWhenStopped / 1000;
            secondsText.setText(Math.abs(seconds) + " seconds");
            chronometer.stop();
            stopClicked = true;
        }
    }

}
