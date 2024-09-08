/*
 * Copyright (c) 2024 - The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MegaMek.
 *
 * MegaMek is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MegaMek is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MegaMek. If not, see <http://www.gnu.org/licenses/>.
 */
package megamek.server.trigger;

import megamek.common.*;
import org.apache.logging.log4j.LogManager;

/**
 * This trigger reacts when only units of a single team remain alive and on board (this trigger
 * disregards undeployed units, offboard units, TeleMissiles, GunEmplacements and MechWarriors!).
 */
public class BattlefieldControlTrigger implements Trigger {

    @Override
    public boolean isTriggered(IGame game, TriggerSituation event) {
        if (game instanceof Game twGame) {
            return twGame.getEntitiesVector().stream()
                    .filter(e -> !e.isOffBoard())
                    .filter(e -> e.getPosition() != null)
                    .filter(e -> !(e instanceof MekWarrior))
                    .filter(e -> !(e instanceof TeleMissile))
                    .filter(e -> !(e instanceof GunEmplacement))
                    .map(unit -> game.getPlayer(unit.getOwnerId()).getTeam())
                    .distinct()
                    .count() == 1;
        } else {
            LogManager.getLogger().warn("BattlefieldControlTrigger is currently only available for TW games.");
            return false;
        }
    }
}
