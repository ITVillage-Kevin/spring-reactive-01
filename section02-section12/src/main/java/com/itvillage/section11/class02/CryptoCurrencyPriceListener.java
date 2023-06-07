package com.itvillage.section11.class02;

import java.util.List;

public interface CryptoCurrencyPriceListener {
    void onPrice(List<Integer> priceList);
    void onComplete();
}
