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
public class SlideOne extends Fragment {
    TextView text1;


    public SlideOne() {
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
        View view = inflater.inflate(R.layout.fragment_slide_one, container, false);
        text1 = (TextView)view.findViewById(R.id.text1);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "Neou-Thin.ttf");
        text1.setTypeface(type);
        return view;
    }

}
