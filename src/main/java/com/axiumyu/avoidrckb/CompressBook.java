package com.axiumyu.avoidrckb;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import static com.axiumyu.avoidrckb.AxiumyuUtil.*;

public class CompressBook {

    static NamespacedKey nas = new NamespacedKey(AvoidRcKb.instance, "a_shapeless_rec");
    static ShapelessRecipe b1 =CreateShapelessRecipe(2,book0,book1);

    static ShapelessRecipe b2 =CreateShapelessRecipe(2,book1,book2);

    static ShapelessRecipe b3 =CreateShapelessRecipe(2,book2,book3);

    static ShapelessRecipe b4 =CreateShapelessRecipe(2,book3,book4);
    static ShapelessRecipe b24 =CreateShapelessRecipe(4,book0,book2);

    static ShapelessRecipe b34 = CreateShapelessRecipe(4,book1,book3);

    static ShapelessRecipe b44 = CreateShapelessRecipe(4,book2,book4);

    static ShapelessRecipe b38 =CreateShapelessRecipe(8,book0,book3);

    static ShapelessRecipe b48 = CreateShapelessRecipe(8,book1,book4);

    static ShapelessRecipe d1 = CreateShapelessRecipe(1,book1,genItem(Material.KNOWLEDGE_BOOK,2));

    static ShapelessRecipe d2 = CreateShapelessRecipe(1,book2,genItem(Material.KNOWLEDGE_BOOK,4));

    static ShapelessRecipe d3 = CreateShapelessRecipe(1,book1,genItem(Material.KNOWLEDGE_BOOK,8));

    static ShapelessRecipe d4 = CreateShapelessRecipe(1,book1,genItem(Material.KNOWLEDGE_BOOK,16));

    static ShapelessRecipe[] slp={b1,b2,b3,b4,b24,b38,b34,b44,b48,d1,d2,d3,d4};


    public static ShapelessRecipe CreateShapelessRecipe(int amount, ItemStack item,ItemStack result) {
        return new ShapelessRecipe(nas, result).addIngredient(amount, item);
    }
}

