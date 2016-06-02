package book.course.molareza.ir.collapse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;


public class AdapterRcv extends RecyclerView.Adapter<AdapterRcv.ViewHolder> {

    public List<StructMain> items;

    public AdapterRcv(List<StructMain> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        StructMain item = items.get(position);

        holder.txtName.setText(item.name);
        holder.pBar.setVisibility(View.VISIBLE);


        if (item.image != null) {

            holder.imgPic.setImageBitmap(item.image);
            holder.pBar.setVisibility(View.GONE);
        } else {

            holder.imgPic.setImageResource(R.mipmap.not_found3);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPic;
        private TextView txtName;

        private ProgressBar pBar;

        public ViewHolder(View view) {
            super(view);

            imgPic = (ImageView) view.findViewById(R.id.imgPic);
            txtName = (TextView) view.findViewById(R.id.txtName);
            pBar = (ProgressBar) view.findViewById(R.id.pBarAdapterMain);

        }
    }
}
