package com.textsurface.interfaces;

import com.textsurface.Text;

/**
 * Created by Eugene Levenetc.
 */
public interface ITextSurfaceAnimation extends ISurfaceAnimation {

	void setInitValues(Text text);

	Text getText();

}