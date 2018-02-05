package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (isSulfuras(item)) {

            } else if (isAgedBrie(item)) {
                increaseQuality(item)
                decreaseSellin(item)
                if (item.sellIn < 0) {
                    increaseQuality(item)
                }
            } else if (isBackstagePasses(item)) {
                increaseQuality(item)
                if (item.sellIn < 11) {
                    increaseQuality(item)
                }
                if (item.sellIn < 6) {
                    increaseQuality(item)
                }
                decreaseSellin(item)
                if (item.sellIn < 0) {
                    item.quality = 0
                }
            } else {
                decreaseQuality(item)
                decreaseSellin(item)
                if (item.sellIn < 0) {
                    decreaseQuality(item)
                }
            }
        }
    }

    private fun decreaseSellin(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

    private fun decreaseQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    private fun isSulfuras(item: Item) = item.name.equals("Sulfuras, Hand of Ragnaros")

    private fun isBackstagePasses(item: Item) = item.name.equals("Backstage passes to a TAFKAL80ETC concert")

    private fun isAgedBrie(item: Item) = item.name.equals("Aged Brie")

}

