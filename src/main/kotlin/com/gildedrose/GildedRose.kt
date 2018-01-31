package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (!isSulfuras(item)) {
                if (isBrie(item)) {
                    updateQualityForBrie(item)
                } else if (isBackstagePass(item)) {
                    updateQualityForBackstagePass(item)
                } else {
                    updateQualityCommon(item)
                }
            }
        }
    }

    private fun updateQualityCommon(item: Item) {
        decreaseQuality(item)
        decreaseSellIn(item)
        if (itemExpired(item)) {
            decreaseQuality(item)
        }
    }

    private fun updateQualityForBrie(item: Item) {
        increaseQuality(item)
        decreaseSellIn(item)
        if (itemExpired(item)) {
            increaseQuality(item)
        }
    }

    private fun itemExpired(item: Item) = item.sellIn < 0

    private fun updateQualityForBackstagePass(item: Item) {
        increaseQuality(item)
        if (item.sellIn < 11) {
            increaseQuality(item)
        }
        if (item.sellIn < 6) {
            increaseQuality(item)
        }
        decreaseSellIn(item)
        if (itemExpired(item)) {
            item.quality = 0
        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun decreaseQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    private fun increaseQuality(item: Item) {
        if (itemBelowMaxQuality(item)) {
            item.quality = item.quality + 1
        }
    }

    private fun itemBelowMaxQuality(item: Item) = item.quality < 50

    private fun isSulfuras(item: Item) = item.name.equals("Sulfuras, Hand of Ragnaros")

    private fun isBackstagePass(item: Item) = item.name.equals("Backstage passes to a TAFKAL80ETC concert")

    private fun isBrie(item: Item) = item.name.equals("Aged Brie")

}