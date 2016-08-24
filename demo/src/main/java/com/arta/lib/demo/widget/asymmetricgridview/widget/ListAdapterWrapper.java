package com.arta.lib.demo.widget.asymmetricgridview.widget;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.WrapperListAdapter;

import com.arta.lib.demo.R;
import com.arta.lib.demo.widget.asymmetricgridview.model.DemoItem;
import com.arta.lib.widget.asymmetricgridview.library.Utils;
import com.arta.lib.widget.asymmetricgridview.library.widget.AsymmetricGridView;
import com.arta.lib.widget.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;

// Here is a sample of how you could use your own adapter and implement
// the WrapperListAdapter interface to wrap the asymmetric grid adapter.
// Use this for a more customizable setup, if you can't extend from
// AsymmetricGridViewAdapter (typically if you already have a custom base adapter class).
public class ListAdapterWrapper extends ArrayAdapter<DemoItem> implements WrapperListAdapter {

    private final AsymmetricGridViewAdapter<DemoItem> wrappedAdapter;

    public ListAdapterWrapper(final Context context,
                              final AsymmetricGridView listView,
                              final List<DemoItem> items) {
        super(context, 0, items);

        wrappedAdapter = new AsymmetricGridViewAdapter<DemoItem>(context, listView, items) {
            @Override
            public View getActualView(int position, View convertView, ViewGroup parent) {
                return ListAdapterWrapper.this.getView(position, convertView, parent);
            }
        };
    }

    @Override
    @SuppressWarnings("deprecation")
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        TextView v;

        DemoItem item = getItem(position);

        if (convertView == null) {
            v = new TextView(getContext());
            v.setGravity(Gravity.CENTER);
            v.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.asymmetricgridview_text_view_background_selector));
            v.setTextColor(Color.parseColor("#ffffff"));
            v.setTextSize(Utils.dpToPx(getContext(), 18));
            v.setId(item.getPosition());
        } else
            v = (TextView) convertView;

        v.setText(String.valueOf(item.getPosition()));

        return v;
    }

    @Override public android.widget.ListAdapter getWrappedAdapter() {
        return wrappedAdapter;
    }
}
