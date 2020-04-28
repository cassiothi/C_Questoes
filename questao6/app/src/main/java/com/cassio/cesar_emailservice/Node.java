package com.cassio.cesar_emailservice;

import android.os.Parcel;
import android.os.Parcelable;

public class Node implements Parcelable {
    String email;
    Node next;

    public Node(String email)
    {
        this.email = email;
    }

    protected Node(Parcel in) {
        email = in.readString();
        next = in.readParcelable(Node.class.getClassLoader());
    }

    public static final Creator<Node> CREATOR = new Creator<Node>() {
        @Override
        public Node createFromParcel(Parcel in) {
            return new Node(in);
        }

        @Override
        public Node[] newArray(int size) {
            return new Node[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeParcelable(next, flags);
    }
}
