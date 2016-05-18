package com.textsurface.sample.checks;

import com.textsurface.contants.Align;
import com.textsurface.animations.AnimationsSet;
import com.textsurface.contants.TYPE;
import com.textsurface.Text;
import com.textsurface.TextBuilder;
import com.textsurface.TextSurface;
import com.textsurface.animations.Rotate3D;
import com.textsurface.contants.Axis;
import com.textsurface.contants.Direction;
import com.textsurface.contants.Pivot;

/**
 * Created by Eugene Levenetc.
 */
public class Rotation3DSample {
	public static void play(TextSurface textSurface) {
		Text textA = TextBuilder.create("How are you?").setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("I'm fine! And you?").setPosition(Align.SURFACE_CENTER, textA).build();
		Text textC = TextBuilder.create("Haaay!").setPosition(Align.SURFACE_CENTER, textB).build();
		int duration = 2750;

		textSurface.play(TYPE.SEQUENTIAL,
				new AnimationsSet(TYPE.SEQUENTIAL,
						Rotate3D.showFromCenter(textA, duration, Direction.CLOCK, Axis.X),
						Rotate3D.hideFromCenter(textA, duration, Direction.CLOCK, Axis.Y)
				),
				new AnimationsSet(TYPE.SEQUENTIAL,
						Rotate3D.showFromSide(textB, duration, Pivot.LEFT),
						Rotate3D.hideFromSide(textB, duration, Pivot.RIGHT)
				),
				new AnimationsSet(TYPE.SEQUENTIAL,
						Rotate3D.showFromSide(textC, duration, Pivot.TOP),
						Rotate3D.hideFromSide(textC, duration, Pivot.BOTTOM)
				)
		);
	}
}
