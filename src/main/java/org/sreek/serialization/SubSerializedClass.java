package org.sreek.serialization;

import java.io.Serial;
import java.io.Serializable;

public class SubSerializedClass implements Serializable {

    @Serial
    private static final long serialVersionUID = -4446176380245386056L;
    private String subString;

    private Long longValue;

    public SubSerializedClass() {
    }

    public SubSerializedClass(String subString, Long longValue) {
        this.subString = subString;
        this.longValue = longValue;
    }

    public String getSubString() {
        return subString;
    }

    public void setSubString(String subString) {
        this.subString = subString;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    @Override
    public String toString() {
        return "SubSerializedClass{" +
                "subString='" + subString + '\'' +
                ", longValue=" + longValue +
                '}';
    }
}
