package com.example.challengefinal.growshop.utils;

import java.util.Random;

public final class NumeroOrden {

    private NumeroOrden(){}

    public static Random randomNumber = new Random();

    public static String getRandomNum() {
        int randomNum = randomNumber.nextInt(900000);
        String formatRandomNum = "GozoGrowShop" + String.format("%04d", randomNum);
        return formatRandomNum;
    }
}
