package com.ttc.polytechnicshiksha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.List;

public class PlacementListAdaptre extends ArrayAdapter<placement_Hero> {
    List<placement_Hero> heroList1;
    Context context;
    Button delete_btn;

    //the layout resource file for the list items
    int resource;
    ListView listView;
    private CardView cardview6;

    public PlacementListAdaptre(Context context, int resource, List<placement_Hero> heroList1) {
        super(context, resource, heroList1);
        this.context = context;
        this.resource = resource;
        this.heroList1 = heroList1;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        delete_btn = (Button)view.findViewById(R.id.delete_btn);
        TextView textViewCollegeName = (TextView)view.findViewById(R.id.tvcollegename);
        TextView textViewCompanyName = (TextView)view.findViewById(R.id.tvcompanyname);
        TextView textViewCompanyAdd = (TextView)view.findViewById(R.id.tvcompanyaddress);
        cardview6=(CardView)view.findViewById(R.id.card_view6);
        //getting the hero of the specified position
        final placement_Hero hero = heroList1.get(position);

        //adding values to the list item
        textViewCollegeName.setText(hero.getCollege_name());
        textViewCompanyName.setText("COMPANY NAME:- "+hero.getCompany_name());
        textViewCompanyAdd.setText("COMPANY ADDRESS:- "+hero.getCompany_address());

        return view;
    }
}
