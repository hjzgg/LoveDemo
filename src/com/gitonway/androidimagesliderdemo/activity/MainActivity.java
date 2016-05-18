package com.gitonway.androidimagesliderdemo.activity;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.util.EncodingUtils;

import com.gitonway.androidimagesliderdemo.R;
import com.gitonway.androidimagesliderdemo.widget.imageslider.SliderLayout;
import com.gitonway.androidimagesliderdemo.widget.imageslider.SliderLayout.Transformer;
import com.gitonway.androidimagesliderdemo.widget.imageslider.Animations.DescriptionAnimation;
import com.gitonway.androidimagesliderdemo.widget.imageslider.Indicators.PagerIndicator;
import com.gitonway.androidimagesliderdemo.widget.imageslider.SliderTypes.BaseSliderView;
import com.gitonway.androidimagesliderdemo.widget.imageslider.SliderTypes.TextSliderView;
import com.textsurface.TextSurface;
import com.textsurface.animations.AnimationsSet;
import com.textsurface.contants.TYPE;
import com.textsurface.sample.checks.CookieThumperSample;
import com.textsurface.sample.checks.SlideSample;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity implements BaseSliderView.OnSliderClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //初始化图片切换
        initChangePicture();
        //初始化音乐
        initMusic();
        //初始化文字展示
        initWord();
    }
    
    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }
    
    private SliderLayout mDemoSlider;
    private void initChangePicture(){
    	 mDemoSlider = (SliderLayout)findViewById(R.id.slider);

         //两种方式加载数据
         
         //加载本地
         HashMap<String,String> url_maps = new HashMap<String, String>();
         url_maps.put("GitOnWay", "http://gitonway.blog.163.com/");
         
         //加载网络
         HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
         file_maps.put("love-A",R.drawable.a);
         file_maps.put("love-B",R.drawable.b);
         file_maps.put("love-C",R.drawable.c);
         file_maps.put("love-D", R.drawable.d);
         
         

         for(String name : file_maps.keySet()){
             TextSliderView textSliderView = new TextSliderView(this);
             // 初始化幻灯片页面
             textSliderView
                     .description(name)
                     .image(file_maps.get(name))
                     .setOnSliderClickListener(this);

             //添加要传递的数据
             textSliderView.getBundle()
                     .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
         }
         
//       幻灯片切换方式  
         mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
//       指示符位置  
         mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//       定义指示器样式  
//       mDemoSlider.setCustomIndicator(your view);
//       幻灯片循环  
//       mDemoSlider.startAutoCycle();
//       停止循环
         mDemoSlider.stopAutoCycle();
//       设置指示器的显示与否  
         mDemoSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Visible);
//       设置幻灯片的转化时间  
//       mDemoSlider.setSliderTransformDuration(5000, null);
//       用来自定义幻灯片标题的显示方式  
         mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//       幻灯片切换时间  
         mDemoSlider.setDuration(3000);
         
