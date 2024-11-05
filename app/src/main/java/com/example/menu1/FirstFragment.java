package com.example.menu1;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_first, container, false);

        textView = view.findViewById(R.id.text_view);
        registerForContextMenu(textView);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Меняйте");
        menu.add(0, 0, 0, "лялял");
        menu.add(0, 1, 0, "гага");
        menu.add(0, 2, 0, "блабла");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                textView.setText("лялял");
                return true;
            case 1:
                textView.setText("гага");
                return true;
            case 2:
                textView.setText("блабла");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
