package com.epam.randomWalk.walk;

import java.util.ArrayList;

public class multipleWalkDto {
    ArrayList<walkDto> walks;

    public multipleWalkDto() {
         walks = new ArrayList<>();
    }

    public ArrayList<walkDto> getWalks() {
        return walks;
    }

    public void setWalks(ArrayList<walkDto> walks) {
        this.walks = walks;
    }
}
