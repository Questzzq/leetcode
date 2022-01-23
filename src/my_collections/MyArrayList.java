package my_collections;

import java.util.ArrayList;
import java.util.Collections;

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Taobao");
        sites.add("Wiki");
        sites.add("Runoob");
        sites.add("Weibo");
        sites.add("Google");
        Collections.sort(sites);
        for(String site: sites) {
            System.out.println(site);
        }
    }
}
