/*
    This file is part of the HeavenMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2018 RonanLana

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm6;

import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;
import client.inventory.Item;
import client.inventory.MapleInventoryType;
import client.inventory.manipulator.MapleInventoryManipulator;

public class ForceDropInventoryCommand extends Command {
    {
        setDescription("Pseudo-drops first item in equip inventory");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();

        Item tempItem = c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((byte) 1);
        if (tempItem == null) return;
        
        Item dropItem = tempItem.copy();
        dropItem.setQuantity((short) 1);
        player.getMap().spawnItemDrop(player, player, dropItem, player.getPosition(), true, true);
        MapleInventoryManipulator.removeFromSlot(c, MapleInventoryType.EQUIP, (byte) 1, tempItem.getQuantity(), false, false);
                           
        
    }
}
