package com.northcoders.databindingdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.R;
import com.example.databinding.databinding.ListItemPersonBinding;
import com.northcoders.databindingdemo.model.Person;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private final Context context;
    private final List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemPersonBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(
                    LayoutInflater.from(context),
                    R.layout.list_item_person,
                    parent,
                    false
            );
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListItemPersonBinding) convertView.getTag();
        }

        Person person = personList.get(position);
        binding.setPerson(person); // Bind the data
        return convertView;
    }
}
