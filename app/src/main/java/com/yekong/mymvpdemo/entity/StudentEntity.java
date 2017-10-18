package com.yekong.mymvpdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.yekong.common.baseentity.BaseEntity;

/**
 * Created by xigua on 2017/10/18.
 */

public class StudentEntity extends BaseEntity implements Parcelable {
    private String sName;
    private int sAge;
    private String sAvatar;
    private int sSex;
    private int[] sClass;

    public StudentEntity(String sName, int sAge, String sAvatar, int sSex, int[] sClass) {
        this.sName = sName;
        this.sAge = sAge;
        this.sAvatar = sAvatar;
        this.sSex = sSex;
        this.sClass = sClass;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public int getsSex() {
        return sSex;
    }

    public void setsSex(int sSex) {
        this.sSex = sSex;
    }

    public int[] getsClass() {
        return sClass;
    }

    public void setsClass(int[] sClass) {
        this.sClass = sClass;
    }

    public String getsAvatar() {
        return sAvatar;
    }

    public void setsAvatar(String sAvatar) {
        this.sAvatar = sAvatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sName);
        dest.writeInt(this.sAge);
        dest.writeString(this.sAvatar);
        dest.writeInt(this.sSex);
        dest.writeIntArray(this.sClass);
    }

    public StudentEntity() {
        sClass = new int[2];
    }

    protected StudentEntity(Parcel in) {
        this.sName = in.readString();
        this.sAge = in.readInt();
        this.sAvatar = in.readString();
        this.sSex = in.readInt();
        this.sClass = in.createIntArray();
    }

    public static final Parcelable.Creator<StudentEntity> CREATOR = new Parcelable.Creator<StudentEntity>() {
        public StudentEntity createFromParcel(Parcel source) {
            return new StudentEntity(source);
        }

        public StudentEntity[] newArray(int size) {
            return new StudentEntity[size];
        }
    };
}
