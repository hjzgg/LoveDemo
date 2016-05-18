package com.textsurface.sample.checks;

import android.graphics.Color;

import com.textsurface.contants.Align;
import com.textsurface.contants.TYPE;
import com.textsurface.Text;
import com.textsurface.TextBuilder;
import com.textsurface.TextSurface;
import com.textsurface.animations.Alpha;
import com.textsurface.animations.ChangeColor;

/**
 * Created by Eugene Levenetc.
 */
public class ColorSample {
	public static void play(TextSurface textSurface) {

		Text textA = TextBuilder
				.create("Now why you loer en kyk gelyk?")
				.setPosition(Align.SURFACE_CENTER)
				.setSize(100)
				.setAlpha(0)
				.build();

		textSurface.play(TYPE.SEQUENTIAL,
				Alpha.show(textA, 1000),
				ChangeColor.to(textA, 1000, Color.RED),
				ChangeColor.fromTo(textA, 1000, Color.BLUE, Color.CYAN),
				Alpha.hide(textA, 1000)
		);
	}
}
