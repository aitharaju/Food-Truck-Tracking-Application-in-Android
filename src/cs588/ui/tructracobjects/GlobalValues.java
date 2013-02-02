package cs588.ui.tructracobjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GlobalValues 
{
public static double lat=34.032959;
public static double lng=-118.288636;
private static GlobalValues instance=new GlobalValues();
public static GlobalValues getInstance()
{
return instance;
}
public static HashMap<String,List> hm=new HashMap<String,List>();
public static List<Truck> favorites=new LinkedList<Truck>();

}
