package asquero.com.myapplication;

import android.support.v7.widget.RecyclerView;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Anmol on 10-Apr-18.
 */

public class LiveListAdapter extends RecyclerView.Adapter<LiveListAdapter.ViewHolder> {

    private static final String TAG = "myactivity";
    private List<LiveList>list;
    private Context context;

    //DotProgressBar dotProgressBar = (DotProgressBar) View.findViewById(R.id.dot_progress_bar);



    public LiveListAdapter(List<LiveList> listLive, Live live) {
        this.list = listLive;
        this.context = live;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.live_list_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LiveList listItem = list.get(position);

        String cc = listItem.getContestCode();
        String cn = listItem.getContestName();
        String cs = listItem.getStartDate();
        String ce = listItem.getEndDate();
        String csrc = listItem.getContestSource();

        String url = listItem.getImageUrl();

        holder.contestCode.setText(""+cc);
        holder.contestName.setText(cn);
        holder.endDate.setText(""+(cs));
        holder.startDate.setText(""+(ce));
        holder.contestSourceImg.setImageResource(listItem.getContestSourceImg());
        holder.aic.setText(listItem.getAIC());
        holder.progressBar.setVisibility(View.VISIBLE);
        holder.contestSource.setText("Source: "+csrc);
        //String url = "https://edsurge.imgix.net/uploads/post/image/7747/Kids_coding-1456433921.jpg?auto=compress%2Cformat&w=2000&h=810&fit=crop";

        try {

            Picasso.get().load(""+url).into(holder.imageView);
            holder.progressBar.setVisibility(View.INVISIBLE);
        }
        catch (Exception e){

            e.printStackTrace();
            //Picasso.get().load(url).placeholder(R.drawable.upcoming).error(R.drawable.ended).into(holder.imageView);
            holder.progressBar.setVisibility(View.INVISIBLE);
            holder.imageView.setImageResource(R.drawable.ended);

        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView contestCode;
        public TextView contestName;
        public TextView endDate;
        public TextView startDate;
        public ImageView contestSourceImg;
        public ImageView imageView;
        public TextView aic;
        public TextView contestSource;
        public ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            contestCode = (TextView)itemView.findViewById(R.id.contestCode);
            contestName = (TextView)itemView.findViewById(R.id.contestName);
            endDate = (TextView)itemView.findViewById(R.id.startDateNum);
            startDate = (TextView)itemView.findViewById(R.id.endDateNum);
            contestSourceImg = (ImageView)itemView.findViewById(R.id.contestSourceImage);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBarImage);
            aic = (TextView)itemView.findViewById(R.id.AICTextView);
            contestSource = (TextView)itemView.findViewById(R.id.contestSource);
        }
    }
}
