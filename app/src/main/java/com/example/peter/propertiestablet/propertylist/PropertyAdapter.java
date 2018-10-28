package com.example.peter.propertiestablet.propertylist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.peter.propertiestablet.R;
import com.example.peter.propertiestablet.data.Property;

import java.util.List;

/**
 * Adapter for the RecyclerView which displays a list of properties
 */
public class PropertyAdapter extends RecyclerView.Adapter <PropertyAdapter.PropertyHolder> {
    private List<Property> propertyList;
    private Context context;
    private PropertyListFragment.Callbacks callbacks;


    PropertyAdapter(List<Property> propertyList, Context context, PropertyListFragment.Callbacks callbacks) {
        this.propertyList = propertyList;
        this.context = context;
        this.callbacks = callbacks;
    }

    @Override
    public int getItemViewType(int position) {
        if (!propertyList.get(position).is_premium()) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public PropertyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_property, parent, false);
        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_property_premium, parent, false);
        }
        return new PropertyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyHolder holder, int position) {
        Property prop = propertyList.get(position);

        holder.priceTextView.setText(context.getString(R.string.prefix_dollar_sign, prop.getDisplayPrice()));
        holder.descriptionTextView.setText(prop.getDescription());
        holder.numBedroomTextView.setText(String.valueOf(prop.getBedrooms()));
        holder.numBathroomTextView.setText(String.valueOf(prop.getBathrooms()));
        holder.numCarSpaceTextView.setText(String.valueOf(prop.getCarspaces()));
        holder.addressTextView.setText(prop.getAddress1());
        holder.address2TextView.setText(prop.getAddress2());
        Glide.with(context)
                .load(prop.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    class PropertyHolder extends RecyclerView.ViewHolder {

         TextView priceTextView, descriptionTextView, addressTextView, address2TextView;
         TextView numBedroomTextView, numBathroomTextView, numCarSpaceTextView;
         ImageView imageView;

        PropertyHolder(View v) {
            super(v);

            priceTextView = itemView.findViewById(R.id.text_view_price);
            descriptionTextView = itemView.findViewById(R.id.text_view_description);
            numBedroomTextView = itemView.findViewById(R.id.text_view_num_bedrooms);
            numBathroomTextView = itemView.findViewById(R.id.text_view_num_bathrooms);
            numCarSpaceTextView = itemView.findViewById(R.id.text_view_num_car_spaces);
            addressTextView = itemView.findViewById(R.id.text_view_address);
            address2TextView = itemView.findViewById(R.id.text_view_address_2);
            imageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    callbacks.onPropertySelected(propertyList.get(position));
                }
            });
        }
    }
}
