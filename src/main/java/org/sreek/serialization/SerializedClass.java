package org.sreek.serialization;

import java.io.Serial;
import java.io.Serializable;

public class SerializedClass implements Serializable {

    @Serial
    private static final long serialVersionUID = 4800303586101587186L;

    private String value;

    private Integer number;

    private Boolean trueOrFalse;

    private SubSerializedClass subSerializedClass;

    public SerializedClass() {
    }

    public SerializedClass(String value, Integer number, Boolean trueOrFalse, SubSerializedClass subSerializedClass) {
        this.value = value;
        this.number = number;
        this.trueOrFalse = trueOrFalse;
        this.subSerializedClass = subSerializedClass;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public SubSerializedClass getSubSerializedClass() {
        return subSerializedClass;
    }

    public void setSubSerializedClass(SubSerializedClass subSerializedClass) {
        this.subSerializedClass = subSerializedClass;
    }

    @Override
    public String toString() {
        return "SerializedClass{" +
                "value='" + value + '\'' +
                ", number=" + number +
                ", trueOrFalse=" + trueOrFalse +
                ", subSerializedClass=" + subSerializedClass +
                '}';
    }
}
