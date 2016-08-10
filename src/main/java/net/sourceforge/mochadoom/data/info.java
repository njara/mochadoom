package net.sourceforge.mochadoom.data;


import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTITEM;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_DROPOFF;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_MISSILE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOBLOCKMAP;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOBLOOD;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOCLIP;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOGRAVITY;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOSECTOR;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOTDMATCH;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SPAWNCEILING;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SPECIAL;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.data.mobjinfo.AlternatePlasma_t;
import net.sourceforge.mochadoom.data.mobjinfo.Baby_t;
import net.sourceforge.mochadoom.data.mobjinfo.BlackZombie_t;
import net.sourceforge.mochadoom.data.mobjinfo.BossBrain_t;
import net.sourceforge.mochadoom.data.mobjinfo.Bruiser_t;
import net.sourceforge.mochadoom.data.mobjinfo.ChainGuy_t;
import net.sourceforge.mochadoom.data.mobjinfo.CommanderKeen_t;
import net.sourceforge.mochadoom.data.mobjinfo.Cyborg_t;
import net.sourceforge.mochadoom.data.mobjinfo.Fatso_t;
import net.sourceforge.mochadoom.data.mobjinfo.Flare_t;
import net.sourceforge.mochadoom.data.mobjinfo.GrayZombie_t;
import net.sourceforge.mochadoom.data.mobjinfo.GreenZombie_t;
import net.sourceforge.mochadoom.data.mobjinfo.Head_t;
import net.sourceforge.mochadoom.data.mobjinfo.Knight_t;
import net.sourceforge.mochadoom.data.mobjinfo.MT_Player_t;
import net.sourceforge.mochadoom.data.mobjinfo.Medikit_t;
import net.sourceforge.mochadoom.data.mobjinfo.Pain_t;
import net.sourceforge.mochadoom.data.mobjinfo.Plasma_t;
import net.sourceforge.mochadoom.data.mobjinfo.Possessed_t;
import net.sourceforge.mochadoom.data.mobjinfo.RedZombie_t;
import net.sourceforge.mochadoom.data.mobjinfo.Sergeant_t;
import net.sourceforge.mochadoom.data.mobjinfo.Shadows_t;
import net.sourceforge.mochadoom.data.mobjinfo.ShotGuy_t;
import net.sourceforge.mochadoom.data.mobjinfo.Skull_t;
import net.sourceforge.mochadoom.data.mobjinfo.Spider_t;
import net.sourceforge.mochadoom.data.mobjinfo.Troop_t;
import net.sourceforge.mochadoom.data.mobjinfo.Undead_t;
import net.sourceforge.mochadoom.data.mobjinfo.Vile_t;
import net.sourceforge.mochadoom.data.mobjinfo.WolfSS_t;
import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.doom.think_t;

// Emacs style mode select   -*- C++ -*- 
//-----------------------------------------------------------------------------
//
// $Id: info.java,v 1.12 2011/11/03 15:10:51 velktron Exp $
//
// Copyright (C) 1993-1996 by id Software, Inc.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// $Log: info.java,v $
// Revision 1.12  2011/11/03 15:10:51  velktron
// Doom default sprite names moved to ISpriteManager
//
// Revision 1.11  2011/06/08 18:26:42  velktron
// Actually, the death state was fine. The problem was in Actions.
//
// Revision 1.10  2011/06/08 18:09:51  velktron
// Fixed MT_BARREL xdeathstate
//
// Revision 1.9  2011/05/25 17:54:23  velktron
// Added extra S_NULL information.
//
// Revision 1.8  2011/05/06 14:00:54  velktron
// More of _D_'s changes committed.
//
// Revision 1.7  2010/12/20 17:15:08  velktron
// Made the renderer more OO -> TextureManager and other changes as well.
//
// Revision 1.6  2010/11/22 01:17:16  velktron
// Fixed blockmap (for the most part), some actions implemented and functional, ambient animation/lighting functional.
//
// Revision 1.5  2010/11/17 23:55:06  velktron
// Kind of playable/controllable.
//
// Revision 1.4  2010/09/27 02:27:29  velktron
// BEASTLY update
//
// Revision 1.3  2010/08/24 14:57:42  velktron
// A lot but inconclusive work today.
//
// Revision 1.2  2010/08/19 23:14:49  velktron
// Automap
//
// Revision 1.1  2010/06/30 08:58:51  velktron
// Let's see if this stuff will finally commit....
//
//
// Most stuff is still  being worked on. For a good place to start and get an idea of what is being done, I suggest checking out the "testers" package.
//
// Revision 1.1  2010/06/29 11:07:34  velktron
// Release often, release early they say...
//
// Commiting ALL stuff done so far. A lot of stuff is still broken/incomplete, and there's still mixed C code in there. I suggest you load everything up in Eclpise and see what gives from there.
//
// A good place to start is the testers/ directory, where you  can get an idea of how a few of the implemented stuff works.
//
//
// DESCRIPTION:
//	Thing frame/state LUT,
//	generated by multigen utilitiy.
//	This one is the original DOOM version, preserved.
//
//-----------------------------------------------------------------------------

public class info {

//public static state_t[]  states=new state_t[NUMSTATES];
//public static String[] sprnames=new String[NUMSPRITES];

