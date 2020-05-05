package com.silent.main;

import com.silent.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TestSplit {

    public static void main(String[] args) {
        String actualIds = "8952890081";

        String[] idList = actualIds.split(",");
        List<String> list = new ArrayList<String>();

        actualIds = null;
        System.out.println((String) actualIds);

//        for (String actualId : idList) {
//            list.add(actualId);
//            System.out.println(actualId);
//
//        }
    }
}
