package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jbnu.comall.R;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.ComparePart;

import java.util.List;

public class CompareListFragment extends BaseFragment {

    private Spinner spinner;
    private Spinner spinner1;
    private TextView spec1;
    private TextView spec2;
    private TextView spec3;
    private TextView spec4;
    private TextView spec5;
    private TextView spec6;
    private ImageView thumnail;
    private ImageView thumnail1;
    private List<ComparePart> compareParts;
    public CompareListFragment(List<ComparePart> compareList) {this.compareParts = compareList;}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_compare_list, container, false);

        spinner = rootView.findViewById(R.id.spinner);
        spinner1 = rootView.findViewById(R.id.spinner1);
        spec1 = rootView.findViewById(R.id.spec1);
        spec2 = rootView.findViewById(R.id.spec2);
        spec3 = rootView.findViewById(R.id.spec3);
        spec4 = rootView.findViewById(R.id.spec4);
        spec5 = rootView.findViewById(R.id.spec5);
        spec6 = rootView.findViewById(R.id.spec6);
        thumnail = rootView.findViewById(R.id.compare_thumbnail);
        thumnail1 = rootView.findViewById(R.id.compare_thumbnail1);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position >=0)
                    switch (position) {
                        case 0:
                            spec1.setText("인텔 9세대");
                            spec2.setText("3.5Hz");
                            spec3.setText("14nano 공정");
                            thumnail.setImageResource(R.drawable.cart);
                            break;
                        case 1:
                            spec1.setText("MSI 4세대");
                            spec2.setText("2.5Hz");
                            spec3.setText("10nano 공정");
                            break;
                        case 2:
                            spec1.setText("GAXAXY 6세대");
                            spec2.setText("5.5Hz");
                            spec3.setText("11nano 공정");
                    }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position >= 0)
                    switch (position) {
                        case 0:
                            spec4.setText("인텔 9세대");
                            spec5.setText("3.5Hz");
                            spec6.setText("14nano 공정");
                            break;
                        case 1:
                            spec4.setText("MSI 4세대");
                            spec5.setText("2.5Hz");
                            spec6.setText("10nano 공정");
                            break;
                        case 2:
                            spec4.setText("GAXAXY 6세대");
                            spec5.setText("5.5Hz");
                            spec6.setText("11nano 공정");
                    }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
            return rootView;
    }
}
