package com.mobility42.azurechatr;

import java.util.*;

/**
 * Represents an item in a Chat conversation
 */
public class ChatItem {

	/**
	 * Item text
	 */
	@com.google.gson.annotations.SerializedName("text")
	private String mText;

	/**
	 * Item Id
	 */
	@com.google.gson.annotations.SerializedName("id")
	private String mId;

	/**
	 * Indicates who sent the message
	 */
	@com.google.gson.annotations.SerializedName("username")
	private String mUserName;
	
	/**
	 * Indicates when the message was posted
	 */
	@com.google.gson.annotations.SerializedName("timestamp")
	private Date mTimeStamp;

	/**
	 * ChatItem constructor
	 */
	public ChatItem() {

	}

	@Override
	public String toString() {
		return getText();
	}

	/**
	 * Initializes a new ChatItem
	 * 
	 * @param text
	 *            The item text
	 * @param username
	 *            The item username
	 * @param id
	 *            The item id
	 */
	public ChatItem(String text, String username, String id) {
		this.setText(text);
		this.setUserName(username);
		this.setId(id);
	}

	/**
	 * Returns the item text
	 */
	public String getText() {
		return mText;
	}

	/**
	 * Sets the item text
	 * 
	 * @param text
	 *            text to set
	 */
	public final void setText(String text) {
		mText = text;
	}

	/**
	 * Returns the item id
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the item id
	 * 
	 * @param id
	 *            id to set
	 */
	public final void setId(String id) {
		mId = id;
	}

	/**
	 * Returns the item username
	 */
	public String getUserName() {
		return mUserName;
	}

	/**
	 * Sets the item username
	 * 
	 * @param username
	 *            username to set
	 */
	public final void setUserName(String username) {
		mUserName = username;
	}
	
	/**
	 * Returns the item TimeStamp
	 */
	public Date getTimeStamp() {
		return mTimeStamp;
	}

	/**
	 * Sets the item TimeStamp
	 * 
	 * @param timestamp
	 *            timestamp to set
	 */
	public final void setTimeStamp(Date timestamp) {
		mTimeStamp = timestamp;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof ChatItem && ((ChatItem) o).mId == mId;
	}
}
