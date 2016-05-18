package com.textsurface.sample.checks;

import com.textsurface.contants.Align;
import com.textsurface.animations.AnimationsSet;
import com.textsurface.contants.TYPE;
import com.textsurface.Text;
import com.textsurface.TextBuilder;
import com.textsurface.TextSurface;
import com.textsurface.animations.Alpha;
import com.textsurface.animations.Circle;
import com.textsurface.animations.Delay;
import com.textsurface.animations.Rotate3D;
import com.textsurface.animations.ShapeReveal;
import com.textsurface.animations.SideCut;
import com.textsurface.animations.Slide;
import com.textsurface.animations.TransSurface;
import com.textsurface.contants.Axis;
import com.textsurface.contants.Direction;
import com.textsurface.contants.Pivot;
import com.textsurface.contants.Side;

/**
 * Created by Eugene Levenetc.
 */
public class ShapeRevealSample {
	public static void play(TextSurface textSurface) {

		Text textA = TextBuilder.create("Now why you loer en kyk gelyk?").setPosition(Align.SURFACE_CENTER).build();
		Text textB = TextBuilder.create("Is ek miskien van goud gemake?").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textA).build();
		Text textC = TextBuilder.create("You want to fight, you come tonight.").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textB).build();
		Text textD = TextBuilder.create("Ek moer jou sleg! So jy hardloop weg.").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textC).build();

		final int flash = 1500;

		textSurface.play(TYPE.SEQUENTIAL,
				Rotate3D.showFromCenter(textA, 500, Direction.CLOCK, Axis.X),
				new AnimationsSet(TYPE.PARALLEL,
						ShapeReveal.create(textA, flash, SideCut.hide(Side.LEFT), false),
						new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(flash / 4), ShapeReveal.create(textA, flash, SideCut.show(Side.LEFT), false))
				),
				new AnimationsSet(TYPE.PARALLEL,
						Rotate3D.showFromSide(textB, 500, Pivot.TOP),
						new TransSurface(500, textB, Pivot.CENTER)
				),
				Delay.duration(500),
				new AnimationsSet(TYPE.PARALLEL,
						Slide.showFrom(Side.TOP, textC, 500),
						new TransSurface(1000, textC, Pivot.CENTER)
				),
				Delay.duration(500),
				new AnimationsSet(TYPE.PARALLEL,
						ShapeReveal.create(textD, 500, Circle.show(Side.CENTER, Direction.OUT), false),
						new TransSurface(1500, textD, Pivot.CENTER)
				),
				Delay.duration(500),
				new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textD, 700), ShapeReveal.create(textD, 1000, SideCut.hide(Side.LEFT), true)),
						new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textC, 700), ShapeReveal.create(textC, 1000, SideCut.hide(Side.LEFT), true))),
						new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(1000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textB, 700), ShapeReveal.create(textB, 1000, SideCut.hide(Side.LEFT), true))),
						new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(1500), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textA, 700), ShapeReveal.create(textA, 1000, SideCut.hide(Side.LEFT), true))),
						new TransSurface(4000, textA, Pivot.CENTER)
				)

		);
	}
}
