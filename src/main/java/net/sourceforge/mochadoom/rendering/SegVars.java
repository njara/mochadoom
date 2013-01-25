package net.sourceforge.mochadoom.rendering;

import net.sourceforge.mochadoom.data.Limits;
import net.sourceforge.mochadoom.utils.C2JUtils;

public class SegVars {
    // /// FROM BSP /////////

    public int MAXDRAWSEGS = Limits.MAXDRAWSEGS;

    /**
     * pointer to drawsegs
     */
    public int ds_p;

    public drawseg_t[] drawsegs;

    public short[] maskedtexturecol;
    public int pmaskedtexturecol = 0;


    /**
     * R_ClearDrawSegs
     * <p/>
     * The drawseg list is reset by pointing back at 0.
     */
    public void ClearDrawSegs() {
        ds_p = 0;
    }

    public final void ResizeDrawsegs() {
        drawsegs = C2JUtils.resize(drawsegs[0], drawsegs, drawsegs.length * 2);
    }
}
