package com.mobility42.azurechatr;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapter to bind a ToDoItem List to a view
 */
public class ChatItemAdapter extends ArrayAdapter<ChatItem> {

	/**
	 * Adapter context
	 */
	Context mContext;

	/**
	 * Adapter View layout
	 */
	int mLayoutResourceId;

	public ChatItemAdapter(Context context, int layoutResourceId) {
		super(context, layoutResourceId);

		mContext = context;
		mLayoutResourceId = layoutResourceId;
	}

	/**
	 * Returns the view for a specific item on the list
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		final ChatItem currentItem = getItem(position);

		if (row == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			row = inflater.inflate(mLayoutResourceId, parent, false);
		}

		row.setTag(currentItem);
		final TextView textView = (TextView) row.findViewById(R.id.textChatItem);
		textView.setText(currentItem.getUserName() + " - " + currentItem.getText());
		textView.setEnabled(true);

		return row;
	}

}
