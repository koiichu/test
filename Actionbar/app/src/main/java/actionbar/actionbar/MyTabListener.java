package actionbar.actionbar;

import android.app.Fragment;

/**
 * Created by KMITL on 22/12/2015.
 */
public class MyTabListener <extends Fragment>
        implements ActionBar.TabListener {

        private Fragment fragment;
        private static final String TAG = "junk";
}
public MyTabListener(Fragment fragment){
        this.fragment = fragment;
        }
