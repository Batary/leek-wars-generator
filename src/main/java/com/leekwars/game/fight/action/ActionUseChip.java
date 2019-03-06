package com.leekwars.game.fight.action;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.leekwars.game.attack.chips.ChipTemplate;
import com.leekwars.game.fight.entity.Entity;
import com.leekwars.game.maps.Cell;

public class ActionUseChip implements Action {

	private final int caster;
	private final int cell;
	private final int chip;
	private final int success;
	private int[] leeks;

	public ActionUseChip(Entity caster, Cell cell, ChipTemplate chip, int success) {
		this.caster = caster.getFId();
		this.cell = cell.getId();
		this.chip = chip.getId();
		this.success = success;
		this.leeks = new int[0];
	}

	public void setEntities(List<Entity> leeks) {
		if (leeks != null) {
			this.leeks = new int[leeks.size()];
			for (int i = 0; i < leeks.size(); i++) {
				this.leeks[i] = leeks.get(i).getFId();
			}
		} else
			this.leeks = new int[0];
	}

	@Override
	public JSONArray getJSON() {
		JSONArray retour = new JSONArray();
		retour.add(Action.USE_CHIP);
		retour.add(caster);
		retour.add(cell);
		retour.add(chip);
		retour.add(success);
		retour.add(leeks);
		return retour;
	}
}
