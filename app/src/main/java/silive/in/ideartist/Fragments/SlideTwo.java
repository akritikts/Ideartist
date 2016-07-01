package silive.in.ideartist.Fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import silive.in.ideartist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideTwo extends Fragment {
    TextView text2;


    public SlideTwo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_slide_two, container, false);
        text2 = (TextView)view.findViewById(R.id.text2);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "Neou-Thin.ttf");
        text2.setTypeface(type);
        return view;
    }

}
