package cloud.lemonslice.afterthedrizzle.data.provider;

import cloud.lemonslice.afterthedrizzle.common.block.BlocksRegistry;
import cloud.lemonslice.afterthedrizzle.common.item.ItemsRegistry;
import cloud.lemonslice.afterthedrizzle.data.tag.NormalTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;

import static cloud.lemonslice.afterthedrizzle.data.tag.NormalTags.Items.*;
import static net.minecraft.item.Items.*;

public class NormalItemTagsProvider extends ItemTagsProvider
{
    public NormalItemTagsProvider(DataGenerator gen)
    {
        super(gen);
    }

    @Override
    protected void registerTags()
    {
        getBuilder(NormalTags.Items.DIRT).add(Blocks.DIRT.asItem(), COARSE_DIRT.asItem(), GRASS_BLOCK.asItem(), MYCELIUM.asItem(), PODZOL.asItem());
        getBuilder(FOOD_JERKY).add(ItemsRegistry.BEEF_JERKY, ItemsRegistry.PORK_JERKY, ItemsRegistry.CHICKEN_JERKY, ItemsRegistry.RABBIT_JERKY, ItemsRegistry.MUTTON_JERKY);
        getBuilder(FOOD_MEAT).add(FOOD_JERKY).add(RABBIT, PORKCHOP, BEEF, MUTTON, CHICKEN);
        getBuilder(ItemTags.SMALL_FLOWERS).add(BlocksRegistry.CHRYSANTHEMUM_ITEM, BlocksRegistry.HYACINTH_ITEM, BlocksRegistry.ZINNIA_ITEM);
        getBuilder(DUSTS_ASH).add(ItemsRegistry.ASH);
        /*getBuilder(AGAVE);
        getBuilder(AMARANTH);
        getBuilder(ARROWROOT);
        getBuilder(ARTICHOKE);
        getBuilder(ASPARAGUS);
        getBuilder(BARLEY);
        getBuilder(BEAN);
        getBuilder(BELL_PEPPER);
        getBuilder(BLACKBERRY);
        getBuilder(BLUEBERRY);
        getBuilder(BROCCOLI);
        getBuilder(BRUSSELS_SPROUT);
        getBuilder(CABBAGE);
        getBuilder(CACTUS_FRUIT);
        getBuilder(CANDLE_BERRY);
        getBuilder(CANTALOUPE);*/
        getBuilder(SEEDS_CARROT).add(Items.CARROT);
        /*getBuilder(CASSAVA);
        getBuilder(CAULIFLOWER);
        getBuilder(CELERY);
        getBuilder(CHICKPEA);
        getBuilder(CHILI_PEPPER);
        getBuilder(COFFEE_BEAN);
        getBuilder(CORN);
        getBuilder(COTTON);
        getBuilder(CRANBERRY);
        getBuilder(CUCUMBER);
        getBuilder(CUMIN);
        getBuilder(EGGPLANT);
        getBuilder(ELDERBERRY);
        getBuilder(FLAX);
        getBuilder(GARLIC);
        getBuilder(GINGER);*/
        getBuilder(SEEDS_GRAPE).add(ItemsRegistry.GRAPES);
        /*getBuilder(GREEN_GRAPE);
        getBuilder(HONEYDEW);
        getBuilder(HUCKLEBERRY);
        getBuilder(JICAMA);
        getBuilder(JUNIPER_BERRY);
        getBuilder(JUTE);
        getBuilder(KALE);
        getBuilder(KENAF);
        getBuilder(KIWI);
        getBuilder(KOHLRABI);
        getBuilder(LEEK);
        getBuilder(LENTIL);
        getBuilder(LETTUCE);
        getBuilder(MILLET);
        getBuilder(MULBERRY);
        getBuilder(MUSTARD_SEEDS);
        getBuilder(OAT);
        getBuilder(OKRA);
        getBuilder(ONION);
        getBuilder(PARSNIP);
        getBuilder(PEA);
        getBuilder(PEANUT);
        getBuilder(PEPPER);
        getBuilder(PINEAPPLE);*/
        getBuilder(SEEDS_POTATO).add(Items.POTATO);
        /*getBuilder(QUINOA);
        getBuilder(RADISH);
        getBuilder(RASPBERRY);
        getBuilder(RHUBARB);*/
        getBuilder(SEEDS_RICE).add(ItemsRegistry.RICE_SEEDS);
        /*getBuilder(RUTABAGA);
        getBuilder(RYE);
        getBuilder(SCALLION);
        getBuilder(SESAME_SEEDS);
        getBuilder(SISAL);
        getBuilder(SORGHUM);
        getBuilder(SOYBEAN);
        getBuilder(SPINACH);
        getBuilder(SUNFLOWER);
        getBuilder(SWEET_POTATO);
        getBuilder(TARO);
        getBuilder(STRAWBERRY);*/
        getBuilder(SEEDS_TEA_LEAF).add(ItemsRegistry.TEA_SEEDS);
        /*getBuilder(TOMATILLO);
        getBuilder(TOMATO);
        getBuilder(TURNIP);
        getBuilder(WATER_CHESTNUT);
        getBuilder(WHITE_MUSHROOM);
        getBuilder(WINTER_SQUASH);
        getBuilder(YAM);
        getBuilder(ZUCCHINI);*/
        getBuilder(CROPS_BLACK_TEA_LEAF).add(ItemsRegistry.BLACK_TEA_LEAVES);
        getBuilder(CROPS_GREEN_TEA_LEAF).add(ItemsRegistry.GREEN_TEA_LEAVES);
        getBuilder(CROPS_TEA_LEAF).add(ItemsRegistry.TEA_LEAVES);
        getBuilder(CROPS_WHITE_TEA_LEAF).add(ItemsRegistry.WHITE_TEA_LEAVES);
        getBuilder(CROPS_GRAPE).add(ItemsRegistry.GRAPES);
    }

    @Override
    public String getName()
    {
        return "After the Drizzle Item Tags";
    }
}
