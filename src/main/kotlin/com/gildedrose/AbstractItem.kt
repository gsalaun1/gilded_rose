package com.gildedrose

/**
 * <p>AbstractItem</p>
 */
abstract class AbstractItem(var name: String, var sellIn: Int, var quality: Int) {

    abstract fun updateQuality()

    fun decreaseSellin() {
        this.sellIn = sellIn - 1
    }

    fun increaseQuality() {
        if (quality < 50) {
            quality = quality + 1
        }
    }

    fun decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1
        }
    }
}