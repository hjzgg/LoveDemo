package com.gitonway.androidimagesliderdemo.activity;

import java.io.File; 
import java.io.FilenameFilter;

public class MusicFilter implements FilenameFilter{
	@Override
	public boolean accept(File dir, String filename) {
		// TODO Auto-generated method stub
		return (filename.toLowerCase().endsWith(".mp3"));
	}
}
