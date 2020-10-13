package com.artopher.floxum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class SignupTabFragment extends Fragment {

    TextView name , username , password , password_again;
    Button signup_button;
    float v=0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment , container , false);

        //Hooks
        name=root.findViewById(R.id.name);
        username=root.findViewById(R.id.username);
        password=root.findViewById(R.id.password);
        password_again=root.findViewById(R.id.passwordAgain);
        signup_button=root.findViewById(R.id.signup);

        //Animations

        name.setTranslationX(800);
        username.setTranslationX(800);
        password.setTranslationX(800);
        password_again.setTranslationX(800);
        signup_button.setTranslationX(800);

        name.setAlpha(v);
        username.setAlpha(v);
        password.setAlpha(v);
        password_again.setAlpha(v);
        signup_button.setAlpha(v);

        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        username.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password_again.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        signup_button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();



        return root;
    }

}
