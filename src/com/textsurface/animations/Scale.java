package com.textsurface.animations;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;

import com.textsurface.Text;
import com.textsurface.TextSurface;
import com.textsurface.utils.Utils;
import com.textsurface.interfaces.IEndListener;
import com.textsurface.interfaces.ITextSurfaceAnimation;

/**
 * Created by Eugene Levenetc.
 */
public class Scale implements ITextSurfaceAnimation, ValueAnimator.AnimatorUpdateListener {

	private int duration;
	private final float from;
	private final float to;
	private final int pivot;
	private Text text;
	private TextSurface textSurface;
	private ObjectAnimator animator;

	public Scale(Text text, int duration, float from, float to, int pivot) {
		this.text = text;
		this.duration = duration;
		this.from = from;
		this.to = to;
		this.pivot = pivot;
	}

	@Override public void setInitValues( Text text) {

	}

	 @Override public Text getText() {
		return text;
	}

	@Override public void onStart() {

	}

	@Override public void start( IEndListener listener) {
		text.setScalePivot(pivot, pivot);
		PropertyValuesHolder sX = PropertyValuesHolder.ofFloat("scaleX", from, to);
		PropertyValuesHolder sY = PropertyValuesHolder.ofFloat("scaleY", from, to);
		animator = ObjectAnimator.ofPropertyValuesHolder(text, sX, sY);
		Utils.addEndListener(this, animator, listener);
		animator.setDuration(duration);
		animator.addUpdateListener(this);
		animator.start();
	}

	@Override public void setTextSurface( TextSurface textSurface) {
		this.textSurface = textSurface;
	}

	@Override public long getDuration() {
		return duration;
	}

	@Override public void cancel() {
		if (animator != null && animator.isRunning()) {
			animator.cancel();
			animator = null;
		}
	}

	@Override public void onAnimationUpdate(ValueAnimator animation) {
		textSurface.invalidate();
	}

	@Override public String toString() {
		return "Scale{" +
				"text=" + text +
				'}';
	}
}
