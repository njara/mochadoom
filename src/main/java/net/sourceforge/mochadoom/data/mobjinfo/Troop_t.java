package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Imp">Troop</a> 
 * @author Joaquin
 *
 */
public class Troop_t extends Monster_t {
  
  public Troop_t() {
    super(3001,        // doomednum
        StateNum.S_TROO_STND,        // spawnstate
        60,        // spawnhealth
        StateNum.S_TROO_RUN1,        // seestate
        sfxenum_t.sfx_bgsit1,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_TROO_PAIN,        // painstate
        200,        // painchance
        sfxenum_t.sfx_popain,        // painsound
        StateNum.S_TROO_ATK1,        // meleestate
        StateNum.S_TROO_ATK1,        // missilestate
        StateNum.S_TROO_DIE1,        // deathstate
        StateNum.S_TROO_XDIE1,        // xdeathstate
        sfxenum_t.sfx_bgdth1,        // deathsound
        8,        // speed
        20 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        100,        // mass
        0,        // damage
        sfxenum_t.sfx_bgact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_TROO_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_TROOP";
  }
  
}
