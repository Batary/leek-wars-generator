package com.leekwars.generator.attack.effect;

import com.leekwars.generator.fight.Fight;
import com.leekwars.generator.fight.action.ActionDamage;
import com.leekwars.generator.fight.action.DamageType;

public class EffectPoison extends Effect {

	@Override
	public void apply(Fight fight) {
		value = (int) Math.round(((value1 + jet * value2)) * (1 + (double) Math.max(0, caster.getMagic()) / 100) * power * criticalPower);
	}

	@Override
	public void applyStartTurn(Fight fight) {

		int damages = value;
		if (target.getLife() < damages) {
			damages = target.getLife();
		}
		if (damages > 0) {
			int erosion = (int) Math.round(damages * erosionRate);

			fight.log(new ActionDamage(DamageType.POISON, target, damages, erosion));
			target.removeLife(damages, erosion, caster, false);
			fight.statistics.poison(caster, target, damages);
			target.onPoisonDamage(damages);
			target.onNovaDamage(erosion);
		}
	}
}
