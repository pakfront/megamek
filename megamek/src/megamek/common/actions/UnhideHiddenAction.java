/**
 * MegaMek - Copyright (C) 2004 Ben Mazur (bmazur@sev.org)
 * 
 *  This program is free software; you can redistribute it and/or modify it 
 *  under the terms of the GNU General Public License as published by the Free 
 *  Software Foundation; either version 2 of the License, or (at your option) 
 *  any later version.
 * 
 *  This program is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 *  or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
 *  for more details.
 */

package megamek.common.actions;

/**
 * Concrete implementation of and entity action for unhiding entities that are
 * Please note that the value,
 * <code>Enity.NONE</code> <em>is</em> a valid value for entityId.
 */
public class UnhideHiddenAction extends AbstractEntityAction {
    /**
     *
     */
    //TODO assign a proper uid
    private static final long serialVersionUID = -8319076127334875299L;
    private int playerId;

    public UnhideHiddenAction(int playerId, int entityId) {
        super(entityId);
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
}
