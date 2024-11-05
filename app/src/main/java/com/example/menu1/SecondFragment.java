package com.example.menu1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private TextView gameCountTextView;
    private Button increaseButton;
    private int gameCount = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        gameCountTextView = view.findViewById(R.id.game_count_text_view);
        increaseButton = view.findViewById(R.id.increase_button);
        increaseButton.setOnClickListener(v -> {
            gameCount++;
            updateGameCountText();
        });

        updateGameCountText();
        return view;
    }

    private void updateGameCountText() {
        gameCountTextView.setText("Игр сыграно: " + gameCount);
    }
}
