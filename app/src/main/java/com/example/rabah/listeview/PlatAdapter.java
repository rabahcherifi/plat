package com.example.rabah.listeview;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;



public class PlatAdapter extends ArrayAdapter<Plat> {
    private TextView nom;
    private TextView prix;
    private ImageView image;



    public List<Plat> plats;

    public PlatAdapter(Context context, List<Plat> plats) {
        super(context, 0, plats);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_plat, parent, false);
        }
        final Plat plat = getItem(position);
        PlatViewHolder viewHolder = (PlatViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new PlatViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.textView4);
            viewHolder.prix = (TextView) convertView.findViewById(R.id.textView3);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);

            Button b = (Button) convertView.findViewById(R.id.button);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Context context = v.getContext();


                    Intent intent=new Intent(context,DeailPlatActivity.class);
                    intent.putExtra("plat",  plat);


                    context.startActivity(intent);

                }

            });
            convertView.setTag(viewHolder);
        }




        viewHolder.nom.setText(plat.getNom());
        viewHolder.prix.setText(plat.getPrix());


        int[] image = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        viewHolder.image.setImageResource(image[position]);
        return convertView;
    }



    private class PlatViewHolder {
        public TextView nom;
        public TextView prix;
        public ImageView image;


    }








}