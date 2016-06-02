package book.course.molareza.ir.collapse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragPage2 extends Fragment {

    private ImageView imgPage2;
    private Animation animation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_page2, container, false);

        return view;
    }

}
