package lobster.moe.anvilcook.events.effects;

import lobster.moe.anvilcook.init.ModPlayerStatistics;
import lobster.moe.anvilcook.tag.ModFoodTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Unbelievable implements FoodType{

    public void effect(ItemStack itemStack, ServerPlayer serverPlayer, Level level){
        if (itemStack.is(ModFoodTags.UNBELIEVABLE)){
            if (serverPlayer.getStats().getValue(Stats.CUSTOM,getCunterResourceLocation())==1){
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.LUCK,20,1));
            }
            if (serverPlayer.getStats().getValue(Stats.CUSTOM,getCunterResourceLocation())==2){
                float currentHealth = serverPlayer.getHealth();
                float newHealth = currentHealth - 9.0f;
                serverPlayer.setHealth(newHealth);
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,20,1));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.WITHER,20,1));
            }
        }
    }


    @Override
    public ResourceLocation getCunterResourceLocation() {
        return ModPlayerStatistics.UNBELIEVABLECOUNTER;
    }

    @Override
    public ResourceLocation getjudgeResourceLocation() {
        return ModPlayerStatistics.UNBELIEVABLEJUDGE;
    }
}
