package com.textsurface.animations;

import android.animation.ValueAnimator;
import com.textsurface.Text;
import com.textsurface.TextSurface;
import com.textsurface.interfaces.IEndListener;
import com.textsurface.interfaces.ITextSurfaceAnimation;

/**
 * Created by Eugene Levenetc.
 */
public class AbstractSurfaceAnimation implements ITextSurfaceAnimation, ValueAnimator.AnimatorUpdateListener {

	protected final Text text;
	protected final int duration;
	protected TextSurface textSurface;

	public AbstractSurfaceAnimation(Text text, int duration) {
		this.text = text;
		this.duration = duration;
	}

	@Override public void setInitValues(Text text) {

	}

    @Override public Text getText() {
		return text;
	}

	@Override public void onStart() {

	}

	@Override public void start(final IEndListener listener) {

	}

	@Override public void setTextSurface(TextSurface textSurface) {
		this.textSurface = textSurface;
	}

	@Override public long getDuration() {
		return duration;
	}

	@Override public void cancel() {

	}

	@Override public void onAnimationUpdate(ValueAnimator animation) {
		textSurface.invalidate();
	}
}
