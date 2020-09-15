package com.ddnshop.rolesservice.models;

public class RolesConfiguration {
    int maxium;
    int minium;

    public RolesConfiguration(int maxium, int minium) {
        this.maxium = maxium;
        this.minium = minium;
    }
    public RolesConfiguration(){}

    public int getMaxium() {
        return maxium;
    }

    public int getMinium() {
        return minium;
    }

}
