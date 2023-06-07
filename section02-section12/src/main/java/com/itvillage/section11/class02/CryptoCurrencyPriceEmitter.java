package com.itvillage.section11.class02;

import com.itvillage.common.SampleData;

public class CryptoCurrencyPriceEmitter {
    private CryptoCurrencyPriceListener listener;

    public void setListener(CryptoCurrencyPriceListener listener) {
        this.listener = listener;
    }

    public void flowInto() {
        listener.onPrice(SampleData.btcPrices);
    }
    public void complete() {
        listener.onComplete();
    }
}
