package com.textsurface.sample.checks;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.textsurface.contants.Align;

import java.util.List;

import com.textsurface.Text;
import com.textsurface.TextBuilder;
import com.textsurface.TextSurface;
import com.textsurface.animations.Alpha;
import com.textsurface.animations.AnimationsSet;
import com.textsurface.animations.ChangeColor;
import com.textsurface.animations.Circle;
import com.textsurface.animations.Delay;
import com.textsurface.animations.Parallel;
import com.textsurface.animations.Rotate3D;
import com.textsurface.animations.Sequential;
import com.textsurface.animations.ShapeReveal;
import com.textsurface.animations.SideCut;
import com.textsurface.animations.Slide;
import com.textsurface.animations.TransSurface;
import com.textsurface.contants.Direction;
import com.textsurface.contants.Pivot;
import com.textsurface.contants.Side;

/**
 * Created by Eugene Levenetc.
 */
public class CookieThumperSample {

	public static void play(TextSurface textSurface, AssetManager assetManager) {

		final Typeface robotoBlack = Typeface.createFromAsset(assetManager, "fonts/Roboto-Black.ttf");
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTypeface(robotoBlack);

		Text textDaai = TextBuilder
				.create("史上")
				.setPaint(paint)
				.setSize(64)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.SURFACE_CENTER).build();

