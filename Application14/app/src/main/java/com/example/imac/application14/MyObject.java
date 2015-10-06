package com.example.imac.application14;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A basic object that can be parcelled to
 * transfer between objects.
 */

public class MyObject implements Parcelable
{
    public String strValue = null;
    public int intValue = 0;

    public MyObject()
    {
    }

    /**
     *
     * Constructor to use when re-constructing object
     * from a parcel.
     *
     * @param in a parcel from which to read this object.
     */

    public MyObject(Parcel in)
    {
        readFromParcel(in);
    }

    /*
    public String getStrValue()
    {
        return this.strValue;
    }

    public void setStrValue(String strValue)
    {
        this.strValue = strValue;
    }

    public Integer getIntValue()
    {
        return this.intValue;
    }

    public void setIntValue(Integer intValue)
    {
        this.intValue = intValue;
    }
    */

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        // We just need to write each field into the
        // parcel. When we read from parcel, they
        // will come back in the same order

        dest.writeString(this.strValue);
        dest.writeInt(this.intValue);
    }

    /**
     *
     * Called from the constructor to create this
     * object from a parcel.
     *
     * @param in parcel from which to re-create object.
     */
    public void readFromParcel(Parcel in)
    {
        // We just need to read back each
        // field in the order that it was
        // written to the parcel

        this.strValue = in.readString();
        this.intValue = in.readInt();
    }

    /**
     *
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * This also means that you can use use the default
     * constructor to create the object and use another
     * method to hyrdate it as necessary.
     */
    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        @Override
        public MyObject createFromParcel(Parcel in)
        {
            return new MyObject(in);
        }

        @Override
        public Object[] newArray(int size)
        {
            return new MyObject[size];
        }
    };
}