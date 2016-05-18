package com.textsurface.sample.checks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.textsurface.Text;
import com.textsurface.TextBuilder;
import com.textsurface.TextSurface;
import com.textsurface.animations.AnimationsSet;
import com.textsurface.animations.Slide;
import com.textsurface.animations.TransSurface;
import com.textsurface.contants.Align;
import com.textsurface.contants.Pivot;
import com.textsurface.contants.Side;
import com.textsurface.contants.TYPE;

/**
 * Created by Eugene Levenetc.
 */
public class SlideSample {
	
	private static Text[] randomTexts(String[] contents, int way){
		Text[] texts = new Text[4];
		switch (way) {
			case 0:
				texts[0] = TextBuilder.create(contents[0]).setSize(30).build();
				texts[1] = TextBuilder.create(contents[1]).setSize(30).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texts[0]).build();
				texts[2] = TextBuilder.create(contents[2]).setSize(30).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texts[1]).build();
				texts[3] = TextBuilder.create(contents[3]).setSize(30).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texts[2]).build();
				break;
			case 1:
				texts[0] = TextBuilder.create(contents[0]).setSize(30).build();
				texts[1] = TextBuilder.create(contents[1]).setSize(30).setPosition(Align.BOTTOM_OF, texts[0]).build();
				texts[2] = TextBuilder.create(contents[2]).setSize(30).setPosition(Align.LEFT_OF, texts[1]).build();
				texts[3] = TextBuilder.create(contents[3]).setSize(30).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texts[1]).build();
				break;
			case 2:
				texts[0] = TextBuilder.create(contents[0]).setSize(30).build();
				texts[1] = TextBuilder.create(contents[1]).setSize(30).setPosition(Align.LEFT_OF, texts[0]).build();
				texts[2] = TextBuilder.create(contents[2]).setSize(30).setPosition(Align.BOTTOM_OF, texts[1]).build();
				texts[3] = TextBuilder.create(contents[3]).setSize(30).setPosition(Align.LEFT_OF, texts[2]).build();
				break;
			default:
				texts[0] = TextBuilder.create(contents[0]).setSize(30).build();
				texts[1] = TextBuilder.create(contents[1]).setSize(30).setPosition(Align.LEFT_OF, texts[0]).build();
				texts[2] = TextBuilder.create(contents[2]).setSize(30).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texts[1]).build();
				texts[3] = TextBuilder.create(contents[3]).setSize(30).setPadding(10, 10, 10, 10).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texts[2]).build();
				break;
		}
		return texts;
	}
	
	private static AnimationsSet[] randomPlay(Text[] texts, int way){
		int duration = 1250;
		AnimationsSet[] animationsSets = new AnimationsSet[2];
		switch (way) {
			case 0:
				animationsSets[0] = new AnimationsSet(TYPE.SEQUENTIAL,
						new AnimationsSet(TYPE.SEQUENTIAL,
								new AnimationsSet(TYPE.PARALLEL, Slide.showFrom(Side.RIGHT, texts[0], duration), Slide.showFrom(Side.LEFT, texts[1], duration)),
								Slide.showFrom(Side.BOTTOM, texts[2], duration),
								Slide.showFrom(Side.TOP, texts[3], duration)
						),
						new TransSurface(duration * 3, texts[3], Pivot.CENTER)
				);
				animationsSets[1] = new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.SEQUENTIAL,
								new AnimationsSet(TYPE.PARALLEL, Slide.hideFrom(Side.TOP, texts[3], duration), Slide.hideFrom(Side.BOTTOM, texts[2], duration)),
								Slide.hideFrom(Side.LEFT, texts[1], duration),
								Slide.hideFrom(Side.RIGHT, texts[0], duration)
						),
						new TransSurface(duration * 3, texts[0], Pivot.CENTER)
				);
				break;
			case 1:
				animationsSets[0] = new AnimationsSet(TYPE.SEQUENTIAL,
						new AnimationsSet(TYPE.SEQUENTIAL,
								new AnimationsSet(TYPE.PARALLEL, Slide.showFrom(Side.TOP, texts[0], duration), Slide.showFrom(Side.LEFT, texts[1], duration)),
								Slide.showFrom(Side.RIGHT, texts[2], duration),
								Slide.showFrom(Side.BOTTOM, texts[3], duration)
						),
						new TransSurface(duration * 3, texts[3], Pivot.CENTER)
				);
				animationsSets[1] = new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.SEQUENTIAL,
								new AnimationsSet(TYPE.PARALLEL, Slide.hideFrom(Side.LEFT, texts[3], duration), Slide.hideFrom(Side.LEFT, texts[2], duration)),
								Slide.hideFrom(Side.RIGHT, texts[1], duration),
								Slide.hideFrom(Side.RIGHT, texts[0], duration)
						),
						new TransSurface(duration * 3, texts[0], Pivot.CENTER)
				);
				break;
			case 2:
				animationsSets[0] = new AnimationsSet(TYPE.SEQUENTIAL,
						new AnimationsSet(TYPE.SEQUENTIAL,
								new AnimationsSet(TYPE.PARALLEL, Slide.showFrom(Side.LEFT, texts[0], duration), Slide.showFrom(Side.RIGHT, texts[1], duration)),
								Slide.showFrom(Side.TOP, texts[2], duration),
								Slide.showFrom(Side.BOTTOM, texts[3], duration)
						),
						new TransSurface(duration * 3, texts[3], Pivot.CENTER)
				);
				animationsSets[1] = new AnimationsSet(TYPE.PARALLEL,
						new AnimationsSet(TYPE.SEQUENTIAL,
								new AnimationsSet(TYPE.PARALLEL, Slide.hideFrom(Side.TOP, texts[3], duration), Slide.hideFrom(Side.TOP, texts[2], duration)),
								Slide.hideFrom(Side.BOTTOM, texts[1], duration),
								Slide.hideFrom(Side.BOTTOM, texts[0], duration)
						),
						new TransSurface(duration * 3, texts[0], Pivot.CENTER)
				);
				break;
			default:
				animationsSets[0] = new AnimationsSet(TYPE.SEQUENTIAL,
							new AnimationsSet(TYPE.SEQUENTIAL,
									new AnimationsSet(TYPE.PARALLEL, Slide.showFrom(Side.LEFT, texts[0], duration), Slide.showFrom(Side.RIGHT, texts[1], duration)),
									Slide.showFrom(Side.TOP, texts[2], duration),
									Slide.showFrom(Side.BOTTOM, texts[3], duration)
							),
							new TransSurface(duration * 3, texts[3], Pivot.CENTER)
					);
				animationsSets[1] = new AnimationsSet(TYPE.PARALLEL,
							new AnimationsSet(TYPE.SEQUENTIAL,
									new AnimationsSet(TYPE.PARALLEL, Slide.hideFrom(Side.LEFT, texts[3], duration), Slide.hideFrom(Side.RIGHT, texts[2], duration)),
									Slide.hideFrom(Side.TOP, texts[1], duration),
									Slide.hideFrom(Side.BOTTOM, texts[0], duration)
							),
							new TransSurface(duration * 3, texts[0], Pivot.CENTER)
					);
				break;
		}
		return animationsSets;
	}
	
	public static List<AnimationsSet> getSlideAnimations(List<String> strings){
		List<AnimationsSet> animationsSets  = new ArrayList<AnimationsSet>();
		if(strings.size()%4 != 0) return animationsSets;
		Random random = new Random();
		for(int i=0; i < strings.size(); ) {
			int way = Math.abs(random.nextInt()) % 4;
			String[] contens = {strings.get(i), strings.get(i+1), strings.get(i+2), strings.get(i+3)}; 
			Text[] texts = randomTexts(contens, way);
			animationsSets.addAll(Arrays.asList(randomPlay(texts, way)));
			i += 4;
		}
		return animationsSets;
	}
	
	private static void play(TextSurface textSurface, List<String> strings) {
		if(strings.size()%4 != 0) return;
		Random random = new Random();
		List<AnimationsSet> animationsSets = new ArrayList<AnimationsSet>();
		for(int i=0; i < strings.size(); ) {
			int way = Math.abs(random.nextInt()) % 4;
			String[] contens = {strings.get(i), strings.get(i+1), strings.get(i+2), strings.get(i+3)}; 
			Text[] texts = randomTexts(contens, way);
			animationsSets.addAll(Arrays.asList(randomPlay(texts, way)));
			i += 4;
		}
		
		textSurface.play(TYPE.SEQUENTIAL, animationsSets.toArray(new AnimationsSet[]{}));
	}
}