		Text textBraAnies = TextBuilder
				.create("最真情告白")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF, textDaai).build();

		Text textFokkenGamBra = TextBuilder
				.create("送给我爱的人")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.RIGHT_OF, textBraAnies).build();

		Text textHaai = TextBuilder
				.create("愿你一生平安幸福")
				.setPaint(paint)
				.setSize(74)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF, textFokkenGamBra).build();

		Text textDaaiAnies = TextBuilder
				.create("History of ")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textHaai).build();

		Text texThyLamInnie = TextBuilder
				.create("Give me love")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.RIGHT_OF, textDaaiAnies).build();

		Text textThrowDamn = TextBuilder
				.create("I wish you")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texThyLamInnie).build();

		Text textDevilishGang = TextBuilder
				.create("have a peace")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textThrowDamn).build();

		Text textSignsInTheAir = TextBuilder
				.create("and happiness life")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textDevilishGang).build();

		textSurface.play(
				new Sequential(
						ShapeReveal.create(textDaai, 750, SideCut.show(Side.LEFT), false),
						new Parallel(ShapeReveal.create(textDaai, 600, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(300), ShapeReveal.create(textDaai, 600, SideCut.show(Side.LEFT), false))),
						new Parallel(new TransSurface(500, textBraAnies, Pivot.CENTER), ShapeReveal.create(textBraAnies, 1300, SideCut.show(Side.LEFT), false)),
						Delay.duration(500),
						new Parallel(new TransSurface(750, textFokkenGamBra, Pivot.CENTER), Slide.showFrom(Side.LEFT, textFokkenGamBra, 750), ChangeColor.to(textFokkenGamBra, 750, Color.WHITE)),
						Delay.duration(500),
						new Parallel(TransSurface.toCenter(textHaai, 500), Rotate3D.showFromSide(textHaai, 750, Pivot.TOP)),
						new Parallel(TransSurface.toCenter(textDaaiAnies, 500), Slide.showFrom(Side.TOP, textDaaiAnies, 500)),
						new Parallel(TransSurface.toCenter(texThyLamInnie, 750), Slide.showFrom(Side.LEFT, texThyLamInnie, 500)),
						Delay.duration(500),
						new Parallel(
								new TransSurface(1500, textSignsInTheAir, Pivot.CENTER),
								new Sequential(
										new Sequential(ShapeReveal.create(textThrowDamn, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
										new Sequential(ShapeReveal.create(textDevilishGang, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
										new Sequential(ShapeReveal.create(textSignsInTheAir, 500, Circle.show(Side.CENTER, Direction.OUT), false))
								)
						),
						Delay.duration(200),
						new Parallel(
								ShapeReveal.create(textThrowDamn, 1500, SideCut.hide(Side.LEFT), true),
								new Sequential(Delay.duration(250), ShapeReveal.create(textDevilishGang, 1500, SideCut.hide(Side.LEFT), true)),
								new Sequential(Delay.duration(500), ShapeReveal.create(textSignsInTheAir, 1500, SideCut.hide(Side.LEFT), true)),
								Alpha.hide(texThyLamInnie, 1500),
								Alpha.hide(textDaaiAnies, 1500)
						)
				)
		);

	}
	
	
	public static AnimationsSet getCookieThumperAnimations(AssetManager assetManager) {

		final Typeface robotoBlack = Typeface.createFromAsset(assetManager, "fonts/Roboto-Black.ttf");
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTypeface(robotoBlack);

		Text textDaai = TextBuilder
				.create("史上")
				.setPaint(paint)
				.setSize(64)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.SURFACE_CENTER).build();

		Text textBraAnies = TextBuilder
				.create("最真情告白")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF, textDaai).build();

		Text textFokkenGamBra = TextBuilder
				.create("送给我爱的人")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.RIGHT_OF, textBraAnies).build();

		Text textHaai = TextBuilder
				.create("愿你一生平安幸福")
				.setPaint(paint)
				.setSize(74)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF, textFokkenGamBra).build();

		Text textDaaiAnies = TextBuilder
				.create("History of ")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textHaai).build();

		Text texThyLamInnie = TextBuilder
				.create("Give me love")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.RIGHT_OF, textDaaiAnies).build();

		Text textThrowDamn = TextBuilder
				.create("I wish you")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texThyLamInnie).build();

		Text textDevilishGang = TextBuilder
				.create("have a peace")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textThrowDamn).build();

		Text textSignsInTheAir = TextBuilder
				.create("and happiness life")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textDevilishGang).build();

		return 
				new Sequential(
						ShapeReveal.create(textDaai, 750, SideCut.show(Side.LEFT), false),
						new Parallel(ShapeReveal.create(textDaai, 600, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(300), ShapeReveal.create(textDaai, 600, SideCut.show(Side.LEFT), false))),
						new Parallel(new TransSurface(500, textBraAnies, Pivot.CENTER), ShapeReveal.create(textBraAnies, 1300, SideCut.show(Side.LEFT), false)),
						Delay.duration(500),
						new Parallel(new TransSurface(750, textFokkenGamBra, Pivot.CENTER), Slide.showFrom(Side.LEFT, textFokkenGamBra, 750), ChangeColor.to(textFokkenGamBra, 750, Color.WHITE)),
						Delay.duration(500),
						new Parallel(TransSurface.toCenter(textHaai, 500), Rotate3D.showFromSide(textHaai, 750, Pivot.TOP)),
						new Parallel(TransSurface.toCenter(textDaaiAnies, 500), Slide.showFrom(Side.TOP, textDaaiAnies, 500)),
						new Parallel(TransSurface.toCenter(texThyLamInnie, 750), Slide.showFrom(Side.LEFT, texThyLamInnie, 500)),
						Delay.duration(500),
						new Parallel(
								new TransSurface(1500, textSignsInTheAir, Pivot.CENTER),
								new Sequential(
										new Sequential(ShapeReveal.create(textThrowDamn, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
										new Sequential(ShapeReveal.create(textDevilishGang, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
										new Sequential(ShapeReveal.create(textSignsInTheAir, 500, Circle.show(Side.CENTER, Direction.OUT), false))
								)
						),
						Delay.duration(200),
						new Parallel(
								ShapeReveal.create(textThrowDamn, 1500, SideCut.hide(Side.LEFT), true),
								new Sequential(Delay.duration(250), ShapeReveal.create(textDevilishGang, 1500, SideCut.hide(Side.LEFT), true)),
								new Sequential(Delay.duration(500), ShapeReveal.create(textSignsInTheAir, 1500, SideCut.hide(Side.LEFT), true)),
								Alpha.hide(texThyLamInnie, 10),
								Alpha.hide(textDaaiAnies, 10),
								Alpha.hide(textDaai, 10),
								Alpha.hide(textBraAnies, 10),
								Alpha.hide(textFokkenGamBra, 10),
								Alpha.hide(textHaai, 10)
						)
				);
	}
}
