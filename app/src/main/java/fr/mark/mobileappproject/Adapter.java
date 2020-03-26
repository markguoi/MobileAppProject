package fr.mark.mobileappproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContent;
    private String[] sLinks;

    Adapter(Context context,String[] titles, String[] contents, String[] links)
    {
        this.inflater=LayoutInflater.from(context);
        this.sTitles=titles;
        this.sContent=contents;
        this.sLinks=links;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = sTitles[i];
        String content = sContent[i];
        String link = sLinks[i];
        viewHolder.songTitle.setText(title);
        viewHolder.songContent.setText(content);

    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView songTitle;
        TextView songContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Details.class);
                    //send story title and contents through recyclerview to detail activity
                    i.putExtra("linkOfSong", sLinks[getAdapterPosition()]);
                    i.putExtra("titleOfSong",sTitles[getAdapterPosition()]);
                    i.putExtra("contentOfSong",sContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            songTitle = itemView.findViewById(R.id.songTitle);
            songContent = itemView.findViewById(R.id.songContent);
        }
    }
}
