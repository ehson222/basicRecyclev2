package Adapter;

import Model.ListItem;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ea222.reminderlistt4.DetailsActivity;
import com.ea222.reminderlistt4.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;
//    public adapterClickListener adapterClickListener;
//    public adapterDeleteListener adapterDeleteListener;

    public MyAdapter(Context context, List listItem) {
        this.context = context;
        this.listItems = listItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new ViewHolder(v, context, (ArrayList<ListItem>) listItems);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.name.setText(listItem.getName());
        holder.description.setText(listItem.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;
        public TextView rating;

        public ViewHolder(View view, Context ctx, ArrayList<ListItem> items) {
            super(view);
            listItems = items;
            //get the Activity Context
            context = ctx;

            view.setOnClickListener(this);

            name = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            rating = (TextView) view.findViewById(R.id.rating);

        }

        @Override
        public void onClick(View v) {
            //Get int position
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);

            //make a new Intent(a.k.a. Request) to get the context(Snapshot of object/item, in another class)
            //.putExtra is adding lines
            //context.startActivity pushes to GUI
              Intent intent = new Intent(context, DetailsActivity.class);
              intent.putExtra("name",item.getName());
              intent.putExtra("description",item.getDescription());
              intent.putExtra("rating",item.getRating());

              context.startActivity(intent);

        }
    }
}
