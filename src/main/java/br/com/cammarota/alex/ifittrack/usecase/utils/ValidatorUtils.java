package br.com.cammarota.alex.ifittrack.usecase.utils;

import java.math.BigDecimal;

public class ValidatorUtils {

    private ValidatorUtils(){

    }

    public static BigDecimal checkNullAndSubtract(BigDecimal anterior, BigDecimal atual){
        if(anterior == null){
            return BigDecimal.ZERO;
        }
        return atual.subtract(anterior);
    }

    public static Integer checkNullAndSubtract(Integer anterior, Integer atual){
        if(anterior == null){
            return 0;
        }
        return atual - anterior;
    }
}
