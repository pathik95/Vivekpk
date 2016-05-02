package in.vaksys.vivekpk.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import in.vaksys.vivekpk.R;
import in.vaksys.vivekpk.pojo.Country;

/**
 * Created by dell980 on 5/2/2016.
 */
public class CountryCodeAdapter extends BaseAdapter {


    Context mContext;
    private List<Country> worldpopulationlist = null;
    private ArrayList<Country> arraylist;
    LayoutInflater inflater;


    public CountryCodeAdapter(Context context, List<Country> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Country>();
        this.arraylist.addAll(worldpopulationlist);
    }

    @Override
    public int getCount() {

        return worldpopulationlist.size();
    }

    @Override
    public Object getItem(int arg0) {
        return worldpopulationlist.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup arg2) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_row, null);
            // Locate the TextViews in listview_item.xml
            holder.code = (TextView) convertView.findViewById(R.id.code);
            holder.counryName = (TextView) convertView.findViewById(R.id.countryName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Set the results into TextViews
        holder.code.setText(worldpopulationlist.get(position).getCode());
        holder.counryName.setText(worldpopulationlist.get(position).getCoutryName());

        // Listen for ListView Item Click
        /*convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                holder.code.setText(worldpopulationlist.get(position).getCode());
            }
        });*/

        return convertView;
    }

    private static class ViewHolder {
        TextView code, counryName;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        } else {
            for (Country wp : arraylist) {
                if (wp.getCode().toLowerCase(Locale.getDefault()).contains(charText)) {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
