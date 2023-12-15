package org.sreek.serialization;

import java.io.Serial;
import java.io.Serializable;

public class ChildClass extends ParentClass  {

    private String childString;

    private Float childFloat;

    private transient Integer testTransientInt;

    public ChildClass() {
    }

    public ChildClass(String childString, Float childFloat, Integer testTransientInt) {
        this.childString = childString;
        this.childFloat = childFloat;
        this.testTransientInt = testTransientInt;
    }

    public String getChildString() {
        return childString;
    }

    public void setChildString(String childString) {
        this.childString = childString;
    }

    public Float getChildFloat() {
        return childFloat;
    }

    public void setChildFloat(Float childFloat) {
        this.childFloat = childFloat;
    }

    public Integer getTestTransientInt() {
        return testTransientInt;
    }

    public void setTestTransientInt(Integer testTransientInt) {
        this.testTransientInt = testTransientInt;
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "childString='" + childString + '\'' +
                ", childFloat=" + childFloat +
                ", testTransientInt=" + testTransientInt +
                '}';
    }
}