// 		实现随机切换
         TimerTask task = new TimerTask() {
 			@Override
 			public void run() {
 				Transformer[] tranformers = SliderLayout.Transformer.values();
 				Transformer transformer = tranformers[(int) (Math.random() * tranformers.length)];
 				mDemoSlider.setPresetTransformer(transformer);
 			}
 		};
 		
 		new Timer().schedule(task, 2000, 2000);
    }
    
    
    //播放对象
  	private MediaPlayer myMediaPlayer;
  	//播放列表
  	private List<String> myMusicList = new ArrayList<String>();
  	//当前播放歌曲的索引
  	private int currentListItem=0;
  	//音乐的路径
  	private static final String MUSIC_PATH = new String(Environment.getExternalStorageDirectory().getAbsolutePath() + "/hjz/");
  	
    private void initMusic(){
    	myMediaPlayer=new MediaPlayer();
        findView();
        musicList();
        listener();
        
        //自动播放第一首歌
        if(myMusicList.size() > 0){
        	playMusic(MUSIC_PATH+myMusicList.get(currentListItem));
        }
    }
    
  //绑定音乐
    void musicList(){
    	try {
    		Log.e("mypath", MUSIC_PATH);
	    	File home=new File(MUSIC_PATH);
	    	if(home.listFiles(new MusicFilter()).length>0){
	    		for(File file:home.listFiles(new MusicFilter())){
	    			myMusicList.add(file.getName());
	    		}
	    		ArrayAdapter<String> musicList = new ArrayAdapter<String>(MainActivity.this, R.layout.musicitme, myMusicList);
	    		setListAdapter(musicList);
	    	}
    	} catch (Exception e) {
    		Log.e("获取音乐文件出错:", e.toString());
    	}
    }
    
    //获取按钮
   void findView(){
	   viewHolder.start=(Button)findViewById(R.id.start);
	   viewHolder.stop=(Button)findViewById(R.id.stop);
	   viewHolder.next=(Button)findViewById(R.id.next);
	   viewHolder.pause=(Button)findViewById(R.id.pause);
	   viewHolder.last=(Button)findViewById(R.id.last);
   }
   
   
   //监听事件
   void listener(){
	   //停止
	   viewHolder.stop.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(myMediaPlayer.isPlaying()){
				myMediaPlayer.reset();
			}
		}
	});
	   //开始
     viewHolder.start.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			playMusic(MUSIC_PATH+myMusicList.get(currentListItem));
		}
	});
	   //下一首
	   viewHolder.next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			nextMusic();
		}
	});
	   //暂停
	   viewHolder.pause.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(myMediaPlayer.isPlaying()){
				myMediaPlayer.pause();
			}else{
				myMediaPlayer.start();
			}
		}
	});
	   //上一首
	   viewHolder.last.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			lastMusic();
		}
	});
	   
   }
   
   //播放音乐 
   void playMusic(String path){
	   try { 
		myMediaPlayer.reset();
		myMediaPlayer.setDataSource(path);
		myMediaPlayer.prepare();
		myMediaPlayer.start();
		myMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				nextMusic();
			}
		});
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   }
   
   //下一首
   void nextMusic(){
	   if(++currentListItem>=myMusicList.size()){
		   currentListItem=0;
	   }
	   else{
		   playMusic(MUSIC_PATH+myMusicList.get(currentListItem));
	   }
   }
   
   //上一首
   void lastMusic(){
	   if(currentListItem!=0)
		   {
	   if(--currentListItem>=0){
		   currentListItem=myMusicList.size();
	   } else{
		   playMusic(MUSIC_PATH+myMusicList.get(currentListItem));
	   }
		  }  else{
		   playMusic(MUSIC_PATH+myMusicList.get(currentListItem));
	   }
   }
   
   //当用户返回时结束音乐并释放音乐对象
	   @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		   if(keyCode==KeyEvent.KEYCODE_BACK){
			   myMediaPlayer.stop();
			   myMediaPlayer.release();
			   this.finish();
			   return true;
		   }
		return super.onKeyDown(keyCode, event);
	}
   
	//当选择列表项时播放音乐 
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		currentListItem=position;
		playMusic(MUSIC_PATH+myMusicList.get(currentListItem));
	}
    
    //初始化文字展示
    private TextSurface textSurface;
    private void initWord(){
    	LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayoutWord);//找到你要设透明背景的layout 的id 
    	layout.getBackground().setAlpha(60);//0~255透明度值 
    	textSurface = (TextSurface) findViewById(R.id.text_surface);
    	textSurface.postDelayed(new Runnable() {
			@Override public void run() {
				show();
			}
		}, 1000);
    }
    
    private void show() {
		textSurface.reset();
		List<AnimationsSet> animationsSets = new ArrayList<AnimationsSet>();
		animationsSets.add(CookieThumperSample.getCookieThumperAnimations(getAssets()));
		animationsSets.addAll(SlideSample.getSlideAnimations(getContents()));
		textSurface.play(TYPE.SEQUENTIAL, animationsSets.toArray(new AnimationsSet[]{}));
		
		
//		ColorSample.play(textSurface);
//		AlignSample.play(textSurface);
//		Rotation3DSample.play(textSurface);
//		ScaleTextSample.run(textSurface);
//		ShapeRevealLoopSample.play(textSurface);
//		ShapeRevealSample.play(textSurface);
//		SlideSample.play(textSurface);
//		SurfaceScaleSample.play(textSurface);
//		SurfaceTransSample.play(textSurface);
	}
    
    private List<String> getContents(){
    	List<String> contents = new ArrayList<String>();
    	try{   
    	   //得到资源中的asset数据流  
    	   String fileName = "content.txt"; //文件名字   
    	   String res="";   
    	   InputStream in = getResources().getAssets().open(fileName);   
    	   int length = in.available();           
    	   byte [] buffer = new byte[length];          
    	   in.read(buffer);              
    	   in.close();  
    	   res = EncodingUtils.getString(buffer, "UTF-8");
    	   String[] strings = res.split("[,|，|\\.|。]");
    	   int len = strings.length/4 * 4;
    	   for(int i=0; i < len; ++i)
    		   contents.add(strings[i]);
    	}catch(Exception e){   
	      e.printStackTrace();
	      Log.e("getContents", e.toString());
	   }   
    	return contents;
    }
}
