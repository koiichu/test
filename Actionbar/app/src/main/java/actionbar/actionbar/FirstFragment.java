package actionbar.actionbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KMITL on 22/12/2015.
 */
public class FirstFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle saveInstanceState)
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
    return view;
}
}
