package com.lokesh.loginsignup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lokesh.loginsignup.R;
import com.lokesh.loginsignup.database.notesEntity;
import com.lokesh.loginsignup.database.userEntity;

import java.util.Date;
import java.util.List;

public class notesViewAdapter extends ArrayAdapter<notesEntity> {
    private Context context;

    Date date = new Date();

    LinearLayout notes_layout;
    EditText edit_notes_title,edit_notes_description;
    TextView date_view;


    public notesViewAdapter(Context context, List<notesEntity> data) {
        super(context, 0, data);
        this.context = context;
        data.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.notes_list_row, parent, false);
        }

        notes_layout = convertView.findViewById(R.id.notes_layout);
        edit_notes_title = convertView.findViewById(R.id.edit_notes_title);
        edit_notes_description = convertView.findViewById(R.id.edit_notes_description);
        date_view = convertView.findViewById(R.id.date_view);
        notesEntity dataItem = getItem(position);

        if (dataItem!= null) {
            edit_notes_title.setText(dataItem.getTitle());
            edit_notes_description.setText(dataItem.getDescription());
            date_view.setText(dataItem.getDate());

        }
        return convertView;

    }



}
