package me.mihael.sundarina.sunshine;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    private TextView mInfoTextView;
    private ImageView mStarImageViev;
    private String[] mDescriptionArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_second, container, false);
        mInfoTextView = (TextView) rootView.findViewById(R.id.textView1);
        mStarImageViev = (ImageView) rootView.findViewById(R.id.imageView1);
        mDescriptionArray = getResources().getStringArray(R.array.star);
        return rootView;
    }

    //метод для подключения картинок к кнопочным индексам

    public void setDescription(int buttonIndex) {
        String mDescription = mDescriptionArray[buttonIndex];
        mInfoTextView.setText(mDescription);

        switch (buttonIndex) {
            case 1:
                mStarImageViev.setImageResource(R.drawable.ic_star_border_black_24dp);
                break;
            case 2:
                mStarImageViev.setImageResource(R.drawable.ic_star_black_24dp);
                break;
            case 3:
                mStarImageViev.setImageResource(R.drawable.ic_star_half_black_24dp);
                break;

            default:
                break;
        }
    }
}
