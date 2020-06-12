package com.jbnu.comall.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.jbnu.comall.R;

/**
 * @author : Hyunwoong
 * @when : 5/10/2020 4:53 PM
 * @homepage : https://github.com/gusdnd852
 */
public class BaseFragment extends Fragment{

    public void replaceWithoutStack(FragmentTransaction transaction, int resid, Fragment fragment) {
        transaction.replace(resid, fragment).commit();
        getActivity().overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }

    public void replaceWithStack(FragmentTransaction transaction, int resid, Fragment fragment) {
        transaction.replace(resid, fragment).addToBackStack(fragment.getClass().getName()).commit();
        getActivity().overridePendingTransition(R.anim.activity_fadein, R.anim.activity_fadeout);
    }
}
