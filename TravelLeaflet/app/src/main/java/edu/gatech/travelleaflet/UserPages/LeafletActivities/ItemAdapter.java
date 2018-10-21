package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import edu.gatech.travelleaflet.Models.Item;
import edu.gatech.travelleaflet.R;

public class ItemAdapter extends ArrayAdapter<Item> {
    private List<Item> itemList;
    private Context context;

    public ItemAdapter(List<Item> itemList, Context context) {
        super(context, R.layout.checklist_item, itemList);
        this.itemList = itemList;
        this.context = context;
    }

    private static class ItemHolder {
        public TextView itemName;
        public TextView countView;
        public CheckBox chkBox;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ItemHolder holder = new ItemHolder();
        final Item i = itemList.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.checklist_item, null);

            holder.itemName = (TextView) v.findViewById(R.id.name);
            holder.countView = (TextView) v.findViewById(R.id.count);
            holder.chkBox = (CheckBox) v.findViewById(R.id.chk_box);

            holder.chkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i.setChecked(!i.isChecked());
                }
            });
        } else {
            holder = (ItemHolder) v.getTag();
        }

        holder.itemName.setText(i.getName());
        holder.countView.setText(i.getQuantity());
        holder.chkBox.setChecked(i.isChecked());
        holder.chkBox.setTag(i);

        return v;
    }
}
