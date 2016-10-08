package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ibtech.smg.android_benchmark.R;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final EditText name = (EditText) view.findViewById(R.id.txt_name);
        final EditText surname = (EditText) view.findViewById(R.id.txt_surname);

        Button show = (Button) view.findViewById(R.id.btn_show);
        show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = String.format("Welcome %s %s", name.getText(), surname.getText());
                Toast.makeText(getContext(), message,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
