/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2017;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author louis
 */
public class Skier {

    private String itsName;
    private String itsCategory;
    private String itsGender;
    private int itsHour;
    private int itsMinute;
    private int itsSecond;

    public Skier(String itsName, String itsCategory, String itsGender, int itsHour, int itsMinute, int itsSecond) {
        this.itsName = itsName;
        this.itsCategory = itsCategory;
        this.itsGender = itsGender;
        this.itsHour = itsHour;
        this.itsMinute = itsMinute;
        this.itsSecond = itsSecond;
    }

    public String getItsName() {
        return itsName;
    }

    public String getItsCategory() {
        return itsCategory;
    }

    public String getItsGender() {
        return itsGender;
    }

    public int getItsMinute() {
        return itsMinute;
    }

    public int getItsSecond() {
        return itsSecond;
    }

    public int getItsHour() {
        return itsHour;
    }

    public Date getItsTime() throws ParseException {
        String itsTime = itsHour + ":" + itsMinute + ":" + itsSecond;
        Date time = new SimpleDateFormat("hh:mm:ss").parse(itsTime);
        return time;
    }

    public void setItsName(String itsName) {
        this.itsName = itsName;
    }

    public void setItsCategory(String itsCategory) {
        this.itsCategory = itsCategory;
    }

    public void setItsGender(String itsGender) {
        this.itsGender = itsGender;
    }

    public void setItsHour(int itsHour) {
        this.itsHour = itsHour;
    }

    public void setItsMinute(int itsMinute) {
        this.itsMinute = itsMinute;
    }

    public void setItsSecond(int itsSecond) {
        this.itsSecond = itsSecond;
    }

    @Override
    public String toString() {
        return itsName + "\t" + itsGender + "\t" + itsCategory + "\t" + itsHour
                + ":" + itsMinute + ":" + itsSecond + "\n";
    }

}
