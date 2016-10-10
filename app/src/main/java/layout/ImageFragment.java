package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.ibtech.smg.android_benchmark.R;

import java.util.HashMap;

public class ImageFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public HashMap<String, Integer> images = new HashMap<String, Integer>();


    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        images.put("Monkey", R.drawable.monkey);
        images.put("WaterFront", R.drawable.waterfront);
        images.put("Xamarin", R.drawable.tapped);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.spn_job);
        spinner.setOnItemSelectedListener(this);

        imageView = (ImageView) view.findViewById(R.id.img_item);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        imageView.setImageResource(images.get(item));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
