package com.leekwars.generator.attack.effect;

import com.leekwars.generator.fight.Fight;
import com.leekwars.generator.fight.entity.Entity;

public class EffectDamageReturn extends Effect {

	@Override
	public void apply(Fight fight) {

		value = (int) Math.round((value1 + jet * value2) * (1 + caster.getAgility() / 100.0) * power * criticalPower);

		stats.setStat(Entity.CHARAC_DAMAGE_RETURN, value);
		target.updateBuffStats(Entity.CHARAC_DAMAGE_RETURN);
	}
	
	public void reduce() {
		value /= 2;
		stats.setStat(Entity.CHARAC_DAMAGE_RETURN, value);
		target.updateBuffStats(Entity.CHARAC_DAMAGE_RETURN);
	}
}
