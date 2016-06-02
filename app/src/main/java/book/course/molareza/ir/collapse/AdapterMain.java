package book.course.molareza.ir.collapse;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Home on 5/20/2016.
 */
public class AdapterMain extends ArrayAdapter<StructMain> {

    public AdapterMain(ArrayList<StructMain> items) {
        super(G.context, R.layout.adapter_main, items);
    }

    public class ViewHolder {

        private ImageView imgPic;
        private TextView txtName;
        private ProgressBar pBar;

        public ViewHolder(View view) {

            imgPic = (ImageView) view.findViewById(R.id.imgPic);
            txtName = (TextView) view.findViewById(R.id.txtName);
            pBar = (ProgressBar) view.findViewById(R.id.pBarAdapterMain);


        }

        public void fill(ArrayAdapter<StructMain> adapter, StructMain item, int position) {

            txtName.setText(item.name);
            pBar.setVisibility(View.VISIBLE);


            if (item.image != null) {

                imgPic.setImageBitmap(item.image);
                pBar.setVisibility(View.GONE);
            } else {

                imgPic.setImageResource(R.mipmap.not_found3);

            }

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        StructMain item = getItem(position);

        if (convertView == null) {

            convertView = G.inflater.inflate(R.layout.adapter_main, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(this, item, position);
        return convertView;
    }
}
