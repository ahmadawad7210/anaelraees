package naser.badr.ana.elraees;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by ahmed on 10/19/2017.
 */

public class ImageAdapter extends ArrayAdapter {
    private Context context;
    private Integer [] images ;
    public int pos;

    public ImageAdapter(@NonNull Context context, Integer [] images) {
        super(context,R.layout.single_image, images);

        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(R.layout.single_image, parent, false);

        ImageView image = (ImageView) item.findViewById(R.id.image);

        image.setImageResource(images[position]);
        pos = position;
        Log.v("a7a2", ""+position);

        return item;
    }

    public int currentPos(){
        return pos;
    }


}
