package com.axiumyu.avoidrckb.String;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.serializer.legacy.CharacterAndFormat.*;

public final class Strings {

    //存放Component形式字符串

    public static final Component Invalid_Number =text()
            .content("Invalid Number Format").style((Style) RED)
            .build();

    public static final Component DoNotRC =text()
            .content("请勿右键点击").style((Style) AQUA)
            .build();

    public static final Component FoolLevelLow =text()
            .content("你没有足够的体力").style((Style) YELLOW)
            .build();

    public static final Component DistanceGet =text()
            .content("物品磁铁能够吸附的距离为：").style((Style) LIGHT_PURPLE)
            .build();

    public static final Component DistanceSet =text()
            .content("物品磁铁能够吸附的距离设置为：").style((Style) LIGHT_PURPLE)
            .build();
}
