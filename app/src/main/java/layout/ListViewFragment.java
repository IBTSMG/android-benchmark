package layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ibtech.smg.android_benchmark.MySimpleArrayAdapter;
import com.ibtech.smg.android_benchmark.OrderItem;
import com.ibtech.smg.android_benchmark.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {
    private Integer itemcount = 100;
    private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
    private MySimpleArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        loadOrderItems();

        final ListView orderlist = (ListView) view.findViewById(R.id.order_list);
        adapter = new MySimpleArrayAdapter(getActivity(), orderItems);
        orderlist.setAdapter(adapter);

        final EditText itemcount_value = (EditText) view.findViewById(R.id.item_count_value);

        Button load = (Button) view.findViewById(R.id.btn_load);
        load.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                itemcount = Integer.parseInt(itemcount_value.getText().toString());

                loadOrderItems();

                adapter.notifyDataSetChanged();

                hideKeyboard(getActivity());
            }
        });

        return view;
    }

    private void loadOrderItems(){
        orderItems.clear();
        for (Integer i=0; i < itemcount; i++) {
            orderItems.add(new OrderItem(i+1, "Fatih Şimşek", "Bilgisayar", 1, 150.0));
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}