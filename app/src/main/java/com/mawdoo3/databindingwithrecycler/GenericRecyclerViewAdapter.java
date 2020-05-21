package com.mawdoo3.databindingwithrecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public  class GenericRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<T> myList;
    private int resource;




    public GenericRecyclerViewAdapter(List<T> myList, int resource) {
        this.myList = myList;
        this.resource = resource;
    }





    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        LayoutInflater layoutInflater =
                LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, resource, viewGroup, false);


        return new MyHolder(binding);


    }

    public T getItem(int position) {
        return myList.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object obj = myList.get(position);
        ((MyHolder) holder).bind(obj);


    }



    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public MyHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.obj, obj);
            binding.executePendingBindings();
        }
    }
}


