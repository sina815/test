package book.course.molareza.ir.collapse;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import java.io.File;


public class G extends Application {

    public static Context context;
    public static Activity currentActivity;
    public static LayoutInflater inflater;

    public static final String URL_IMAGE_JSON = "http://shohada.molareza.ir/index.php?page=";
    public static final String IMAGE_PATH = "data/data/book.course.molareza.ir.collapse/images";


    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        new File(IMAGE_PATH).mkdirs();
    }
}
