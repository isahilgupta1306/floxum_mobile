package com.artopher.floxum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {
    EditText editText , pass ;
    TextView forgot;
    Button login;
    float v=0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment , container , false);

        pass =root.findViewById(R.id.pass);
        editText =root.findViewById(R.id.editText);
        forgot =root.findViewById(R.id.forgot);
        login =root.findViewById(R.id.login);


        pass.setTranslationX(800);
       editText.setTranslationX(800);
        forgot.setTranslationX(800);
        login.setTranslationX(800);

        editText.setAlpha(v);
       pass.setAlpha(v);
        forgot.setAlpha(v);
        login.setAlpha(v);


        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        editText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
       forgot.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();





        return root;
    }

}
