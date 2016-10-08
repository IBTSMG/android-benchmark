package layout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ibtech.smg.android_benchmark.R;

import java.util.Calendar;

public class ControlsFragment extends Fragment {
    final Calendar myCalendar = Calendar.getInstance();

    View view;
    EditText txtBirthday;
    TextView txtDebt, lblAge;
    Integer age = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_controls, container, false);
        txtBirthday  = (EditText) view.findViewById(R.id.txt_birthday);

        bindBirthday();

        bindDebt();

        bindAge();

        return view;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateBirthday();
        }
    };

    private void bindBirthday() {
        updateBirthday();

        txtBirthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(ControlsFragment.this.getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateBirthday() {

        int day = myCalendar.get(Calendar.DAY_OF_MONTH);
        int month = myCalendar.get(Calendar.MONTH);
        int year = myCalendar.get(Calendar.YEAR);

        txtBirthday.setText(String.format("%s.%s.%s", day, month, year));
    }

    private void bindDebt() {
        txtDebt = (TextView) view.findViewById(R.id.lbl_debt_value);
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.sk_debt);
        seekBar.setMax(1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtDebt.setText(Integer.toString(progress));
            }
        });
    }

    private void bindAge() {
        lblAge  = (TextView) view.findViewById(R.id.lbl_age_value);

        Button decrease = (Button) view.findViewById(R.id.btn_age_decrease);
        decrease.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(age > 0) {
                    age--;
                    lblAge.setText(Integer.toString(age));
                }
            }
        });

        Button increase = (Button) view.findViewById(R.id.btn_age_increase);
        increase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                age++;
                lblAge.setText(Integer.toString(age));
            }
        });
    }
}
