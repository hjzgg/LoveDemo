package com.textsurface.interfaces;

import java.util.LinkedList;

import com.textsurface.contants.TYPE;

/**
 * Created by Eugene Levenetc.
 */
public interface ISet extends ISurfaceAnimation {
	TYPE getType();

	LinkedList<ISurfaceAnimation> getAnimations();
}
