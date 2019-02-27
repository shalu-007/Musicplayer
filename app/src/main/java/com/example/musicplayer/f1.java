package com.example.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class f1  extends Fragment {
    buttonClicked mButtonClicked;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mButtonClicked=(buttonClicked)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f1,container,false);
    }
    EditText t1,t2;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t1=view.findViewById(R.id.ed1);
        t2=view.findViewById(R.id.ed2);
        Button sub=view.findViewById(R.id.submit);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=t1.getText().toString();
                mButtonClicked.sendText(name);
            }
        });
    }
    public interface buttonClicked{
        void sendText(String text);
    }

}
