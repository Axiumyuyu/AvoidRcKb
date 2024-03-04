package com.axiumyu.avoidrckb;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import static com.axiumyu.avoidrckb.AxiumyuUtil.*;

public class CompressBook {
    public NamespacedKey genKey(int order){
            return new NamespacedKey("avoidrckb","book"+ order);
    }

    public ShapelessRecipe CreateShapelessRecipe(int amount, ItemStack item, ItemStack result,int order) {
        return new ShapelessRecipe(genKey(order), result).addIngredient(amount, item);
    }

    ShapelessRecipe b1 = CreateShapelessRecipe(2, book0, book1,1);

    ShapelessRecipe b2 = CreateShapelessRecipe(2, book1, book2,2);

    ShapelessRecipe b3 = CreateShapelessRecipe(2, book2, book3,3);

    ShapelessRecipe b4 = CreateShapelessRecipe(2, book3, book4,4);

    ShapelessRecipe b24 = CreateShapelessRecipe(4, book0, book2,5);

    ShapelessRecipe b34 = CreateShapelessRecipe(4, book1, book3,6);

    ShapelessRecipe b44 = CreateShapelessRecipe(4, book2, book4,7);

    ShapelessRecipe b38 = CreateShapelessRecipe(8, book0, book3,8);

    ShapelessRecipe b48 = CreateShapelessRecipe(8, book1, book4,9);

    ShapelessRecipe d1 = CreateShapelessRecipe(1, book1, genItem(Material.KNOWLEDGE_BOOK, 2),10);

    ShapelessRecipe d2 = CreateShapelessRecipe(1, book2, genItem(Material.KNOWLEDGE_BOOK, 4),11);

    ShapelessRecipe d3 = CreateShapelessRecipe(1, book3, genItem(Material.KNOWLEDGE_BOOK, 8),12);

    ShapelessRecipe d4 = CreateShapelessRecipe(1, book4, genItem(Material.KNOWLEDGE_BOOK, 16),13);

    ShapelessRecipe[] slp = {b1, b2, b3, b4, b24, b38, b34, b44, b48, d1, d2, d3, d4};

}

