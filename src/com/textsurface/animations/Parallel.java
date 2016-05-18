package com.textsurface.animations;

import com.textsurface.contants.TYPE;
import com.textsurface.interfaces.ISurfaceAnimation;

/**
 * Created by Eugene Levenetc.
 */
public class Parallel extends AnimationsSet {
	public Parallel(ISurfaceAnimation... animations) {
		super(TYPE.PARALLEL, animations);
	}
}
