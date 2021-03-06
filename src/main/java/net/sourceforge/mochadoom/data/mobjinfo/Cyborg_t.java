package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;

/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Cyberdemon">Cyborg</a> 
 * @author Joaquin
 *
 */
public class Cyborg_t extends Monster_t {
  
  public Cyborg_t() {
    super( 16,        // doomednum
        StateNum.S_CYBER_STND,        // spawnstate
        4000,        // spawnhealth
        StateNum.S_CYBER_RUN1,        // seestate
        sfxenum_t.sfx_cybsit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_CYBER_PAIN,        // painstate
        20,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_CYBER_ATK1,        // missilestate
        StateNum.S_CYBER_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_cybdth,        // deathsound
        16,        // speed
        40 * FRACUNIT,        // radius
        110 * FRACUNIT,        // height
        1000,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_NULL        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_CYBORG";
  }
  
}
