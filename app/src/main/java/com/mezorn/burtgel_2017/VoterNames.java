package com.mezorn.burtgel_2017;

import java.io.Serializable;

/**
 * Created by manlai on 5/25/17.
 */


public class VoterNames implements Serializable{
    private String voterName;

    public VoterNames(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterName() {
        return this.voterName;
    }

}
