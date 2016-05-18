package com.textsurface.animations;

import com.textsurface.contants.TYPE;
import com.textsurface.interfaces.ISurfaceAnimation;

/**
 * Created by Eugene Levenetc.
 */
public class Sequential extends AnimationsSet {
	public Sequential(ISurfaceAnimation... animations) {
		super(TYPE.SEQUENTIAL, animations);
	}
}
