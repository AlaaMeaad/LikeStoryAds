package com.alaameaad.likestoryads;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import static com.alaameaad.likestoryads.HelperMethod.ReplaceFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {
    private WebView webView;
    View view;
    private ImageButton imageButton;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        imageButton = view.findViewById(R.id.imageview);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InternetState.isConnected(getContext())) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_goToWebFragment2);
                    Toast.makeText(getActivity() , "جارى الدخول للموقع ..." , Toast.LENGTH_SHORT).show();

                } else {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_notConnectionFragment);
                }

            }
        });

        return view;
    }

    @Override
    public void onBack() {
        Intent intent = new Intent(getActivity(), SplashActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
