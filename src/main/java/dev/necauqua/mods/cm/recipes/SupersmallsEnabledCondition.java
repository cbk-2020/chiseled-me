package dev.necauqua.mods.cm.recipes;

import com.google.gson.JsonObject;
import dev.necauqua.mods.cm.Config;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.function.BooleanSupplier;

@SuppressWarnings("unused") // referred from json
public final class SupersmallsEnabledCondition implements IConditionFactory {

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        return () -> Config.enableSupersmalls;
    }
}
