package book.course.molareza.ir.collapse;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FragPage1 extends Fragment {

    private ProgressBar pBarMain;
    private Toolbar toolbar;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private int page = 0;
    private int up = 0;

    private RecyclerView rcvContent;
    private List<StructMain> items = new ArrayList<>();
    private AdapterRcv adapterRcv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_page1, container, false);


        pBarMain = (ProgressBar) view.findViewById(R.id.pBarFrag1);
        pBarMain.setVisibility(View.VISIBLE);

//        lstContent = (ListView) findViewById(R.id.lstContent);
//        adapterMain = new AdapterMain(items);
//        lstContent.setAdapter(adapterMain);
//        setItems();


        rcvContent = (RecyclerView) view.findViewById(R.id.rcvContent);
        adapterRcv = new AdapterRcv(items);
        rcvContent.setAdapter(adapterRcv);
        rcvContent.setLayoutManager(new LinearLayoutManager(G.context));
        setItems();

        return view;
    }

    private void setItems() {

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, G.URL_IMAGE_JSON + page, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("haram");

                    if (array != null) {

                        for (int i = 0; i < array.length(); i++) {

                            StructMain item = new StructMain();
                            JSONObject object = array.getJSONObject(i);

                            item.id = object.getString("id");
                            item.name = object.getString("name");
                            item.urlImage = object.getString("image");

                            imageDownloader(item.urlImage, up);
                            up++;

                            items.add(item);

                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                pBarMain.setVisibility(View.INVISIBLE);
                page++;
                adapterRcv.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(G.context).add(objectRequest);

    }

    private void imageDownloader(String urlImage, final int id) {

        ImageRequest imageRequest = new ImageRequest(urlImage, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                adapterRcv.items.get(id).image = response;
                adapterRcv.notifyDataSetChanged();

            }
        }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    copy();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //   adapterMain.getItem(id).image = BitmapFactory.decodeFile(G.IMAGE_PATH + "/" + "not_found2.jpg");
                adapterRcv.items.get(id).image = BitmapFactory.decodeFile(G.IMAGE_PATH + "/" + "not_found2.jpg");
                adapterRcv.notifyDataSetChanged();

            }
        });

        Volley.newRequestQueue(G.context).add(imageRequest);

    }

    private void copy() throws IOException {


        InputStream inputStream = G.context.getAssets().open("not_found2.jpg");

        String path = G.IMAGE_PATH + "/" + "not_found2.jpg";

        FileOutputStream outputStream = new FileOutputStream(path);

        byte[] buffer = new byte[1024];

        int lay;

        while ((lay = inputStream.read(buffer)) > 0) {

            outputStream.write(buffer, 0, lay);
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();

    }
}