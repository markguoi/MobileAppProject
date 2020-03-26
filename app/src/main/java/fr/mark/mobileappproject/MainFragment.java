package fr.mark.mobileappproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        //get the list of song titles and lyrics in the string array
        String[] titles = getResources().getStringArray(R.array.song_titles);
        String[] contents = getResources().getStringArray(R.array.song_content);
        String[] links = getResources().getStringArray(R.array.song_links);
        recyclerView = view.findViewById(R.id.songListsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), titles, contents, links);
        recyclerView.setAdapter(adapter);
        return view;
    }
}