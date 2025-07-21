package com.kielson.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record RingComponent(String ringMaterial, String ringEffect) {

    public static final Codec<RingComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("ring_material").forGetter(RingComponent::ringMaterial),
            Codec.STRING.fieldOf("ring_effect").forGetter(RingComponent::ringEffect)
    ).apply(builder, RingComponent::new));

}
