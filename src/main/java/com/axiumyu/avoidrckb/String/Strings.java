package com.axiumyu.avoidrckb.String;

import net.kyori.adventure.text.Component;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;

public final class Strings {

    //存放Component形式字符串

    public static final Component Invalid_Number =text()
            .content("Invalid Number Format").color(color(0xC1001C))
            .build();

    public static final Component DoNotRC =text()
            .content("请勿右键点击").color(color(0xE6F83C))
            .build();

    public static final Component FoolLevelLow =text()
            .content("你没有足够的体力").color(color(0xE6F83C))
            .build();

    public static final Component DistanceGet =text()
            .content("物品磁铁能够吸附的距离为：").color(color(0x84FFEC))
            .build();

    public static final Component DistanceSet =text()
            .content("物品磁铁能够吸附的距离设置为：").color(color(0xFA40))
            .build();
}
