package com.textsurface.sample.checks;

import com.textsurface.contants.Align;
import com.textsurface.animations.AnimationsSet;
import com.textsurface.contants.TYPE;
import com.textsurface.Text;
import com.textsurface.TextBuilder;
import com.textsurface.TextSurface;
import com.textsurface.animations.Alpha;
import com.textsurface.animations.Delay;
import com.textsurface.animations.ScaleSurface;
import com.textsurface.contants.Fit;

/**
 * Created by Eugene Levenetc.
 */
public class SurfaceScaleSample {
	public static void play(TextSurface textSurface) {

		Text textA = TextBuilder.create("How are you?").setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("Would you mind?").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textA).build();
		Text textC = TextBuilder.create("Yes!").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textB).build();


		textSurface.play(TYPE.SEQUENTIAL,
				Alpha.show(textA, 500),
				new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.PARALLEL, Alpha.show(textB, 500), Alpha.hide(textA, 500)),
						new ScaleSurface(500, textB, Fit.WIDTH)
				),
				Delay.duration(1000),
				new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.PARALLEL, Alpha.show(textC, 500), Alpha.hide(textB, 500)),
						new ScaleSurface(500, textC, Fit.WIDTH)
				)
		);
	}
}