package com.example.demo.listener;

import org.springframework.batch.core.SkipListener;

public class CustomSkipListener implements SkipListener {
    @Override
    public void onSkipInRead(Throwable throwable) {
        System.out.println("skipped something");
    }

    @Override
    public void onSkipInWrite(Object item, Throwable throwable) {
        System.out.println("skipped: " + item +" | caused error in writing");

    }

    @Override
    public void onSkipInProcess(Object item, Throwable throwable) {
        System.out.println("skipped: " + item + " | caused error in processing");

    }
}
