package com.github.hiapk.easycdk.entiy;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class EasyCdkConfig {
    private int step;
    private Array watchFileSuffix;
    private boolean autoUpdate;
}
