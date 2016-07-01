package silive.in.ideartist.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import silive.in.ideartist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Idea extends DialogFragment implements View.OnClickListener {
    Button dialog_close_btn;


    public Idea() {
        // Required empty public constructor
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_idea, container, false);
        dialog_close_btn = (Button)view.findViewById(R.id.dialog_close_btn);
        dialog_close_btn.setOnClickListener(this);
        setCancelable(false);
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.dialog_close_btn){
            dismiss();
        }

    }

}
