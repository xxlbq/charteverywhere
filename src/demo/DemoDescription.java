// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package demo;


public class DemoDescription
{

    public DemoDescription(String s, String s1)
    {
        className = s;
        description = s1;
    }

    public String getClassName()
    {
        return className;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return description;
    }

    private String className;
    private String description;
}
