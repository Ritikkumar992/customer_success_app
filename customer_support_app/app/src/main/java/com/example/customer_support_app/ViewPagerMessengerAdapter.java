package com.example.customer_support_app;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerMessengerAdapter extends FragmentStateAdapter {

    public ViewPagerMessengerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new PageFragment1();
            case 1:
                return new PageFragment2();
            case 2:
                return new PageFragment3();
            default:
                return new PageFragment4();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