    public static final state_t[] states = {
            // MAES: ATTENTION! The "null" state looks just like an imp. If you see it, then something's
            // wrong. When you check for "null" state, you should actually check whether something 
            // is set to S_NULL!
            new state_t(spritenum_t.SPR_TROO, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_NULL
            // _D_: replaced "null" by "think_t.A_Light0" (see linuxdoom source)
            // I was trying to make the red fire around the gun apprear when we shoot
            // but I didn't succeed. This modification below is minor as I didn't see
            // any change in the game
            new state_t(spritenum_t.SPR_SHTG, 4, 0, think_t.A_Light0, StateNum.S_NULL, 0, 0),    // S_LIGHTDONE
            new state_t(spritenum_t.SPR_PUNG, 0, 1, think_t.A_WeaponReady, StateNum.S_PUNCH, 0, 0),    // S_PUNCH
            new state_t(spritenum_t.SPR_PUNG, 0, 1, think_t.A_Lower, StateNum.S_PUNCHDOWN, 0, 0),    // S_PUNCHDOWN
            new state_t(spritenum_t.SPR_PUNG, 0, 1, think_t.A_Raise, StateNum.S_PUNCHUP, 0, 0),    // S_PUNCHUP
            new state_t(spritenum_t.SPR_PUNG, 1, 4, null, StateNum.S_PUNCH2, 0, 0),        // S_PUNCH1
            new state_t(spritenum_t.SPR_PUNG, 2, 4, think_t.A_Punch, StateNum.S_PUNCH3, 0, 0),    // S_PUNCH2
            new state_t(spritenum_t.SPR_PUNG, 3, 5, null, StateNum.S_PUNCH4, 0, 0),        // S_PUNCH3
            new state_t(spritenum_t.SPR_PUNG, 2, 4, null, StateNum.S_PUNCH5, 0, 0),        // S_PUNCH4
            new state_t(spritenum_t.SPR_PUNG, 1, 5, think_t.A_ReFire, StateNum.S_PUNCH, 0, 0),    // S_PUNCH5
            
            new state_t(spritenum_t.SPR_PUNG, 1, 12, null, StateNum.S_PUNCH7, 0, 0),        // S_PUNCH6
            new state_t(spritenum_t.SPR_PUNG, 2, 1, think_t.A_PunchAlternate, StateNum.S_PUNCH8, 0, 0),    // S_PUNCH7
            new state_t(spritenum_t.SPR_PUNG, 3, 15, null, StateNum.S_PUNCH9, 0, 0),        // S_PUNCH8
            new state_t(spritenum_t.SPR_PUNG, 2, 1, null, StateNum.S_PUNCH5, 0, 0),        // S_PUNCH9
            
            new state_t(spritenum_t.SPR_PISG, 0, 1, think_t.A_WeaponReady, StateNum.S_PISTOL, 0, 0),// S_PISTOL
            new state_t(spritenum_t.SPR_PISG, 0, 1, think_t.A_Lower, StateNum.S_PISTOLDOWN, 0, 0),    // S_PISTOLDOWN
            new state_t(spritenum_t.SPR_PISG, 0, 1, think_t.A_Raise, StateNum.S_PISTOLUP, 0, 0),    // S_PISTOLUP
            new state_t(spritenum_t.SPR_PISG, 0, 4, null, StateNum.S_PISTOL2, 0, 0),    // S_PISTOL1
            new state_t(spritenum_t.SPR_PISG, 1, 6, think_t.A_FirePistol, StateNum.S_PISTOL3, 0, 0),// S_PISTOL2
            new state_t(spritenum_t.SPR_PISG, 2, 4, null, StateNum.S_PISTOL4, 0, 0),    // S_PISTOL3
            new state_t(spritenum_t.SPR_PISG, 1, 5, think_t.A_ReFire, StateNum.S_PISTOL, 0, 0),    // S_PISTOL4
            
   /*->*/   new state_t(spritenum_t.SPR_PISG, 0, 4, null, StateNum.S_PISTOL6, 0, 0),    // S_PISTOL5
   /*->*/   new state_t(spritenum_t.SPR_PISG, 1, 6, think_t.A_FirePistolAlternate, StateNum.S_PISTOL3, 0, 0),// S_PISTOL6
   
            new state_t(spritenum_t.SPR_PISF, 32768, 7, think_t.A_Light1, StateNum.S_LIGHTDONE, 0, 0),    // S_PISTOLFLASH
            new state_t(spritenum_t.SPR_SHTG, 0, 1, think_t.A_WeaponReady, StateNum.S_SGUN, 0, 0),    // S_SGUN
            new state_t(spritenum_t.SPR_SHTG, 0, 1, think_t.A_Lower, StateNum.S_SGUNDOWN, 0, 0),    // S_SGUNDOWN
            new state_t(spritenum_t.SPR_SHTG, 0, 1, think_t.A_Raise, StateNum.S_SGUNUP, 0, 0),    // S_SGUNUP
            new state_t(spritenum_t.SPR_SHTG, 0, 3, null, StateNum.S_SGUN2, 0, 0),    // S_SGUN1
            new state_t(spritenum_t.SPR_SHTG, 0, 7, think_t.A_FireShotgun, StateNum.S_SGUN3, 0, 0),    // S_SGUN2
            new state_t(spritenum_t.SPR_SHTG, 1, 5, null, StateNum.S_SGUN4, 0, 0),    // S_SGUN3
            new state_t(spritenum_t.SPR_SHTG, 2, 5, null, StateNum.S_SGUN5, 0, 0),    // S_SGUN4
            new state_t(spritenum_t.SPR_SHTG, 3, 4, null, StateNum.S_SGUN6, 0, 0),    // S_SGUN5
            new state_t(spritenum_t.SPR_SHTG, 2, 5, null, StateNum.S_SGUN7, 0, 0),    // S_SGUN6
            new state_t(spritenum_t.SPR_SHTG, 1, 5, null, StateNum.S_SGUN8, 0, 0),    // S_SGUN7
            new state_t(spritenum_t.SPR_SHTG, 0, 3, null, StateNum.S_SGUN9, 0, 0),    // S_SGUN8
            new state_t(spritenum_t.SPR_SHTG, 0, 7, think_t.A_ReFire, StateNum.S_SGUN, 0, 0),    // S_SGUN9
            
   			//Code.110 Se agregan los state para el modo de disparo de ejemplo
   			new state_t(spritenum_t.SPR_SHTG, 0, 3, null, StateNum.S_EXAMPLE2, 0, 0),    // S_EXAMPLE1
   			new state_t(spritenum_t.SPR_SHTG, 0, 7, think_t.A_FireExample, StateNum.S_SGUN3, 0, 0),// S_EXAMPLE2
   			
            new state_t(spritenum_t.SPR_SHTF, 32768, 4, think_t.A_Light1, StateNum.S_SGUNFLASH2, 0, 0),    // S_SGUNFLASH1
            new state_t(spritenum_t.SPR_SHTF, 32769, 3, think_t.A_Light2, StateNum.S_LIGHTDONE, 0, 0),    // S_SGUNFLASH2
            new state_t(spritenum_t.SPR_SHT2, 0, 1, think_t.A_WeaponReady, StateNum.S_DSGUN, 0, 0),    // S_DSGUN
            new state_t(spritenum_t.SPR_SHT2, 0, 1, think_t.A_Lower, StateNum.S_DSGUNDOWN, 0, 0),    // S_DSGUNDOWN
            new state_t(spritenum_t.SPR_SHT2, 0, 1, think_t.A_Raise, StateNum.S_DSGUNUP, 0, 0),    // S_DSGUNUP
            new state_t(spritenum_t.SPR_SHT2, 0, 3, null, StateNum.S_DSGUN2, 0, 0),    // S_DSGUN1
            new state_t(spritenum_t.SPR_SHT2, 0, 7, think_t.A_FireShotgun2, StateNum.S_DSGUN3, 0, 0),    // S_DSGUN2
            new state_t(spritenum_t.SPR_SHT2, 1, 7, null, StateNum.S_DSGUN4, 0, 0),    // S_DSGUN3
            new state_t(spritenum_t.SPR_SHT2, 2, 7, think_t.A_CheckReload, StateNum.S_DSGUN5, 0, 0),    // S_DSGUN4
            new state_t(spritenum_t.SPR_SHT2, 3, 7, think_t.A_OpenShotgun2, StateNum.S_DSGUN6, 0, 0),    // S_DSGUN5
            new state_t(spritenum_t.SPR_SHT2, 4, 7, null, StateNum.S_DSGUN7, 0, 0),    // S_DSGUN6
            new state_t(spritenum_t.SPR_SHT2, 5, 7, think_t.A_LoadShotgun2, StateNum.S_DSGUN8, 0, 0),    // S_DSGUN7
            new state_t(spritenum_t.SPR_SHT2, 6, 6, null, StateNum.S_DSGUN9, 0, 0),    // S_DSGUN8
            new state_t(spritenum_t.SPR_SHT2, 7, 6, think_t.A_CloseShotgun2, StateNum.S_DSGUN10, 0, 0),    // S_DSGUN9
            new state_t(spritenum_t.SPR_SHT2, 0, 5, think_t.A_ReFire, StateNum.S_DSGUN, 0, 0),    // S_DSGUN10
            new state_t(spritenum_t.SPR_SHT2, 1, 7, null, StateNum.S_DSNR2, 0, 0),    // S_DSNR1
            new state_t(spritenum_t.SPR_SHT2, 0, 3, null, StateNum.S_DSGUNDOWN, 0, 0),    // S_DSNR2
            new state_t(spritenum_t.SPR_SHT2, 32776, 5, think_t.A_Light1, StateNum.S_DSGUNFLASH2, 0, 0),    // S_DSGUNFLASH1
            new state_t(spritenum_t.SPR_SHT2, 32777, 4, think_t.A_Light2, StateNum.S_LIGHTDONE, 0, 0),    // S_DSGUNFLASH2
            new state_t(spritenum_t.SPR_CHGG, 0, 1, think_t.A_WeaponReady, StateNum.S_CHAIN, 0, 0),    // S_CHAIN
            new state_t(spritenum_t.SPR_CHGG, 0, 1, think_t.A_Lower, StateNum.S_CHAINDOWN, 0, 0),    // S_CHAINDOWN
            new state_t(spritenum_t.SPR_CHGG, 0, 1, think_t.A_Raise, StateNum.S_CHAINUP, 0, 0),    // S_CHAINUP
            new state_t(spritenum_t.SPR_CHGG, 0, 4, think_t.A_FireCGun, StateNum.S_CHAIN2, 0, 0),    // S_CHAIN1
            new state_t(spritenum_t.SPR_CHGG, 1, 4, think_t.A_FireCGun, StateNum.S_CHAIN3, 0, 0),    // S_CHAIN2
            new state_t(spritenum_t.SPR_CHGG, 1, 0, think_t.A_ReFire, StateNum.S_CHAIN, 0, 0),    // S_CHAIN3

            new state_t(spritenum_t.SPR_CHGG, 0, 1, think_t.A_FireCGunAltern, StateNum.S_CHAIN5, 0, 0),    // S_CHAIN4
            new state_t(spritenum_t.SPR_CHGG, 1, 1, think_t.A_FireCGunAltern, StateNum.S_CHAIN3, 0, 0),    // S_CHAIN5

            new state_t(spritenum_t.SPR_CHGF, 32768, 5, think_t.A_Light1, StateNum.S_LIGHTDONE, 0, 0),    // S_CHAINFLASH1
            new state_t(spritenum_t.SPR_CHGF, 32769, 5, think_t.A_Light2, StateNum.S_LIGHTDONE, 0, 0),    // S_CHAINFLASH2
            new state_t(spritenum_t.SPR_MISG, 0, 1, think_t.A_WeaponReady, StateNum.S_MISSILE, 0, 0),    // S_MISSILE
            new state_t(spritenum_t.SPR_MISG, 0, 1, think_t.A_Lower, StateNum.S_MISSILEDOWN, 0, 0),    // S_MISSILEDOWN
            new state_t(spritenum_t.SPR_MISG, 0, 1, think_t.A_Raise, StateNum.S_MISSILEUP, 0, 0),    // S_MISSILEUP
            new state_t(spritenum_t.SPR_MISG, 1, 8, think_t.A_GunFlash, StateNum.S_MISSILE2, 0, 0),    // S_MISSILE1
            new state_t(spritenum_t.SPR_MISG, 1, 12, think_t.A_FireMissile, StateNum.S_MISSILE3, 0, 0),    // S_MISSILE2
            new state_t(spritenum_t.SPR_MISG, 1, 0, think_t.A_ReFire, StateNum.S_MISSILE, 0, 0),    // S_MISSILE3

            new state_t(spritenum_t.SPR_MISG, 0, 5, think_t.A_GunFlash, StateNum.S_MISSILE5, 0, 0),    // S_MISSILE4
            new state_t(spritenum_t.SPR_MISG, 1, 5, think_t.A_FireMissileAltern, StateNum.S_MISSILE3, 0, 0),    // S_MISSILE5

            new state_t(spritenum_t.SPR_MISF, 32768, 3, think_t.A_Light1, StateNum.S_MISSILEFLASH2, 0, 0),    // S_MISSILEFLASH1
            new state_t(spritenum_t.SPR_MISF, 32769, 4, null, StateNum.S_MISSILEFLASH3, 0, 0),    // S_MISSILEFLASH2
            new state_t(spritenum_t.SPR_MISF, 32770, 4, think_t.A_Light2, StateNum.S_MISSILEFLASH4, 0, 0),    // S_MISSILEFLASH3
            new state_t(spritenum_t.SPR_MISF, 32771, 4, think_t.A_Light2, StateNum.S_LIGHTDONE, 0, 0),    // S_MISSILEFLASH4
            new state_t(spritenum_t.SPR_SAWG, 2, 4, think_t.A_WeaponReady, StateNum.S_SAWB, 0, 0),    // S_SAW
            new state_t(spritenum_t.SPR_SAWG, 3, 4, think_t.A_WeaponReady, StateNum.S_SAW, 0, 0),    // S_SAWB
            new state_t(spritenum_t.SPR_SAWG, 2, 1, think_t.A_Lower, StateNum.S_SAWDOWN, 0, 0),    // S_SAWDOWN
            new state_t(spritenum_t.SPR_SAWG, 2, 1, think_t.A_Raise, StateNum.S_SAWUP, 0, 0),    // S_SAWUP
            new state_t(spritenum_t.SPR_SAWG, 0, 4, think_t.A_Saw, StateNum.S_SAW2, 0, 0),    // S_SAW1
            new state_t(spritenum_t.SPR_SAWG, 1, 4, think_t.A_Saw, StateNum.S_SAW3, 0, 0),    // S_SAW2
            new state_t(spritenum_t.SPR_SAWG, 1, 0, think_t.A_ReFire, StateNum.S_SAW, 0, 0),    // S_SAW3
            
            new state_t(spritenum_t.SPR_SAWG, 0, 16, think_t.A_SawAlternate, StateNum.S_SAW5, 0, 0),    // S_SAW4
            new state_t(spritenum_t.SPR_SAWG, 1, 4, think_t.A_SawAlternate, StateNum.S_SAW3, 0, 0),    // S_SAW5
            
            new state_t(spritenum_t.SPR_PLSG, 0, 1, think_t.A_WeaponReady, StateNum.S_PLASMA, 0, 0),    // S_PLASMA
            new state_t(spritenum_t.SPR_PLSG, 0, 1, think_t.A_Lower, StateNum.S_PLASMADOWN, 0, 0),    // S_PLASMADOWN
            new state_t(spritenum_t.SPR_PLSG, 0, 1, think_t.A_Raise, StateNum.S_PLASMAUP, 0, 0),    // S_PLASMAUP
            new state_t(spritenum_t.SPR_PLSG, 0, 3, think_t.A_FirePlasma, StateNum.S_PLASMA2, 0, 0),    // S_PLASMA1
            new state_t(spritenum_t.SPR_PLSG, 1, 20, think_t.A_ReFire, StateNum.S_PLASMA, 0, 0),    // S_PLASMA2
            new state_t(spritenum_t.SPR_PLSF, 32768, 4, think_t.A_Light1, StateNum.S_LIGHTDONE, 0, 0),    // S_PLASMAFLASH1
            new state_t(spritenum_t.SPR_PLSF, 32769, 4, think_t.A_Light1, StateNum.S_LIGHTDONE, 0, 0),    // S_PLASMAFLASH2
            new state_t(spritenum_t.SPR_PLSG, 0, 3, null, StateNum.S_PLASMA4, 0, 0),    // S_PLASMA3
            new state_t(spritenum_t.SPR_PLSG, 0, 3, think_t.A_FirePlasmaAlternate, StateNum.S_PLASMA1, 0, 0),    // S_PLASMA4
            //new state_t(spritenum_t.SPR_SHTG, 0, 3, null, StateNum.S_EXAMPLE2, 0, 0),    // S_EXAMPLE1
   			//new state_t(spritenum_t.SPR_SHTG, 0, 7, think_t.A_FireExample, StateNum.S_SGUN3, 0, 0),// S_EXAMPLE2



            new state_t(spritenum_t.SPR_BFGG, 0, 1, think_t.A_WeaponReady, StateNum.S_BFG, 0, 0),    // S_BFG
            new state_t(spritenum_t.SPR_BFGG, 0, 1, think_t.A_Lower, StateNum.S_BFGDOWN, 0, 0),    // S_BFGDOWN
            new state_t(spritenum_t.SPR_BFGG, 0, 1, think_t.A_Raise, StateNum.S_BFGUP, 0, 0),    // S_BFGUP
            new state_t(spritenum_t.SPR_BFGG, 0, 20, think_t.A_BFGsound, StateNum.S_BFG2, 0, 0),    // S_BFG1
            new state_t(spritenum_t.SPR_BFGG, 1, 10, think_t.A_GunFlash, StateNum.S_BFG3, 0, 0),    // S_BFG2
            new state_t(spritenum_t.SPR_BFGG, 1, 10, think_t.A_FireBFG, StateNum.S_BFG4, 0, 0),    // S_BFG3
            new state_t(spritenum_t.SPR_BFGG, 1, 20, think_t.A_ReFire, StateNum.S_BFG, 0, 0),    // S_BFG4

			new state_t(spritenum_t.SPR_BFGG, 0, 20, think_t.A_BFGsound, StateNum.S_BFG6, 0, 0),    // S_BFG5
			new state_t(spritenum_t.SPR_BFGG, 1, 10, think_t.A_GunFlash, StateNum.S_BFG7, 0, 0),    // S_BFG6
			new state_t(spritenum_t.SPR_BFGG, 1, 10, think_t.A_FireBFGAltern, StateNum.S_BFG8, 0, 0),    // S_BFG7
			new state_t(spritenum_t.SPR_BFGG, 1, 20, think_t.A_ReFire, StateNum.S_BFG, 0, 0),    // S_BFG8

            new state_t(spritenum_t.SPR_BFGF, 32768, 11, think_t.A_Light1, StateNum.S_BFGFLASH2, 0, 0),    // S_BFGFLASH1
            new state_t(spritenum_t.SPR_BFGF, 32769, 6, think_t.A_Light2, StateNum.S_LIGHTDONE, 0, 0),    // S_BFGFLASH2
            new state_t(spritenum_t.SPR_BLUD, 2, 8, null, StateNum.S_BLOOD2, 0, 0),    // S_BLOOD1
            new state_t(spritenum_t.SPR_BLUD, 1, 8, null, StateNum.S_BLOOD3, 0, 0),    // S_BLOOD2
            new state_t(spritenum_t.SPR_BLUD, 0, 8, null, StateNum.S_NULL, 0, 0),    // S_BLOOD3
            new state_t(spritenum_t.SPR_PUFF, 32768, 4, null, StateNum.S_PUFF2, 0, 0),    // S_PUFF1
            new state_t(spritenum_t.SPR_PUFF, 1, 4, null, StateNum.S_PUFF3, 0, 0),    // S_PUFF2
            new state_t(spritenum_t.SPR_PUFF, 2, 4, null, StateNum.S_PUFF4, 0, 0),    // S_PUFF3
            new state_t(spritenum_t.SPR_PUFF, 3, 4, null, StateNum.S_NULL, 0, 0),    // S_PUFF4
            new state_t(spritenum_t.SPR_BAL1, 32768, 4, null, StateNum.S_TBALL2, 0, 0),    // S_TBALL1
            new state_t(spritenum_t.SPR_BAL1, 32769, 4, null, StateNum.S_TBALL1, 0, 0),    // S_TBALL2
            new state_t(spritenum_t.SPR_BAL1, 32770, 6, null, StateNum.S_TBALLX2, 0, 0),    // S_TBALLX1
            new state_t(spritenum_t.SPR_BAL1, 32771, 6, null, StateNum.S_TBALLX3, 0, 0),    // S_TBALLX2
            new state_t(spritenum_t.SPR_BAL1, 32772, 6, null, StateNum.S_NULL, 0, 0),    // S_TBALLX3
            new state_t(spritenum_t.SPR_BAL2, 32768, 4, null, StateNum.S_RBALL2, 0, 0),    // S_RBALL1
            new state_t(spritenum_t.SPR_BAL2, 32769, 4, null, StateNum.S_RBALL1, 0, 0),    // S_RBALL2
            new state_t(spritenum_t.SPR_BAL2, 32770, 6, null, StateNum.S_RBALLX2, 0, 0),    // S_RBALLX1
            new state_t(spritenum_t.SPR_BAL2, 32771, 6, null, StateNum.S_RBALLX3, 0, 0),    // S_RBALLX2
            new state_t(spritenum_t.SPR_BAL2, 32772, 6, null, StateNum.S_NULL, 0, 0),    // S_RBALLX3
            new state_t(spritenum_t.SPR_PLSS, 32768, 6, null, StateNum.S_PLASBALL2, 0, 0),    // S_PLASBALL
            new state_t(spritenum_t.SPR_PLSS, 32769, 6, null, StateNum.S_PLASBALL, 0, 0),    // S_PLASBALL2
            new state_t(spritenum_t.SPR_PLSS, 32768, 6, null, StateNum.S_PLASBALL4, 0, 0),    // S_PLASBALL
            new state_t(spritenum_t.SPR_PLSS, 32769, 6, null, StateNum.S_PLASBALL3, 0, 0),    // S_PLASBALL2
            new state_t(spritenum_t.SPR_PLSE, 32768, 4, null, StateNum.S_PLASEXP2, 0, 0),    // S_PLASEXP
            new state_t(spritenum_t.SPR_PLSE, 32769, 4, null, StateNum.S_PLASEXP3, 0, 0),    // S_PLASEXP2
            new state_t(spritenum_t.SPR_PLSE, 32770, 4, null, StateNum.S_PLASEXP4, 0, 0),    // S_PLASEXP3
            new state_t(spritenum_t.SPR_PLSE, 32771, 4, null, StateNum.S_PLASEXP5, 0, 0),    // S_PLASEXP4
            new state_t(spritenum_t.SPR_PLSE, 32772, 4, null, StateNum.S_NULL, 0, 0),    // S_PLASEXP5
            new state_t(spritenum_t.SPR_MISL, 32768, 1, null, StateNum.S_ROCKET, 0, 0),    // S_ROCKET
            new state_t(spritenum_t.SPR_BFS1, 32768, 4, null, StateNum.S_BFGSHOT2, 0, 0),    // S_BFGSHOT
            new state_t(spritenum_t.SPR_BFS1, 32769, 4, null, StateNum.S_BFGSHOT, 0, 0),    // S_BFGSHOT2
            new state_t(spritenum_t.SPR_BFE1, 32768, 8, null, StateNum.S_BFGLAND2, 0, 0),    // S_BFGLAND
            new state_t(spritenum_t.SPR_BFE1, 32769, 8, null, StateNum.S_BFGLAND3, 0, 0),    // S_BFGLAND2
            new state_t(spritenum_t.SPR_BFE1, 32770, 8, think_t.A_BFGSpray, StateNum.S_BFGLAND4, 0, 0),    // S_BFGLAND3
            new state_t(spritenum_t.SPR_BFE1, 32771, 8, null, StateNum.S_BFGLAND5, 0, 0),    // S_BFGLAND4
            new state_t(spritenum_t.SPR_BFE1, 32772, 8, null, StateNum.S_BFGLAND6, 0, 0),    // S_BFGLAND5
            new state_t(spritenum_t.SPR_BFE1, 32773, 8, null, StateNum.S_NULL, 0, 0),    // S_BFGLAND6
            new state_t(spritenum_t.SPR_BFE2, 32768, 8, null, StateNum.S_BFGEXP2, 0, 0),    // S_BFGEXP
            new state_t(spritenum_t.SPR_BFE2, 32769, 8, null, StateNum.S_BFGEXP3, 0, 0),    // S_BFGEXP2
            new state_t(spritenum_t.SPR_BFE2, 32770, 8, null, StateNum.S_BFGEXP4, 0, 0),    // S_BFGEXP3
            new state_t(spritenum_t.SPR_BFE2, 32771, 8, null, StateNum.S_NULL, 0, 0),    // S_BFGEXP4
            new state_t(spritenum_t.SPR_MISL, 32769, 8, think_t.A_Explode, StateNum.S_EXPLODE2, 0, 0),    // S_EXPLODE1
            new state_t(spritenum_t.SPR_MISL, 32770, 6, null, StateNum.S_EXPLODE3, 0, 0),    // S_EXPLODE2
            new state_t(spritenum_t.SPR_MISL, 32771, 4, null, StateNum.S_NULL, 0, 0),    // S_EXPLODE3
            new state_t(spritenum_t.SPR_TFOG, 32768, 6, null, StateNum.S_TFOG01, 0, 0),    // S_TFOG
            new state_t(spritenum_t.SPR_TFOG, 32769, 6, null, StateNum.S_TFOG02, 0, 0),    // S_TFOG01
            new state_t(spritenum_t.SPR_TFOG, 32768, 6, null, StateNum.S_TFOG2, 0, 0),    // S_TFOG02
            new state_t(spritenum_t.SPR_TFOG, 32769, 6, null, StateNum.S_TFOG3, 0, 0),    // S_TFOG2
            new state_t(spritenum_t.SPR_TFOG, 32770, 6, null, StateNum.S_TFOG4, 0, 0),    // S_TFOG3
            new state_t(spritenum_t.SPR_TFOG, 32771, 6, null, StateNum.S_TFOG5, 0, 0),    // S_TFOG4
            new state_t(spritenum_t.SPR_TFOG, 32772, 6, null, StateNum.S_TFOG6, 0, 0),    // S_TFOG5
            new state_t(spritenum_t.SPR_TFOG, 32773, 6, null, StateNum.S_TFOG7, 0, 0),    // S_TFOG6
            new state_t(spritenum_t.SPR_TFOG, 32774, 6, null, StateNum.S_TFOG8, 0, 0),    // S_TFOG7
            new state_t(spritenum_t.SPR_TFOG, 32775, 6, null, StateNum.S_TFOG9, 0, 0),    // S_TFOG8
            new state_t(spritenum_t.SPR_TFOG, 32776, 6, null, StateNum.S_TFOG10, 0, 0),    // S_TFOG9
            new state_t(spritenum_t.SPR_TFOG, 32777, 6, null, StateNum.S_NULL, 0, 0),    // S_TFOG10
            new state_t(spritenum_t.SPR_IFOG, 32768, 6, null, StateNum.S_IFOG01, 0, 0),    // S_IFOG
            new state_t(spritenum_t.SPR_IFOG, 32769, 6, null, StateNum.S_IFOG02, 0, 0),    // S_IFOG01
            new state_t(spritenum_t.SPR_IFOG, 32768, 6, null, StateNum.S_IFOG2, 0, 0),    // S_IFOG02
            new state_t(spritenum_t.SPR_IFOG, 32769, 6, null, StateNum.S_IFOG3, 0, 0),    // S_IFOG2
            new state_t(spritenum_t.SPR_IFOG, 32770, 6, null, StateNum.S_IFOG4, 0, 0),    // S_IFOG3
            new state_t(spritenum_t.SPR_IFOG, 32771, 6, null, StateNum.S_IFOG5, 0, 0),    // S_IFOG4
            new state_t(spritenum_t.SPR_IFOG, 32772, 6, null, StateNum.S_NULL, 0, 0),    // S_IFOG5
            new state_t(spritenum_t.SPR_PLAY, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_PLAY
            new state_t(spritenum_t.SPR_PLAY, 0, 4, null, StateNum.S_PLAY_RUN2, 0, 0),    // S_PLAY_RUN1
            new state_t(spritenum_t.SPR_PLAY, 1, 4, null, StateNum.S_PLAY_RUN3, 0, 0),    // S_PLAY_RUN2
            new state_t(spritenum_t.SPR_PLAY, 2, 4, null, StateNum.S_PLAY_RUN4, 0, 0),    // S_PLAY_RUN3
            new state_t(spritenum_t.SPR_PLAY, 3, 4, null, StateNum.S_PLAY_RUN1, 0, 0),    // S_PLAY_RUN4
            new state_t(spritenum_t.SPR_PLAY, 4, 12, null, StateNum.S_PLAY, 0, 0),    // S_PLAY_ATK1
            new state_t(spritenum_t.SPR_PLAY, 32773, 6, null, StateNum.S_PLAY_ATK1, 0, 0),    // S_PLAY_ATK2
            new state_t(spritenum_t.SPR_PLAY, 6, 4, null, StateNum.S_PLAY_PAIN2, 0, 0),    // S_PLAY_PAIN
            new state_t(spritenum_t.SPR_PLAY, 6, 4, think_t.A_Pain, StateNum.S_PLAY, 0, 0),    // S_PLAY_PAIN2
            new state_t(spritenum_t.SPR_PLAY, 7, 10, null, StateNum.S_PLAY_DIE2, 0, 0),    // S_PLAY_DIE1
            new state_t(spritenum_t.SPR_PLAY, 8, 10, think_t.A_PlayerScream, StateNum.S_PLAY_DIE3, 0, 0),    // S_PLAY_DIE2
            new state_t(spritenum_t.SPR_PLAY, 9, 10, think_t.A_Fall, StateNum.S_PLAY_DIE4, 0, 0),    // S_PLAY_DIE3
            new state_t(spritenum_t.SPR_PLAY, 10, 10, null, StateNum.S_PLAY_DIE5, 0, 0),    // S_PLAY_DIE4
            new state_t(spritenum_t.SPR_PLAY, 11, 10, null, StateNum.S_PLAY_DIE6, 0, 0),    // S_PLAY_DIE5
            new state_t(spritenum_t.SPR_PLAY, 12, 10, null, StateNum.S_PLAY_DIE7, 0, 0),    // S_PLAY_DIE6
            new state_t(spritenum_t.SPR_PLAY, 13, -1, null, StateNum.S_NULL, 0, 0),    // S_PLAY_DIE7
            new state_t(spritenum_t.SPR_PLAY, 14, 5, null, StateNum.S_PLAY_XDIE2, 0, 0),    // S_PLAY_XDIE1
            new state_t(spritenum_t.SPR_PLAY, 15, 5, think_t.A_XScream, StateNum.S_PLAY_XDIE3, 0, 0),    // S_PLAY_XDIE2
            new state_t(spritenum_t.SPR_PLAY, 16, 5, think_t.A_Fall, StateNum.S_PLAY_XDIE4, 0, 0),    // S_PLAY_XDIE3
            new state_t(spritenum_t.SPR_PLAY, 17, 5, null, StateNum.S_PLAY_XDIE5, 0, 0),    // S_PLAY_XDIE4
            new state_t(spritenum_t.SPR_PLAY, 18, 5, null, StateNum.S_PLAY_XDIE6, 0, 0),    // S_PLAY_XDIE5
            new state_t(spritenum_t.SPR_PLAY, 19, 5, null, StateNum.S_PLAY_XDIE7, 0, 0),    // S_PLAY_XDIE6
            new state_t(spritenum_t.SPR_PLAY, 20, 5, null, StateNum.S_PLAY_XDIE8, 0, 0),    // S_PLAY_XDIE7
            new state_t(spritenum_t.SPR_PLAY, 21, 5, null, StateNum.S_PLAY_XDIE9, 0, 0),    // S_PLAY_XDIE8
            new state_t(spritenum_t.SPR_PLAY, 22, -1, null, StateNum.S_NULL, 0, 0),    // S_PLAY_XDIE9
            new state_t(spritenum_t.SPR_POSS, 0, 10, think_t.A_Look, StateNum.S_POSS_STND2, 0, 0),    // S_POSS_STND
            new state_t(spritenum_t.SPR_POSS, 1, 10, think_t.A_Look, StateNum.S_POSS_STND, 0, 0),    // S_POSS_STND2
            new state_t(spritenum_t.SPR_POSS, 0, 4, think_t.A_Chase, StateNum.S_POSS_RUN2, 0, 0),    // S_POSS_RUN1
            new state_t(spritenum_t.SPR_POSS, 0, 4, think_t.A_Chase, StateNum.S_POSS_RUN3, 0, 0),    // S_POSS_RUN2
            new state_t(spritenum_t.SPR_POSS, 1, 4, think_t.A_Chase, StateNum.S_POSS_RUN4, 0, 0),    // S_POSS_RUN3
            new state_t(spritenum_t.SPR_POSS, 1, 4, think_t.A_Chase, StateNum.S_POSS_RUN5, 0, 0),    // S_POSS_RUN4
            new state_t(spritenum_t.SPR_POSS, 2, 4, think_t.A_Chase, StateNum.S_POSS_RUN6, 0, 0),    // S_POSS_RUN5
            new state_t(spritenum_t.SPR_POSS, 2, 4, think_t.A_Chase, StateNum.S_POSS_RUN7, 0, 0),    // S_POSS_RUN6
            new state_t(spritenum_t.SPR_POSS, 3, 4, think_t.A_Chase, StateNum.S_POSS_RUN8, 0, 0),    // S_POSS_RUN7
            new state_t(spritenum_t.SPR_POSS, 3, 4, think_t.A_Chase, StateNum.S_POSS_RUN1, 0, 0),    // S_POSS_RUN8
            new state_t(spritenum_t.SPR_POSS, 4, 10, think_t.A_FaceTarget, StateNum.S_POSS_ATK2, 0, 0),    // S_POSS_ATK1
            new state_t(spritenum_t.SPR_POSS, 5, 8, think_t.A_PosAttack, StateNum.S_POSS_ATK3, 0, 0),    // S_POSS_ATK2
            new state_t(spritenum_t.SPR_POSS, 4, 8, null, StateNum.S_POSS_RUN1, 0, 0),    // S_POSS_ATK3
            new state_t(spritenum_t.SPR_POSS, 6, 3, null, StateNum.S_POSS_PAIN2, 0, 0),    // S_POSS_PAIN
            new state_t(spritenum_t.SPR_POSS, 6, 3, think_t.A_Pain, StateNum.S_POSS_RUN1, 0, 0),    // S_POSS_PAIN2
            new state_t(spritenum_t.SPR_POSS, 7, 5, null, StateNum.S_POSS_DIE2, 0, 0),    // S_POSS_DIE1
            new state_t(spritenum_t.SPR_POSS, 8, 5, think_t.A_Scream, StateNum.S_POSS_DIE3, 0, 0),    // S_POSS_DIE2
            new state_t(spritenum_t.SPR_POSS, 9, 5, think_t.A_Fall, StateNum.S_POSS_DIE4, 0, 0),    // S_POSS_DIE3
            new state_t(spritenum_t.SPR_POSS, 10, 5, null, StateNum.S_POSS_DIE5, 0, 0),    // S_POSS_DIE4
            new state_t(spritenum_t.SPR_POSS, 11, -1, null, StateNum.S_NULL, 0, 0),    // S_POSS_DIE5
            new state_t(spritenum_t.SPR_POSS, 12, 5, null, StateNum.S_POSS_XDIE2, 0, 0),    // S_POSS_XDIE1
            new state_t(spritenum_t.SPR_POSS, 13, 5, think_t.A_XScream, StateNum.S_POSS_XDIE3, 0, 0),    // S_POSS_XDIE2
            new state_t(spritenum_t.SPR_POSS, 14, 5, think_t.A_Fall, StateNum.S_POSS_XDIE4, 0, 0),    // S_POSS_XDIE3
            new state_t(spritenum_t.SPR_POSS, 15, 5, null, StateNum.S_POSS_XDIE5, 0, 0),    // S_POSS_XDIE4
            new state_t(spritenum_t.SPR_POSS, 16, 5, null, StateNum.S_POSS_XDIE6, 0, 0),    // S_POSS_XDIE5
            new state_t(spritenum_t.SPR_POSS, 17, 5, null, StateNum.S_POSS_XDIE7, 0, 0),    // S_POSS_XDIE6
            new state_t(spritenum_t.SPR_POSS, 18, 5, null, StateNum.S_POSS_XDIE8, 0, 0),    // S_POSS_XDIE7
            new state_t(spritenum_t.SPR_POSS, 19, 5, null, StateNum.S_POSS_XDIE9, 0, 0),    // S_POSS_XDIE8
            new state_t(spritenum_t.SPR_POSS, 20, -1, null, StateNum.S_NULL, 0, 0),    // S_POSS_XDIE9
            new state_t(spritenum_t.SPR_POSS, 10, 5, null, StateNum.S_POSS_RAISE2, 0, 0),    // S_POSS_RAISE1
            new state_t(spritenum_t.SPR_POSS, 9, 5, null, StateNum.S_POSS_RAISE3, 0, 0),    // S_POSS_RAISE2
            new state_t(spritenum_t.SPR_POSS, 8, 5, null, StateNum.S_POSS_RAISE4, 0, 0),    // S_POSS_RAISE3
            new state_t(spritenum_t.SPR_POSS, 7, 5, null, StateNum.S_POSS_RUN1, 0, 0),    // S_POSS_RAISE4
            new state_t(spritenum_t.SPR_SPOS, 0, 10, think_t.A_Look, StateNum.S_SPOS_STND2, 0, 0),    // S_SPOS_STND
            new state_t(spritenum_t.SPR_SPOS, 1, 10, think_t.A_Look, StateNum.S_SPOS_STND, 0, 0),    // S_SPOS_STND2
            new state_t(spritenum_t.SPR_SPOS, 0, 3, think_t.A_Chase, StateNum.S_SPOS_RUN2, 0, 0),    // S_SPOS_RUN1
            new state_t(spritenum_t.SPR_SPOS, 0, 3, think_t.A_Chase, StateNum.S_SPOS_RUN3, 0, 0),    // S_SPOS_RUN2
            new state_t(spritenum_t.SPR_SPOS, 1, 3, think_t.A_Chase, StateNum.S_SPOS_RUN4, 0, 0),    // S_SPOS_RUN3
            new state_t(spritenum_t.SPR_SPOS, 1, 3, think_t.A_Chase, StateNum.S_SPOS_RUN5, 0, 0),    // S_SPOS_RUN4
            new state_t(spritenum_t.SPR_SPOS, 2, 3, think_t.A_Chase, StateNum.S_SPOS_RUN6, 0, 0),    // S_SPOS_RUN5
            new state_t(spritenum_t.SPR_SPOS, 2, 3, think_t.A_Chase, StateNum.S_SPOS_RUN7, 0, 0),    // S_SPOS_RUN6
            new state_t(spritenum_t.SPR_SPOS, 3, 3, think_t.A_Chase, StateNum.S_SPOS_RUN8, 0, 0),    // S_SPOS_RUN7
            new state_t(spritenum_t.SPR_SPOS, 3, 3, think_t.A_Chase, StateNum.S_SPOS_RUN1, 0, 0),    // S_SPOS_RUN8
            new state_t(spritenum_t.SPR_SPOS, 4, 10, think_t.A_FaceTarget, StateNum.S_SPOS_ATK2, 0, 0),    // S_SPOS_ATK1
            new state_t(spritenum_t.SPR_SPOS, 32773, 10, think_t.A_SPosAttack, StateNum.S_SPOS_ATK3, 0, 0),    // S_SPOS_ATK2
            new state_t(spritenum_t.SPR_SPOS, 4, 10, null, StateNum.S_SPOS_RUN1, 0, 0),    // S_SPOS_ATK3
            new state_t(spritenum_t.SPR_SPOS, 6, 3, null, StateNum.S_SPOS_PAIN2, 0, 0),    // S_SPOS_PAIN
            new state_t(spritenum_t.SPR_SPOS, 6, 3, think_t.A_Pain, StateNum.S_SPOS_RUN1, 0, 0),    // S_SPOS_PAIN2
            new state_t(spritenum_t.SPR_SPOS, 7, 5, null, StateNum.S_SPOS_DIE2, 0, 0),    // S_SPOS_DIE1
            new state_t(spritenum_t.SPR_SPOS, 8, 5, think_t.A_Scream, StateNum.S_SPOS_DIE3, 0, 0),    // S_SPOS_DIE2
            new state_t(spritenum_t.SPR_SPOS, 9, 5, think_t.A_Fall, StateNum.S_SPOS_DIE4, 0, 0),    // S_SPOS_DIE3
            new state_t(spritenum_t.SPR_SPOS, 10, 5, null, StateNum.S_SPOS_DIE5, 0, 0),    // S_SPOS_DIE4
            new state_t(spritenum_t.SPR_SPOS, 11, -1, null, StateNum.S_NULL, 0, 0),    // S_SPOS_DIE5
            new state_t(spritenum_t.SPR_SPOS, 12, 5, null, StateNum.S_SPOS_XDIE2, 0, 0),    // S_SPOS_XDIE1
            new state_t(spritenum_t.SPR_SPOS, 13, 5, think_t.A_XScream, StateNum.S_SPOS_XDIE3, 0, 0),    // S_SPOS_XDIE2
            new state_t(spritenum_t.SPR_SPOS, 14, 5, think_t.A_Fall, StateNum.S_SPOS_XDIE4, 0, 0),    // S_SPOS_XDIE3
            new state_t(spritenum_t.SPR_SPOS, 15, 5, null, StateNum.S_SPOS_XDIE5, 0, 0),    // S_SPOS_XDIE4
            new state_t(spritenum_t.SPR_SPOS, 16, 5, null, StateNum.S_SPOS_XDIE6, 0, 0),    // S_SPOS_XDIE5
            new state_t(spritenum_t.SPR_SPOS, 17, 5, null, StateNum.S_SPOS_XDIE7, 0, 0),    // S_SPOS_XDIE6
            new state_t(spritenum_t.SPR_SPOS, 18, 5, null, StateNum.S_SPOS_XDIE8, 0, 0),    // S_SPOS_XDIE7
            new state_t(spritenum_t.SPR_SPOS, 19, 5, null, StateNum.S_SPOS_XDIE9, 0, 0),    // S_SPOS_XDIE8
            new state_t(spritenum_t.SPR_SPOS, 20, -1, null, StateNum.S_NULL, 0, 0),    // S_SPOS_XDIE9
            new state_t(spritenum_t.SPR_SPOS, 11, 5, null, StateNum.S_SPOS_RAISE2, 0, 0),    // S_SPOS_RAISE1
            new state_t(spritenum_t.SPR_SPOS, 10, 5, null, StateNum.S_SPOS_RAISE3, 0, 0),    // S_SPOS_RAISE2
            new state_t(spritenum_t.SPR_SPOS, 9, 5, null, StateNum.S_SPOS_RAISE4, 0, 0),    // S_SPOS_RAISE3
            new state_t(spritenum_t.SPR_SPOS, 8, 5, null, StateNum.S_SPOS_RAISE5, 0, 0),    // S_SPOS_RAISE4
            new state_t(spritenum_t.SPR_SPOS, 7, 5, null, StateNum.S_SPOS_RUN1, 0, 0),    // S_SPOS_RAISE5
            new state_t(spritenum_t.SPR_VILE, 0, 10, think_t.A_Look, StateNum.S_VILE_STND2, 0, 0),    // S_VILE_STND
            new state_t(spritenum_t.SPR_VILE, 1, 10, think_t.A_Look, StateNum.S_VILE_STND, 0, 0),    // S_VILE_STND2
            new state_t(spritenum_t.SPR_VILE, 0, 2, think_t.A_VileChase, StateNum.S_VILE_RUN2, 0, 0),    // S_VILE_RUN1
            new state_t(spritenum_t.SPR_VILE, 0, 2, think_t.A_VileChase, StateNum.S_VILE_RUN3, 0, 0),    // S_VILE_RUN2
            new state_t(spritenum_t.SPR_VILE, 1, 2, think_t.A_VileChase, StateNum.S_VILE_RUN4, 0, 0),    // S_VILE_RUN3
            new state_t(spritenum_t.SPR_VILE, 1, 2, think_t.A_VileChase, StateNum.S_VILE_RUN5, 0, 0),    // S_VILE_RUN4
            new state_t(spritenum_t.SPR_VILE, 2, 2, think_t.A_VileChase, StateNum.S_VILE_RUN6, 0, 0),    // S_VILE_RUN5
            new state_t(spritenum_t.SPR_VILE, 2, 2, think_t.A_VileChase, StateNum.S_VILE_RUN7, 0, 0),    // S_VILE_RUN6
            new state_t(spritenum_t.SPR_VILE, 3, 2, think_t.A_VileChase, StateNum.S_VILE_RUN8, 0, 0),    // S_VILE_RUN7
            new state_t(spritenum_t.SPR_VILE, 3, 2, think_t.A_VileChase, StateNum.S_VILE_RUN9, 0, 0),    // S_VILE_RUN8
            new state_t(spritenum_t.SPR_VILE, 4, 2, think_t.A_VileChase, StateNum.S_VILE_RUN10, 0, 0),    // S_VILE_RUN9
            new state_t(spritenum_t.SPR_VILE, 4, 2, think_t.A_VileChase, StateNum.S_VILE_RUN11, 0, 0),    // S_VILE_RUN10
            new state_t(spritenum_t.SPR_VILE, 5, 2, think_t.A_VileChase, StateNum.S_VILE_RUN12, 0, 0),    // S_VILE_RUN11
            new state_t(spritenum_t.SPR_VILE, 5, 2, think_t.A_VileChase, StateNum.S_VILE_RUN1, 0, 0),    // S_VILE_RUN12
            new state_t(spritenum_t.SPR_VILE, 32774, 0, think_t.A_VileStart, StateNum.S_VILE_ATK2, 0, 0),    // S_VILE_ATK1
            new state_t(spritenum_t.SPR_VILE, 32774, 10, think_t.A_FaceTarget, StateNum.S_VILE_ATK3, 0, 0),    // S_VILE_ATK2
            new state_t(spritenum_t.SPR_VILE, 32775, 8, think_t.A_VileTarget, StateNum.S_VILE_ATK4, 0, 0),    // S_VILE_ATK3
            new state_t(spritenum_t.SPR_VILE, 32776, 8, think_t.A_FaceTarget, StateNum.S_VILE_ATK5, 0, 0),    // S_VILE_ATK4
            new state_t(spritenum_t.SPR_VILE, 32777, 8, think_t.A_FaceTarget, StateNum.S_VILE_ATK6, 0, 0),    // S_VILE_ATK5
            new state_t(spritenum_t.SPR_VILE, 32778, 8, think_t.A_FaceTarget, StateNum.S_VILE_ATK7, 0, 0),    // S_VILE_ATK6
            new state_t(spritenum_t.SPR_VILE, 32779, 8, think_t.A_FaceTarget, StateNum.S_VILE_ATK8, 0, 0),    // S_VILE_ATK7
            new state_t(spritenum_t.SPR_VILE, 32780, 8, think_t.A_FaceTarget, StateNum.S_VILE_ATK9, 0, 0),    // S_VILE_ATK8
            new state_t(spritenum_t.SPR_VILE, 32781, 8, think_t.A_FaceTarget, StateNum.S_VILE_ATK10, 0, 0),    // S_VILE_ATK9
            new state_t(spritenum_t.SPR_VILE, 32782, 8, think_t.A_VileAttack, StateNum.S_VILE_ATK11, 0, 0),    // S_VILE_ATK10
            new state_t(spritenum_t.SPR_VILE, 32783, 20, null, StateNum.S_VILE_RUN1, 0, 0),    // S_VILE_ATK11
            new state_t(spritenum_t.SPR_VILE, 32794, 10, null, StateNum.S_VILE_HEAL2, 0, 0),    // S_VILE_HEAL1
            new state_t(spritenum_t.SPR_VILE, 32795, 10, null, StateNum.S_VILE_HEAL3, 0, 0),    // S_VILE_HEAL2
            new state_t(spritenum_t.SPR_VILE, 32796, 10, null, StateNum.S_VILE_RUN1, 0, 0),    // S_VILE_HEAL3
            new state_t(spritenum_t.SPR_VILE, 16, 5, null, StateNum.S_VILE_PAIN2, 0, 0),    // S_VILE_PAIN
            new state_t(spritenum_t.SPR_VILE, 16, 5, think_t.A_Pain, StateNum.S_VILE_RUN1, 0, 0),    // S_VILE_PAIN2
            new state_t(spritenum_t.SPR_VILE, 16, 7, null, StateNum.S_VILE_DIE2, 0, 0),    // S_VILE_DIE1
            new state_t(spritenum_t.SPR_VILE, 17, 7, think_t.A_Scream, StateNum.S_VILE_DIE3, 0, 0),    // S_VILE_DIE2
            new state_t(spritenum_t.SPR_VILE, 18, 7, think_t.A_Fall, StateNum.S_VILE_DIE4, 0, 0),    // S_VILE_DIE3
            new state_t(spritenum_t.SPR_VILE, 19, 7, null, StateNum.S_VILE_DIE5, 0, 0),    // S_VILE_DIE4
            new state_t(spritenum_t.SPR_VILE, 20, 7, null, StateNum.S_VILE_DIE6, 0, 0),    // S_VILE_DIE5
            new state_t(spritenum_t.SPR_VILE, 21, 7, null, StateNum.S_VILE_DIE7, 0, 0),    // S_VILE_DIE6
            new state_t(spritenum_t.SPR_VILE, 22, 7, null, StateNum.S_VILE_DIE8, 0, 0),    // S_VILE_DIE7
            new state_t(spritenum_t.SPR_VILE, 23, 5, null, StateNum.S_VILE_DIE9, 0, 0),    // S_VILE_DIE8
            new state_t(spritenum_t.SPR_VILE, 24, 5, null, StateNum.S_VILE_DIE10, 0, 0),    // S_VILE_DIE9
            new state_t(spritenum_t.SPR_VILE, 25, -1, null, StateNum.S_NULL, 0, 0),    // S_VILE_DIE10
            new state_t(spritenum_t.SPR_FIRE, 32768, 2, think_t.A_StartFire, StateNum.S_FIRE2, 0, 0),    // S_FIRE1
            new state_t(spritenum_t.SPR_FIRE, 32769, 2, think_t.A_Fire, StateNum.S_FIRE3, 0, 0),    // S_FIRE2
            new state_t(spritenum_t.SPR_FIRE, 32768, 2, think_t.A_Fire, StateNum.S_FIRE4, 0, 0),    // S_FIRE3
            new state_t(spritenum_t.SPR_FIRE, 32769, 2, think_t.A_Fire, StateNum.S_FIRE5, 0, 0),    // S_FIRE4
            new state_t(spritenum_t.SPR_FIRE, 32770, 2, think_t.A_FireCrackle, StateNum.S_FIRE6, 0, 0),    // S_FIRE5
            new state_t(spritenum_t.SPR_FIRE, 32769, 2, think_t.A_Fire, StateNum.S_FIRE7, 0, 0),    // S_FIRE6
            new state_t(spritenum_t.SPR_FIRE, 32770, 2, think_t.A_Fire, StateNum.S_FIRE8, 0, 0),    // S_FIRE7
            new state_t(spritenum_t.SPR_FIRE, 32769, 2, think_t.A_Fire, StateNum.S_FIRE9, 0, 0),    // S_FIRE8
            new state_t(spritenum_t.SPR_FIRE, 32770, 2, think_t.A_Fire, StateNum.S_FIRE10, 0, 0),    // S_FIRE9
            new state_t(spritenum_t.SPR_FIRE, 32771, 2, think_t.A_Fire, StateNum.S_FIRE11, 0, 0),    // S_FIRE10
            new state_t(spritenum_t.SPR_FIRE, 32770, 2, think_t.A_Fire, StateNum.S_FIRE12, 0, 0),    // S_FIRE11
            new state_t(spritenum_t.SPR_FIRE, 32771, 2, think_t.A_Fire, StateNum.S_FIRE13, 0, 0),    // S_FIRE12
            new state_t(spritenum_t.SPR_FIRE, 32770, 2, think_t.A_Fire, StateNum.S_FIRE14, 0, 0),    // S_FIRE13
            new state_t(spritenum_t.SPR_FIRE, 32771, 2, think_t.A_Fire, StateNum.S_FIRE15, 0, 0),    // S_FIRE14
            new state_t(spritenum_t.SPR_FIRE, 32772, 2, think_t.A_Fire, StateNum.S_FIRE16, 0, 0),    // S_FIRE15
            new state_t(spritenum_t.SPR_FIRE, 32771, 2, think_t.A_Fire, StateNum.S_FIRE17, 0, 0),    // S_FIRE16
            new state_t(spritenum_t.SPR_FIRE, 32772, 2, think_t.A_Fire, StateNum.S_FIRE18, 0, 0),    // S_FIRE17
            new state_t(spritenum_t.SPR_FIRE, 32771, 2, think_t.A_Fire, StateNum.S_FIRE19, 0, 0),    // S_FIRE18
            new state_t(spritenum_t.SPR_FIRE, 32772, 2, think_t.A_FireCrackle, StateNum.S_FIRE20, 0, 0),    // S_FIRE19
            new state_t(spritenum_t.SPR_FIRE, 32773, 2, think_t.A_Fire, StateNum.S_FIRE21, 0, 0),    // S_FIRE20
            new state_t(spritenum_t.SPR_FIRE, 32772, 2, think_t.A_Fire, StateNum.S_FIRE22, 0, 0),    // S_FIRE21
            new state_t(spritenum_t.SPR_FIRE, 32773, 2, think_t.A_Fire, StateNum.S_FIRE23, 0, 0),    // S_FIRE22
            new state_t(spritenum_t.SPR_FIRE, 32772, 2, think_t.A_Fire, StateNum.S_FIRE24, 0, 0),    // S_FIRE23
            new state_t(spritenum_t.SPR_FIRE, 32773, 2, think_t.A_Fire, StateNum.S_FIRE25, 0, 0),    // S_FIRE24
            new state_t(spritenum_t.SPR_FIRE, 32774, 2, think_t.A_Fire, StateNum.S_FIRE26, 0, 0),    // S_FIRE25
            new state_t(spritenum_t.SPR_FIRE, 32775, 2, think_t.A_Fire, StateNum.S_FIRE27, 0, 0),    // S_FIRE26
            new state_t(spritenum_t.SPR_FIRE, 32774, 2, think_t.A_Fire, StateNum.S_FIRE28, 0, 0),    // S_FIRE27
            new state_t(spritenum_t.SPR_FIRE, 32775, 2, think_t.A_Fire, StateNum.S_FIRE29, 0, 0),    // S_FIRE28
            new state_t(spritenum_t.SPR_FIRE, 32774, 2, think_t.A_Fire, StateNum.S_FIRE30, 0, 0),    // S_FIRE29
            new state_t(spritenum_t.SPR_FIRE, 32775, 2, think_t.A_Fire, StateNum.S_NULL, 0, 0),    // S_FIRE30
            new state_t(spritenum_t.SPR_PUFF, 1, 4, null, StateNum.S_SMOKE2, 0, 0),    // S_SMOKE1
            new state_t(spritenum_t.SPR_PUFF, 2, 4, null, StateNum.S_SMOKE3, 0, 0),    // S_SMOKE2
            new state_t(spritenum_t.SPR_PUFF, 1, 4, null, StateNum.S_SMOKE4, 0, 0),    // S_SMOKE3
            new state_t(spritenum_t.SPR_PUFF, 2, 4, null, StateNum.S_SMOKE5, 0, 0),    // S_SMOKE4
            new state_t(spritenum_t.SPR_PUFF, 3, 4, null, StateNum.S_NULL, 0, 0),    // S_SMOKE5
            new state_t(spritenum_t.SPR_FATB, 32768, 2, think_t.A_Tracer, StateNum.S_TRACER2, 0, 0),    // S_TRACER
            new state_t(spritenum_t.SPR_FATB, 32769, 2, think_t.A_Tracer, StateNum.S_TRACER, 0, 0),    // S_TRACER2
            new state_t(spritenum_t.SPR_FBXP, 32768, 8, null, StateNum.S_TRACEEXP2, 0, 0),    // S_TRACEEXP1
            new state_t(spritenum_t.SPR_FBXP, 32769, 6, null, StateNum.S_TRACEEXP3, 0, 0),    // S_TRACEEXP2
            new state_t(spritenum_t.SPR_FBXP, 32770, 4, null, StateNum.S_NULL, 0, 0),    // S_TRACEEXP3
            new state_t(spritenum_t.SPR_SKEL, 0, 10, think_t.A_Look, StateNum.S_SKEL_STND2, 0, 0),    // S_SKEL_STND
            new state_t(spritenum_t.SPR_SKEL, 1, 10, think_t.A_Look, StateNum.S_SKEL_STND, 0, 0),    // S_SKEL_STND2
            new state_t(spritenum_t.SPR_SKEL, 0, 2, think_t.A_Chase, StateNum.S_SKEL_RUN2, 0, 0),    // S_SKEL_RUN1
            new state_t(spritenum_t.SPR_SKEL, 0, 2, think_t.A_Chase, StateNum.S_SKEL_RUN3, 0, 0),    // S_SKEL_RUN2
            new state_t(spritenum_t.SPR_SKEL, 1, 2, think_t.A_Chase, StateNum.S_SKEL_RUN4, 0, 0),    // S_SKEL_RUN3
            new state_t(spritenum_t.SPR_SKEL, 1, 2, think_t.A_Chase, StateNum.S_SKEL_RUN5, 0, 0),    // S_SKEL_RUN4
            new state_t(spritenum_t.SPR_SKEL, 2, 2, think_t.A_Chase, StateNum.S_SKEL_RUN6, 0, 0),    // S_SKEL_RUN5
            new state_t(spritenum_t.SPR_SKEL, 2, 2, think_t.A_Chase, StateNum.S_SKEL_RUN7, 0, 0),    // S_SKEL_RUN6
            new state_t(spritenum_t.SPR_SKEL, 3, 2, think_t.A_Chase, StateNum.S_SKEL_RUN8, 0, 0),    // S_SKEL_RUN7
            new state_t(spritenum_t.SPR_SKEL, 3, 2, think_t.A_Chase, StateNum.S_SKEL_RUN9, 0, 0),    // S_SKEL_RUN8
            new state_t(spritenum_t.SPR_SKEL, 4, 2, think_t.A_Chase, StateNum.S_SKEL_RUN10, 0, 0),    // S_SKEL_RUN9
            new state_t(spritenum_t.SPR_SKEL, 4, 2, think_t.A_Chase, StateNum.S_SKEL_RUN11, 0, 0),    // S_SKEL_RUN10
            new state_t(spritenum_t.SPR_SKEL, 5, 2, think_t.A_Chase, StateNum.S_SKEL_RUN12, 0, 0),    // S_SKEL_RUN11
            new state_t(spritenum_t.SPR_SKEL, 5, 2, think_t.A_Chase, StateNum.S_SKEL_RUN1, 0, 0),    // S_SKEL_RUN12
            new state_t(spritenum_t.SPR_SKEL, 6, 0, think_t.A_FaceTarget, StateNum.S_SKEL_FIST2, 0, 0),    // S_SKEL_FIST1
            new state_t(spritenum_t.SPR_SKEL, 6, 6, think_t.A_SkelWhoosh, StateNum.S_SKEL_FIST3, 0, 0),    // S_SKEL_FIST2
            new state_t(spritenum_t.SPR_SKEL, 7, 6, think_t.A_FaceTarget, StateNum.S_SKEL_FIST4, 0, 0),    // S_SKEL_FIST3
            new state_t(spritenum_t.SPR_SKEL, 8, 6, think_t.A_SkelFist, StateNum.S_SKEL_RUN1, 0, 0),    // S_SKEL_FIST4
            new state_t(spritenum_t.SPR_SKEL, 32777, 0, think_t.A_FaceTarget, StateNum.S_SKEL_MISS2, 0, 0),    // S_SKEL_MISS1
            new state_t(spritenum_t.SPR_SKEL, 32777, 10, think_t.A_FaceTarget, StateNum.S_SKEL_MISS3, 0, 0),    // S_SKEL_MISS2
            new state_t(spritenum_t.SPR_SKEL, 10, 10, think_t.A_SkelMissile, StateNum.S_SKEL_MISS4, 0, 0),    // S_SKEL_MISS3
            new state_t(spritenum_t.SPR_SKEL, 10, 10, think_t.A_FaceTarget, StateNum.S_SKEL_RUN1, 0, 0),    // S_SKEL_MISS4
            new state_t(spritenum_t.SPR_SKEL, 11, 5, null, StateNum.S_SKEL_PAIN2, 0, 0),    // S_SKEL_PAIN
            new state_t(spritenum_t.SPR_SKEL, 11, 5, think_t.A_Pain, StateNum.S_SKEL_RUN1, 0, 0),    // S_SKEL_PAIN2
            new state_t(spritenum_t.SPR_SKEL, 11, 7, null, StateNum.S_SKEL_DIE2, 0, 0),    // S_SKEL_DIE1
            new state_t(spritenum_t.SPR_SKEL, 12, 7, null, StateNum.S_SKEL_DIE3, 0, 0),    // S_SKEL_DIE2
            new state_t(spritenum_t.SPR_SKEL, 13, 7, think_t.A_Scream, StateNum.S_SKEL_DIE4, 0, 0),    // S_SKEL_DIE3
            new state_t(spritenum_t.SPR_SKEL, 14, 7, think_t.A_Fall, StateNum.S_SKEL_DIE5, 0, 0),    // S_SKEL_DIE4
            new state_t(spritenum_t.SPR_SKEL, 15, 7, null, StateNum.S_SKEL_DIE6, 0, 0),    // S_SKEL_DIE5
            new state_t(spritenum_t.SPR_SKEL, 16, -1, null, StateNum.S_NULL, 0, 0),    // S_SKEL_DIE6
            new state_t(spritenum_t.SPR_SKEL, 16, 5, null, StateNum.S_SKEL_RAISE2, 0, 0),    // S_SKEL_RAISE1
            new state_t(spritenum_t.SPR_SKEL, 15, 5, null, StateNum.S_SKEL_RAISE3, 0, 0),    // S_SKEL_RAISE2
            new state_t(spritenum_t.SPR_SKEL, 14, 5, null, StateNum.S_SKEL_RAISE4, 0, 0),    // S_SKEL_RAISE3
            new state_t(spritenum_t.SPR_SKEL, 13, 5, null, StateNum.S_SKEL_RAISE5, 0, 0),    // S_SKEL_RAISE4
            new state_t(spritenum_t.SPR_SKEL, 12, 5, null, StateNum.S_SKEL_RAISE6, 0, 0),    // S_SKEL_RAISE5
            new state_t(spritenum_t.SPR_SKEL, 11, 5, null, StateNum.S_SKEL_RUN1, 0, 0),    // S_SKEL_RAISE6
            new state_t(spritenum_t.SPR_MANF, 32768, 4, null, StateNum.S_FATSHOT2, 0, 0),    // S_FATSHOT1
            new state_t(spritenum_t.SPR_MANF, 32769, 4, null, StateNum.S_FATSHOT1, 0, 0),    // S_FATSHOT2
            new state_t(spritenum_t.SPR_MISL, 32769, 8, null, StateNum.S_FATSHOTX2, 0, 0),    // S_FATSHOTX1
            new state_t(spritenum_t.SPR_MISL, 32770, 6, null, StateNum.S_FATSHOTX3, 0, 0),    // S_FATSHOTX2
            new state_t(spritenum_t.SPR_MISL, 32771, 4, null, StateNum.S_NULL, 0, 0),    // S_FATSHOTX3
            new state_t(spritenum_t.SPR_FATT, 0, 15, think_t.A_Look, StateNum.S_FATT_STND2, 0, 0),    // S_FATT_STND
            new state_t(spritenum_t.SPR_FATT, 1, 15, think_t.A_Look, StateNum.S_FATT_STND, 0, 0),    // S_FATT_STND2
            new state_t(spritenum_t.SPR_FATT, 0, 4, think_t.A_Chase, StateNum.S_FATT_RUN2, 0, 0),    // S_FATT_RUN1
            new state_t(spritenum_t.SPR_FATT, 0, 4, think_t.A_Chase, StateNum.S_FATT_RUN3, 0, 0),    // S_FATT_RUN2
            new state_t(spritenum_t.SPR_FATT, 1, 4, think_t.A_Chase, StateNum.S_FATT_RUN4, 0, 0),    // S_FATT_RUN3
            new state_t(spritenum_t.SPR_FATT, 1, 4, think_t.A_Chase, StateNum.S_FATT_RUN5, 0, 0),    // S_FATT_RUN4
            new state_t(spritenum_t.SPR_FATT, 2, 4, think_t.A_Chase, StateNum.S_FATT_RUN6, 0, 0),    // S_FATT_RUN5
            new state_t(spritenum_t.SPR_FATT, 2, 4, think_t.A_Chase, StateNum.S_FATT_RUN7, 0, 0),    // S_FATT_RUN6
            new state_t(spritenum_t.SPR_FATT, 3, 4, think_t.A_Chase, StateNum.S_FATT_RUN8, 0, 0),    // S_FATT_RUN7
            new state_t(spritenum_t.SPR_FATT, 3, 4, think_t.A_Chase, StateNum.S_FATT_RUN9, 0, 0),    // S_FATT_RUN8
            new state_t(spritenum_t.SPR_FATT, 4, 4, think_t.A_Chase, StateNum.S_FATT_RUN10, 0, 0),    // S_FATT_RUN9
            new state_t(spritenum_t.SPR_FATT, 4, 4, think_t.A_Chase, StateNum.S_FATT_RUN11, 0, 0),    // S_FATT_RUN10
            new state_t(spritenum_t.SPR_FATT, 5, 4, think_t.A_Chase, StateNum.S_FATT_RUN12, 0, 0),    // S_FATT_RUN11
            new state_t(spritenum_t.SPR_FATT, 5, 4, think_t.A_Chase, StateNum.S_FATT_RUN1, 0, 0),    // S_FATT_RUN12
            new state_t(spritenum_t.SPR_FATT, 6, 20, think_t.A_FatRaise, StateNum.S_FATT_ATK2, 0, 0),    // S_FATT_ATK1
            new state_t(spritenum_t.SPR_FATT, 32775, 10, think_t.A_FatAttack1, StateNum.S_FATT_ATK3, 0, 0),    // S_FATT_ATK2
            new state_t(spritenum_t.SPR_FATT, 8, 5, think_t.A_FaceTarget, StateNum.S_FATT_ATK4, 0, 0),    // S_FATT_ATK3
            new state_t(spritenum_t.SPR_FATT, 6, 5, think_t.A_FaceTarget, StateNum.S_FATT_ATK5, 0, 0),    // S_FATT_ATK4
            new state_t(spritenum_t.SPR_FATT, 32775, 10, think_t.A_FatAttack2, StateNum.S_FATT_ATK6, 0, 0),    // S_FATT_ATK5
            new state_t(spritenum_t.SPR_FATT, 8, 5, think_t.A_FaceTarget, StateNum.S_FATT_ATK7, 0, 0),    // S_FATT_ATK6
            new state_t(spritenum_t.SPR_FATT, 6, 5, think_t.A_FaceTarget, StateNum.S_FATT_ATK8, 0, 0),    // S_FATT_ATK7
            new state_t(spritenum_t.SPR_FATT, 32775, 10, think_t.A_FatAttack3, StateNum.S_FATT_ATK9, 0, 0),    // S_FATT_ATK8
            new state_t(spritenum_t.SPR_FATT, 8, 5, think_t.A_FaceTarget, StateNum.S_FATT_ATK10, 0, 0),    // S_FATT_ATK9
            new state_t(spritenum_t.SPR_FATT, 6, 5, think_t.A_FaceTarget, StateNum.S_FATT_RUN1, 0, 0),    // S_FATT_ATK10
            new state_t(spritenum_t.SPR_FATT, 9, 3, null, StateNum.S_FATT_PAIN2, 0, 0),    // S_FATT_PAIN
            new state_t(spritenum_t.SPR_FATT, 9, 3, think_t.A_Pain, StateNum.S_FATT_RUN1, 0, 0),    // S_FATT_PAIN2
            new state_t(spritenum_t.SPR_FATT, 10, 6, null, StateNum.S_FATT_DIE2, 0, 0),    // S_FATT_DIE1
            new state_t(spritenum_t.SPR_FATT, 11, 6, think_t.A_Scream, StateNum.S_FATT_DIE3, 0, 0),    // S_FATT_DIE2
            new state_t(spritenum_t.SPR_FATT, 12, 6, think_t.A_Fall, StateNum.S_FATT_DIE4, 0, 0),    // S_FATT_DIE3
            new state_t(spritenum_t.SPR_FATT, 13, 6, null, StateNum.S_FATT_DIE5, 0, 0),    // S_FATT_DIE4
            new state_t(spritenum_t.SPR_FATT, 14, 6, null, StateNum.S_FATT_DIE6, 0, 0),    // S_FATT_DIE5
            new state_t(spritenum_t.SPR_FATT, 15, 6, null, StateNum.S_FATT_DIE7, 0, 0),    // S_FATT_DIE6
            new state_t(spritenum_t.SPR_FATT, 16, 6, null, StateNum.S_FATT_DIE8, 0, 0),    // S_FATT_DIE7
            new state_t(spritenum_t.SPR_FATT, 17, 6, null, StateNum.S_FATT_DIE9, 0, 0),    // S_FATT_DIE8
            new state_t(spritenum_t.SPR_FATT, 18, 6, null, StateNum.S_FATT_DIE10, 0, 0),    // S_FATT_DIE9
            new state_t(spritenum_t.SPR_FATT, 19, -1, think_t.A_BossDeath, StateNum.S_NULL, 0, 0),    // S_FATT_DIE10
            new state_t(spritenum_t.SPR_FATT, 17, 5, null, StateNum.S_FATT_RAISE2, 0, 0),    // S_FATT_RAISE1
            new state_t(spritenum_t.SPR_FATT, 16, 5, null, StateNum.S_FATT_RAISE3, 0, 0),    // S_FATT_RAISE2
            new state_t(spritenum_t.SPR_FATT, 15, 5, null, StateNum.S_FATT_RAISE4, 0, 0),    // S_FATT_RAISE3
            new state_t(spritenum_t.SPR_FATT, 14, 5, null, StateNum.S_FATT_RAISE5, 0, 0),    // S_FATT_RAISE4
            new state_t(spritenum_t.SPR_FATT, 13, 5, null, StateNum.S_FATT_RAISE6, 0, 0),    // S_FATT_RAISE5
            new state_t(spritenum_t.SPR_FATT, 12, 5, null, StateNum.S_FATT_RAISE7, 0, 0),    // S_FATT_RAISE6
            new state_t(spritenum_t.SPR_FATT, 11, 5, null, StateNum.S_FATT_RAISE8, 0, 0),    // S_FATT_RAISE7
            new state_t(spritenum_t.SPR_FATT, 10, 5, null, StateNum.S_FATT_RUN1, 0, 0),    // S_FATT_RAISE8
            new state_t(spritenum_t.SPR_CPOS, 0, 10, think_t.A_Look, StateNum.S_CPOS_STND2, 0, 0),    // S_CPOS_STND
            new state_t(spritenum_t.SPR_CPOS, 1, 10, think_t.A_Look, StateNum.S_CPOS_STND, 0, 0),    // S_CPOS_STND2
            new state_t(spritenum_t.SPR_CPOS, 0, 3, think_t.A_Chase, StateNum.S_CPOS_RUN2, 0, 0),    // S_CPOS_RUN1
            new state_t(spritenum_t.SPR_CPOS, 0, 3, think_t.A_Chase, StateNum.S_CPOS_RUN3, 0, 0),    // S_CPOS_RUN2
            new state_t(spritenum_t.SPR_CPOS, 1, 3, think_t.A_Chase, StateNum.S_CPOS_RUN4, 0, 0),    // S_CPOS_RUN3
            new state_t(spritenum_t.SPR_CPOS, 1, 3, think_t.A_Chase, StateNum.S_CPOS_RUN5, 0, 0),    // S_CPOS_RUN4
            new state_t(spritenum_t.SPR_CPOS, 2, 3, think_t.A_Chase, StateNum.S_CPOS_RUN6, 0, 0),    // S_CPOS_RUN5
            new state_t(spritenum_t.SPR_CPOS, 2, 3, think_t.A_Chase, StateNum.S_CPOS_RUN7, 0, 0),    // S_CPOS_RUN6
            new state_t(spritenum_t.SPR_CPOS, 3, 3, think_t.A_Chase, StateNum.S_CPOS_RUN8, 0, 0),    // S_CPOS_RUN7
            new state_t(spritenum_t.SPR_CPOS, 3, 3, think_t.A_Chase, StateNum.S_CPOS_RUN1, 0, 0),    // S_CPOS_RUN8
            new state_t(spritenum_t.SPR_CPOS, 4, 10, think_t.A_FaceTarget, StateNum.S_CPOS_ATK2, 0, 0),    // S_CPOS_ATK1
            new state_t(spritenum_t.SPR_CPOS, 32773, 4, think_t.A_CPosAttack, StateNum.S_CPOS_ATK3, 0, 0),    // S_CPOS_ATK2
            new state_t(spritenum_t.SPR_CPOS, 32772, 4, think_t.A_CPosAttack, StateNum.S_CPOS_ATK4, 0, 0),    // S_CPOS_ATK3
            new state_t(spritenum_t.SPR_CPOS, 5, 1, think_t.A_CPosRefire, StateNum.S_CPOS_ATK2, 0, 0),    // S_CPOS_ATK4
            new state_t(spritenum_t.SPR_CPOS, 6, 3, null, StateNum.S_CPOS_PAIN2, 0, 0),    // S_CPOS_PAIN
            new state_t(spritenum_t.SPR_CPOS, 6, 3, think_t.A_Pain, StateNum.S_CPOS_RUN1, 0, 0),    // S_CPOS_PAIN2
            new state_t(spritenum_t.SPR_CPOS, 7, 5, null, StateNum.S_CPOS_DIE2, 0, 0),    // S_CPOS_DIE1
            new state_t(spritenum_t.SPR_CPOS, 8, 5, think_t.A_Scream, StateNum.S_CPOS_DIE3, 0, 0),    // S_CPOS_DIE2
            new state_t(spritenum_t.SPR_CPOS, 9, 5, think_t.A_Fall, StateNum.S_CPOS_DIE4, 0, 0),    // S_CPOS_DIE3
            new state_t(spritenum_t.SPR_CPOS, 10, 5, null, StateNum.S_CPOS_DIE5, 0, 0),    // S_CPOS_DIE4
            new state_t(spritenum_t.SPR_CPOS, 11, 5, null, StateNum.S_CPOS_DIE6, 0, 0),    // S_CPOS_DIE5
            new state_t(spritenum_t.SPR_CPOS, 12, 5, null, StateNum.S_CPOS_DIE7, 0, 0),    // S_CPOS_DIE6
            new state_t(spritenum_t.SPR_CPOS, 13, -1, null, StateNum.S_NULL, 0, 0),    // S_CPOS_DIE7
            new state_t(spritenum_t.SPR_CPOS, 14, 5, null, StateNum.S_CPOS_XDIE2, 0, 0),    // S_CPOS_XDIE1
            new state_t(spritenum_t.SPR_CPOS, 15, 5, think_t.A_XScream, StateNum.S_CPOS_XDIE3, 0, 0),    // S_CPOS_XDIE2
            new state_t(spritenum_t.SPR_CPOS, 16, 5, think_t.A_Fall, StateNum.S_CPOS_XDIE4, 0, 0),    // S_CPOS_XDIE3
            new state_t(spritenum_t.SPR_CPOS, 17, 5, null, StateNum.S_CPOS_XDIE5, 0, 0),    // S_CPOS_XDIE4
            new state_t(spritenum_t.SPR_CPOS, 18, 5, null, StateNum.S_CPOS_XDIE6, 0, 0),    // S_CPOS_XDIE5
            new state_t(spritenum_t.SPR_CPOS, 19, -1, null, StateNum.S_NULL, 0, 0),    // S_CPOS_XDIE6
            new state_t(spritenum_t.SPR_CPOS, 13, 5, null, StateNum.S_CPOS_RAISE2, 0, 0),    // S_CPOS_RAISE1
            new state_t(spritenum_t.SPR_CPOS, 12, 5, null, StateNum.S_CPOS_RAISE3, 0, 0),    // S_CPOS_RAISE2
            new state_t(spritenum_t.SPR_CPOS, 11, 5, null, StateNum.S_CPOS_RAISE4, 0, 0),    // S_CPOS_RAISE3
            new state_t(spritenum_t.SPR_CPOS, 10, 5, null, StateNum.S_CPOS_RAISE5, 0, 0),    // S_CPOS_RAISE4
            new state_t(spritenum_t.SPR_CPOS, 9, 5, null, StateNum.S_CPOS_RAISE6, 0, 0),    // S_CPOS_RAISE5
            new state_t(spritenum_t.SPR_CPOS, 8, 5, null, StateNum.S_CPOS_RAISE7, 0, 0),    // S_CPOS_RAISE6
            new state_t(spritenum_t.SPR_CPOS, 7, 5, null, StateNum.S_CPOS_RUN1, 0, 0),    // S_CPOS_RAISE7
            new state_t(spritenum_t.SPR_TROO, 0, 10, think_t.A_Look, StateNum.S_TROO_STND2, 0, 0),    // S_TROO_STND
            new state_t(spritenum_t.SPR_TROO, 1, 10, think_t.A_Look, StateNum.S_TROO_STND, 0, 0),    // S_TROO_STND2
            new state_t(spritenum_t.SPR_TROO, 0, 3, think_t.A_Chase, StateNum.S_TROO_RUN2, 0, 0),    // S_TROO_RUN1
            new state_t(spritenum_t.SPR_TROO, 0, 3, think_t.A_Chase, StateNum.S_TROO_RUN3, 0, 0),    // S_TROO_RUN2
            new state_t(spritenum_t.SPR_TROO, 1, 3, think_t.A_Chase, StateNum.S_TROO_RUN4, 0, 0),    // S_TROO_RUN3
            new state_t(spritenum_t.SPR_TROO, 1, 3, think_t.A_Chase, StateNum.S_TROO_RUN5, 0, 0),    // S_TROO_RUN4
            new state_t(spritenum_t.SPR_TROO, 2, 3, think_t.A_Chase, StateNum.S_TROO_RUN6, 0, 0),    // S_TROO_RUN5
            new state_t(spritenum_t.SPR_TROO, 2, 3, think_t.A_Chase, StateNum.S_TROO_RUN7, 0, 0),    // S_TROO_RUN6
            new state_t(spritenum_t.SPR_TROO, 3, 3, think_t.A_Chase, StateNum.S_TROO_RUN8, 0, 0),    // S_TROO_RUN7
            new state_t(spritenum_t.SPR_TROO, 3, 3, think_t.A_Chase, StateNum.S_TROO_RUN1, 0, 0),    // S_TROO_RUN8
            new state_t(spritenum_t.SPR_TROO, 4, 8, think_t.A_FaceTarget, StateNum.S_TROO_ATK2, 0, 0),    // S_TROO_ATK1
            new state_t(spritenum_t.SPR_TROO, 5, 8, think_t.A_FaceTarget, StateNum.S_TROO_ATK3, 0, 0),    // S_TROO_ATK2
            new state_t(spritenum_t.SPR_TROO, 6, 6, think_t.A_TroopAttack, StateNum.S_TROO_RUN1, 0, 0),    // S_TROO_ATK3
            new state_t(spritenum_t.SPR_TROO, 7, 2, null, StateNum.S_TROO_PAIN2, 0, 0),    // S_TROO_PAIN
            new state_t(spritenum_t.SPR_TROO, 7, 2, think_t.A_Pain, StateNum.S_TROO_RUN1, 0, 0),    // S_TROO_PAIN2
            new state_t(spritenum_t.SPR_TROO, 8, 8, null, StateNum.S_TROO_DIE2, 0, 0),    // S_TROO_DIE1
            new state_t(spritenum_t.SPR_TROO, 9, 8, think_t.A_Scream, StateNum.S_TROO_DIE3, 0, 0),    // S_TROO_DIE2
            new state_t(spritenum_t.SPR_TROO, 10, 6, null, StateNum.S_TROO_DIE4, 0, 0),    // S_TROO_DIE3
            new state_t(spritenum_t.SPR_TROO, 11, 6, think_t.A_Fall, StateNum.S_TROO_DIE5, 0, 0),    // S_TROO_DIE4
            new state_t(spritenum_t.SPR_TROO, 12, -1, null, StateNum.S_NULL, 0, 0),    // S_TROO_DIE5
            new state_t(spritenum_t.SPR_TROO, 13, 5, null, StateNum.S_TROO_XDIE2, 0, 0),    // S_TROO_XDIE1
            new state_t(spritenum_t.SPR_TROO, 14, 5, think_t.A_XScream, StateNum.S_TROO_XDIE3, 0, 0),    // S_TROO_XDIE2
            new state_t(spritenum_t.SPR_TROO, 15, 5, null, StateNum.S_TROO_XDIE4, 0, 0),    // S_TROO_XDIE3
            new state_t(spritenum_t.SPR_TROO, 16, 5, think_t.A_Fall, StateNum.S_TROO_XDIE5, 0, 0),    // S_TROO_XDIE4
            new state_t(spritenum_t.SPR_TROO, 17, 5, null, StateNum.S_TROO_XDIE6, 0, 0),    // S_TROO_XDIE5
            new state_t(spritenum_t.SPR_TROO, 18, 5, null, StateNum.S_TROO_XDIE7, 0, 0),    // S_TROO_XDIE6
            new state_t(spritenum_t.SPR_TROO, 19, 5, null, StateNum.S_TROO_XDIE8, 0, 0),    // S_TROO_XDIE7
            new state_t(spritenum_t.SPR_TROO, 20, -1, null, StateNum.S_NULL, 0, 0),    // S_TROO_XDIE8
            new state_t(spritenum_t.SPR_TROO, 12, 8, null, StateNum.S_TROO_RAISE2, 0, 0),    // S_TROO_RAISE1
            new state_t(spritenum_t.SPR_TROO, 11, 8, null, StateNum.S_TROO_RAISE3, 0, 0),    // S_TROO_RAISE2
            new state_t(spritenum_t.SPR_TROO, 10, 6, null, StateNum.S_TROO_RAISE4, 0, 0),    // S_TROO_RAISE3
            new state_t(spritenum_t.SPR_TROO, 9, 6, null, StateNum.S_TROO_RAISE5, 0, 0),    // S_TROO_RAISE4
            new state_t(spritenum_t.SPR_TROO, 8, 6, null, StateNum.S_TROO_RUN1, 0, 0),    // S_TROO_RAISE5
            new state_t(spritenum_t.SPR_SARG, 0, 10, think_t.A_Look, StateNum.S_SARG_STND2, 0, 0),    // S_SARG_STND
            new state_t(spritenum_t.SPR_SARG, 1, 10, think_t.A_Look, StateNum.S_SARG_STND, 0, 0),    // S_SARG_STND2
            new state_t(spritenum_t.SPR_SARG, 0, 2, think_t.A_Chase, StateNum.S_SARG_RUN2, 0, 0),    // S_SARG_RUN1
            new state_t(spritenum_t.SPR_SARG, 0, 2, think_t.A_Chase, StateNum.S_SARG_RUN3, 0, 0),    // S_SARG_RUN2
            new state_t(spritenum_t.SPR_SARG, 1, 2, think_t.A_Chase, StateNum.S_SARG_RUN4, 0, 0),    // S_SARG_RUN3
            new state_t(spritenum_t.SPR_SARG, 1, 2, think_t.A_Chase, StateNum.S_SARG_RUN5, 0, 0),    // S_SARG_RUN4
            new state_t(spritenum_t.SPR_SARG, 2, 2, think_t.A_Chase, StateNum.S_SARG_RUN6, 0, 0),    // S_SARG_RUN5
            new state_t(spritenum_t.SPR_SARG, 2, 2, think_t.A_Chase, StateNum.S_SARG_RUN7, 0, 0),    // S_SARG_RUN6
            new state_t(spritenum_t.SPR_SARG, 3, 2, think_t.A_Chase, StateNum.S_SARG_RUN8, 0, 0),    // S_SARG_RUN7
            new state_t(spritenum_t.SPR_SARG, 3, 2, think_t.A_Chase, StateNum.S_SARG_RUN1, 0, 0),    // S_SARG_RUN8
            new state_t(spritenum_t.SPR_SARG, 4, 8, think_t.A_FaceTarget, StateNum.S_SARG_ATK2, 0, 0),    // S_SARG_ATK1
            new state_t(spritenum_t.SPR_SARG, 5, 8, think_t.A_FaceTarget, StateNum.S_SARG_ATK3, 0, 0),    // S_SARG_ATK2
            new state_t(spritenum_t.SPR_SARG, 6, 8, think_t.A_SargAttack, StateNum.S_SARG_RUN1, 0, 0),    // S_SARG_ATK3
            new state_t(spritenum_t.SPR_SARG, 7, 2, null, StateNum.S_SARG_PAIN2, 0, 0),    // S_SARG_PAIN
            new state_t(spritenum_t.SPR_SARG, 7, 2, think_t.A_Pain, StateNum.S_SARG_RUN1, 0, 0),    // S_SARG_PAIN2
            new state_t(spritenum_t.SPR_SARG, 8, 8, null, StateNum.S_SARG_DIE2, 0, 0),    // S_SARG_DIE1
            new state_t(spritenum_t.SPR_SARG, 9, 8, think_t.A_Scream, StateNum.S_SARG_DIE3, 0, 0),    // S_SARG_DIE2
            new state_t(spritenum_t.SPR_SARG, 10, 4, null, StateNum.S_SARG_DIE4, 0, 0),    // S_SARG_DIE3
            new state_t(spritenum_t.SPR_SARG, 11, 4, think_t.A_Fall, StateNum.S_SARG_DIE5, 0, 0),    // S_SARG_DIE4
            new state_t(spritenum_t.SPR_SARG, 12, 4, null, StateNum.S_SARG_DIE6, 0, 0),    // S_SARG_DIE5
            new state_t(spritenum_t.SPR_SARG, 13, -1, null, StateNum.S_NULL, 0, 0),    // S_SARG_DIE6
            new state_t(spritenum_t.SPR_SARG, 13, 5, null, StateNum.S_SARG_RAISE2, 0, 0),    // S_SARG_RAISE1
            new state_t(spritenum_t.SPR_SARG, 12, 5, null, StateNum.S_SARG_RAISE3, 0, 0),    // S_SARG_RAISE2
            new state_t(spritenum_t.SPR_SARG, 11, 5, null, StateNum.S_SARG_RAISE4, 0, 0),    // S_SARG_RAISE3
            new state_t(spritenum_t.SPR_SARG, 10, 5, null, StateNum.S_SARG_RAISE5, 0, 0),    // S_SARG_RAISE4
            new state_t(spritenum_t.SPR_SARG, 9, 5, null, StateNum.S_SARG_RAISE6, 0, 0),    // S_SARG_RAISE5
            new state_t(spritenum_t.SPR_SARG, 8, 5, null, StateNum.S_SARG_RUN1, 0, 0),    // S_SARG_RAISE6
            new state_t(spritenum_t.SPR_HEAD, 0, 10, think_t.A_Look, StateNum.S_HEAD_STND, 0, 0),    // S_HEAD_STND
            new state_t(spritenum_t.SPR_HEAD, 0, 3, think_t.A_Chase, StateNum.S_HEAD_RUN1, 0, 0),    // S_HEAD_RUN1
            new state_t(spritenum_t.SPR_HEAD, 1, 5, think_t.A_FaceTarget, StateNum.S_HEAD_ATK2, 0, 0),    // S_HEAD_ATK1
            new state_t(spritenum_t.SPR_HEAD, 2, 5, think_t.A_FaceTarget, StateNum.S_HEAD_ATK3, 0, 0),    // S_HEAD_ATK2
            new state_t(spritenum_t.SPR_HEAD, 32771, 5, think_t.A_HeadAttack, StateNum.S_HEAD_RUN1, 0, 0),    // S_HEAD_ATK3
            new state_t(spritenum_t.SPR_HEAD, 4, 3, null, StateNum.S_HEAD_PAIN2, 0, 0),    // S_HEAD_PAIN
            new state_t(spritenum_t.SPR_HEAD, 4, 3, think_t.A_Pain, StateNum.S_HEAD_PAIN3, 0, 0),    // S_HEAD_PAIN2
            new state_t(spritenum_t.SPR_HEAD, 5, 6, null, StateNum.S_HEAD_RUN1, 0, 0),    // S_HEAD_PAIN3
            new state_t(spritenum_t.SPR_HEAD, 6, 8, null, StateNum.S_HEAD_DIE2, 0, 0),    // S_HEAD_DIE1
            new state_t(spritenum_t.SPR_HEAD, 7, 8, think_t.A_Scream, StateNum.S_HEAD_DIE3, 0, 0),    // S_HEAD_DIE2
            new state_t(spritenum_t.SPR_HEAD, 8, 8, null, StateNum.S_HEAD_DIE4, 0, 0),    // S_HEAD_DIE3
            new state_t(spritenum_t.SPR_HEAD, 9, 8, null, StateNum.S_HEAD_DIE5, 0, 0),    // S_HEAD_DIE4
            new state_t(spritenum_t.SPR_HEAD, 10, 8, think_t.A_Fall, StateNum.S_HEAD_DIE6, 0, 0),    // S_HEAD_DIE5
            new state_t(spritenum_t.SPR_HEAD, 11, -1, null, StateNum.S_NULL, 0, 0),    // S_HEAD_DIE6
            new state_t(spritenum_t.SPR_HEAD, 11, 8, null, StateNum.S_HEAD_RAISE2, 0, 0),    // S_HEAD_RAISE1
            new state_t(spritenum_t.SPR_HEAD, 10, 8, null, StateNum.S_HEAD_RAISE3, 0, 0),    // S_HEAD_RAISE2
            new state_t(spritenum_t.SPR_HEAD, 9, 8, null, StateNum.S_HEAD_RAISE4, 0, 0),    // S_HEAD_RAISE3
            new state_t(spritenum_t.SPR_HEAD, 8, 8, null, StateNum.S_HEAD_RAISE5, 0, 0),    // S_HEAD_RAISE4
            new state_t(spritenum_t.SPR_HEAD, 7, 8, null, StateNum.S_HEAD_RAISE6, 0, 0),    // S_HEAD_RAISE5
            new state_t(spritenum_t.SPR_HEAD, 6, 8, null, StateNum.S_HEAD_RUN1, 0, 0),    // S_HEAD_RAISE6
            new state_t(spritenum_t.SPR_BAL7, 32768, 4, null, StateNum.S_BRBALL2, 0, 0),    // S_BRBALL1
            new state_t(spritenum_t.SPR_BAL7, 32769, 4, null, StateNum.S_BRBALL1, 0, 0),    // S_BRBALL2
            new state_t(spritenum_t.SPR_BAL7, 32770, 6, null, StateNum.S_BRBALLX2, 0, 0),    // S_BRBALLX1
            new state_t(spritenum_t.SPR_BAL7, 32771, 6, null, StateNum.S_BRBALLX3, 0, 0),    // S_BRBALLX2
            new state_t(spritenum_t.SPR_BAL7, 32772, 6, null, StateNum.S_NULL, 0, 0),    // S_BRBALLX3
            new state_t(spritenum_t.SPR_BOSS, 0, 10, think_t.A_Look, StateNum.S_BOSS_STND2, 0, 0),    // S_BOSS_STND
            new state_t(spritenum_t.SPR_BOSS, 1, 10, think_t.A_Look, StateNum.S_BOSS_STND, 0, 0),    // S_BOSS_STND2
            new state_t(spritenum_t.SPR_BOSS, 0, 3, think_t.A_Chase, StateNum.S_BOSS_RUN2, 0, 0),    // S_BOSS_RUN1
            new state_t(spritenum_t.SPR_BOSS, 0, 3, think_t.A_Chase, StateNum.S_BOSS_RUN3, 0, 0),    // S_BOSS_RUN2
            new state_t(spritenum_t.SPR_BOSS, 1, 3, think_t.A_Chase, StateNum.S_BOSS_RUN4, 0, 0),    // S_BOSS_RUN3
            new state_t(spritenum_t.SPR_BOSS, 1, 3, think_t.A_Chase, StateNum.S_BOSS_RUN5, 0, 0),    // S_BOSS_RUN4
            new state_t(spritenum_t.SPR_BOSS, 2, 3, think_t.A_Chase, StateNum.S_BOSS_RUN6, 0, 0),    // S_BOSS_RUN5
            new state_t(spritenum_t.SPR_BOSS, 2, 3, think_t.A_Chase, StateNum.S_BOSS_RUN7, 0, 0),    // S_BOSS_RUN6
            new state_t(spritenum_t.SPR_BOSS, 3, 3, think_t.A_Chase, StateNum.S_BOSS_RUN8, 0, 0),    // S_BOSS_RUN7
            new state_t(spritenum_t.SPR_BOSS, 3, 3, think_t.A_Chase, StateNum.S_BOSS_RUN1, 0, 0),    // S_BOSS_RUN8
            new state_t(spritenum_t.SPR_BOSS, 4, 8, think_t.A_FaceTarget, StateNum.S_BOSS_ATK2, 0, 0),    // S_BOSS_ATK1
            new state_t(spritenum_t.SPR_BOSS, 5, 8, think_t.A_FaceTarget, StateNum.S_BOSS_ATK3, 0, 0),    // S_BOSS_ATK2
            new state_t(spritenum_t.SPR_BOSS, 6, 8, think_t.A_BruisAttack, StateNum.S_BOSS_RUN1, 0, 0),    // S_BOSS_ATK3
            new state_t(spritenum_t.SPR_BOSS, 7, 2, null, StateNum.S_BOSS_PAIN2, 0, 0),    // S_BOSS_PAIN
            new state_t(spritenum_t.SPR_BOSS, 7, 2, think_t.A_Pain, StateNum.S_BOSS_RUN1, 0, 0),    // S_BOSS_PAIN2
            new state_t(spritenum_t.SPR_BOSS, 8, 8, null, StateNum.S_BOSS_DIE2, 0, 0),    // S_BOSS_DIE1
            new state_t(spritenum_t.SPR_BOSS, 9, 8, think_t.A_Scream, StateNum.S_BOSS_DIE3, 0, 0),    // S_BOSS_DIE2
            new state_t(spritenum_t.SPR_BOSS, 10, 8, null, StateNum.S_BOSS_DIE4, 0, 0),    // S_BOSS_DIE3
            new state_t(spritenum_t.SPR_BOSS, 11, 8, think_t.A_Fall, StateNum.S_BOSS_DIE5, 0, 0),    // S_BOSS_DIE4
            new state_t(spritenum_t.SPR_BOSS, 12, 8, null, StateNum.S_BOSS_DIE6, 0, 0),    // S_BOSS_DIE5
            new state_t(spritenum_t.SPR_BOSS, 13, 8, null, StateNum.S_BOSS_DIE7, 0, 0),    // S_BOSS_DIE6
            new state_t(spritenum_t.SPR_BOSS, 14, -1, think_t.A_BossDeath, StateNum.S_NULL, 0, 0),    // S_BOSS_DIE7
            new state_t(spritenum_t.SPR_BOSS, 14, 8, null, StateNum.S_BOSS_RAISE2, 0, 0),    // S_BOSS_RAISE1
            new state_t(spritenum_t.SPR_BOSS, 13, 8, null, StateNum.S_BOSS_RAISE3, 0, 0),    // S_BOSS_RAISE2
            new state_t(spritenum_t.SPR_BOSS, 12, 8, null, StateNum.S_BOSS_RAISE4, 0, 0),    // S_BOSS_RAISE3
            new state_t(spritenum_t.SPR_BOSS, 11, 8, null, StateNum.S_BOSS_RAISE5, 0, 0),    // S_BOSS_RAISE4
            new state_t(spritenum_t.SPR_BOSS, 10, 8, null, StateNum.S_BOSS_RAISE6, 0, 0),    // S_BOSS_RAISE5
            new state_t(spritenum_t.SPR_BOSS, 9, 8, null, StateNum.S_BOSS_RAISE7, 0, 0),    // S_BOSS_RAISE6
            new state_t(spritenum_t.SPR_BOSS, 8, 8, null, StateNum.S_BOSS_RUN1, 0, 0),    // S_BOSS_RAISE7
            new state_t(spritenum_t.SPR_BOS2, 0, 10, think_t.A_Look, StateNum.S_BOS2_STND2, 0, 0),    // S_BOS2_STND
            new state_t(spritenum_t.SPR_BOS2, 1, 10, think_t.A_Look, StateNum.S_BOS2_STND, 0, 0),    // S_BOS2_STND2
            new state_t(spritenum_t.SPR_BOS2, 0, 3, think_t.A_Chase, StateNum.S_BOS2_RUN2, 0, 0),    // S_BOS2_RUN1
            new state_t(spritenum_t.SPR_BOS2, 0, 3, think_t.A_Chase, StateNum.S_BOS2_RUN3, 0, 0),    // S_BOS2_RUN2
            new state_t(spritenum_t.SPR_BOS2, 1, 3, think_t.A_Chase, StateNum.S_BOS2_RUN4, 0, 0),    // S_BOS2_RUN3
            new state_t(spritenum_t.SPR_BOS2, 1, 3, think_t.A_Chase, StateNum.S_BOS2_RUN5, 0, 0),    // S_BOS2_RUN4
            new state_t(spritenum_t.SPR_BOS2, 2, 3, think_t.A_Chase, StateNum.S_BOS2_RUN6, 0, 0),    // S_BOS2_RUN5
            new state_t(spritenum_t.SPR_BOS2, 2, 3, think_t.A_Chase, StateNum.S_BOS2_RUN7, 0, 0),    // S_BOS2_RUN6
            new state_t(spritenum_t.SPR_BOS2, 3, 3, think_t.A_Chase, StateNum.S_BOS2_RUN8, 0, 0),    // S_BOS2_RUN7
            new state_t(spritenum_t.SPR_BOS2, 3, 3, think_t.A_Chase, StateNum.S_BOS2_RUN1, 0, 0),    // S_BOS2_RUN8
            new state_t(spritenum_t.SPR_BOS2, 4, 8, think_t.A_FaceTarget, StateNum.S_BOS2_ATK2, 0, 0),    // S_BOS2_ATK1
            new state_t(spritenum_t.SPR_BOS2, 5, 8, think_t.A_FaceTarget, StateNum.S_BOS2_ATK3, 0, 0),    // S_BOS2_ATK2
            new state_t(spritenum_t.SPR_BOS2, 6, 8, think_t.A_BruisAttack, StateNum.S_BOS2_RUN1, 0, 0),    // S_BOS2_ATK3
            new state_t(spritenum_t.SPR_BOS2, 7, 2, null, StateNum.S_BOS2_PAIN2, 0, 0),    // S_BOS2_PAIN
            new state_t(spritenum_t.SPR_BOS2, 7, 2, think_t.A_Pain, StateNum.S_BOS2_RUN1, 0, 0),    // S_BOS2_PAIN2
            new state_t(spritenum_t.SPR_BOS2, 8, 8, null, StateNum.S_BOS2_DIE2, 0, 0),    // S_BOS2_DIE1
            new state_t(spritenum_t.SPR_BOS2, 9, 8, think_t.A_Scream, StateNum.S_BOS2_DIE3, 0, 0),    // S_BOS2_DIE2
            new state_t(spritenum_t.SPR_BOS2, 10, 8, null, StateNum.S_BOS2_DIE4, 0, 0),    // S_BOS2_DIE3
            new state_t(spritenum_t.SPR_BOS2, 11, 8, think_t.A_Fall, StateNum.S_BOS2_DIE5, 0, 0),    // S_BOS2_DIE4
            new state_t(spritenum_t.SPR_BOS2, 12, 8, null, StateNum.S_BOS2_DIE6, 0, 0),    // S_BOS2_DIE5
            new state_t(spritenum_t.SPR_BOS2, 13, 8, null, StateNum.S_BOS2_DIE7, 0, 0),    // S_BOS2_DIE6
            new state_t(spritenum_t.SPR_BOS2, 14, -1, null, StateNum.S_NULL, 0, 0),    // S_BOS2_DIE7
            new state_t(spritenum_t.SPR_BOS2, 14, 8, null, StateNum.S_BOS2_RAISE2, 0, 0),    // S_BOS2_RAISE1
            new state_t(spritenum_t.SPR_BOS2, 13, 8, null, StateNum.S_BOS2_RAISE3, 0, 0),    // S_BOS2_RAISE2
            new state_t(spritenum_t.SPR_BOS2, 12, 8, null, StateNum.S_BOS2_RAISE4, 0, 0),    // S_BOS2_RAISE3
            new state_t(spritenum_t.SPR_BOS2, 11, 8, null, StateNum.S_BOS2_RAISE5, 0, 0),    // S_BOS2_RAISE4
            new state_t(spritenum_t.SPR_BOS2, 10, 8, null, StateNum.S_BOS2_RAISE6, 0, 0),    // S_BOS2_RAISE5
            new state_t(spritenum_t.SPR_BOS2, 9, 8, null, StateNum.S_BOS2_RAISE7, 0, 0),    // S_BOS2_RAISE6
            new state_t(spritenum_t.SPR_BOS2, 8, 8, null, StateNum.S_BOS2_RUN1, 0, 0),    // S_BOS2_RAISE7
            new state_t(spritenum_t.SPR_SKUL, 32768, 10, think_t.A_Look, StateNum.S_SKULL_STND2, 0, 0),    // S_SKULL_STND
            new state_t(spritenum_t.SPR_SKUL, 32769, 10, think_t.A_Look, StateNum.S_SKULL_STND, 0, 0),    // S_SKULL_STND2
            new state_t(spritenum_t.SPR_SKUL, 32768, 6, think_t.A_Chase, StateNum.S_SKULL_RUN2, 0, 0),    // S_SKULL_RUN1
            new state_t(spritenum_t.SPR_SKUL, 32769, 6, think_t.A_Chase, StateNum.S_SKULL_RUN1, 0, 0),    // S_SKULL_RUN2
            new state_t(spritenum_t.SPR_SKUL, 32770, 10, think_t.A_FaceTarget, StateNum.S_SKULL_ATK2, 0, 0),    // S_SKULL_ATK1
            new state_t(spritenum_t.SPR_SKUL, 32771, 4, think_t.A_SkullAttack, StateNum.S_SKULL_ATK3, 0, 0),    // S_SKULL_ATK2
            new state_t(spritenum_t.SPR_SKUL, 32770, 4, null, StateNum.S_SKULL_ATK4, 0, 0),    // S_SKULL_ATK3
            new state_t(spritenum_t.SPR_SKUL, 32771, 4, null, StateNum.S_SKULL_ATK3, 0, 0),    // S_SKULL_ATK4
            new state_t(spritenum_t.SPR_SKUL, 32772, 3, null, StateNum.S_SKULL_PAIN2, 0, 0),    // S_SKULL_PAIN
            new state_t(spritenum_t.SPR_SKUL, 32772, 3, think_t.A_Pain, StateNum.S_SKULL_RUN1, 0, 0),    // S_SKULL_PAIN2
            new state_t(spritenum_t.SPR_SKUL, 32773, 6, null, StateNum.S_SKULL_DIE2, 0, 0),    // S_SKULL_DIE1
            new state_t(spritenum_t.SPR_SKUL, 32774, 6, think_t.A_Scream, StateNum.S_SKULL_DIE3, 0, 0),    // S_SKULL_DIE2
            new state_t(spritenum_t.SPR_SKUL, 32775, 6, null, StateNum.S_SKULL_DIE4, 0, 0),    // S_SKULL_DIE3
            new state_t(spritenum_t.SPR_SKUL, 32776, 6, think_t.A_Fall, StateNum.S_SKULL_DIE5, 0, 0),    // S_SKULL_DIE4
            new state_t(spritenum_t.SPR_SKUL, 9, 6, null, StateNum.S_SKULL_DIE6, 0, 0),    // S_SKULL_DIE5
            new state_t(spritenum_t.SPR_SKUL, 10, 6, null, StateNum.S_NULL, 0, 0),    // S_SKULL_DIE6
            new state_t(spritenum_t.SPR_SPID, 0, 10, think_t.A_Look, StateNum.S_SPID_STND2, 0, 0),    // S_SPID_STND
            new state_t(spritenum_t.SPR_SPID, 1, 10, think_t.A_Look, StateNum.S_SPID_STND, 0, 0),    // S_SPID_STND2
            new state_t(spritenum_t.SPR_SPID, 0, 3, think_t.A_Metal, StateNum.S_SPID_RUN2, 0, 0),    // S_SPID_RUN1
            new state_t(spritenum_t.SPR_SPID, 0, 3, think_t.A_Chase, StateNum.S_SPID_RUN3, 0, 0),    // S_SPID_RUN2
            new state_t(spritenum_t.SPR_SPID, 1, 3, think_t.A_Chase, StateNum.S_SPID_RUN4, 0, 0),    // S_SPID_RUN3
            new state_t(spritenum_t.SPR_SPID, 1, 3, think_t.A_Chase, StateNum.S_SPID_RUN5, 0, 0),    // S_SPID_RUN4
            new state_t(spritenum_t.SPR_SPID, 2, 3, think_t.A_Metal, StateNum.S_SPID_RUN6, 0, 0),    // S_SPID_RUN5
            new state_t(spritenum_t.SPR_SPID, 2, 3, think_t.A_Chase, StateNum.S_SPID_RUN7, 0, 0),    // S_SPID_RUN6
            new state_t(spritenum_t.SPR_SPID, 3, 3, think_t.A_Chase, StateNum.S_SPID_RUN8, 0, 0),    // S_SPID_RUN7
            new state_t(spritenum_t.SPR_SPID, 3, 3, think_t.A_Chase, StateNum.S_SPID_RUN9, 0, 0),    // S_SPID_RUN8
            new state_t(spritenum_t.SPR_SPID, 4, 3, think_t.A_Metal, StateNum.S_SPID_RUN10, 0, 0),    // S_SPID_RUN9
            new state_t(spritenum_t.SPR_SPID, 4, 3, think_t.A_Chase, StateNum.S_SPID_RUN11, 0, 0),    // S_SPID_RUN10
            new state_t(spritenum_t.SPR_SPID, 5, 3, think_t.A_Chase, StateNum.S_SPID_RUN12, 0, 0),    // S_SPID_RUN11
            new state_t(spritenum_t.SPR_SPID, 5, 3, think_t.A_Chase, StateNum.S_SPID_RUN1, 0, 0),    // S_SPID_RUN12
            new state_t(spritenum_t.SPR_SPID, 32768, 20, think_t.A_FaceTarget, StateNum.S_SPID_ATK2, 0, 0),    // S_SPID_ATK1
            new state_t(spritenum_t.SPR_SPID, 32774, 4, think_t.A_SPosAttack, StateNum.S_SPID_ATK3, 0, 0),    // S_SPID_ATK2
            new state_t(spritenum_t.SPR_SPID, 32775, 4, think_t.A_SPosAttack, StateNum.S_SPID_ATK4, 0, 0),    // S_SPID_ATK3
            new state_t(spritenum_t.SPR_SPID, 32775, 1, think_t.A_SpidRefire, StateNum.S_SPID_ATK2, 0, 0),    // S_SPID_ATK4
            new state_t(spritenum_t.SPR_SPID, 8, 3, null, StateNum.S_SPID_PAIN2, 0, 0),    // S_SPID_PAIN
            new state_t(spritenum_t.SPR_SPID, 8, 3, think_t.A_Pain, StateNum.S_SPID_RUN1, 0, 0),    // S_SPID_PAIN2
            new state_t(spritenum_t.SPR_SPID, 9, 20, think_t.A_Scream, StateNum.S_SPID_DIE2, 0, 0),    // S_SPID_DIE1
            new state_t(spritenum_t.SPR_SPID, 10, 10, think_t.A_Fall, StateNum.S_SPID_DIE3, 0, 0),    // S_SPID_DIE2
            new state_t(spritenum_t.SPR_SPID, 11, 10, null, StateNum.S_SPID_DIE4, 0, 0),    // S_SPID_DIE3
            new state_t(spritenum_t.SPR_SPID, 12, 10, null, StateNum.S_SPID_DIE5, 0, 0),    // S_SPID_DIE4
            new state_t(spritenum_t.SPR_SPID, 13, 10, null, StateNum.S_SPID_DIE6, 0, 0),    // S_SPID_DIE5
            new state_t(spritenum_t.SPR_SPID, 14, 10, null, StateNum.S_SPID_DIE7, 0, 0),    // S_SPID_DIE6
            new state_t(spritenum_t.SPR_SPID, 15, 10, null, StateNum.S_SPID_DIE8, 0, 0),    // S_SPID_DIE7
            new state_t(spritenum_t.SPR_SPID, 16, 10, null, StateNum.S_SPID_DIE9, 0, 0),    // S_SPID_DIE8
            new state_t(spritenum_t.SPR_SPID, 17, 10, null, StateNum.S_SPID_DIE10, 0, 0),    // S_SPID_DIE9
            new state_t(spritenum_t.SPR_SPID, 18, 30, null, StateNum.S_SPID_DIE11, 0, 0),    // S_SPID_DIE10
            new state_t(spritenum_t.SPR_SPID, 18, -1, think_t.A_BossDeath, StateNum.S_NULL, 0, 0),    // S_SPID_DIE11
            new state_t(spritenum_t.SPR_BSPI, 0, 10, think_t.A_Look, StateNum.S_BSPI_STND2, 0, 0),    // S_BSPI_STND
            new state_t(spritenum_t.SPR_BSPI, 1, 10, think_t.A_Look, StateNum.S_BSPI_STND, 0, 0),    // S_BSPI_STND2
            new state_t(spritenum_t.SPR_BSPI, 0, 20, null, StateNum.S_BSPI_RUN1, 0, 0),    // S_BSPI_SIGHT
            new state_t(spritenum_t.SPR_BSPI, 0, 3, think_t.A_BabyMetal, StateNum.S_BSPI_RUN2, 0, 0),    // S_BSPI_RUN1
            new state_t(spritenum_t.SPR_BSPI, 0, 3, think_t.A_Chase, StateNum.S_BSPI_RUN3, 0, 0),    // S_BSPI_RUN2
            new state_t(spritenum_t.SPR_BSPI, 1, 3, think_t.A_Chase, StateNum.S_BSPI_RUN4, 0, 0),    // S_BSPI_RUN3
            new state_t(spritenum_t.SPR_BSPI, 1, 3, think_t.A_Chase, StateNum.S_BSPI_RUN5, 0, 0),    // S_BSPI_RUN4
            new state_t(spritenum_t.SPR_BSPI, 2, 3, think_t.A_Chase, StateNum.S_BSPI_RUN6, 0, 0),    // S_BSPI_RUN5
            new state_t(spritenum_t.SPR_BSPI, 2, 3, think_t.A_Chase, StateNum.S_BSPI_RUN7, 0, 0),    // S_BSPI_RUN6
            new state_t(spritenum_t.SPR_BSPI, 3, 3, think_t.A_BabyMetal, StateNum.S_BSPI_RUN8, 0, 0),    // S_BSPI_RUN7
            new state_t(spritenum_t.SPR_BSPI, 3, 3, think_t.A_Chase, StateNum.S_BSPI_RUN9, 0, 0),    // S_BSPI_RUN8
            new state_t(spritenum_t.SPR_BSPI, 4, 3, think_t.A_Chase, StateNum.S_BSPI_RUN10, 0, 0),    // S_BSPI_RUN9
            new state_t(spritenum_t.SPR_BSPI, 4, 3, think_t.A_Chase, StateNum.S_BSPI_RUN11, 0, 0),    // S_BSPI_RUN10
            new state_t(spritenum_t.SPR_BSPI, 5, 3, think_t.A_Chase, StateNum.S_BSPI_RUN12, 0, 0),    // S_BSPI_RUN11
            new state_t(spritenum_t.SPR_BSPI, 5, 3, think_t.A_Chase, StateNum.S_BSPI_RUN1, 0, 0),    // S_BSPI_RUN12
            new state_t(spritenum_t.SPR_BSPI, 32768, 20, think_t.A_FaceTarget, StateNum.S_BSPI_ATK2, 0, 0),    // S_BSPI_ATK1
            new state_t(spritenum_t.SPR_BSPI, 32774, 4, think_t.A_BspiAttack, StateNum.S_BSPI_ATK3, 0, 0),    // S_BSPI_ATK2
            new state_t(spritenum_t.SPR_BSPI, 32775, 4, null, StateNum.S_BSPI_ATK4, 0, 0),    // S_BSPI_ATK3
            new state_t(spritenum_t.SPR_BSPI, 32775, 1, think_t.A_SpidRefire, StateNum.S_BSPI_ATK2, 0, 0),    // S_BSPI_ATK4
            new state_t(spritenum_t.SPR_BSPI, 8, 3, null, StateNum.S_BSPI_PAIN2, 0, 0),    // S_BSPI_PAIN
            new state_t(spritenum_t.SPR_BSPI, 8, 3, think_t.A_Pain, StateNum.S_BSPI_RUN1, 0, 0),    // S_BSPI_PAIN2
            new state_t(spritenum_t.SPR_BSPI, 9, 20, think_t.A_Scream, StateNum.S_BSPI_DIE2, 0, 0),    // S_BSPI_DIE1
            new state_t(spritenum_t.SPR_BSPI, 10, 7, think_t.A_Fall, StateNum.S_BSPI_DIE3, 0, 0),    // S_BSPI_DIE2
            new state_t(spritenum_t.SPR_BSPI, 11, 7, null, StateNum.S_BSPI_DIE4, 0, 0),    // S_BSPI_DIE3
            new state_t(spritenum_t.SPR_BSPI, 12, 7, null, StateNum.S_BSPI_DIE5, 0, 0),    // S_BSPI_DIE4
            new state_t(spritenum_t.SPR_BSPI, 13, 7, null, StateNum.S_BSPI_DIE6, 0, 0),    // S_BSPI_DIE5
            new state_t(spritenum_t.SPR_BSPI, 14, 7, null, StateNum.S_BSPI_DIE7, 0, 0),    // S_BSPI_DIE6
            new state_t(spritenum_t.SPR_BSPI, 15, -1, think_t.A_BossDeath, StateNum.S_NULL, 0, 0),    // S_BSPI_DIE7
            new state_t(spritenum_t.SPR_BSPI, 15, 5, null, StateNum.S_BSPI_RAISE2, 0, 0),    // S_BSPI_RAISE1
            new state_t(spritenum_t.SPR_BSPI, 14, 5, null, StateNum.S_BSPI_RAISE3, 0, 0),    // S_BSPI_RAISE2
            new state_t(spritenum_t.SPR_BSPI, 13, 5, null, StateNum.S_BSPI_RAISE4, 0, 0),    // S_BSPI_RAISE3
            new state_t(spritenum_t.SPR_BSPI, 12, 5, null, StateNum.S_BSPI_RAISE5, 0, 0),    // S_BSPI_RAISE4
            new state_t(spritenum_t.SPR_BSPI, 11, 5, null, StateNum.S_BSPI_RAISE6, 0, 0),    // S_BSPI_RAISE5
            new state_t(spritenum_t.SPR_BSPI, 10, 5, null, StateNum.S_BSPI_RAISE7, 0, 0),    // S_BSPI_RAISE6
            new state_t(spritenum_t.SPR_BSPI, 9, 5, null, StateNum.S_BSPI_RUN1, 0, 0),    // S_BSPI_RAISE7
            new state_t(spritenum_t.SPR_APLS, 32768, 5, null, StateNum.S_ARACH_PLAZ2, 0, 0),    // S_ARACH_PLAZ
            new state_t(spritenum_t.SPR_APLS, 32769, 5, null, StateNum.S_ARACH_PLAZ, 0, 0),    // S_ARACH_PLAZ2
            new state_t(spritenum_t.SPR_APBX, 32768, 5, null, StateNum.S_ARACH_PLEX2, 0, 0),    // S_ARACH_PLEX
            new state_t(spritenum_t.SPR_APBX, 32769, 5, null, StateNum.S_ARACH_PLEX3, 0, 0),    // S_ARACH_PLEX2
            new state_t(spritenum_t.SPR_APBX, 32770, 5, null, StateNum.S_ARACH_PLEX4, 0, 0),    // S_ARACH_PLEX3
            new state_t(spritenum_t.SPR_APBX, 32771, 5, null, StateNum.S_ARACH_PLEX5, 0, 0),    // S_ARACH_PLEX4
            new state_t(spritenum_t.SPR_APBX, 32772, 5, null, StateNum.S_NULL, 0, 0),    // S_ARACH_PLEX5
            new state_t(spritenum_t.SPR_CYBR, 0, 10, think_t.A_Look, StateNum.S_CYBER_STND2, 0, 0),    // S_CYBER_STND
            new state_t(spritenum_t.SPR_CYBR, 1, 10, think_t.A_Look, StateNum.S_CYBER_STND, 0, 0),    // S_CYBER_STND2
            new state_t(spritenum_t.SPR_CYBR, 0, 3, think_t.A_Hoof, StateNum.S_CYBER_RUN2, 0, 0),    // S_CYBER_RUN1
            new state_t(spritenum_t.SPR_CYBR, 0, 3, think_t.A_Chase, StateNum.S_CYBER_RUN3, 0, 0),    // S_CYBER_RUN2
            new state_t(spritenum_t.SPR_CYBR, 1, 3, think_t.A_Chase, StateNum.S_CYBER_RUN4, 0, 0),    // S_CYBER_RUN3
            new state_t(spritenum_t.SPR_CYBR, 1, 3, think_t.A_Chase, StateNum.S_CYBER_RUN5, 0, 0),    // S_CYBER_RUN4
            new state_t(spritenum_t.SPR_CYBR, 2, 3, think_t.A_Chase, StateNum.S_CYBER_RUN6, 0, 0),    // S_CYBER_RUN5
            new state_t(spritenum_t.SPR_CYBR, 2, 3, think_t.A_Chase, StateNum.S_CYBER_RUN7, 0, 0),    // S_CYBER_RUN6
            new state_t(spritenum_t.SPR_CYBR, 3, 3, think_t.A_Metal, StateNum.S_CYBER_RUN8, 0, 0),    // S_CYBER_RUN7
            new state_t(spritenum_t.SPR_CYBR, 3, 3, think_t.A_Chase, StateNum.S_CYBER_RUN1, 0, 0),    // S_CYBER_RUN8
            new state_t(spritenum_t.SPR_CYBR, 4, 6, think_t.A_FaceTarget, StateNum.S_CYBER_ATK2, 0, 0),    // S_CYBER_ATK1
            new state_t(spritenum_t.SPR_CYBR, 5, 12, think_t.A_CyberAttack, StateNum.S_CYBER_ATK3, 0, 0),    // S_CYBER_ATK2
            new state_t(spritenum_t.SPR_CYBR, 4, 12, think_t.A_FaceTarget, StateNum.S_CYBER_ATK4, 0, 0),    // S_CYBER_ATK3
            new state_t(spritenum_t.SPR_CYBR, 5, 12, think_t.A_CyberAttack, StateNum.S_CYBER_ATK5, 0, 0),    // S_CYBER_ATK4
            new state_t(spritenum_t.SPR_CYBR, 4, 12, think_t.A_FaceTarget, StateNum.S_CYBER_ATK6, 0, 0),    // S_CYBER_ATK5
            new state_t(spritenum_t.SPR_CYBR, 5, 12, think_t.A_CyberAttack, StateNum.S_CYBER_RUN1, 0, 0),    // S_CYBER_ATK6
            new state_t(spritenum_t.SPR_CYBR, 6, 10, think_t.A_Pain, StateNum.S_CYBER_RUN1, 0, 0),    // S_CYBER_PAIN
            new state_t(spritenum_t.SPR_CYBR, 7, 10, null, StateNum.S_CYBER_DIE2, 0, 0),    // S_CYBER_DIE1
            new state_t(spritenum_t.SPR_CYBR, 8, 10, think_t.A_Scream, StateNum.S_CYBER_DIE3, 0, 0),    // S_CYBER_DIE2
            new state_t(spritenum_t.SPR_CYBR, 9, 10, null, StateNum.S_CYBER_DIE4, 0, 0),    // S_CYBER_DIE3
            new state_t(spritenum_t.SPR_CYBR, 10, 10, null, StateNum.S_CYBER_DIE5, 0, 0),    // S_CYBER_DIE4
            new state_t(spritenum_t.SPR_CYBR, 11, 10, null, StateNum.S_CYBER_DIE6, 0, 0),    // S_CYBER_DIE5
            new state_t(spritenum_t.SPR_CYBR, 12, 10, think_t.A_Fall, StateNum.S_CYBER_DIE7, 0, 0),    // S_CYBER_DIE6
            new state_t(spritenum_t.SPR_CYBR, 13, 10, null, StateNum.S_CYBER_DIE8, 0, 0),    // S_CYBER_DIE7
            new state_t(spritenum_t.SPR_CYBR, 14, 10, null, StateNum.S_CYBER_DIE9, 0, 0),    // S_CYBER_DIE8
            new state_t(spritenum_t.SPR_CYBR, 15, 30, null, StateNum.S_CYBER_DIE10, 0, 0),    // S_CYBER_DIE9
            new state_t(spritenum_t.SPR_CYBR, 15, -1, think_t.A_BossDeath, StateNum.S_NULL, 0, 0),    // S_CYBER_DIE10
            new state_t(spritenum_t.SPR_PAIN, 0, 10, think_t.A_Look, StateNum.S_PAIN_STND, 0, 0),    // S_PAIN_STND
            new state_t(spritenum_t.SPR_PAIN, 0, 3, think_t.A_Chase, StateNum.S_PAIN_RUN2, 0, 0),    // S_PAIN_RUN1
            new state_t(spritenum_t.SPR_PAIN, 0, 3, think_t.A_Chase, StateNum.S_PAIN_RUN3, 0, 0),    // S_PAIN_RUN2
            new state_t(spritenum_t.SPR_PAIN, 1, 3, think_t.A_Chase, StateNum.S_PAIN_RUN4, 0, 0),    // S_PAIN_RUN3
            new state_t(spritenum_t.SPR_PAIN, 1, 3, think_t.A_Chase, StateNum.S_PAIN_RUN5, 0, 0),    // S_PAIN_RUN4
            new state_t(spritenum_t.SPR_PAIN, 2, 3, think_t.A_Chase, StateNum.S_PAIN_RUN6, 0, 0),    // S_PAIN_RUN5
            new state_t(spritenum_t.SPR_PAIN, 2, 3, think_t.A_Chase, StateNum.S_PAIN_RUN1, 0, 0),    // S_PAIN_RUN6
            new state_t(spritenum_t.SPR_PAIN, 3, 5, think_t.A_FaceTarget, StateNum.S_PAIN_ATK2, 0, 0),    // S_PAIN_ATK1
            new state_t(spritenum_t.SPR_PAIN, 4, 5, think_t.A_FaceTarget, StateNum.S_PAIN_ATK3, 0, 0),    // S_PAIN_ATK2
            new state_t(spritenum_t.SPR_PAIN, 32773, 5, think_t.A_FaceTarget, StateNum.S_PAIN_ATK4, 0, 0),    // S_PAIN_ATK3
            new state_t(spritenum_t.SPR_PAIN, 32773, 0, think_t.A_PainAttack, StateNum.S_PAIN_RUN1, 0, 0),    // S_PAIN_ATK4
            new state_t(spritenum_t.SPR_PAIN, 6, 6, null, StateNum.S_PAIN_PAIN2, 0, 0),    // S_PAIN_PAIN
            new state_t(spritenum_t.SPR_PAIN, 6, 6, think_t.A_Pain, StateNum.S_PAIN_RUN1, 0, 0),    // S_PAIN_PAIN2
            new state_t(spritenum_t.SPR_PAIN, 32775, 8, null, StateNum.S_PAIN_DIE2, 0, 0),    // S_PAIN_DIE1
            new state_t(spritenum_t.SPR_PAIN, 32776, 8, think_t.A_Scream, StateNum.S_PAIN_DIE3, 0, 0),    // S_PAIN_DIE2
            new state_t(spritenum_t.SPR_PAIN, 32777, 8, null, StateNum.S_PAIN_DIE4, 0, 0),    // S_PAIN_DIE3
            new state_t(spritenum_t.SPR_PAIN, 32778, 8, null, StateNum.S_PAIN_DIE5, 0, 0),    // S_PAIN_DIE4
            new state_t(spritenum_t.SPR_PAIN, 32779, 8, think_t.A_PainDie, StateNum.S_PAIN_DIE6, 0, 0),    // S_PAIN_DIE5
            new state_t(spritenum_t.SPR_PAIN, 32780, 8, null, StateNum.S_NULL, 0, 0),    // S_PAIN_DIE6
            new state_t(spritenum_t.SPR_PAIN, 12, 8, null, StateNum.S_PAIN_RAISE2, 0, 0),    // S_PAIN_RAISE1
            new state_t(spritenum_t.SPR_PAIN, 11, 8, null, StateNum.S_PAIN_RAISE3, 0, 0),    // S_PAIN_RAISE2
            new state_t(spritenum_t.SPR_PAIN, 10, 8, null, StateNum.S_PAIN_RAISE4, 0, 0),    // S_PAIN_RAISE3
            new state_t(spritenum_t.SPR_PAIN, 9, 8, null, StateNum.S_PAIN_RAISE5, 0, 0),    // S_PAIN_RAISE4
            new state_t(spritenum_t.SPR_PAIN, 8, 8, null, StateNum.S_PAIN_RAISE6, 0, 0),    // S_PAIN_RAISE5
            new state_t(spritenum_t.SPR_PAIN, 7, 8, null, StateNum.S_PAIN_RUN1, 0, 0),    // S_PAIN_RAISE6
            new state_t(spritenum_t.SPR_SSWV, 0, 10, think_t.A_Look, StateNum.S_SSWV_STND2, 0, 0),    // S_SSWV_STND
            new state_t(spritenum_t.SPR_SSWV, 1, 10, think_t.A_Look, StateNum.S_SSWV_STND, 0, 0),    // S_SSWV_STND2
            new state_t(spritenum_t.SPR_SSWV, 0, 3, think_t.A_Chase, StateNum.S_SSWV_RUN2, 0, 0),    // S_SSWV_RUN1
            new state_t(spritenum_t.SPR_SSWV, 0, 3, think_t.A_Chase, StateNum.S_SSWV_RUN3, 0, 0),    // S_SSWV_RUN2
            new state_t(spritenum_t.SPR_SSWV, 1, 3, think_t.A_Chase, StateNum.S_SSWV_RUN4, 0, 0),    // S_SSWV_RUN3
            new state_t(spritenum_t.SPR_SSWV, 1, 3, think_t.A_Chase, StateNum.S_SSWV_RUN5, 0, 0),    // S_SSWV_RUN4
            new state_t(spritenum_t.SPR_SSWV, 2, 3, think_t.A_Chase, StateNum.S_SSWV_RUN6, 0, 0),    // S_SSWV_RUN5
            new state_t(spritenum_t.SPR_SSWV, 2, 3, think_t.A_Chase, StateNum.S_SSWV_RUN7, 0, 0),    // S_SSWV_RUN6
            new state_t(spritenum_t.SPR_SSWV, 3, 3, think_t.A_Chase, StateNum.S_SSWV_RUN8, 0, 0),    // S_SSWV_RUN7
            new state_t(spritenum_t.SPR_SSWV, 3, 3, think_t.A_Chase, StateNum.S_SSWV_RUN1, 0, 0),    // S_SSWV_RUN8
            new state_t(spritenum_t.SPR_SSWV, 4, 10, think_t.A_FaceTarget, StateNum.S_SSWV_ATK2, 0, 0),    // S_SSWV_ATK1
            new state_t(spritenum_t.SPR_SSWV, 5, 10, think_t.A_FaceTarget, StateNum.S_SSWV_ATK3, 0, 0),    // S_SSWV_ATK2
            new state_t(spritenum_t.SPR_SSWV, 32774, 4, think_t.A_CPosAttack, StateNum.S_SSWV_ATK4, 0, 0),    // S_SSWV_ATK3
            new state_t(spritenum_t.SPR_SSWV, 5, 6, think_t.A_FaceTarget, StateNum.S_SSWV_ATK5, 0, 0),    // S_SSWV_ATK4
            new state_t(spritenum_t.SPR_SSWV, 32774, 4, think_t.A_CPosAttack, StateNum.S_SSWV_ATK6, 0, 0),    // S_SSWV_ATK5
            new state_t(spritenum_t.SPR_SSWV, 5, 1, think_t.A_CPosRefire, StateNum.S_SSWV_ATK2, 0, 0),    // S_SSWV_ATK6
            new state_t(spritenum_t.SPR_SSWV, 7, 3, null, StateNum.S_SSWV_PAIN2, 0, 0),    // S_SSWV_PAIN
            new state_t(spritenum_t.SPR_SSWV, 7, 3, think_t.A_Pain, StateNum.S_SSWV_RUN1, 0, 0),    // S_SSWV_PAIN2
            new state_t(spritenum_t.SPR_SSWV, 8, 5, null, StateNum.S_SSWV_DIE2, 0, 0),    // S_SSWV_DIE1
            new state_t(spritenum_t.SPR_SSWV, 9, 5, think_t.A_Scream, StateNum.S_SSWV_DIE3, 0, 0),    // S_SSWV_DIE2
            new state_t(spritenum_t.SPR_SSWV, 10, 5, think_t.A_Fall, StateNum.S_SSWV_DIE4, 0, 0),    // S_SSWV_DIE3
            new state_t(spritenum_t.SPR_SSWV, 11, 5, null, StateNum.S_SSWV_DIE5, 0, 0),    // S_SSWV_DIE4
            new state_t(spritenum_t.SPR_SSWV, 12, -1, null, StateNum.S_NULL, 0, 0),    // S_SSWV_DIE5
            new state_t(spritenum_t.SPR_SSWV, 13, 5, null, StateNum.S_SSWV_XDIE2, 0, 0),    // S_SSWV_XDIE1
            new state_t(spritenum_t.SPR_SSWV, 14, 5, think_t.A_XScream, StateNum.S_SSWV_XDIE3, 0, 0),    // S_SSWV_XDIE2
            new state_t(spritenum_t.SPR_SSWV, 15, 5, think_t.A_Fall, StateNum.S_SSWV_XDIE4, 0, 0),    // S_SSWV_XDIE3
            new state_t(spritenum_t.SPR_SSWV, 16, 5, null, StateNum.S_SSWV_XDIE5, 0, 0),    // S_SSWV_XDIE4
            new state_t(spritenum_t.SPR_SSWV, 17, 5, null, StateNum.S_SSWV_XDIE6, 0, 0),    // S_SSWV_XDIE5
            new state_t(spritenum_t.SPR_SSWV, 18, 5, null, StateNum.S_SSWV_XDIE7, 0, 0),    // S_SSWV_XDIE6
            new state_t(spritenum_t.SPR_SSWV, 19, 5, null, StateNum.S_SSWV_XDIE8, 0, 0),    // S_SSWV_XDIE7
            new state_t(spritenum_t.SPR_SSWV, 20, 5, null, StateNum.S_SSWV_XDIE9, 0, 0),    // S_SSWV_XDIE8
            new state_t(spritenum_t.SPR_SSWV, 21, -1, null, StateNum.S_NULL, 0, 0),    // S_SSWV_XDIE9
            new state_t(spritenum_t.SPR_SSWV, 12, 5, null, StateNum.S_SSWV_RAISE2, 0, 0),    // S_SSWV_RAISE1
            new state_t(spritenum_t.SPR_SSWV, 11, 5, null, StateNum.S_SSWV_RAISE3, 0, 0),    // S_SSWV_RAISE2
            new state_t(spritenum_t.SPR_SSWV, 10, 5, null, StateNum.S_SSWV_RAISE4, 0, 0),    // S_SSWV_RAISE3
            new state_t(spritenum_t.SPR_SSWV, 9, 5, null, StateNum.S_SSWV_RAISE5, 0, 0),    // S_SSWV_RAISE4
            new state_t(spritenum_t.SPR_SSWV, 8, 5, null, StateNum.S_SSWV_RUN1, 0, 0),    // S_SSWV_RAISE5
            new state_t(spritenum_t.SPR_KEEN, 0, -1, null, StateNum.S_KEENSTND, 0, 0),    // S_KEENSTND
            new state_t(spritenum_t.SPR_KEEN, 0, 6, null, StateNum.S_COMMKEEN2, 0, 0),    // S_COMMKEEN
            new state_t(spritenum_t.SPR_KEEN, 1, 6, null, StateNum.S_COMMKEEN3, 0, 0),    // S_COMMKEEN2
            new state_t(spritenum_t.SPR_KEEN, 2, 6, think_t.A_Scream, StateNum.S_COMMKEEN4, 0, 0),    // S_COMMKEEN3
            new state_t(spritenum_t.SPR_KEEN, 3, 6, null, StateNum.S_COMMKEEN5, 0, 0),    // S_COMMKEEN4
            new state_t(spritenum_t.SPR_KEEN, 4, 6, null, StateNum.S_COMMKEEN6, 0, 0),    // S_COMMKEEN5
            new state_t(spritenum_t.SPR_KEEN, 5, 6, null, StateNum.S_COMMKEEN7, 0, 0),    // S_COMMKEEN6
            new state_t(spritenum_t.SPR_KEEN, 6, 6, null, StateNum.S_COMMKEEN8, 0, 0),    // S_COMMKEEN7
            new state_t(spritenum_t.SPR_KEEN, 7, 6, null, StateNum.S_COMMKEEN9, 0, 0),    // S_COMMKEEN8
            new state_t(spritenum_t.SPR_KEEN, 8, 6, null, StateNum.S_COMMKEEN10, 0, 0),    // S_COMMKEEN9
            new state_t(spritenum_t.SPR_KEEN, 9, 6, null, StateNum.S_COMMKEEN11, 0, 0),    // S_COMMKEEN10
            new state_t(spritenum_t.SPR_KEEN, 10, 6, think_t.A_KeenDie, StateNum.S_COMMKEEN12, 0, 0),// S_COMMKEEN11
            new state_t(spritenum_t.SPR_KEEN, 11, -1, null, StateNum.S_NULL, 0, 0),        // S_COMMKEEN12
            new state_t(spritenum_t.SPR_KEEN, 12, 4, null, StateNum.S_KEENPAIN2, 0, 0),    // S_KEENPAIN
            new state_t(spritenum_t.SPR_KEEN, 12, 8, think_t.A_Pain, StateNum.S_KEENSTND, 0, 0),    // S_KEENPAIN2
            new state_t(spritenum_t.SPR_BBRN, 0, -1, null, StateNum.S_NULL, 0, 0),        // S_BRAIN
            new state_t(spritenum_t.SPR_BBRN, 1, 36, think_t.A_BrainPain, StateNum.S_BRAIN, 0, 0),    // S_BRAIN_PAIN
            new state_t(spritenum_t.SPR_BBRN, 0, 100, think_t.A_BrainScream, StateNum.S_BRAIN_DIE2, 0, 0),    // S_BRAIN_DIE1
            new state_t(spritenum_t.SPR_BBRN, 0, 10, null, StateNum.S_BRAIN_DIE3, 0, 0),    // S_BRAIN_DIE2
            new state_t(spritenum_t.SPR_BBRN, 0, 10, null, StateNum.S_BRAIN_DIE4, 0, 0),    // S_BRAIN_DIE3
            new state_t(spritenum_t.SPR_BBRN, 0, -1, think_t.A_BrainDie, StateNum.S_NULL, 0, 0),    // S_BRAIN_DIE4
            new state_t(spritenum_t.SPR_SSWV, 0, 10, think_t.A_Look, StateNum.S_BRAINEYE, 0, 0),    // S_BRAINEYE
            new state_t(spritenum_t.SPR_SSWV, 0, 181, think_t.A_BrainAwake, StateNum.S_BRAINEYE1, 0, 0),    // S_BRAINEYESEE
            new state_t(spritenum_t.SPR_SSWV, 0, 150, think_t.A_BrainSpit, StateNum.S_BRAINEYE1, 0, 0),    // S_BRAINEYE1
            new state_t(spritenum_t.SPR_BOSF, 32768, 3, think_t.A_SpawnSound, StateNum.S_SPAWN2, 0, 0),    // S_SPAWN1
            new state_t(spritenum_t.SPR_BOSF, 32769, 3, think_t.A_SpawnFly, StateNum.S_SPAWN3, 0, 0),    // S_SPAWN2
            new state_t(spritenum_t.SPR_BOSF, 32770, 3, think_t.A_SpawnFly, StateNum.S_SPAWN4, 0, 0),    // S_SPAWN3
            new state_t(spritenum_t.SPR_BOSF, 32771, 3, think_t.A_SpawnFly, StateNum.S_SPAWN1, 0, 0),    // S_SPAWN4
            new state_t(spritenum_t.SPR_FIRE, 32768, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE2, 0, 0),    // S_SPAWNFIRE1
            new state_t(spritenum_t.SPR_FIRE, 32769, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE3, 0, 0),    // S_SPAWNFIRE2
            new state_t(spritenum_t.SPR_FIRE, 32770, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE4, 0, 0),    // S_SPAWNFIRE3
            new state_t(spritenum_t.SPR_FIRE, 32771, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE5, 0, 0),    // S_SPAWNFIRE4
            new state_t(spritenum_t.SPR_FIRE, 32772, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE6, 0, 0),    // S_SPAWNFIRE5
            new state_t(spritenum_t.SPR_FIRE, 32773, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE7, 0, 0),    // S_SPAWNFIRE6
            new state_t(spritenum_t.SPR_FIRE, 32774, 4, think_t.A_Fire, StateNum.S_SPAWNFIRE8, 0, 0),    // S_SPAWNFIRE7
            new state_t(spritenum_t.SPR_FIRE, 32775, 4, think_t.A_Fire, StateNum.S_NULL, 0, 0),        // S_SPAWNFIRE8
            new state_t(spritenum_t.SPR_MISL, 32769, 10, null, StateNum.S_BRAINEXPLODE2, 0, 0),    // S_BRAINEXPLODE1
            new state_t(spritenum_t.SPR_MISL, 32770, 10, null, StateNum.S_BRAINEXPLODE3, 0, 0),    // S_BRAINEXPLODE2
            new state_t(spritenum_t.SPR_MISL, 32771, 10, think_t.A_BrainExplode, StateNum.S_NULL, 0, 0),    // S_BRAINEXPLODE3
            new state_t(spritenum_t.SPR_ARM1, 0, 6, null, StateNum.S_ARM1A, 0, 0),    // S_ARM1
            new state_t(spritenum_t.SPR_ARM1, 32769, 7, null, StateNum.S_ARM1, 0, 0),    // S_ARM1A
            new state_t(spritenum_t.SPR_ARM2, 0, 6, null, StateNum.S_ARM2A, 0, 0),    // S_ARM2
            new state_t(spritenum_t.SPR_ARM2, 32769, 6, null, StateNum.S_ARM2, 0, 0),    // S_ARM2A
            new state_t(spritenum_t.SPR_BAR1, 0, 6, null, StateNum.S_BAR2, 0, 0),    // S_BAR1
            new state_t(spritenum_t.SPR_BAR1, 1, 6, null, StateNum.S_BAR1, 0, 0),    // S_BAR2
            new state_t(spritenum_t.SPR_BEXP, 32768, 5, null, StateNum.S_BEXP2, 0, 0),    // S_BEXP
            new state_t(spritenum_t.SPR_BEXP, 32769, 5, think_t.A_Scream, StateNum.S_BEXP3, 0, 0),    // S_BEXP2
            new state_t(spritenum_t.SPR_BEXP, 32770, 5, null, StateNum.S_BEXP4, 0, 0),    // S_BEXP3
            new state_t(spritenum_t.SPR_BEXP, 32771, 10, think_t.A_Explode, StateNum.S_BEXP5, 0, 0),    // S_BEXP4
            new state_t(spritenum_t.SPR_BEXP, 32772, 10, null, StateNum.S_NULL, 0, 0),    // S_BEXP5
            new state_t(spritenum_t.SPR_FCAN, 32768, 4, null, StateNum.S_BBAR2, 0, 0),    // S_BBAR1
            new state_t(spritenum_t.SPR_FCAN, 32769, 4, null, StateNum.S_BBAR3, 0, 0),    // S_BBAR2
            new state_t(spritenum_t.SPR_FCAN, 32770, 4, null, StateNum.S_BBAR1, 0, 0),    // S_BBAR3
            new state_t(spritenum_t.SPR_BON1, 0, 6, null, StateNum.S_BON1A, 0, 0),    // S_BON1
            new state_t(spritenum_t.SPR_BON1, 1, 6, null, StateNum.S_BON1B, 0, 0),    // S_BON1A
            new state_t(spritenum_t.SPR_BON1, 2, 6, null, StateNum.S_BON1C, 0, 0),    // S_BON1B
            new state_t(spritenum_t.SPR_BON1, 3, 6, null, StateNum.S_BON1D, 0, 0),    // S_BON1C
            new state_t(spritenum_t.SPR_BON1, 2, 6, null, StateNum.S_BON1E, 0, 0),    // S_BON1D
            new state_t(spritenum_t.SPR_BON1, 1, 6, null, StateNum.S_BON1, 0, 0),    // S_BON1E
            new state_t(spritenum_t.SPR_BON2, 0, 6, null, StateNum.S_BON2A, 0, 0),    // S_BON2
            new state_t(spritenum_t.SPR_BON2, 1, 6, null, StateNum.S_BON2B, 0, 0),    // S_BON2A
            new state_t(spritenum_t.SPR_BON2, 2, 6, null, StateNum.S_BON2C, 0, 0),    // S_BON2B
            new state_t(spritenum_t.SPR_BON2, 3, 6, null, StateNum.S_BON2D, 0, 0),    // S_BON2C
            new state_t(spritenum_t.SPR_BON2, 2, 6, null, StateNum.S_BON2E, 0, 0),    // S_BON2D
            new state_t(spritenum_t.SPR_BON2, 1, 6, null, StateNum.S_BON2, 0, 0),    // S_BON2E
            new state_t(spritenum_t.SPR_BKEY, 0, 10, null, StateNum.S_BKEY2, 0, 0),    // S_BKEY
            new state_t(spritenum_t.SPR_BKEY, 32769, 10, null, StateNum.S_BKEY, 0, 0),    // S_BKEY2
            new state_t(spritenum_t.SPR_RKEY, 0, 10, null, StateNum.S_RKEY2, 0, 0),    // S_RKEY
            new state_t(spritenum_t.SPR_RKEY, 32769, 10, null, StateNum.S_RKEY, 0, 0),    // S_RKEY2
            new state_t(spritenum_t.SPR_YKEY, 0, 10, null, StateNum.S_YKEY2, 0, 0),    // S_YKEY
            new state_t(spritenum_t.SPR_YKEY, 32769, 10, null, StateNum.S_YKEY, 0, 0),    // S_YKEY2
            new state_t(spritenum_t.SPR_BSKU, 0, 10, null, StateNum.S_BSKULL2, 0, 0),    // S_BSKULL
            new state_t(spritenum_t.SPR_BSKU, 32769, 10, null, StateNum.S_BSKULL, 0, 0),    // S_BSKULL2
            new state_t(spritenum_t.SPR_RSKU, 0, 10, null, StateNum.S_RSKULL2, 0, 0),    // S_RSKULL
            new state_t(spritenum_t.SPR_RSKU, 32769, 10, null, StateNum.S_RSKULL, 0, 0),    // S_RSKULL2
            new state_t(spritenum_t.SPR_YSKU, 0, 10, null, StateNum.S_YSKULL2, 0, 0),    // S_YSKULL
            new state_t(spritenum_t.SPR_YSKU, 32769, 10, null, StateNum.S_YSKULL, 0, 0),    // S_YSKULL2
            new state_t(spritenum_t.SPR_STIM, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_STIM
            new state_t(spritenum_t.SPR_MEDI, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_MEDI
            new state_t(spritenum_t.SPR_SOUL, 32768, 6, null, StateNum.S_SOUL2, 0, 0),    // S_SOUL
            new state_t(spritenum_t.SPR_SOUL, 32769, 6, null, StateNum.S_SOUL3, 0, 0),    // S_SOUL2
            new state_t(spritenum_t.SPR_SOUL, 32770, 6, null, StateNum.S_SOUL4, 0, 0),    // S_SOUL3
            new state_t(spritenum_t.SPR_SOUL, 32771, 6, null, StateNum.S_SOUL5, 0, 0),    // S_SOUL4
            new state_t(spritenum_t.SPR_SOUL, 32770, 6, null, StateNum.S_SOUL6, 0, 0),    // S_SOUL5
            new state_t(spritenum_t.SPR_SOUL, 32769, 6, null, StateNum.S_SOUL, 0, 0),    // S_SOUL6
            new state_t(spritenum_t.SPR_PINV, 32768, 6, null, StateNum.S_PINV2, 0, 0),    // S_PINV
            new state_t(spritenum_t.SPR_PINV, 32769, 6, null, StateNum.S_PINV3, 0, 0),    // S_PINV2
            new state_t(spritenum_t.SPR_PINV, 32770, 6, null, StateNum.S_PINV4, 0, 0),    // S_PINV3
            new state_t(spritenum_t.SPR_PINV, 32771, 6, null, StateNum.S_PINV, 0, 0),    // S_PINV4
            new state_t(spritenum_t.SPR_PSTR, 32768, -1, null, StateNum.S_NULL, 0, 0),    // S_PSTR
            new state_t(spritenum_t.SPR_PINS, 32768, 6, null, StateNum.S_PINS2, 0, 0),    // S_PINS
            new state_t(spritenum_t.SPR_PINS, 32769, 6, null, StateNum.S_PINS3, 0, 0),    // S_PINS2
            new state_t(spritenum_t.SPR_PINS, 32770, 6, null, StateNum.S_PINS4, 0, 0),    // S_PINS3
            new state_t(spritenum_t.SPR_PINS, 32771, 6, null, StateNum.S_PINS, 0, 0),    // S_PINS4
            new state_t(spritenum_t.SPR_MEGA, 32768, 6, null, StateNum.S_MEGA2, 0, 0),    // S_MEGA
            new state_t(spritenum_t.SPR_MEGA, 32769, 6, null, StateNum.S_MEGA3, 0, 0),    // S_MEGA2
            new state_t(spritenum_t.SPR_MEGA, 32770, 6, null, StateNum.S_MEGA4, 0, 0),    // S_MEGA3
            new state_t(spritenum_t.SPR_MEGA, 32771, 6, null, StateNum.S_MEGA, 0, 0),    // S_MEGA4
            new state_t(spritenum_t.SPR_SUIT, 32768, -1, null, StateNum.S_NULL, 0, 0),    // S_SUIT
            new state_t(spritenum_t.SPR_PMAP, 32768, 6, null, StateNum.S_PMAP2, 0, 0),    // S_PMAP
            new state_t(spritenum_t.SPR_PMAP, 32769, 6, null, StateNum.S_PMAP3, 0, 0),    // S_PMAP2
            new state_t(spritenum_t.SPR_PMAP, 32770, 6, null, StateNum.S_PMAP4, 0, 0),    // S_PMAP3
            new state_t(spritenum_t.SPR_PMAP, 32771, 6, null, StateNum.S_PMAP5, 0, 0),    // S_PMAP4
            new state_t(spritenum_t.SPR_PMAP, 32770, 6, null, StateNum.S_PMAP6, 0, 0),    // S_PMAP5
            new state_t(spritenum_t.SPR_PMAP, 32769, 6, null, StateNum.S_PMAP, 0, 0),    // S_PMAP6
            new state_t(spritenum_t.SPR_PVIS, 32768, 6, null, StateNum.S_PVIS2, 0, 0),    // S_PVIS
            new state_t(spritenum_t.SPR_PVIS, 1, 6, null, StateNum.S_PVIS, 0, 0),    // S_PVIS2
            new state_t(spritenum_t.SPR_CLIP, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_CLIP
            new state_t(spritenum_t.SPR_AMMO, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_AMMO
            new state_t(spritenum_t.SPR_ROCK, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_ROCK
            new state_t(spritenum_t.SPR_BROK, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_BROK
            new state_t(spritenum_t.SPR_CELL, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_CELL
            new state_t(spritenum_t.SPR_CELP, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_CELP
            new state_t(spritenum_t.SPR_SHEL, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SHEL
            new state_t(spritenum_t.SPR_SBOX, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SBOX
            new state_t(spritenum_t.SPR_BPAK, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_BPAK
            new state_t(spritenum_t.SPR_BFUG, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_BFUG
            new state_t(spritenum_t.SPR_MGUN, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_MGUN
            new state_t(spritenum_t.SPR_CSAW, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_CSAW
            new state_t(spritenum_t.SPR_LAUN, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_LAUN
            new state_t(spritenum_t.SPR_PLAS, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_PLAS
            new state_t(spritenum_t.SPR_SHOT, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SHOT
            new state_t(spritenum_t.SPR_SGN2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SHOT2
            new state_t(spritenum_t.SPR_COLU, 32768, -1, null, StateNum.S_NULL, 0, 0),    // S_COLU
            new state_t(spritenum_t.SPR_SMT2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_STALAG
            new state_t(spritenum_t.SPR_GOR1, 0, 10, null, StateNum.S_BLOODYTWITCH2, 0, 0),    // S_BLOODYTWITCH
            new state_t(spritenum_t.SPR_GOR1, 1, 15, null, StateNum.S_BLOODYTWITCH3, 0, 0),    // S_BLOODYTWITCH2
            new state_t(spritenum_t.SPR_GOR1, 2, 8, null, StateNum.S_BLOODYTWITCH4, 0, 0),    // S_BLOODYTWITCH3
            new state_t(spritenum_t.SPR_GOR1, 1, 6, null, StateNum.S_BLOODYTWITCH, 0, 0),    // S_BLOODYTWITCH4
            new state_t(spritenum_t.SPR_PLAY, 13, -1, null, StateNum.S_NULL, 0, 0),    // S_DEADTORSO
            new state_t(spritenum_t.SPR_PLAY, 18, -1, null, StateNum.S_NULL, 0, 0),    // S_DEADBOTTOM
            new state_t(spritenum_t.SPR_POL2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HEADSONSTICK
            new state_t(spritenum_t.SPR_POL5, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_GIBS
            new state_t(spritenum_t.SPR_POL4, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HEADONASTICK
            new state_t(spritenum_t.SPR_POL3, 32768, 6, null, StateNum.S_HEADCANDLES2, 0, 0),    // S_HEADCANDLES
            new state_t(spritenum_t.SPR_POL3, 32769, 6, null, StateNum.S_HEADCANDLES, 0, 0),    // S_HEADCANDLES2
            new state_t(spritenum_t.SPR_POL1, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_DEADSTICK
            new state_t(spritenum_t.SPR_POL6, 0, 6, null, StateNum.S_LIVESTICK2, 0, 0),    // S_LIVESTICK
            new state_t(spritenum_t.SPR_POL6, 1, 8, null, StateNum.S_LIVESTICK, 0, 0),    // S_LIVESTICK2
            new state_t(spritenum_t.SPR_GOR2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_MEAT2
            new state_t(spritenum_t.SPR_GOR3, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_MEAT3
            new state_t(spritenum_t.SPR_GOR4, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_MEAT4
            new state_t(spritenum_t.SPR_GOR5, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_MEAT5
            new state_t(spritenum_t.SPR_SMIT, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_STALAGTITE
            new state_t(spritenum_t.SPR_COL1, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_TALLGRNCOL
            new state_t(spritenum_t.SPR_COL2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SHRTGRNCOL
            new state_t(spritenum_t.SPR_COL3, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_TALLREDCOL
            new state_t(spritenum_t.SPR_COL4, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SHRTREDCOL
            new state_t(spritenum_t.SPR_CAND, 32768, -1, null, StateNum.S_NULL, 0, 0),    // S_CANDLESTIK
            new state_t(spritenum_t.SPR_CBRA, 32768, -1, null, StateNum.S_NULL, 0, 0),    // S_CANDELABRA
            new state_t(spritenum_t.SPR_COL6, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SKULLCOL
            new state_t(spritenum_t.SPR_TRE1, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_TORCHTREE
            new state_t(spritenum_t.SPR_TRE2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_BIGTREE
            new state_t(spritenum_t.SPR_ELEC, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_TECHPILLAR
            new state_t(spritenum_t.SPR_CEYE, 32768, 6, null, StateNum.S_EVILEYE2, 0, 0),    // S_EVILEYE
            new state_t(spritenum_t.SPR_CEYE, 32769, 6, null, StateNum.S_EVILEYE3, 0, 0),    // S_EVILEYE2
            new state_t(spritenum_t.SPR_CEYE, 32770, 6, null, StateNum.S_EVILEYE4, 0, 0),    // S_EVILEYE3
            new state_t(spritenum_t.SPR_CEYE, 32769, 6, null, StateNum.S_EVILEYE, 0, 0),    // S_EVILEYE4
            new state_t(spritenum_t.SPR_FSKU, 32768, 6, null, StateNum.S_FLOATSKULL2, 0, 0),    // S_FLOATSKULL
            new state_t(spritenum_t.SPR_FSKU, 32769, 6, null, StateNum.S_FLOATSKULL3, 0, 0),    // S_FLOATSKULL2
            new state_t(spritenum_t.SPR_FSKU, 32770, 6, null, StateNum.S_FLOATSKULL, 0, 0),    // S_FLOATSKULL3
            new state_t(spritenum_t.SPR_COL5, 0, 14, null, StateNum.S_HEARTCOL2, 0, 0),    // S_HEARTCOL
            new state_t(spritenum_t.SPR_COL5, 1, 14, null, StateNum.S_HEARTCOL, 0, 0),    // S_HEARTCOL2
            new state_t(spritenum_t.SPR_TBLU, 32768, 4, null, StateNum.S_BLUETORCH2, 0, 0),    // S_BLUETORCH
            new state_t(spritenum_t.SPR_TBLU, 32769, 4, null, StateNum.S_BLUETORCH3, 0, 0),    // S_BLUETORCH2
            new state_t(spritenum_t.SPR_TBLU, 32770, 4, null, StateNum.S_BLUETORCH4, 0, 0),    // S_BLUETORCH3
            new state_t(spritenum_t.SPR_TBLU, 32771, 4, null, StateNum.S_BLUETORCH, 0, 0),    // S_BLUETORCH4
            new state_t(spritenum_t.SPR_TGRN, 32768, 4, null, StateNum.S_GREENTORCH2, 0, 0),    // S_GREENTORCH
            new state_t(spritenum_t.SPR_TGRN, 32769, 4, null, StateNum.S_GREENTORCH3, 0, 0),    // S_GREENTORCH2
            new state_t(spritenum_t.SPR_TGRN, 32770, 4, null, StateNum.S_GREENTORCH4, 0, 0),    // S_GREENTORCH3
            new state_t(spritenum_t.SPR_TGRN, 32771, 4, null, StateNum.S_GREENTORCH, 0, 0),    // S_GREENTORCH4
            new state_t(spritenum_t.SPR_TRED, 32768, 4, null, StateNum.S_REDTORCH2, 0, 0),    // S_REDTORCH
            new state_t(spritenum_t.SPR_TRED, 32769, 4, null, StateNum.S_REDTORCH3, 0, 0),    // S_REDTORCH2
            new state_t(spritenum_t.SPR_TRED, 32770, 4, null, StateNum.S_REDTORCH4, 0, 0),    // S_REDTORCH3
            new state_t(spritenum_t.SPR_TRED, 32771, 4, null, StateNum.S_REDTORCH, 0, 0),    // S_REDTORCH4
            new state_t(spritenum_t.SPR_SMBT, 32768, 4, null, StateNum.S_BTORCHSHRT2, 0, 0),    // S_BTORCHSHRT
            new state_t(spritenum_t.SPR_SMBT, 32769, 4, null, StateNum.S_BTORCHSHRT3, 0, 0),    // S_BTORCHSHRT2
            new state_t(spritenum_t.SPR_SMBT, 32770, 4, null, StateNum.S_BTORCHSHRT4, 0, 0),    // S_BTORCHSHRT3
            new state_t(spritenum_t.SPR_SMBT, 32771, 4, null, StateNum.S_BTORCHSHRT, 0, 0),    // S_BTORCHSHRT4
            new state_t(spritenum_t.SPR_SMGT, 32768, 4, null, StateNum.S_GTORCHSHRT2, 0, 0),    // S_GTORCHSHRT
            new state_t(spritenum_t.SPR_SMGT, 32769, 4, null, StateNum.S_GTORCHSHRT3, 0, 0),    // S_GTORCHSHRT2
            new state_t(spritenum_t.SPR_SMGT, 32770, 4, null, StateNum.S_GTORCHSHRT4, 0, 0),    // S_GTORCHSHRT3
            new state_t(spritenum_t.SPR_SMGT, 32771, 4, null, StateNum.S_GTORCHSHRT, 0, 0),    // S_GTORCHSHRT4
            new state_t(spritenum_t.SPR_SMRT, 32768, 4, null, StateNum.S_RTORCHSHRT2, 0, 0),    // S_RTORCHSHRT
            new state_t(spritenum_t.SPR_SMRT, 32769, 4, null, StateNum.S_RTORCHSHRT3, 0, 0),    // S_RTORCHSHRT2
            new state_t(spritenum_t.SPR_SMRT, 32770, 4, null, StateNum.S_RTORCHSHRT4, 0, 0),    // S_RTORCHSHRT3
            new state_t(spritenum_t.SPR_SMRT, 32771, 4, null, StateNum.S_RTORCHSHRT, 0, 0),    // S_RTORCHSHRT4
            new state_t(spritenum_t.SPR_HDB1, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HANGNOGUTS
            new state_t(spritenum_t.SPR_HDB2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HANGBNOBRAIN
            new state_t(spritenum_t.SPR_HDB3, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HANGTLOOKDN
            new state_t(spritenum_t.SPR_HDB4, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HANGTSKULL
            new state_t(spritenum_t.SPR_HDB5, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HANGTLOOKUP
            new state_t(spritenum_t.SPR_HDB6, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_HANGTNOBRAIN
            new state_t(spritenum_t.SPR_POB1, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_COLONGIBS
            new state_t(spritenum_t.SPR_POB2, 0, -1, null, StateNum.S_NULL, 0, 0),    // S_SMALLPOOL
            new state_t(spritenum_t.SPR_BRS1, 0, -1, null, StateNum.S_NULL, 0, 0),        // S_BRAINSTEM
            new state_t(spritenum_t.SPR_TLMP, 32768, 4, null, StateNum.S_TECHLAMP2, 0, 0),    // S_TECHLAMP
            new state_t(spritenum_t.SPR_TLMP, 32769, 4, null, StateNum.S_TECHLAMP3, 0, 0),    // S_TECHLAMP2
            new state_t(spritenum_t.SPR_TLMP, 32770, 4, null, StateNum.S_TECHLAMP4, 0, 0),    // S_TECHLAMP3
            new state_t(spritenum_t.SPR_TLMP, 32771, 4, null, StateNum.S_TECHLAMP, 0, 0),    // S_TECHLAMP4
            new state_t(spritenum_t.SPR_TLP2, 32768, 4, null, StateNum.S_TECH2LAMP2, 0, 0),    // S_TECH2LAMP
            new state_t(spritenum_t.SPR_TLP2, 32769, 4, null, StateNum.S_TECH2LAMP3, 0, 0),    // S_TECH2LAMP2
            new state_t(spritenum_t.SPR_TLP2, 32770, 4, null, StateNum.S_TECH2LAMP4, 0, 0),    // S_TECH2LAMP3
            new state_t(spritenum_t.SPR_TLP2, 32771, 4, null, StateNum.S_TECH2LAMP, 0, 0)    // S_TECH2LAMP4
    };

    public static mobjinfo_t[] mobjinfo = {
            new MT_Player_t(),

            new Possessed_t(),        // MT_POSSESSED

            new ShotGuy_t(),        // MT_SHOTGUY

            new Vile_t(),        // MT_VILE

            new mobjinfo_t(        // MT_FIRE
                    -1,        // doomednum
                    StateNum.S_FIRE1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new Undead_t(),        // MT_UNDEAD

            new mobjinfo_t(        // MT_TRACER
                    -1,        // doomednum
                    StateNum.S_TRACER,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_skeatk,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_TRACEEXP1,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_barexp,        // deathsound
                    10 * FRACUNIT,        // speed
                    11 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    10,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_SMOKE
                    -1,        // doomednum
                    StateNum.S_SMOKE1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new Fatso_t(),        // MT_FATSO

            new mobjinfo_t(        // MT_FATSHOT
                    -1,        // doomednum
                    StateNum.S_FATSHOT1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_firsht,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_FATSHOTX1,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_firxpl,        // deathsound
                    20 * FRACUNIT,        // speed
                    6 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    8,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new ChainGuy_t(),        // MT_CHAINGUY

            new Troop_t(),       // MT_TROOP

            new Sergeant_t(),        // MT_SERGEANT

            new Shadows_t(),        // MT_SHADOWS

            new Head_t(),        // MT_HEAD

            new Bruiser_t(),        // MT_BRUISER

            new mobjinfo_t(        // MT_BRUISERSHOT
                    -1,        // doomednum
                    StateNum.S_BRBALL1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_firsht,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_BRBALLX1,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_firxpl,        // deathsound
                    15 * FRACUNIT,        // speed
                    6 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    8,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new Knight_t(),        // MT_KNIGHT

            new Skull_t(),        // MT_SKULL

            new Spider_t(),        // MT_SPIDER

            new Baby_t(),        // MT_BABY

            new Cyborg_t(),        // MT_CYBORG

            new Pain_t(),        // MT_PAIN

            new WolfSS_t(),        // MT_WOLFSS

            new CommanderKeen_t(),        // MT_KEEN

            new BossBrain_t(),        // MT_BOSSBRAIN

            new mobjinfo_t(        // MT_BOSSSPIT
                    89,        // doomednum
                    StateNum.S_BRAINEYE,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_BRAINEYESEE,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    32 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOSECTOR,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_BOSSTARGET
                    87,        // doomednum
                    StateNum.S_NULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    32 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOSECTOR,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_SPAWNSHOT
                    -1,        // doomednum
                    StateNum.S_SPAWN1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_bospit,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_firxpl,        // deathsound
                    10 * FRACUNIT,        // speed
                    6 * FRACUNIT,        // radius
                    32 * FRACUNIT,        // height
                    100,        // mass
                    3,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY | MF_NOCLIP,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_SPAWNFIRE
                    -1,        // doomednum
                    StateNum.S_SPAWNFIRE1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_BARREL
                    2035,        // doomednum
                    StateNum.S_BAR1,        // spawnstate
                    20,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_BEXP,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_barexp,        // deathsound
                    0,        // speed
                    10 * FRACUNIT,        // radius
                    42 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SHOOTABLE | MF_NOBLOOD,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_TROOPSHOT
                    -1,        // doomednum
                    StateNum.S_TBALL1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_firsht,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_TBALLX1,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_firxpl,        // deathsound
                    10 * FRACUNIT,        // speed
                    6 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    3,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_HEADSHOT
                    -1,        // doomednum
                    StateNum.S_RBALL1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_firsht,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_RBALLX1,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_firxpl,        // deathsound
                    10 * FRACUNIT,        // speed
                    6 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    5,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_ROCKET
                    -1,        // doomednum
                    StateNum.S_ROCKET,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_rlaunc,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_EXPLODE1,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_barexp,        // deathsound
                    20 * FRACUNIT,        // speed
                    11 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    20,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new Plasma_t(),

            new AlternatePlasma_t(),

            new mobjinfo_t(        // MT_BFG
                    -1,        // doomednum
                    StateNum.S_BFGSHOT,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_BFGLAND,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_rxplod,        // deathsound
                    25 * FRACUNIT,        // speed
                    13 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    100,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_ARACHPLAZ
                    -1,        // doomednum
                    StateNum.S_ARACH_PLAZ,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_plasma,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_ARACH_PLEX,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_firxpl,        // deathsound
                    25 * FRACUNIT,        // speed
                    13 * FRACUNIT,        // radius
                    8 * FRACUNIT,        // height
                    100,        // mass
                    5,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_PUFF
                    -1,        // doomednum
                    StateNum.S_PUFF1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_BLOOD
                    -1,        // doomednum
                    StateNum.S_BLOOD1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_TFOG
                    -1,        // doomednum
                    StateNum.S_TFOG,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_IFOG
                    -1,        // doomednum
                    StateNum.S_IFOG,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_TELEPORTMAN
                    14,        // doomednum
                    StateNum.S_NULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOSECTOR,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_EXTRABFG
                    -1,        // doomednum
                    StateNum.S_BFGEXP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC0 ARMOR
                    2018,        // doomednum
                    StateNum.S_ARM1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC1 MEGAARMOR
                    2019,        // doomednum
                    StateNum.S_ARM2,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC2 HEALTH BONUS
                    2014,        // doomednum
                    StateNum.S_BON1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC3 ARMOR BONUS
                    2015,        // doomednum
                    StateNum.S_BON2,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC4
                    5,        // doomednum
                    StateNum.S_BKEY,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_NOTDMATCH,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC5
                    13,        // doomednum
                    StateNum.S_RKEY,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_NOTDMATCH,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC6
                    6,        // doomednum
                    StateNum.S_YKEY,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_NOTDMATCH,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC7
                    39,        // doomednum
                    StateNum.S_YSKULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_NOTDMATCH,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC8
                    38,        // doomednum
                    StateNum.S_RSKULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_NOTDMATCH,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC9
                    40,        // doomednum
                    StateNum.S_BSKULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_NOTDMATCH,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC10 Stimpack_t
                    2011,        // doomednum
                    StateNum.S_STIM,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),
            // BJPR :  MEDIKIT
            new Medikit_t(        // MT_MISC11 MEDIKIT
                    2012,        // doomednum
                    StateNum.S_MEDI,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC12 SuperCharge_t Recupera vida 200%
                    2013,        // doomednum
                    StateNum.S_SOUL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_INV
                    2022,        // doomednum
                    StateNum.S_PINV,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC13
                    2023,        // doomednum
                    StateNum.S_PSTR,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_INS
                    2024,        // doomednum
                    StateNum.S_PINS,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC14
                    2025,        // doomednum
                    StateNum.S_SUIT,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC15
                    2026,        // doomednum
                    StateNum.S_PMAP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC16
                    2045,        // doomednum
                    StateNum.S_PVIS,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MEGA
                    83,        // doomednum
                    StateNum.S_MEGA,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL | MF_COUNTITEM,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_CLIP
                    2007,        // doomednum
                    StateNum.S_CLIP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC17 BOX OF BULLETS
                    2048,        // doomednum
                    StateNum.S_AMMO,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC18
                    2010,        // doomednum
                    StateNum.S_ROCK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC19
                    2046,        // doomednum
                    StateNum.S_BROK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC20
                    2047,        // doomednum
                    StateNum.S_CELL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC21
                    17,        // doomednum
                    StateNum.S_CELP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC22 SHOTGUN SHELL
                    2008,        // doomednum
                    StateNum.S_SHEL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC23 
                    2049,        // doomednum
                    StateNum.S_SBOX,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC24
                    8,        // doomednum
                    StateNum.S_BPAK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC25
                    2006,        // doomednum
                    StateNum.S_BFUG,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_CHAINGUN
                    2002,        // doomednum
                    StateNum.S_MGUN,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC26
                    2005,        // doomednum
                    StateNum.S_CSAW,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC27
                    2003,        // doomednum
                    StateNum.S_LAUN,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC28
                    2004,        // doomednum
                    StateNum.S_PLAS,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_SHOTGUN
                    2001,        // doomednum
                    StateNum.S_SHOT,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_SUPERSHOTGUN
                    82,        // doomednum
                    StateNum.S_SHOT2,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPECIAL,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC29
                    85,        // doomednum
                    StateNum.S_TECHLAMP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC30
                    86,        // doomednum
                    StateNum.S_TECH2LAMP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC31
                    2028,        // doomednum
                    StateNum.S_COLU,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC32
                    30,        // doomednum
                    StateNum.S_TALLGRNCOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC33
                    31,        // doomednum
                    StateNum.S_SHRTGRNCOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC34
                    32,        // doomednum
                    StateNum.S_TALLREDCOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC35
                    33,        // doomednum
                    StateNum.S_SHRTREDCOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC36
                    37,        // doomednum
                    StateNum.S_SKULLCOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC37
                    36,        // doomednum
                    StateNum.S_HEARTCOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC38
                    41,        // doomednum
                    StateNum.S_EVILEYE,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC39
                    42,        // doomednum
                    StateNum.S_FLOATSKULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC40
                    43,        // doomednum
                    StateNum.S_TORCHTREE,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC41
                    44,        // doomednum
                    StateNum.S_BLUETORCH,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC42
                    45,        // doomednum
                    StateNum.S_GREENTORCH,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC43
                    46,        // doomednum
                    StateNum.S_REDTORCH,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC44
                    55,        // doomednum
                    StateNum.S_BTORCHSHRT,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC45
                    56,        // doomednum
                    StateNum.S_GTORCHSHRT,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC46
                    57,        // doomednum
                    StateNum.S_RTORCHSHRT,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC47
                    47,        // doomednum
                    StateNum.S_STALAGTITE,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC48
                    48,        // doomednum
                    StateNum.S_TECHPILLAR,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC49
                    34,        // doomednum
                    StateNum.S_CANDLESTIK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC50
                    35,        // doomednum
                    StateNum.S_CANDELABRA,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC51
                    49,        // doomednum
                    StateNum.S_BLOODYTWITCH,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    68 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC52
                    50,        // doomednum
                    StateNum.S_MEAT2,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    84 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC53
                    51,        // doomednum
                    StateNum.S_MEAT3,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    84 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC54
                    52,        // doomednum
                    StateNum.S_MEAT4,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    68 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC55
                    53,        // doomednum
                    StateNum.S_MEAT5,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    52 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC56
                    59,        // doomednum
                    StateNum.S_MEAT2,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    84 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC57
                    60,        // doomednum
                    StateNum.S_MEAT4,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    68 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC58
                    61,        // doomednum
                    StateNum.S_MEAT3,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    52 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC59
                    62,        // doomednum
                    StateNum.S_MEAT5,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    52 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC60
                    63,        // doomednum
                    StateNum.S_BLOODYTWITCH,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    68 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC61
                    22,        // doomednum
                    StateNum.S_HEAD_DIE6,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC62
                    15,        // doomednum
                    StateNum.S_PLAY_DIE7,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC63
                    18,        // doomednum
                    StateNum.S_POSS_DIE5,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC64
                    21,        // doomednum
                    StateNum.S_SARG_DIE6,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC65
                    23,        // doomednum
                    StateNum.S_SKULL_DIE6,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC66
                    20,        // doomednum
                    StateNum.S_TROO_DIE5,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC67
                    19,        // doomednum
                    StateNum.S_SPOS_DIE5,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC68
                    10,        // doomednum
                    StateNum.S_PLAY_XDIE9,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC69
                    12,        // doomednum
                    StateNum.S_PLAY_XDIE9,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC70
                    28,        // doomednum
                    StateNum.S_HEADSONSTICK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC71
                    24,        // doomednum
                    StateNum.S_GIBS,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    0,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC72
                    27,        // doomednum
                    StateNum.S_HEADONASTICK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC73
                    29,        // doomednum
                    StateNum.S_HEADCANDLES,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC74
                    25,        // doomednum
                    StateNum.S_DEADSTICK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC75
                    26,        // doomednum
                    StateNum.S_LIVESTICK,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC76
                    54,        // doomednum
                    StateNum.S_BIGTREE,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    32 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC77
                    70,        // doomednum
                    StateNum.S_BBAR1,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC78
                    73,        // doomednum
                    StateNum.S_HANGNOGUTS,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    88 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC79
                    74,        // doomednum
                    StateNum.S_HANGBNOBRAIN,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    88 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC80
                    75,        // doomednum
                    StateNum.S_HANGTLOOKDN,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    64 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC81
                    76,        // doomednum
                    StateNum.S_HANGTSKULL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    64 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC82
                    77,        // doomednum
                    StateNum.S_HANGTLOOKUP,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    64 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC83
                    78,        // doomednum
                    StateNum.S_HANGTNOBRAIN,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    16 * FRACUNIT,        // radius
                    64 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC84
                    79,        // doomednum
                    StateNum.S_COLONGIBS,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC85
                    80,        // doomednum
                    StateNum.S_SMALLPOOL,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP,        // flags
                    StateNum.S_NULL        // raisestate
            ),

            new mobjinfo_t(        // MT_MISC86
                    81,        // doomednum
                    StateNum.S_BRAINSTEM,        // spawnstate
                    1000,        // spawnhealth
                    StateNum.S_NULL,        // seestate
                    sfxenum_t.sfx_None,        // seesound
                    8,        // reactiontime
                    sfxenum_t.sfx_None,        // attacksound
                    StateNum.S_NULL,        // painstate
                    0,        // painchance
                    sfxenum_t.sfx_None,        // painsound
                    StateNum.S_NULL,        // meleestate
                    StateNum.S_NULL,        // missilestate
                    StateNum.S_NULL,        // deathstate
                    StateNum.S_NULL,        // xdeathstate
                    sfxenum_t.sfx_None,        // deathsound
                    0,        // speed
                    20 * FRACUNIT,        // radius
                    16 * FRACUNIT,        // height
                    100,        // mass
                    0,        // damage
                    sfxenum_t.sfx_None,        // activesound
                    MF_NOBLOCKMAP,        // flags
                    StateNum.S_NULL        // raisestate
            ),
            new GreenZombie_t(),
            new RedZombie_t(),
            new GrayZombie_t(),
            new BlackZombie_t(),
            new Flare_t()
    };

    static {
// Need to set them to simulate pointer-like operations.
        for (int i = 0; i < states.length; i++) {
            states[i].id = i;

            //states[0]=null;
        }
    }
}

