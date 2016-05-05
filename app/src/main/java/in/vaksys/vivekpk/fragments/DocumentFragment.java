package in.vaksys.vivekpk.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.vaksys.vivekpk.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentFragment extends Fragment {


    public static DocumentFragment newInstance(int index) {
        DocumentFragment fragment = new DocumentFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document, container, false);
    }

}
