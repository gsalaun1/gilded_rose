package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {


            //A modifier
            val max_quality = 50
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        decrementQuality(items[i])
                    }
                }
            } else {
                if (items[i].quality < max_quality) {
                    incrementQuality(items[i])
                }
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < max_quality) {
                            incrementQuality(items[i])
                        }
                    }

                    if (items[i].sellIn < 6) {
                        if (items[i].quality < max_quality) {
                            incrementQuality(items[i])
                        }
                    }
                }

            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                decrementQuality(items[i])
                            }
                        }
                    } else {
                        items[i].quality = 0
                    }
                } else {
                    if (items[i].quality < max_quality) {
                        incrementQuality(items[i])
                    }
                }
            }


        }
    }

    fun incrementQuality(item: Item) {
        item.quality = item.quality + 1
    }

    fun decrementQuality(item: Item) {
        item.quality = item.quality - 1
    }

}

