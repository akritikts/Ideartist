package silive.in.ideartist.Fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import silive.in.ideartist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideThree extends Fragment implements View.OnClickListener {
    TextView text3, idea;


    public SlideThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slide_three, container, false);
        text3 = (TextView) view.findViewById(R.id.text3);
        idea = (TextView) view.findViewById(R.id.idea);
        idea.setOnClickListener(this);
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "Neou-Thin.ttf");
        text3.setTypeface(type);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.idea:
                Log.d("Idea", "Clicked");
                Idea idea = new Idea();
                //Idea.show(getChildFragmentManager(),"What is Ideartist");
                Log.d("Idea", "Semi");
                /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).attach(fragment).commit();*/
                Log.d("Idea", "Worked");
                break;
        }

    }
}
