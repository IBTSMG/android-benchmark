package layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.ibtech.smg.android_benchmark.R;

public class PopupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popup, container, false);

        Button popup = (Button) view.findViewById(R.id.btn_popup);
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Alert").setMessage("You have been alerted");
                alertDialog.create().show();
            }
        });

        Button confirm = (Button) view.findViewById(R.id.btn_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Question?").setMessage("Would you like to play a game");
                alertDialog.setPositiveButton("OK", dialogClickListener);
                alertDialog.setNegativeButton("Cancel", dialogClickListener);
                alertDialog.create().show();
            }
        });

        Button actionsheet = (Button) view.findViewById(R.id.btn_actionsheet);
        actionsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                Display display = activity.getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;

                final Dialog dialog = new Dialog(activity);
                Window window = dialog.getWindow();
                window.setGravity(Gravity.BOTTOM);
                dialog.setContentView(R.layout.dialog_actionsheet);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setLayout(width, height/2-200);
                dialog.show();
            }
        });

        return view;
    }
}
